package com.ixanaui.utils;

public class PreviewConfig {
	
	private String caption;
	private String width;
	private String url;
	private String key;
	
	public PreviewConfig(){
		
	}
	
	public PreviewConfig(String caption,String width,String url,String key){
		this.caption=caption;
		this.width=width;
		this.url=url;
		this.key=key;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	

}
