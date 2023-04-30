package com.example.internship;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    List<String> listViewValues;
    List<String> listViewDetails = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.mobile_list);



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You will be redirected to"+"  "+ listViewValues.get(i)+"  "+"Profile", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, photoView.class);

                intent.putExtra("details", listViewDetails.get(i));
                startActivity(intent);
            }


        });
        // listview= findViewById(R.id.mobile_list);
        //listview.setOnClickListener(new View.OnClickListener() {
        //  @Override
        // public void onClick(View v) {
        //   Intent intent = new Intent(getApplicationContext(),photoView.class);
        //  startActivity(intent);
        // }
        //});


        try {
            JSONObject jsonObject = new JSONObject(loadJsonFile());
            JSONArray jsonArray = jsonObject.getJSONArray("studentdetails");
            listViewValues = new ArrayList<String>();
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject obj = jsonArray.getJSONObject(i);
                String name = obj.getString("name");
                String details = obj.toString();
                listViewValues.add(name);
                listViewDetails.add(details);


            }
            ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.displayname, listViewValues);
            listview.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String loadJsonFile() throws IOException {
        String json=null;
        InputStream inputStream=this.getAssets().open("studentdetails.json");
        int size=inputStream.available();
        byte[] byteArray=new byte[size];
        inputStream.read(byteArray);
        inputStream.close();
        json=new String(byteArray, "UTF-8");
        return json;
    }
}