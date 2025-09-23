package com.choicely.sdk.demo.splash;

import android.os.Bundle;
import android.view.View;

import com.choicely.sdk.activity.splash.AbstractSplashFragment;
import com.choicely.sdk.demo.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DemoAppSplashFragment extends AbstractSplashFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_splash;
    }

    @Override
    protected void onLayoutCreated(@NonNull View layout, @Nullable Bundle savedInstanceState) {
        super.onLayoutCreated(layout, savedInstanceState);
        updateSplash();
    }

    private void updateSplash() {
    }

    //Set Splash Duration.
    @Override
    protected long getSplashDuration() {
        return 600;
    }

}
