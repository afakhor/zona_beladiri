package com.heruwngchn.addhmescrn;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.RemoteViews;
import com.esatpro.home_widget.HomeWidgetProvider;

public class AtletWidgetProvider extends HomeWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds, SharedPreferences widgetData) {
        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_atlet_layout);
            
            String nama = widgetData.getString("key_nama", "Nama Atlet");
            views.setTextViewText(R.id.widget_atlet_nama, nama);
            
            String pathGambar = widgetData.getString("key_path_grafik", null);
            if (pathGambar != null) {
                Bitmap bitmapGrafik = BitmapFactory.decodeFile(pathGambar);
                views.setImageViewBitmap(R.id.widget_grafik_gabungan, bitmapGrafik);
            }

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
