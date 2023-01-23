package com.example.project.model;

import com.google.gson.annotations.SerializedName;

public class SoldRangeCount{

	@SerializedName("en")
	private String en;

	@SerializedName("id")
	private String id;

	public String getEn(){
		return en;
	}

	public String getId(){
		return id;
	}
}