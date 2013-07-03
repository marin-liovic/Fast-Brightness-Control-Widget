package com.mod.android.widget.fbcw;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import static com.mod.android.widget.fbcw.MyConstants.*;

public class FastBrightnessControlWidget extends AppWidgetProvider {
	
	public static final String ACTION_SET_BRIGHTNESS="com.mod.android.widget.fbcw.SetBrightness";
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		
		//fetch remoteViews
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.main);
		
		//create intents for setting brightness when buttons are clicked
		Intent setBrightness1 = new Intent(context, BrightnessControl.class);
		setBrightness1.setAction(ACTION_SET_BRIGHTNESS);
		setBrightness1.putExtra("brightness", BRIGHTNESS_BUTTON1);
		Intent setBrightness2 = new Intent(context, BrightnessControl.class);
		setBrightness2.setAction(ACTION_SET_BRIGHTNESS);
		setBrightness2.putExtra("brightness", BRIGHTNESS_BUTTON2);
		Intent setBrightness3 = new Intent(context, BrightnessControl.class);
		setBrightness3.setAction(ACTION_SET_BRIGHTNESS);
		setBrightness3.putExtra("brightness", BRIGHTNESS_BUTTON3);
		Intent setBrightness4 = new Intent(context, BrightnessControl.class);
		setBrightness4.setAction(ACTION_SET_BRIGHTNESS);
		setBrightness4.putExtra("brightness", BRIGHTNESS_BUTTON4);
		Intent setBrightness5 = new Intent(context, BrightnessControl.class);
		setBrightness5.setAction(ACTION_SET_BRIGHTNESS);
		setBrightness5.putExtra("brightness", BRIGHTNESS_BUTTON5);
		
		//register on click listeners with buttons		
		remoteViews.setOnClickPendingIntent(R.id.button1, PendingIntent.getActivity(context, 1, setBrightness1, PendingIntent.FLAG_UPDATE_CURRENT));		
		remoteViews.setOnClickPendingIntent(R.id.button2, PendingIntent.getActivity(context, 2, setBrightness2, PendingIntent.FLAG_UPDATE_CURRENT));	
		remoteViews.setOnClickPendingIntent(R.id.button3, PendingIntent.getActivity(context, 3, setBrightness3, PendingIntent.FLAG_UPDATE_CURRENT));		
		remoteViews.setOnClickPendingIntent(R.id.button4, PendingIntent.getActivity(context, 4, setBrightness4, PendingIntent.FLAG_UPDATE_CURRENT));		
		remoteViews.setOnClickPendingIntent(R.id.button5, PendingIntent.getActivity(context, 5, setBrightness5, PendingIntent.FLAG_UPDATE_CURRENT));		
		appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
		
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}
	
}
