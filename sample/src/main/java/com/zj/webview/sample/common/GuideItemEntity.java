package com.zj.webview.sample.common;

public class GuideItemEntity {

	private String guideTitle;
	private int guideDictionary;
	private int extra;

	public GuideItemEntity(String guideTitle, int guideDictionary) {
		this.guideTitle = guideTitle;
		this.guideDictionary = guideDictionary;
	}


	public String getGuideTitle() {
		return guideTitle;
	}

	public void setGuideTitle(String guideTitle) {
		this.guideTitle = guideTitle;
	}

	public int getGuideDictionary() {
		return guideDictionary;
	}

	public void setGuideDictionary(int guideDictionary) {
		this.guideDictionary = guideDictionary;
	}
}
