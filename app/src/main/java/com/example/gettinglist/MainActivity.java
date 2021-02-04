package com.example.gettinglist;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    public void generateTimesTable(int timesValue){
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for(int j = 1; j<=10; j++){
            timesTableContent.add(Integer.toString(j * timesValue));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        listView.setAdapter(arrayAdapter);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        listView = (ListView) findViewById(R.id.listView);

        int max = 20;
        int startingPosition = 10;

        seekBar.setMax(max);
        seekBar.setProgress(startingPosition);
        generateTimesTable(startingPosition);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesValue;
                if(progress < min){
                    timesValue = min;
                    seekBar.setProgress(min);
                } else {
                    timesValue = progress;
                }
                Log.i("SeekBar Value", Integer.toString(timesValue));
                generateTimesTable(timesValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
//        listView.setAdapter(arrayAdapter);

    }


}