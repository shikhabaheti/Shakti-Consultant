package com.shakticonsultant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.shakticonsultant.databinding.ActivityAboutUsBinding;

public class AboutUsActivity extends AppCompatActivity {

    ActivityAboutUsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgBackArrow.setOnClickListener(v -> {
            onBackPressed();
        });

    }
}