package com.example.project.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Sorting{

	@SerializedName("parameter")
	private String parameter;

	@SerializedName("options")
	private List<OptionsItem> options;

	public String getParameter(){
		return parameter;
	}

	public List<OptionsItem> getOptions(){
		return options;
	}
}