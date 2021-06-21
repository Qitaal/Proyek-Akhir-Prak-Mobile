package com.upnyk.tenorapp.service.model;

import com.google.gson.annotations.SerializedName;

public class MediaItem{

	@SerializedName("mp4")
	private Mp4 mp4;

	@SerializedName("tinygif")
	private Tinygif tinygif;

	@SerializedName("nanogif")
	private Nanogif nanogif;

	@SerializedName("tinywebm")
	private Tinywebm tinywebm;

	@SerializedName("gif")
	private Gif gif;

	@SerializedName("mediumgif")
	private Mediumgif mediumgif;

	@SerializedName("tinymp4")
	private Tinymp4 tinymp4;

	@SerializedName("nanomp4")
	private Nanomp4 nanomp4;

	@SerializedName("nanowebm")
	private Nanowebm nanowebm;

	@SerializedName("loopedmp4")
	private Loopedmp4 loopedmp4;

	@SerializedName("webm")
	private Webm webm;

	public Mp4 getMp4(){
		return mp4;
	}

	public Tinygif getTinygif(){
		return tinygif;
	}

	public Nanogif getNanogif(){
		return nanogif;
	}

	public Tinywebm getTinywebm(){
		return tinywebm;
	}

	public Gif getGif(){
		return gif;
	}

	public Mediumgif getMediumgif(){
		return mediumgif;
	}

	public Tinymp4 getTinymp4(){
		return tinymp4;
	}

	public Nanomp4 getNanomp4(){
		return nanomp4;
	}

	public Nanowebm getNanowebm(){
		return nanowebm;
	}

	public Loopedmp4 getLoopedmp4(){
		return loopedmp4;
	}

	public Webm getWebm(){
		return webm;
	}
}