package com.mod.android.widget.fbcw.bean;

import java.io.Serializable;
import java.util.Map;

public class ApplicationState implements Serializable{
	private static final long serialVersionUID = 418084490741556757L;
	
	private Map<Integer, Integer> brightnessLevels;
	private Boolean showMessage;
	
	public ApplicationState(Map<Integer, Integer> brightnessLevels, Boolean showMessage) {
		this.brightnessLevels = brightnessLevels;
		this.showMessage = showMessage;
	}

	public Map<Integer, Integer> getBrightnessLevels() {
		return brightnessLevels;
	}

	public void setBrightnessLevels(Map<Integer, Integer> brightnessLevels) {
		this.brightnessLevels = brightnessLevels;
	}

	public Boolean getShowMessage() {
		return showMessage;
	}

	public void setShowMessage(Boolean showMessage) {
		this.showMessage = showMessage;
	}
	
}
