package edu.tjhsst.quizyourfriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.Serializable;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AnswerActivity extends AppCompatActivity {

    private Button mAB;
    private Button mBB;
    private Button mCB;
    private Button mDB;
    private Button mHonor;
    private Button mBrexit;
    private TextView mText;
    private TextView mTrulse;
    private Question q;
    double fail = 0.0;
    double mult = 1.0;
    private int right;
    private int one;
    private int two;
    private int three;
    private int four;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        mText = (TextView)findViewById(R.id.qtext);
        mTrulse = (TextView)findViewById(R.id.trulse);
        mAB = (Button)findViewById(R.id.AB);
        mBB = (Button)findViewById(R.id.BB);
        mCB = (Button)findViewById(R.id.CB);
        mDB = (Button)findViewById(R.id.DB);
        mBrexit = (Button)findViewById(R.id.brexit);
        right = getIntent().getIntExtra("correct", 1);
        q = (Question)getIntent().getSerializableExtra("question");
        mText.setText(q.getQid2());
        one = q.getA();
        two = q.getB();
        three = q.getC();
        four = q.getD();
        mAB.setText(one);
        mBB.setText(two);
        mCB.setText(three);
        mDB.setText(four);



        mAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (one == right) {
                    mTrulse.setText(R.string.correct_toast);
                    fail = mult;
                }else {
                    mTrulse.setText(R.string.incorrect_toast);
                }
                mAB.setEnabled(false);
                mBB.setEnabled(false);
                mCB.setEnabled(false);
                mDB.setEnabled(false);
            }
        });

        mBB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (two == right) {
                    mTrulse.setText(R.string.correct_toast);
                    fail = mult;
                }else {
                    mTrulse.setText(R.string.incorrect_toast);
                }
                mAB.setEnabled(false);
                mBB.setEnabled(false);
                mCB.setEnabled(false);
                mDB.setEnabled(false);
            }
        });

        mCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (three == right) {
                    mTrulse.setText(R.string.correct_toast);
                    fail = mult;
                }else {
                    mTrulse.setText(R.string.incorrect_toast);
                }
                mAB.setEnabled(false);
                mBB.setEnabled(false);
                mCB.setEnabled(false);
                mDB.setEnabled(false);
            }
        });

        mDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (four == right) {
                    mTrulse.setText(R.string.correct_toast);
                    fail = mult;
                }else {
                    mTrulse.setText(R.string.incorrect_toast);
                }
                mAB.setEnabled(false);
                mBB.setEnabled(false);
                mCB.setEnabled(false);
                mDB.setEnabled(false);
            }
        });
        mHonor = (Button)findViewById(R.id.HonorCode);
        mHonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AnswerActivity.this,HonorActivity.class);
                i.putExtra("cheat",right);
                i.putExtra("question", getIntent().getSerializableExtra("question"));
                startActivityForResult(i, 9);
            }
        });
        mBrexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent output = getIntent();
                output.putExtra("result", fail);
                setResult(RESULT_OK, output);
                finish();
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 9) {
            if (resultCode == RESULT_OK) {
                boolean fake = data.getBooleanExtra("truth", true);
                if(fake){
                    mult = .6;
                }
            }
        }
    }
}
