package com.example.project.model;

import com.google.gson.annotations.SerializedName;

public class ProductDetail{

	@SerializedName("code")
	private int code;

	@SerializedName("data")
	private Data data;

	@SerializedName("status")
	private String status;

	public int getCode(){
		return code;
	}

	public Data getData(){
		return data;
	}

	public String getStatus(){
		return status;
	}
}