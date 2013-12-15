package com.mod.android.widget.fbcw;

import android.widget.RemoteViews;

public class VerticalWidgetProvider extends BaseWidgetProvider {

	@Override
	RemoteViews createRemoteViews(String packageName) {
		return new RemoteViews(packageName, R.layout.buttons_vertical);
	}

}
