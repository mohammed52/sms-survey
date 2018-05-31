package com.example.user.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {
    public static final String MY_TAG = "my_custom_message";

    private static Button button_boadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickBroadcastButtonListener(View view) {
        Log.v("MAP", "is this for real ?");
        Intent intent = new Intent(this, BroadcastActivity.class);
        startActivity(intent);
    }

    public void onClickUpdateContactsButtonListener(View view) {
        Log.v("MAP", "read file");
        Log.v("MAP", Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.v("MAP", "/storage/sdcard/MAP/Sample ITS File(filtered).csv");
//        CSVReader reader = new CSVReader(new FileReader(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Download/filtered.csv"));
//        List myEntries = reader.readAll();

        readMumineenData();


    }
    private List<MuminSample> muminSamples = new ArrayList<>();

    private void readMumineenData(){
        InputStream is = getResources().openRawResource(R.raw.filtered);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        try {

            // step over header
            reader.readLine();

            while((line = reader.readLine()) != null){
                Log.d("MAP", "line: "+ line + "\n");
                // split by ','
                String[] tokens = line.split(",");

                // read the data
                MuminSample sample = new MuminSample();
                sample.setIts(Integer.parseInt(tokens[0]));
                sample.setHofIts(Integer.parseInt(tokens[1]));
                sample.setAge(Integer.parseInt(tokens[2]));


                sample.setGender(tokens[3].toCharArray()[0]);
                sample.setMobileNo(new BigInteger(tokens[4]));
                sample.setFullName(tokens[5]);
                sample.setCountFamilyMembers(Integer.parseInt(tokens[6]));

                muminSamples.add(sample);
                Log.d("MAP", "just created: "+ sample);

            }
        } catch (IOException e){
            Log.wtf("MAP", "Error reading data file on line "+line, e);
            e.printStackTrace();
        }






    }
}
