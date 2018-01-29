package com.dude.plugins.install;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.analytics.CampaignTrackingReceiver;

/**
 * Created by huyuqiong on 2018/1/26.
 */

public class PlayCampaignReceiver extends BroadcastReceiver {
    private static final String LOGTAG = "PlayCampaignReceiver";
    public static String REFERENCE = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(LOGTAG, "****************************");
        REFERENCE = intent.getStringExtra("referrer");
        Log.e(LOGTAG, REFERENCE);
        new CampaignTrackingReceiver().onReceive(context, intent);
    }
}
