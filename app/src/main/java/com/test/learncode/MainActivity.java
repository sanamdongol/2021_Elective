package com.test.learncode;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name;
    EditText address;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.et_name);
        address = findViewById(R.id.et_address);
        layout = findViewById(R.id.linearLayout);


        TextView tvNewUser = findViewById(R.id.tv_new_account);
        tvNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show dialog box
                //make buttoclick able
                ///set title of the dialog

                AlertDialog.Builder alertDialog = new
                        AlertDialog.Builder(MainActivity.this);

                alertDialog.setTitle("Exit App");
                alertDialog.setMessage("Do you want to close this app?");
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


                https://developer.android.com/guide/topics/ui/dialogs
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alertDialog.show();

            }
        });

        //   Button loginBtn = findViewById(R.id.btn_login);

       /* loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Button Clicked",
                        Toast.LENGTH_SHORT).show();

                Log.e("button clicked", "byutton clicked");
            }
        });*/

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this,
                "Button Clicked",
                Toast.LENGTH_SHORT).show();

        ///= Log.e("button clicked", "byutton clicked");
    }

    public void onLogin(View view) {


        switch (view.getId()) {
            case R.id.tv_forgot_password:


                startActivity(new Intent(MainActivity.this, ForgotPasswordActivity.class));
                break;
            case R.id.btn_login:

                /*Toast.makeText(MainActivity.this,
                        "Button Clicked",
                        Toast.LENGTH_SHORT).show();*/

                /*Snackbar.make(layout,
                        "This is snack bar",
                        Snackbar.LENGTH_LONG).show();*/

                Snackbar snackbar = Snackbar
                        .make(layout, "Message is deleted", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(layout, "Message is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });

                snackbar.show();
                break;
        }

    }

}




               /* String myName = name.getText().toString();
                Intent intent = new Intent(MainActivity.this,
                        DashboardActivity.class);
                intent.putExtra("stdName", myName);
                startActivity(intent);*/





