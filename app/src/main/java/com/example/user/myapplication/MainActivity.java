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

import java.io.FileReader;
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
        CSVReader reader = new CSVReader(new FileReader(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Download/filtered.csv"));
        List myEntries = reader.readAll();

    }
}
