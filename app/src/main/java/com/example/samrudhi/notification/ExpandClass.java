package com.example.samrudhi.notification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.RelativeLayout;
import android.widget.TextView;


public class ExpandClass extends AppCompatActivity {

    private TextView notificationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_class);
        notificationText = (TextView) findViewById(R.id.textView);
        notificationText.setText("Expand");
    }
}
