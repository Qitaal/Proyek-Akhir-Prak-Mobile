package com.upnyk.tenorapp.service.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Webm{

	@SerializedName("preview")
	private String preview;

	@SerializedName("size")
	private int size;

	@SerializedName("dims")
	private List<Integer> dims;

	@SerializedName("url")
	private String url;

	public String getPreview(){
		return preview;
	}

	public int getSize(){
		return size;
	}

	public List<Integer> getDims(){
		return dims;
	}

	public String getUrl(){
		return url;
	}
}