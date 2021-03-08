package com.test.learncode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.et_name);
        address = findViewById(R.id.et_address);
    }

    public void onLogin(View view) {


        switch (view.getId()) {
            case R.id.tv_forgot_password:


                startActivity(new Intent(MainActivity.this, ForgotPasswordActivity.class));
                break;
            case R.id.btn_login:

                String myName = name.getText().toString();
                Intent intent = new Intent(MainActivity.this,
                        DashboardActivity.class);
                intent.putExtra("stdName", myName);
                startActivity(intent);
                break;

        }

        /*//Toast.makeText(MainActivity.this, "Hello this toast", Toast.LENGTH_SHORT).show();
        String myName = name.getText().toString();
        String myAddress = address.getText().toString();
        Toast.makeText(MainActivity.this,
               myName+" "+myAddress ,
                Toast.LENGTH_LONG)
                .show();

        Log.e("ONLogin",myName+" "+myAddress);
        Log.i("ONLogin",myName+" "+myAddress);*/


    }

}