package com.upnyk.tenorapp.service.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem{

	@SerializedName("shares")
	private int shares;

	@SerializedName("created")
	private double created;

	@SerializedName("composite")
	private Object composite;

	@SerializedName("media")
	private List<MediaItem> media;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("hasaudio")
	private boolean hasaudio;

	@SerializedName("url")
	private String url;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("itemurl")
	private String itemurl;

	public int getShares(){
		return shares;
	}

	public double getCreated(){
		return created;
	}

	public Object getComposite(){
		return composite;
	}

	public List<MediaItem> getMedia(){
		return media;
	}

	public String getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public boolean isHasaudio(){
		return hasaudio;
	}

	public String getUrl(){
		return url;
	}

	public List<Object> getTags(){
		return tags;
	}

	public String getItemurl(){
		return itemurl;
	}
}