package com.choicely.sdk.demo;

import android.app.Application;

import com.choicely.sdk.ChoicelySDK;
import com.choicely.sdk.demo.factory.MyContentFactory;
import com.choicely.sdk.demo.factory.MySplashFactory;


public class MyApplication extends Application {
    static String TAG = "SDK-DEMO-APPLICATION";

    @Override
    public void onCreate() {
        super.onCreate();
        ChoicelySDK.init(this, "Y2hvaWNlbHktZXUvYXBwcy9kS1lHUUtUbWREa1pRb1ltZFRiZQ");
//        //for a custom content
        ChoicelySDK.factory().setContentFactory(new MyContentFactory());

//        //For a custom splash screen.
        ChoicelySDK.factory().setSplashFactory(new MySplashFactory());


    }

}
