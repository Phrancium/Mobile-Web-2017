package com.phrancium.mysteryapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.firebase.analytics.FirebaseAnalytics;

public class MysteryActivity extends AppCompatActivity {

    private FirebaseDatabase fire;
    private DatabseReference base;
    private Button butt;
    private TextView t;
    private EditText e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mystery);

        butt = (Button)findViewById(R.id.restart);
        t = (TextView)findViewById(R.id.score);
    }
}
