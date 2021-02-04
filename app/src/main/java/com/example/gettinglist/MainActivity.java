package com.example.gettinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView); // taking list view

        ArrayList<String> myFamily = new ArrayList<String>(); // creating list elements
        myFamily.add("Sarvesh");
        myFamily.add("Yogita");
        myFamily.add("Vikrant");
        myFamily.add("Nishant");
        myFamily.add("Siddhant");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFamily); // creating arrayAdapter and linking the list we created
        listView.setAdapter(arrayAdapter); // arrayAdapter is a bridge which connects listview with list.

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Info", myFamily.get(position));
            }
        });
    }
}