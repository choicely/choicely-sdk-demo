package com.choicely.sdk.demo.factory;

import com.choicely.sdk.activity.splash.AbstractSplashFragment;
import com.choicely.sdk.activity.splash.ChoicelySplashFactory;
import com.choicely.sdk.demo.splash.DemoAppSplashFragment;

public class AppSplashFactory implements ChoicelySplashFactory {

    @Override
    public AbstractSplashFragment makeSplashFragment() {
        return new DemoAppSplashFragment();
    }
}
