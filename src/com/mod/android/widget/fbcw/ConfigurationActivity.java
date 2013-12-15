package com.mod.android.widget.fbcw;

import java.util.HashMap;
import java.util.Map;

import com.mod.android.widget.fbcw.bean.ApplicationState;
import com.mod.android.widget.fbcw.listener.SeekBarListener;

import static com.mod.android.widget.fbcw.MyConstants.*;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.TextView;

public class ConfigurationActivity extends Activity {
	private ApplicationState applicationState;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//set content view
		setContentView(R.layout.configuration);
		
		//restore saved application state
		if (savedInstanceState!=null) {
			applicationState = (ApplicationState) savedInstanceState.getSerializable(APPLICATION_STATE);
		} else {
			SharedPreferences preferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
			Map<Integer, Integer> brightnessLevels = new HashMap<Integer, Integer>();
			Boolean showMessage;
			
			//read saved state
			brightnessLevels.put(BUTTON1, preferences.getInt(BUTTON1.toString(), DEFAULT_BRIGHTNESS_LEVELS.get(BUTTON1)));
			brightnessLevels.put(BUTTON2, preferences.getInt(BUTTON2.toString(), DEFAULT_BRIGHTNESS_LEVELS.get(BUTTON2)));
			brightnessLevels.put(BUTTON3, preferences.getInt(BUTTON3.toString(), DEFAULT_BRIGHTNESS_LEVELS.get(BUTTON3)));
			brightnessLevels.put(BUTTON4, preferences.getInt(BUTTON4.toString(), DEFAULT_BRIGHTNESS_LEVELS.get(BUTTON4)));
			brightnessLevels.put(BUTTON5, preferences.getInt(BUTTON5.toString(), DEFAULT_BRIGHTNESS_LEVELS.get(BUTTON5)));
			showMessage = preferences.getBoolean(SHOW_MESSAGE, true);			
			
			applicationState = new ApplicationState(brightnessLevels, showMessage);
		}
		
		//get them viewz
		Map<Integer, SeekBar> seekBars = new HashMap<Integer, SeekBar>();
		Map<Integer, TextView> textViews = new HashMap<Integer, TextView>();
		CheckBox showMessageCheckBox;
		seekBars.put(BUTTON1, (SeekBar) findViewById(R.id.seekBar1)); 
		seekBars.put(BUTTON2, (SeekBar) findViewById(R.id.seekBar2));
		seekBars.put(BUTTON3, (SeekBar) findViewById(R.id.seekBar3));
		seekBars.put(BUTTON4, (SeekBar) findViewById(R.id.seekBar4));
		seekBars.put(BUTTON5, (SeekBar) findViewById(R.id.seekBar5));		
		textViews.put(BUTTON1, (TextView) findViewById(R.id.textView1));
		textViews.put(BUTTON2, (TextView) findViewById(R.id.textView2));
		textViews.put(BUTTON3, (TextView) findViewById(R.id.textView3));
		textViews.put(BUTTON4, (TextView) findViewById(R.id.textView4));
		textViews.put(BUTTON5, (TextView) findViewById(R.id.textView5));
		showMessageCheckBox = (CheckBox) findViewById(R.id.checkBox1);
		
		//set up views
		for (int i = 0; i < BUTTONS.length; i++) {
			//set max value of the seekbar
			seekBars.get(BUTTONS[i]).setMax(SEEKBAR_MAX);
			//set seekbar listener
			seekBars.get(BUTTONS[i]).setOnSeekBarChangeListener(new SeekBarListener(BUTTONS[i], textViews.get(BUTTONS[i]), applicationState.getBrightnessLevels()));
			//set progress value
			seekBars.get(BUTTONS[i]).setProgress(applicationState.getBrightnessLevels().get(BUTTONS[i])-OFFSET);
			//set text
			textViews.get(BUTTONS[i]).setText(applicationState.getBrightnessLevels().get(BUTTONS[i]).toString()+ "%");
		}
		
		showMessageCheckBox.setChecked(applicationState.getShowMessage());
		showMessageCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {			
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				applicationState.setShowMessage(isChecked);				
			}
		});
		
		super.onCreate(savedInstanceState);
	}
	
	@Override
	protected void onPause() {
		//save app state
		Editor editor = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE).edit();
		//save brightness levels
		for (int i = 0; i < BUTTONS.length; i++) {
			editor.putInt(BUTTONS[i].toString(), applicationState.getBrightnessLevels().get(BUTTONS[i]));			
		}
		//save show message
		editor.putBoolean(SHOW_MESSAGE, applicationState.getShowMessage());
		editor.commit();
		
		super.onPause();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		//save applications state
		outState.putSerializable(APPLICATION_STATE, applicationState);
		super.onSaveInstanceState(outState);
	}
	
	@Override
	protected void onUserLeaveHint() {
		super.onUserLeaveHint();
		//kill the activity when user leaves (so click on the brightness button doesn't bring
		//the user back to the configuration activity)
		finish();
	}
	
}
