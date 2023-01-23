package com.example.project.model;

import com.google.gson.annotations.SerializedName;

public class PageMetadata{

	@SerializedName("productComparisonOverriddenC2s")
	private String productComparisonOverriddenC2s;

	@SerializedName("productComparisonAllowedC1s")
	private String productComparisonAllowedC1s;

	@SerializedName("showProductComparison")
	private String showProductComparison;

	public String getProductComparisonOverriddenC2s(){
		return productComparisonOverriddenC2s;
	}

	public String getProductComparisonAllowedC1s(){
		return productComparisonAllowedC1s;
	}

	public String getShowProductComparison(){
		return showProductComparison;
	}
}