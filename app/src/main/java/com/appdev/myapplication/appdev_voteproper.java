package com.appdev.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;


public class appdev_voteproper extends AppCompatActivity {
private TextView counter_vote1;
private TextView counter_vote2;
private TextView counter_vote3;
private TextView counter_vote4;

private Button vote1_btn;
private Button vote2_btn;
private Button vote3_btn;
private Button vote4_btn;

private int counter;

        ImageButton beforeButton, nextButton;
        ImageSwitcher imageSwitcher;

        int index = 0;
        int image[] = {R.drawable.entry4, R.drawable.entry2, R.drawable.entry3, R.drawable.entry5};

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appdev_voteproper);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.setTitle("Photo Vote");
        tb.setLogo(R.drawable.ic_camera_24);
        setSupportActionBar(tb);

        vote1_btn = (Button) findViewById(R.id.vote1_btn);
        vote2_btn = (Button) findViewById(R.id.vote2_btn);
        vote3_btn = (Button) findViewById(R.id.vote3_btn);
        vote4_btn = (Button) findViewById(R.id.vote4_btn);

        vote1_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                openDialog();
                }
                });

        vote2_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                openDialog();
                }
                });

        vote3_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                openDialog();
                }
                });

        vote4_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                openDialog();
                }
                });

        beforeButton = findViewById(R.id.before);
        nextButton = findViewById(R.id.next);
        imageSwitcher = findViewById(R.id.entries);

        beforeButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        --index;
        if (index < 0) {
        index = image.length - 1;
        }
        imageSwitcher.setImageResource(image[index]);
        }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        index++;
        if (index == image.length) {
        index = 0;
        }
        imageSwitcher.setImageResource(image[index]);
        }
        });

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
@Override
public View makeView() {
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setMaxWidth(300);
        imageView.setMaxHeight(300);

        return imageView;
        }
        });

        imageSwitcher.setImageResource(image[index]);
        }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_vote, menu);
        return true;
        }

@Override
public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();

        if (item_id == R.id.log_out) {
        alertDialog();
        }
        return true;
        }

private void alertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("You will automatically exit the page once confirmed.");
        dialog.setTitle("Confirm log out?");
        dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog,
        int which) {
        openbacktofirst();
        }
        });
        dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getApplicationContext(), "Action Cancelled", Toast.LENGTH_LONG).show();
        }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
        }
public void openbacktofirst(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Successfully logged out", Toast.LENGTH_LONG).show();
        }


public void openDialog(){
        ExampleDialog dialog = new ExampleDialog();
        dialog.show(getSupportFragmentManager(), "example dialog");
        }


}
