package com.choicely.sdk.demo.CustomScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.choicely.sdk.demo.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyCustomScreen extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_screen, container, false);

        Button toast = view.findViewById(R.id.toast);
        toast.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Hi i am a Custom Fragment", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}

