package com.example.project.model;

import com.google.gson.annotations.SerializedName;

public class PageMetaDataResponse{

	@SerializedName("c3SimilarityMap")
	private C3SimilarityMap c3SimilarityMap;

	@SerializedName("c2SimilarityMap")
	private C2SimilarityMap c2SimilarityMap;

	public C3SimilarityMap getC3SimilarityMap(){
		return c3SimilarityMap;
	}

	public C2SimilarityMap getC2SimilarityMap(){
		return c2SimilarityMap;
	}
}