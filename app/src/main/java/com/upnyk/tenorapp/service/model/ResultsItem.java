package com.upnyk.tenorapp.service.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem{

	@SerializedName("created")
	private double created;

	@SerializedName("flags")
	private List<Object> flags;

	@SerializedName("media")
	private List<MediaItem> media;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("shares")
	private int shares;

	@SerializedName("bg_color")
	private String bgColor;

	@SerializedName("hascaption")
	private boolean hascaption;

	@SerializedName("composite")
	private Object composite;

	@SerializedName("id")
	private String id;

	@SerializedName("source_id")
	private String sourceId;

	@SerializedName("hasaudio")
	private boolean hasaudio;

	@SerializedName("h1_title")
	private String h1Title;

	@SerializedName("itemurl")
	private String itemurl;

	public double getCreated(){
		return created;
	}

	public List<Object> getFlags(){
		return flags;
	}

	public List<MediaItem> getMedia(){
		return media;
	}

	public String getTitle(){
		return title;
	}

	public String getUrl(){
		return url;
	}

	public List<Object> getTags(){
		return tags;
	}

	public int getShares(){
		return shares;
	}

	public String getBgColor(){
		return bgColor;
	}

	public boolean isHascaption(){
		return hascaption;
	}

	public Object getComposite(){
		return composite;
	}

	public String getId(){
		return id;
	}

	public String getSourceId(){
		return sourceId;
	}

	public boolean isHasaudio(){
		return hasaudio;
	}

	public String getH1Title(){
		return h1Title;
	}

	public String getItemurl(){
		return itemurl;
	}
}