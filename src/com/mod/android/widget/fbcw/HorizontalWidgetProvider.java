package com.mod.android.widget.fbcw;

import android.widget.RemoteViews;

public class HorizontalWidgetProvider extends BaseWidgetProvider {

	@Override
	RemoteViews createRemoteViews(String packageName) {
		return new RemoteViews(packageName, R.layout.buttons_horizontal);
	}

}
