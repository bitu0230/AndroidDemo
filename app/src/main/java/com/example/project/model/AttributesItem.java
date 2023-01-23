package com.example.project.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AttributesItem{

	@SerializedName("values")
	private List<String> values;

	@SerializedName("count")
	private int count;

	@SerializedName("optionListingType")
	private String optionListingType;

	public List<String> getValues(){
		return values;
	}

	public int getCount(){
		return count;
	}

	public String getOptionListingType(){
		return optionListingType;
	}
}