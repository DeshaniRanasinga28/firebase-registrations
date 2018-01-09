package com.example.ef.cicit.services.firebase;

import com.firebase.client.Firebase;

/**
 * Created by EF on 07-Dec-17.
 */

public class CustomApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
