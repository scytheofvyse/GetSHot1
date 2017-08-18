package com.example.scytheofvyse.getshot;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Handler;

public class basketball extends AppCompatActivity {

    TextView timer1;
    EditText nameTeamA, nameTeamB;

    Button start2, pause2, reset2, addThreeTeamA, addTwoTeamA, addOneTeamA, addThreeTeamB,addTwoTeamB, addOneTeamB, back4, reset3;

    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L;

    Handler handler;

    int Seconds, Minutes, MilliSeconds;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.basketball);


            displayForTeamA(0);
            displayForTeamB(0);
            timer1 = (TextView) findViewById(R.id.timer2);
            start2 = (Button) findViewById(R.id.start2);
            pause2 = (Button) findViewById(R.id.pause2);
            reset2 = (Button) findViewById(R.id.reset2);
            back4 = (Button)  findViewById(R.id.back4);
            reset3 = (Button) findViewById(R.id.reset3);
            addThreeTeamA = (Button) findViewById(R.id.addThreeTeamA);
            addThreeTeamB = (Button) findViewById(R.id.addThreeTeamB);
            addTwoTeamA = (Button) findViewById(R.id.addTwoTeamA);
            addTwoTeamB = (Button) findViewById(R.id.addTwoTeamB);
            addOneTeamA = (Button) findViewById(R.id.addOneTeamA);
            addOneTeamB = (Button) findViewById(R.id.addOneTeamB);
            nameTeamA = (EditText) findViewById(R.id.nameTeamA);
            nameTeamB = (EditText) findViewById(R.id.nameTeamB);
            handler = new Handler();



        start2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            StartTime = SystemClock.uptimeMillis();
            handler.postDelayed(runnable, 0);

            reset2.setEnabled(false);

        }
    });

        pause2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            TimeBuff += MillisecondTime;

            handler.removeCallbacks(runnable);

            reset2.setEnabled(true);

        }
    });

        reset2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            MillisecondTime = 0L;
            StartTime = 0L;
            TimeBuff = 0L;
            UpdateTime = 0L;
            Seconds = 0;
            Minutes = 0;
            MilliSeconds = 0;

            timer1.setText("00:00:00");
        }
    });
        back4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent (basketball.this ,game.class );
            basketball.this.startActivity(intent);
            basketball.this.finish();

        }
    });



}


    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (UpdateTime % 1000);

            timer1.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds));

            handler.postDelayed(this, 0);
        }
    };

    int scoreTeamA = 0;

    int scoreTeamB = 0;

    public void addThreeForTeamA (View v){
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    public void addTwoForTeamA (View v){
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    public void addOneForTeamA (View v){
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_a);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeForTeamB (View v){
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void addTwoForTeamB (View v){
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void addOneForTeamB (View v){
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_b);
        scoreView.setText(String.valueOf(score));
    }

    public void setReset3 (View v) {
        displayForTeamA(0);
        displayForTeamB(0);
        scoreTeamA = 0;
        scoreTeamB = 0;
    }
}
