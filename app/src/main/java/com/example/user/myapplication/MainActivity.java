package com.example.user.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.renderscript.Element;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    private List<MuminReplies> muminReplies = new ArrayList<>();

    public void onClickGenerateReport(View view){
        Log.d("MAP", "generating report...");
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);

        if (cursor.moveToFirst()) { // must check the result to prevent exception
            do {
                String msgData = "";
                MuminReplies replySample = new MuminReplies();

                for(int idx=0;idx<cursor.getColumnCount();idx++)
                {
                    if (cursor.getColumnName(idx).matches("address")){
                        replySample.setMobileNo(cursor.getString(idx));
                    } else if(cursor.getColumnName(idx).matches("body")){
                        replySample.setAttendanceCount(Integer.parseInt(cursor.getString(idx)));
                    }
                }
//                Log.d("MAP", replySample.toString());
                muminReplies.add(replySample);
            } while (cursor.moveToNext());
        } else {
            // empty box, no SMS
        }

        Log.d("MAP", muminReplies.toString());


    }
}
