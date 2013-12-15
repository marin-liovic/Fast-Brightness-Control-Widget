package com.mod.android.widget.fbcw;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import static com.mod.android.widget.fbcw.MyConstants.*;

public abstract class BaseWidgetProvider extends AppWidgetProvider {
	
	public static final String ACTION_SET_BRIGHTNESS="com.mod.android.widget.fbcw.SetBrightness";
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		
		//create remoteViews
		RemoteViews remoteViews = createRemoteViews(context.getPackageName());
		
		//create intents for setting brightness when buttons are clicked
		Intent setBrightness1 = new Intent(context, BrightnessControlActivity.class);
		setBrightness1.setAction(ACTION_SET_BRIGHTNESS);
		setBrightness1.putExtra(BUTTON_ID, BUTTON1);
		Intent setBrightness2 = new Intent(context, BrightnessControlActivity.class);
		setBrightness2.setAction(ACTION_SET_BRIGHTNESS);
		setBrightness2.putExtra(BUTTON_ID, BUTTON2);
		Intent setBrightness3 = new Intent(context, BrightnessControlActivity.class);
		setBrightness3.setAction(ACTION_SET_BRIGHTNESS);
		setBrightness3.putExtra(BUTTON_ID, BUTTON3);
		Intent setBrightness4 = new Intent(context, BrightnessControlActivity.class);
		setBrightness4.setAction(ACTION_SET_BRIGHTNESS);
		setBrightness4.putExtra(BUTTON_ID, BUTTON4);
		Intent setBrightness5 = new Intent(context, BrightnessControlActivity.class);
		setBrightness5.setAction(ACTION_SET_BRIGHTNESS);
		setBrightness5.putExtra(BUTTON_ID, BUTTON5);
		
		//register on click listeners with buttons		
		remoteViews.setOnClickPendingIntent(R.id.button1, PendingIntent.getActivity(context, 1, setBrightness1, PendingIntent.FLAG_UPDATE_CURRENT));		
		remoteViews.setOnClickPendingIntent(R.id.button2, PendingIntent.getActivity(context, 2, setBrightness2, PendingIntent.FLAG_UPDATE_CURRENT));	
		remoteViews.setOnClickPendingIntent(R.id.button3, PendingIntent.getActivity(context, 3, setBrightness3, PendingIntent.FLAG_UPDATE_CURRENT));		
		remoteViews.setOnClickPendingIntent(R.id.button4, PendingIntent.getActivity(context, 4, setBrightness4, PendingIntent.FLAG_UPDATE_CURRENT));		
		remoteViews.setOnClickPendingIntent(R.id.button5, PendingIntent.getActivity(context, 5, setBrightness5, PendingIntent.FLAG_UPDATE_CURRENT));		
		appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
		
	}
	
	/**
	 * Creates RemoteViews object which will be displayed. Layout resource should contain 5 elements
	 * with IDs: button1, button2, button3, button4 and button5.
	 * @param packageName Name of the package that contains the layout resource.
	 * @return Return RemoteViews object which will be displayed.
	 */
	abstract RemoteViews createRemoteViews(String packageName);
	
}
