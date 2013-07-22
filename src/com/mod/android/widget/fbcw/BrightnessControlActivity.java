package com.mod.android.widget.fbcw;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.Toast;
import static com.mod.android.widget.fbcw.MyConstants.*;

public class BrightnessControlActivity extends Activity {	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
				
		//get the ID of the clicked button
		String buttonId = ((Integer) getIntent().getExtras().get(BUTTON_ID)).toString();
		
		//get the brightness level for clicked button
		SharedPreferences preferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
		int brightness = preferences.getInt(buttonId, 50);
		boolean showMessage = preferences.getBoolean(SHOW_MESSAGE, true);
		
		//display message if needed
		if (showMessage) {
			Toast.makeText(getApplicationContext(), "Brightness: " +brightness + "%", Toast.LENGTH_SHORT).show();
		}
				
		//set screen brightness
		Settings.System.putInt(this.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, (int) Math.ceil(brightness/100.0f*255));
		
		//refresh state
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		lp.screenBrightness = brightness / 100.0f;
		getWindow().setAttributes(lp);	
								
		super.onCreate(savedInstanceState);
		
		//wait a bit before closing (so the settings can be updated)
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {			
			public void run() {
				BrightnessControlActivity.this.finish();			
			}
		}, ACTIVITY_FINISH_DELAY);	
		
	}
}
