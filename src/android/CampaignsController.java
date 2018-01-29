package com.dude.plugins.install;

import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by huyuqiong on 2018/1/29.
 */

public class CampaignsController extends CordovaPlugin {
    private static final String TAG = "CampaignsController";
    private static final String ACTION_GET = "getParams";

    @Override
    public boolean execute(String action, JSONArray args,
                           final CallbackContext callbackContext) {

        Log.d(TAG, "execute called");
        PluginResult result;
        JSONObject tmpObj = null;

        if (ACTION_GET.equals(action)) {
            tmpObj = getParameters(PlayCampaignReceiver.REFERENCE);
            result = new PluginResult(PluginResult.Status.OK, tmpObj);
            Log.d(TAG, "Campains:" + result.toString());
            callbackContext.sendPluginResult(result);
        }
        return true;
    }

    public JSONObject getParameters(String url) {
        JSONObject params = new JSONObject();
        String[] parameters = url.split("&");
        if (parameters != null && parameters.length != 0) {
            for (int i = 0; i < parameters.length; i++) {
                if (parameters[i] != null && parameters[i].trim().contains("=")) {
                    String[] split2 = parameters[i].split("=");
                    if (split2.length == 1) {
                        //有这个参数但是是空的
                        try {
                            params.put(split2[0], "");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else if (split2.length == 2) {
                        if (!"".equals(split2[0].trim())) {
                            try {
                                params.put(split2[0], split2[1]);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return params;
    }
}