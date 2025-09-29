package com.choicely.sdk.demo.factory;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

import com.choicely.sdk.activity.ChoicelyIntentKeys;
import com.choicely.sdk.activity.content.factory.ChoicelyContentFragmentFactory;
import com.choicely.sdk.demo.CustomScreen.MyCustomScreen;
import com.choicely.sdk.util.CTextUtils;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyContentFactory extends ChoicelyContentFragmentFactory {
    @Nullable
    @Override
    protected Fragment makeAppContentFragment(Context context, String type, @Nullable Uri internalUri, Bundle data) {
        Fragment fragment = null;
        if (type.equals("special")) {
            final String internalUrl = data.getString(ChoicelyIntentKeys.INTERNAL_URL);
            if (!TextUtils.isEmpty(internalUrl)) {
                final Uri uri = Uri.parse(internalUrl);
                if (uri != null) {
                    final String key = uri.getLastPathSegment();
                    if (!CTextUtils.isEmpty(key)) {
                        if (key.equals("custom")) {
                            fragment = new MyCustomScreen();
                        }
                    }
                }
            }
        }
        return fragment;
    }
}