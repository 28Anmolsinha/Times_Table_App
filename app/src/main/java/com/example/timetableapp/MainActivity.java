package com.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTablesListView;
    public  void generatetimesTable(int timesTable){
        ArrayList<String> timesTablecontent=new ArrayList<String>();
        for(int i=1;i<=10;i++){
            timesTablecontent.add(Integer.toString(i* timesTable));
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timesTablecontent);
        timesTablesListView.setAdapter(arrayAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timesTableSeekBar= (SeekBar) findViewById(R.id.timesTableSeekBar);
        timesTablesListView= (ListView) findViewById(R.id.timesTablesListView);

        timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(10);
        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int  timestable;
                if(progress<min){
                    timestable=min;
                    timesTableSeekBar.setProgress(min);
                }else{
                    timestable=progress;
                }

//                Log.i("Seekbar Value",Integer.toString(timestable));
                generatetimesTable(timestable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        });
        generatetimesTable(10);

        int timesTable=10;
        ArrayList<String> timesTablecontent=new ArrayList<String>();
        for(int i=1;i<=10;i++){
            timesTablecontent.add(Integer.toString(i* timesTable));
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timesTablecontent);
        timesTablesListView.setAdapter(arrayAdapter);
    }

}