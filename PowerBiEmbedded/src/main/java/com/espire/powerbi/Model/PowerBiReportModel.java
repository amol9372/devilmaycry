package com.espire.powerbi.Model;

import org.springframework.stereotype.Component;


public class PowerBiReportModel {
	private String reportId;
	private String groupId;
	private String embedUrl;
	private String embedToken;

	public PowerBiReportModel(String r,String g, String e, String et){
	 	reportId = r;
	 	groupId = g;
	 	embedUrl = e;
	 	embedToken = et;
	}

	public PowerBiReportModel(){}
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

	public String getEmbedToken() {
		return embedToken;
	}

	public void setEmbedToken(String embedToken) {
		this.embedToken = embedToken;
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
		builder.append(", embedToken=");
		builder.append(embedToken);
		builder.append("]");
		return builder.toString();
	}

}
