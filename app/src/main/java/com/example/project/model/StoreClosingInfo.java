package com.example.project.model;

import com.google.gson.annotations.SerializedName;

public class StoreClosingInfo{

	@SerializedName("delayShipping")
	private boolean delayShipping;

	@SerializedName("endDate")
	private long endDate;

	@SerializedName("storeClosed")
	private boolean storeClosed;

	public boolean isDelayShipping(){
		return delayShipping;
	}

	public long getEndDate(){
		return endDate;
	}

	public boolean isStoreClosed(){
		return storeClosed;
	}
}