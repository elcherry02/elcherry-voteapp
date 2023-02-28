package com.appdev.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class appdev_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appdev_login);

        TextView textView = findViewById(R.id.register);
        String text = "Not a member yet? Register here.";
        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                openappdev_signup();
            }
        };
        ss.setSpan(clickableSpan, 27, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());


        MaterialButton login_btn = (MaterialButton) findViewById(R.id.login_btn);

        //admin1 and user123

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensignup();
            }
        });

    }

    public void openappdev_signup() {
        Intent intent = new Intent(this, appdev_signup.class);
        startActivity(intent);
    }

    public void opensignup(){
        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        if (username.getText().toString().equals("admin1") && password.getText().toString().equals("user123")){
            //correct
            Toast.makeText(appdev_login.this, "LOG IN SUCCESSFUL",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, appdev_voteproper.class);
            startActivity(intent);
        } else
            Toast.makeText(appdev_login.this, "INCORRECT DETAILS",Toast.LENGTH_SHORT).show();
    }
}