package edu.tjhsst.quizyourfriend;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.*;

import java.lang.reflect.Array;
import java.util.*;

public class EndActivity extends AppCompatActivity {

    private FirebaseDatabase mFire;
    private DatabaseReference mBase;
    private DatabaseReference one;
    private DatabaseReference two;
    private EditText mName1;
    private EditText mName2;
    private double score;
    private Button mSubmit;
    private Button mHighscore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Button mAgain = (Button) findViewById(R.id.restart);
        TextView mRip = (TextView) findViewById(R.id.rip);
        ImageView mFace = (ImageView) findViewById(R.id.face);
        TextView mScore = (TextView) findViewById(R.id.score);
        mName1 = (EditText)findViewById(R.id.name1);
        mName2 = (EditText)findViewById(R.id.name2);
        mSubmit = (Button)findViewById(R.id.submit);
        mHighscore = (Button)findViewById(R.id.highscore);
        score = getIntent().getDoubleExtra("score", 5);
        mScore.setText("score:" + score);
        if (score >= 8.0){
            mRip.setText("You guys really are friends!\nPlease enter your names!");
            mFace.setImageResource(R.drawable.smile);
            MediaPlayer win = MediaPlayer.create(EndActivity.this,R.raw.win);
            win.start();
        }else if (score >= 3.0){
            mRip.setText("I guess you kinda know each other\nPlease enter your names!");
            mFace.setImageResource(R.drawable.meh);
            MediaPlayer die = MediaPlayer.create(EndActivity.this,R.raw.die);
            die.start();
        }else{
            mRip.setText("Forever Alone\nPlease enter your names!");
            mFace.setImageResource(R.drawable.heartbreak);
            MediaPlayer over = MediaPlayer.create(EndActivity.this,R.raw.over);
            over.start();
        }
        mFire = FirebaseDatabase.getInstance();
        mBase = mFire.getReference("peoples");

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBase.push().setValue(new Highscores(score, mName1.getText().toString(), mName2.getText().toString()));
            }
        });
        mHighscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent high = new Intent(EndActivity.this,HighscoreActivity.class);
                startActivity(high);
            }
        });
        mAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent output = getIntent();
                output.putExtra("result", 0);
                setResult(RESULT_OK, output);
                finish();
            }
        });

    }
}
