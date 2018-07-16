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
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import com.opencsv.CSVReader;

public class LuceneDemo {

	private Directory memoryIndex;
	private StandardAnalyzer analyzer;
	
	public LuceneDemo(){
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
				document.add(new TextField("movieId", record[1], Field.Store.YES));
				document.add(new TextField("tag", record[2], Field.Store.YES));
				writer.addDocument(document);
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Document> searchDocuments(String query, String fieldToSearch) throws Exception {
		Query queryParser = new QueryParser(fieldToSearch, analyzer).parse(query);
		IndexReader indexReader = DirectoryReader.open(memoryIndex);
		IndexSearcher searcher = new IndexSearcher(indexReader);
		TopDocs topDocs = searcher.search(queryParser, 10);
		List<Document> docList = new ArrayList<>();
		for(ScoreDoc scoreDoc : topDocs.scoreDocs)
			docList.add(searcher.doc(scoreDoc.doc));
		
		return docList;
	}

	public static void main(String args[]) throws Exception {
		 CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\amol.singh\\Desktop\\movies dataset\\tags.csv"),',');
		 
         LuceneDemo luceneDemo = new LuceneDemo();
         luceneDemo.indexCSVDocuments(csvReader);
         System.out.println(luceneDemo.searchDocuments("jesus", "tag"));
         
	}

}
