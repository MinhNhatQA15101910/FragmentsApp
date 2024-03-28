package com.donhat.fragmentsapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private Button _displayFragment1Btn;
    private Button _displayFragment2Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();

        handleEvents();
    }

    private void handleEvents() {
        _displayFragment1Btn.setOnClickListener(v1 -> loadFragment(new FirstFragment()));

        _displayFragment2Btn.setOnClickListener(v1 -> loadFragment(new SecondFragment()));
    }

    private void initializeViews() {
        _displayFragment1Btn = findViewById(R.id.display_fragment_1_btn);
        _displayFragment2Btn = findViewById(R.id.display_fragment_2_btn);
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.frame_layout, fragment);
        ft.commit();
    }
}