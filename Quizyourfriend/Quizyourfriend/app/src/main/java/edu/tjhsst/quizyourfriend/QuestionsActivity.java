package edu.tjhsst.quizyourfriend;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionsActivity extends AppCompatActivity {

    private Button mAB;
    private Button mBB;
    private Button mCB;
    private Button mDB;
    private TextView mTextView;
    private TextView mScore;
    private int mnumb = 0;
    private double score = 0;
    static final int requestcode = 14;
    static final int requestcode2 = 8;
    private Question[] mquestions = new Question[]{
            new Question(R.string.question1, R.string.question1f, R.string.question1d, R.string.question1a, R.string.question1b,R.string.question1c),
            new Question(R.string.question2, R.string.question2f, R.string.question2a, R.string.question2b, R.string.question2c,R.string.question2d),
            new Question(R.string.question3, R.string.question3f, R.string.question3a, R.string.question3b, R.string.question3c,R.string.question3d),
            new Question(R.string.question4, R.string.question4f, R.string.question4a, R.string.question4b, R.string.question4c,R.string.question4d),
            new Question(R.string.question5, R.string.question5f, R.string.question5a, R.string.question5b, R.string.question5c,R.string.question5d),
            new Question(R.string.question6, R.string.question6f, R.string.question6a, R.string.question6b, R.string.question6c,R.string.question6d),
            new Question(R.string.question7, R.string.question7f, R.string.question7a, R.string.question7b, R.string.question7c,R.string.question7d),
            new Question(R.string.question8, R.string.question8f, R.string.question8a, R.string.question8b, R.string.question8c,R.string.question8d),
            new Question(R.string.question9, R.string.question9f, R.string.question9a, R.string.question9b, R.string.question9c,R.string.question9d),
            new Question(R.string.question10, R.string.question10f, R.string.question10a, R.string.question10b, R.string.question10c,R.string.question10d)
    };


    public void update(double add) {
        if (mnumb < 10) {
            mTextView.setText(mquestions[mnumb].getQid());
            mAB.setText(mquestions[mnumb].getA());
            mBB.setText(mquestions[mnumb].getB());
            mCB.setText(mquestions[mnumb].getC());
            mDB.setText(mquestions[mnumb].getD());
            score += add;
            mScore.setText("score:" + score);
        }else{
            score += add;
            Intent o = new Intent(this,EndActivity.class);
            o.putExtra("score",score);
            startActivityForResult(o, requestcode2);
        }
    }
    public void pass(int correct) {
        Intent i = new Intent(this,AnswerActivity.class);
        i.putExtra("correct",correct);
        i.putExtra("question", mquestions[mnumb]);
        startActivityForResult(i, requestcode);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        mTextView = (TextView)findViewById(R.id.qtext);
        mScore = (TextView)findViewById(R.id.score);
        mAB = (Button)findViewById(R.id.AB);
        mBB = (Button)findViewById(R.id.BB);
        mCB = (Button)findViewById(R.id.CB);
        mDB = (Button)findViewById(R.id.DB);
        update(0.0);


        mAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass(mquestions[mnumb].getA());
            }
        });

        mBB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass(mquestions[mnumb].getB());
            }
        });

        mCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass(mquestions[mnumb].getC());
            }
        });

        mDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass(mquestions[mnumb].getD());
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 14) {
            if (resultCode == RESULT_OK) {
                double guess = data.getDoubleExtra("result", 1.0);
                mnumb++;
                update(guess);
                if (guess == 1.0){
                    MediaPlayer up = MediaPlayer.create(QuestionsActivity.this,R.raw.up);
                    up.start();
                }else{
                    MediaPlayer down = MediaPlayer.create(QuestionsActivity.this,R.raw.down);
                    down.start();
                }
            }
        }
        if (requestCode == 8){
            if (resultCode == RESULT_OK) {
                mnumb = 0;
                score = 0;
                update(0);
            }
        }
    }
}
