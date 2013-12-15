package com.mod.android.widget.fbcw;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MyConstants {
	
	//button IDs
	public static final Integer BUTTON1 = 1; 
	public static final Integer BUTTON2 = 2; 
	public static final Integer BUTTON3 = 3; 
	public static final Integer BUTTON4 = 4; 
	public static final Integer BUTTON5 = 5; 	
	/**
	 * Helper constant for easier iteration trough buttons. 
	 */
	public static final Integer[] BUTTONS = {BUTTON1, BUTTON2, BUTTON3, BUTTON4, BUTTON5};
		
	/**
	 * Default brightness levels for buttons. Key is button ID value.
	 */
	public static final Map<Integer, Integer> DEFAULT_BRIGHTNESS_LEVELS;
	static {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(BUTTON1, 100);
		map.put(BUTTON2, 80);
		map.put(BUTTON3, 50);
		map.put(BUTTON4, 30);
		map.put(BUTTON5, 10);
		DEFAULT_BRIGHTNESS_LEVELS = Collections.unmodifiableMap(map);
	}
	
	/**
	 * Minimum brightness level that can be set is 7% and this is the offset from the seekbars
	 * minimum value of 0.
	 */
	public static final Integer OFFSET = 7;	
	public static final Integer SEEKBAR_MAX = 100-OFFSET;
	
	public static final String APPLICATION_STATE = "applicationState";
	public static final String SHARED_PREFERENCES = "fbcw_preferences"; 
	public static final String BUTTON_ID = "buttonId";
	public static final String SHOW_MESSAGE = "showMessage";
	
	public static final int ACTIVITY_FINISH_DELAY = 100; // delay to finish activity in miliseconds
}
