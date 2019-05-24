package com.ixanaui.utils;

import java.util.ArrayList;
import java.util.List;

public class ResponseFile {
	
	private List<String> initialPreview;
	private List<PreviewConfig> initialPreviewConfig;
	private Boolean append;
	
	public ResponseFile(){
		this.initialPreview = new ArrayList<String>();
		this.initialPreviewConfig =  new ArrayList<PreviewConfig>();
		this.append = true;
	}
	

	public List<String> getInitialPreview() {
		return initialPreview;
	}



	public void setInitialPreview(List<String> initialPreview) {
		this.initialPreview = initialPreview;
	}



	public List<PreviewConfig> getInitialPreviewConfig() {
		return initialPreviewConfig;
	}



	public void setInitialPreviewConfig(List<PreviewConfig> initialPreviewConfig) {
		this.initialPreviewConfig = initialPreviewConfig;
	}



	public Boolean getAppend() {
		return append;
	}


	public void setAppend(Boolean append) {
		this.append = append;
	}
	

}
