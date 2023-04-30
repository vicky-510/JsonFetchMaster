package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import org.json.JSONException;
import org.json.JSONObject;

public class contact extends AppCompatActivity {
    TextView txt_down,txt_up,txt_banner;
    TextView textViewDetails;

    ImageView image_view;
    //Button button1,button2,button3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        image_view = findViewById(R.id.imageView);

        txt_up = findViewById(R.id.txt_up);
        txt_banner = findViewById(R.id.txt_banner);
        txt_down = findViewById(R.id.txt_down);

        textViewDetails = findViewById(R.id.txt_up);
        String details = getIntent().getStringExtra("message_key");

        // display the string into textView
        textViewDetails.setText(details);

    }
}