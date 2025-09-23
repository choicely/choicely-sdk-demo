package com.choicely.sdk.demo;

import android.app.Application;

import com.choicely.sdk.ChoicelySDK;
import com.choicely.sdk.demo.factory.AppContentFactory;
import com.choicely.sdk.demo.factory.AppSplashFactory;


public class MyApplication extends Application {
    static String TAG = "SDK-DEMO-APPLICATION";

    @Override
    public void onCreate() {
        super.onCreate();
        ChoicelySDK.init(this);
//        //for a custom content
        ChoicelySDK.factory().setContentFactory(new AppContentFactory());

//        //For a custom splash screen.
        ChoicelySDK.factory().setSplashFactory(new AppSplashFactory());


    }

}
