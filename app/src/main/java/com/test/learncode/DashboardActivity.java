package com.test.learncode;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        String data = getIntent().getStringExtra("stdName");
        Toast.makeText(DashboardActivity.this, data, Toast.LENGTH_LONG).show();
    }
}