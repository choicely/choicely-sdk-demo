package com.choicely.sdk.demo.CustomScreen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.choicely.sdk.activity.ChoicelyIntentKeys;
import com.choicely.sdk.activity.content.ChoicelyContentFragment;
import com.choicely.sdk.activity.content.ChoicelyScreenActivity;
import com.choicely.sdk.activity.content.OnChoicelyContentClick;
import com.choicely.sdk.activity.content.article.ChoicelyArticleFragment;
import com.choicely.sdk.activity.content.survey.ChoicelySurveyFragment;
import com.choicely.sdk.activity.content.text.ChoicelyTextView;
import com.choicely.sdk.demo.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyCustomScreen extends ChoicelyContentFragment {
    FrameLayout articleContainer;

    @Override
    protected int getLayout() {
        return R.layout.fragment_custom_screen;
    }

    @Override
    protected void onLayoutCreated(@NonNull View layout, @Nullable Bundle savedInstanceState) {
        articleContainer = layout.findViewById(R.id.article_container);
    }

    @Override
    protected void updateContent(@NonNull ChoicelyScreenActivity act, @NonNull Bundle data) {
        setArticle();
    }


    private void setArticle() {
        Bundle bundle = new Bundle();
        bundle.putString(ChoicelyIntentKeys.ARTICLE_KEY, "Y2hvaWNlbHktZXUvYXJ0aWNsZXMvR01nN2dyWXlIeTkxcERWT1BETjg");
        ChoicelyArticleFragment articleFragment = new ChoicelyArticleFragment();
        articleFragment.setArguments(bundle);
        replaceFragment(articleContainer.getId(), articleFragment, false);
    }
}