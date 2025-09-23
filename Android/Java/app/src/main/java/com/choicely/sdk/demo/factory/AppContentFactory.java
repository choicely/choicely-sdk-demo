package com.choicely.sdk.demo.factory;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import com.choicely.sdk.activity.content.ChoicelyContentFragment;
import com.choicely.sdk.activity.content.factory.ChoicelyContentFragmentFactory;
import com.choicely.sdk.demo.CustomScreen.MyCustomScreen;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AppContentFactory extends ChoicelyContentFragmentFactory {

    private static final String TAG = "AppContentFactory";

    @Nullable
    @Override
    protected Fragment makeAppContentFragment(Context context, String type, @Nullable Uri internalUri, Bundle data) {
        ChoicelyContentFragment fragment = null;
        if (type.equals("custom-screen")) {
            fragment = new MyCustomScreen();
        }
        return fragment;
    }

}