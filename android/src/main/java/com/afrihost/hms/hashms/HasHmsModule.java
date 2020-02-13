package com.afrihost.hms.hashms;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.huawei.hms.api.HuaweiApiAvailability;

public class HasHmsModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext mContext;

    public HasHmsModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.mContext = reactContext;
    }

    @Override
    public String getName() {
        return "HasHms";
    }

    @ReactMethod
    public void isHMSAvailable(Promise promise) {
        HuaweiApiAvailability hms = HuaweiApiAvailability.getInstance();
        int isHMS = hms.isHuaweiMobileServicesAvailable(mContext);
        promise.resolve(isHMS == ConnectionResult.SUCCESS);
    }

    @ReactMethod
    public void isGMSAvailable(Promise promise) {
        GoogleApiAvailability gms = GoogleApiAvailability.getInstance();
        int isGMS = gms.isGooglePlayServicesAvailable(mContext);
        promise.resolve(isGMS == ConnectionResult.SUCCESS);
    }
}
