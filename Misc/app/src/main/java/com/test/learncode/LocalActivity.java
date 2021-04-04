package com.test.learncode;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class LocalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        Button btnEnglish = findViewById(R.id.btn_english);
        Button btnNepali = findViewById(R.id.btn_nepali);
        Button btnFrench = findViewById(R.id.btn_french);

        btnFrench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("ne");
                Locale.setDefault(locale);

                Configuration configuration = new Configuration();
                configuration.locale = locale;
                getResources().updateConfiguration(
                        configuration,
                        getResources().getDisplayMetrics());
                recreate();
            }
        });
    }
}