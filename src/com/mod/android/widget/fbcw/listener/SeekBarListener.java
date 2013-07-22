package com.mod.android.widget.fbcw.listener;

import java.util.Map;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import static com.mod.android.widget.fbcw.MyConstants.*;

public class SeekBarListener implements OnSeekBarChangeListener{
	private TextView textView;
	private Integer buttonId;
	Map<Integer, Integer> brightnessLevels;
	
	/**
	 * Constructor.
	 * @param buttonId - Button that the seekbar references.
	 * @param textView - TextView to update when progress changes. 
	 * @param brightnessLevels - Map of brightness levels to update when progress changes.
	 */
	public SeekBarListener(Integer buttonId, TextView textView, Map<Integer, Integer> brightnessLevels) {
		this.buttonId = buttonId;
		this.textView = textView;
		this.brightnessLevels = brightnessLevels;
	}
	
	
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		
		Integer brightness = progress + OFFSET;
		
		//save brightness
		brightnessLevels.put(buttonId, brightness);
		
		//update text view
		textView.setText(brightness.toString() + "%");		
	}

	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

}
