package com.practice.LuceneSearch.practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.lucene.search.Model.PowerBiModel;
import com.lucene.search.Model.PowerBiReportModel;

public class PowerBiApiTest {
	
	public static void main(String[] args) throws IOException {
		List<PowerBiReportModel> reportList = new ArrayList<>();
		reportList.add(new PowerBiReportModel("amol", "Group1", "google.com"));
		reportList.add(new PowerBiReportModel("rahul", "Group1", "yahoo.com"));
		reportList.add(new PowerBiReportModel("vikas", "Group2", "aws.com"));
		
		PowerBiModel powerBiModel = new PowerBiModel();
		powerBiModel.setReportList(reportList);
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(powerBiModel);
		System.out.println(jsonResponse);
	}

}
