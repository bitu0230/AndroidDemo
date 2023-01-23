package com.example.project.model;

import com.google.gson.annotations.SerializedName;

public class Badge{

	@SerializedName("merchantBadge")
	private String merchantBadge;

	@SerializedName("merchantBadgeUrl")
	private String merchantBadgeUrl;

	public String getMerchantBadge(){
		return merchantBadge;
	}

	public String getMerchantBadgeUrl(){
		return merchantBadgeUrl;
	}
}