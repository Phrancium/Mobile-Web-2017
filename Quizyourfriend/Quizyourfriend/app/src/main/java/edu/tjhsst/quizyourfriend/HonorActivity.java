package edu.tjhsst.quizyourfriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HonorActivity extends AppCompatActivity {

    private Button mCheat;
    private TextView mAnswer;
    private int Strike;
    private Button mExit;
    private int one;
    private int two;
    private int three;
    private int four;
    boolean truth = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honor);

        Strike = getIntent().getIntExtra("cheat", 1);
        Question q = (Question)getIntent().getSerializableExtra("question");
        one = q.getA();
        two = q.getB();
        three = q.getC();
        four = q.getD();
        mAnswer = (TextView)findViewById(R.id.hint);

        mCheat = (Button)findViewById(R.id.lie);
        mCheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Strike == one){
                    mAnswer.setText(R.string.answerA);
                }else if (Strike == two){
                    mAnswer.setText(R.string.answerB);
                }else if (Strike == three){
                    mAnswer.setText(R.string.answerC);
                }else{
                    mAnswer.setText(R.string.answerD);
                }
                truth = true;
            }
        });
        mExit = (Button)findViewById(R.id.repent);
        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent output = getIntent();
                output.putExtra("truth", truth);
                setResult(RESULT_OK, output);
                finish();
            }
        });
    }
}
