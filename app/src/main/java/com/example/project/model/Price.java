package com.example.project.model;

import com.google.gson.annotations.SerializedName;

public class Price{

	@SerializedName("priceDisplay")
	private String priceDisplay;

	@SerializedName("offerPriceDisplay")
	private String offerPriceDisplay;

	@SerializedName("minPrice")
	private Object minPrice;

	@SerializedName("discount")
	private int discount;

	@SerializedName("strikeThroughPriceDisplay")
	private String strikeThroughPriceDisplay;

	public String getPriceDisplay(){
		return priceDisplay;
	}

	public String getOfferPriceDisplay(){
		return offerPriceDisplay;
	}

	public Object getMinPrice(){
		return minPrice;
	}

	public int getDiscount(){
		return discount;
	}

	public String getStrikeThroughPriceDisplay(){
		return strikeThroughPriceDisplay;
	}
}