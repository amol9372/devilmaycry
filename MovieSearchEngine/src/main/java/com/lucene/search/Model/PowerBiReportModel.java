package com.lucene.search.Model;

import org.springframework.stereotype.Component;

@Component
public class PowerBiReportModel {
	private String reportId;
	private String groupId;
	private String embedUrl;

	public PowerBiReportModel(String r,String g, String e){
	 	reportId = r;
	 	groupId = g;
	 	embedUrl = e;
	}
	
	
	
	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getEmbedUrl() {
		return embedUrl;
	}

	public void setEmbedUrl(String embedUrl) {
		this.embedUrl = embedUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PowerBiReportModel [reportId=");
		builder.append(reportId);
		builder.append(", groupId=");
		builder.append(groupId);
		builder.append(", embedUrl=");
		builder.append(embedUrl);
		builder.append("]");
		return builder.toString();
	}

}
