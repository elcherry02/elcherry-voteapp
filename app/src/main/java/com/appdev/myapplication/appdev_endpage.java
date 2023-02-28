package com.appdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class appdev_endpage extends AppCompatActivity {
    TextView backvote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appdev_endpage);

        backvote =(TextView)findViewById(R.id.backvote);
        backvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbackvote();
            }
        });

        MaterialButton logout_btn =(MaterialButton) findViewById(R.id.logout_btn);
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogout();
            }
        });
    }
    public void openbackvote(){
        Intent intent = new Intent(this, appdev_voteproper.class);
        startActivity(intent);
    }
    public void openlogout(){
        Toast.makeText(getApplicationContext(), "Successfully logged out", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
