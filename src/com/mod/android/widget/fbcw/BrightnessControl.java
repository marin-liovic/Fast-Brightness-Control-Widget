package com.mod.android.widget.fbcw;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.Toast;
import static com.mod.android.widget.fbcw.MyConstants.ACTIVITY_FINISH_DELAY;

public class BrightnessControl extends Activity {	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
				
		//get the brightness from the click action
		int brightness = (Integer) getIntent().getExtras().get("brightness");
		
		//display message
		Toast.makeText(getApplicationContext(), "Brightness: " + Math.round(brightness/255.0f *100) + "%", Toast.LENGTH_SHORT).show();
		
		//set screen brightness
		Settings.System.putInt(this.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, brightness);
		
		//refresh state
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		lp.screenBrightness = brightness / 255.0f;
		getWindow().setAttributes(lp);	
								
		super.onCreate(savedInstanceState);
		
		//wait a bit before closing (so the settings can be updated)
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {			
			public void run() {
				BrightnessControl.this.finish();			
			}
		}, ACTIVITY_FINISH_DELAY);	
		
	}
}
