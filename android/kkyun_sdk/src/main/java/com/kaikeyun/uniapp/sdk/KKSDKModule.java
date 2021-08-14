package com.kaikeyun.uniapp.sdk;

import android.app.Activity;
import com.kaikeyun.sdk.KKSDK;

import io.dcloud.feature.uniapp.annotation.UniJSMethod;
import io.dcloud.feature.uniapp.bridge.UniJSCallback;
import io.dcloud.feature.uniapp.common.UniDestroyableModule;
import io.dcloud.feature.uniapp.utils.UniLogUtils;
import io.dcloud.feature.uniapp.utils.UniResourceUtils;

public class KKSDKModule extends UniDestroyableModule {
    @UniJSMethod(uiThread = true)
    public void openRoom(int roomid, int userid, String token){
        if(mUniSDKInstance!= null && mUniSDKInstance.getContext() instanceof Activity) {
            KKSDK.getInstance().openRoom(roomid, userid, token, (Activity)mUniSDKInstance.getContext());
        }
    }

    @UniJSMethod(uiThread = true)
    public void openPlay(String recid, int userid, String token){
        if(mUniSDKInstance!= null && mUniSDKInstance.getContext() instanceof Activity) {
            KKSDK.getInstance().openPlay(recid, userid, token, (Activity)mUniSDKInstance.getContext());
        }
    }

    @Override
    public void destroy() {
        KKSDK.getInstance().closeRoom();
        KKSDK.getInstance().closePlay();
    }
}
