package com.example.project.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BLP6004500314{

	@SerializedName("tags")
	private List<String> tags;

	public List<String> getTags(){
		return tags;
	}
}