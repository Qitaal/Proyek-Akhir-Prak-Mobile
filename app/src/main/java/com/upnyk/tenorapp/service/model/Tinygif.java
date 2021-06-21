package com.upnyk.tenorapp.service.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Tinygif{

	@SerializedName("preview")
	private String preview;

	@SerializedName("dims")
	private List<Integer> dims;

	@SerializedName("size")
	private int size;

	@SerializedName("url")
	private String url;

	public String getPreview(){
		return preview;
	}

	public List<Integer> getDims(){
		return dims;
	}

	public int getSize(){
		return size;
	}

	public String getUrl(){
		return url;
	}
}