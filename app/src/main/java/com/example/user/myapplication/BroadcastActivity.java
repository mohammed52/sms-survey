package com.example.user.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class BroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
    }

    public void onClickBroadcastButtonListener(View view) {
        Log.v("MAP", "send sms ?");

        readMumineenData();

    }

    private List<MuminSample> muminSamples = new ArrayList<>();

    private void readMumineenData() {
//        InputStream is = getResources().openRawResource(R.raw.filtered); work
        InputStream is = null;
        try {
            is = new FileInputStream("/storage/sdcard/MAP/filtered.csv");


            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is, Charset.forName("UTF-8"))
            );
            String line = "";
            try {

                // step over header
                reader.readLine();

                while ((line = reader.readLine()) != null) {
                    Log.d("MAP", "line: " + line + "\n");
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
//                    Log.d("MAP", "just created: " + sample);

                }
            } catch (IOException e) {
                Log.wtf("MAP", "Error reading data file on line " + line, e);
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        sendBulkSms();






    }

    private void sendBulkSms() {
        Log.d("MAP", "lets get the phone numbers");

        for (int i = 0; i < muminSamples.size(); i++) {
            Log.d("MAP", muminSamples.get(i).getMobileNo().toString());
            SmsManager sms = SmsManager.getDefault();

            EditText smsField = (EditText)findViewById(R.id.editText2);
            String smsText = muminSamples.get(i).getFullName() + "\n" + smsField.getText();

            sms.sendTextMessage("+"+muminSamples.get(i).getMobileNo().toString(), null, smsText, null, null);
        }
    }
}
