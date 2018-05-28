package com.example.user.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {
    public static final String MY_TAG = "my_custom_message";

    private static Button button_boadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickButtonListener(View view) {
        Log.v("MAP", "is this for real ?");
        Intent intent = new Intent(this, BroadcastActivity.class);
        startActivity(intent);
    }
}
