package com.lucene.search.Model;

import java.util.List;

public class PowerBiModel {
    private List<PowerBiReportModel> reportList;

	public List<PowerBiReportModel> getReportList() {
		return reportList;
	}

	public void setReportList(List<PowerBiReportModel> reportList) {
		this.reportList = reportList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PowerBiModel [reportList=");
		builder.append(reportList);
		builder.append("]");
		return builder.toString();
	}
    
    
}
