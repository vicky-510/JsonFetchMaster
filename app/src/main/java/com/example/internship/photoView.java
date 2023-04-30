package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class photoView extends AppCompatActivity {
    TextView txt_down,txt_up;
    TextView textViewDetails1,textViewDetails2,textViewDetails3;

    ImageView image_view;
    Button button1,button2,button3;
    List<String> listViewValues;
    List<String> listViewDetails = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);

        image_view = findViewById(R.id.imageView);

        txt_up = findViewById(R.id.txt_up);
        txt_down = findViewById(R.id.txt_down);

        textViewDetails1 = findViewById(R.id.txt_up);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        String details = getIntent().getStringExtra("details");



        try {
            JSONObject jsonObject = new JSONObject(details);
            String name = jsonObject.getString("name");
            String naanmudhalvanid = jsonObject.getString("naanmudhalvanid");
            String collegename = jsonObject.getString("collegename");
            String standard = jsonObject.getString("standard");
            String age = jsonObject.getString("age");
            String dob = jsonObject.getString("dob");
            String address = jsonObject.getString("address");
            String mobilenumber = jsonObject.getString("mobilenumber");

            String formattedDetails1 = name;
            textViewDetails1.setText(formattedDetails1);




            button1.setOnClickListener(v -> {
                // get the value which input by user in EditText and convert it to string
                String formattedDetails = "Name: " + name + "\n\nAge: " + age + "\n\nDOB: " + dob;
                // Create the Intent object of this class Context() to Second_activity class
                Intent intent = new Intent(getApplicationContext(), about.class);
                // now by putExtra method put the value in key, value pair key is
                // message_key by this key we will receive the value, and put the string
                intent.putExtra("message_key", formattedDetails);
                // start the Intent
                startActivity(intent);
            });
            button2.setOnClickListener(v -> {
                // get the value which input by user in EditText and convert it to string
                String formattedDetails2 = "Naan mudhalvan ID: " + naanmudhalvanid + "\n\nStandard: " + standard+ "\n\nCollege name: " + collegename ;
                // Create the Intent object of this class Context() to Second_activity class
                Intent intent = new Intent(getApplicationContext(), academic.class);
                // now by putExtra method put the value in key, value pair key is
                // message_key by this key we will receive the value, and put the string
                intent.putExtra("message_key", formattedDetails2);
                // start the Intent
                startActivity(intent);
            });
            button3.setOnClickListener(v -> {
                // get the value which input by user in EditText and convert it to string
                String formattedDetails3 = "Name: " + name + "\n\nAddress: " + address + "\n\nMobile number: " + mobilenumber;
                // Create the Intent object of this class Context() to Second_activity class
                Intent intent = new Intent(getApplicationContext(), contact.class);
                // now by putExtra method put the value in key, value pair key is
                // message_key by this key we will receive the value, and put the string
                intent.putExtra("message_key", formattedDetails3);
                // start the Intent
                startActivity(intent);
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}