package edu.tjhsst.quizyourfriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HighscoreActivity extends AppCompatActivity {

    private TextView mLine;
    private FirebaseDatabase mFire;
    private DatabaseReference mBase;
    private DatabaseReference one;
    private DatabaseReference two;
    private double high;
    private long Name1;
    private long Name2;
    private Button back;
    private TextView mLane;
    private Highscores[] four = new Highscores[]{
            new Highscores(0.0, "kill", "me"),
            new Highscores(0.0, "kill", "me"),
            new Highscores(0.0, "kill", "me"),
            new Highscores(0.0, "kill", "me"),
            new Highscores(0.0, "kill", "me")
    };
    private List<Highscores> list = new ArrayList<Highscores>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        mLine = (TextView)findViewById(R.id.line);
        mLane = (TextView)findViewById(R.id.lane);
        mFire = FirebaseDatabase.getInstance();
        mBase = mFire.getReference("peoples");

        Query q = mBase.orderByChild("score").limitToLast(5);
        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int count = 0;
                for(DataSnapshot j : dataSnapshot.getChildren())
                {
                    Highscores h = new Highscores(j.child("score").getValue(double.class), j.child("name1").getValue(String.class), j.child("name2").getValue(String.class));
                    four[count] = h;
                    count++;
                }
                mLine.setText("Current Best Friends:");
                mLane.setText("1. " + four[4].toString() + "\n2. " + four[3].toString() + "\n3. " + four[2].toString() + "\n4. " + four[1].toString() + "\n5. " + four[0].toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
