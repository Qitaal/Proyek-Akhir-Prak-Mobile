package com.upnyk.tenorapp.service.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DetailResponse{

	@SerializedName("next")
	private String next;

	@SerializedName("results")
	private List<ResultsItem> results;

	public String getNext(){
		return next;
	}

	public List<ResultsItem> getResults(){
		return results;
	}
}