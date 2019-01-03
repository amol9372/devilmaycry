package com.practice.LuceneSearch.practice;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TermRangeQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.spell.Dictionary;
import org.apache.lucene.search.spell.LuceneDictionary;
import org.apache.lucene.search.suggest.Lookup;
import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.BytesRef;

import com.opencsv.CSVReader;

public class LuceneDemo2 {

	private Directory memoryIndex;
	private StandardAnalyzer analyzer;

	public LuceneDemo2() {
		this.memoryIndex = new RAMDirectory();
		this.analyzer = new StandardAnalyzer();
	}

	public void indexCSVDocuments(CSVReader csvReader) {
		String[] record = null;
		try {
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
			IndexWriter writer = new IndexWriter(memoryIndex, indexWriterConfig);
			while ((record = csvReader.readNext()) != null) {
				Document document = new Document();
				document.add(new TextField("primaryName", record[1], Field.Store.YES));
				document.add(new TextField("birthYear", record[2], Field.Store.YES));
				document.add(new TextField("deathYear", record[3], Field.Store.YES));
				document.add(new TextField("primaryProfession", record[4], Field.Store.YES));
				writer.addDocument(document);
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Document> searchDocuments(String query, String fieldToSearch) throws Exception {
		// Query termQuery = new BooleanQuery();
		QueryParser queryParser = new QueryParser(fieldToSearch, analyzer);
		Query query1 = queryParser.parse(query);
		IndexReader indexReader = DirectoryReader.open(memoryIndex);
		IndexSearcher searcher = new IndexSearcher(indexReader);
		TopDocs topDocs = searcher.search(query1, 10);
		List<Document> docList = new ArrayList<>();
		for (ScoreDoc scoreDoc : topDocs.scoreDocs)
			docList.add(searcher.doc(scoreDoc.doc));

		docList.stream().forEach(d -> {
			System.out.println(d.get("primaryName"));
		});
		return docList;
	}

	public void getSearchSuggestions(String term, String fieldToSearch) throws ParseException, IOException {
		IndexReader indexReader = DirectoryReader.open(memoryIndex);
		Dictionary dictionary = new LuceneDictionary(indexReader, fieldToSearch);
		AnalyzingInfixSuggester analyzingInfixSuggester = new AnalyzingInfixSuggester(memoryIndex,
				analyzer);
		analyzingInfixSuggester.build(dictionary);
		List<Lookup.LookupResult> lookupResultList = analyzingInfixSuggester.lookup(term, false, 10);
		for (Lookup.LookupResult lookupResult : lookupResultList) 
            System.out.println(lookupResult.key + ": " + lookupResult.value);
        
		analyzingInfixSuggester.close();
	}

	public List<Document> searchDocumentsWithBooleanQuery(String term, String fieldToSearch) throws Exception {
		IndexReader indexReader = DirectoryReader.open(memoryIndex);
		IndexSearcher searcher = new IndexSearcher(indexReader);
		//RangeQueryBuilder queryDate = QueryBuilders.rangeQuery("time").to(12).from(13);
		BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
		//booleanQuery.add(new TermQuery(new Term(fieldToSearch, "actor")), BooleanClause.Occur.MUST);
		//booleanQuery.add(new TermQuery(new Term(fieldToSearch, "director")), BooleanClause.Occur.MUST);
		Query query = new TermRangeQuery("birthYear", new BytesRef("1900"), new BytesRef("1920"), true, true);
		booleanQuery.add(query,BooleanClause.Occur.MUST);
		TopDocs topDocs = searcher.search(booleanQuery.build(), 10);
		List<Document> docList = new ArrayList<>();
		for (ScoreDoc scoreDoc : topDocs.scoreDocs)
			docList.add(searcher.doc(scoreDoc.doc));
		return docList;
	}
	
	public static void main(String args[]) throws Exception {
		// Read from CSV
		CSVReader csvReader = new CSVReader(
				new FileReader("C:\\Users\\amol.singh\\Desktop\\movies dataset\\name.basics.csv"), ',');
		LuceneDemo2 luceneDemo2 = new LuceneDemo2();
		// Index documents
		luceneDemo2.indexCSVDocuments(csvReader);
//		List<Document> searchList = luceneDemo.searchDocumentsWithBooleanQuery("", "primaryProfession");
//		for(Document doc : searchList)
//			System.out.println(doc.get("primaryName"));
		//System.out.println(luceneDemo2.searchDocuments("Fred", "primaryName"));
		luceneDemo2.getSearchSuggestions("fred", "primaryName");
 
	}

}