package com.appdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class appdev_signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appdev_signup);

        MaterialButton signup_btn =(MaterialButton) findViewById(R.id.signup_btn);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensuccessreg();
            }
        });
    }
    public void opensuccessreg(){
        Toast.makeText(appdev_signup.this, "Successful",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, appdev_login.class);
        startActivity(intent);
    }
}