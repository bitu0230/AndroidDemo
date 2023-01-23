package com.example.project.model;

import com.google.gson.annotations.SerializedName;

public class TrackerFields{

	@SerializedName("is_ner_eligible")
	private String isNerEligible;

	@SerializedName("group_type")
	private String groupType;

	@SerializedName("sales_velocity_components")
	private String salesVelocityComponents;

	public String getIsNerEligible(){
		return isNerEligible;
	}

	public String getGroupType(){
		return groupType;
	}

	public String getSalesVelocityComponents(){
		return salesVelocityComponents;
	}
}