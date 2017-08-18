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

public class football extends AppCompatActivity {

    TextView timer1;

    EditText nameTeamA, nameTeamB;

    Button start1, pause1, reset1, scoreA, scoreB, back3, reset2;

    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L;

    Handler handler;

    int Seconds, Minutes, MilliSeconds;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.football);
        displayForTeamA(0);
        displayForTeamB(0);
        timer1 = (TextView) findViewById(R.id.timer1);
        start1 = (Button) findViewById(R.id.start1);
        pause1 = (Button) findViewById(R.id.pause1);
        reset1 = (Button) findViewById(R.id.reset1);
        scoreA = (Button) findViewById(R.id.addScoreTeamA);
        scoreB = (Button) findViewById(R.id.addScoreTeamB);
        back3 = (Button)  findViewById(R.id.back3);
        reset2 = (Button) findViewById(R.id.reset2);
        nameTeamA = (EditText) findViewById(R.id.nameTeamA);
        nameTeamB = (EditText) findViewById(R.id.nameTeamB);
        handler = new Handler();



        start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);

                reset1.setEnabled(false);

            }
        });

        pause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimeBuff += MillisecondTime;

                handler.removeCallbacks(runnable);

                reset1.setEnabled(true);

            }
        });

        reset1.setOnClickListener(new View.OnClickListener() {
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
        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (football.this ,game.class );
                football.this.startActivity(intent);
                football.this.finish();

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

    public void addOneForTeamA (View v){
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_a);
        scoreView.setText(String.valueOf(score));
    }

    public void addOneForTeamB (View v){
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_b);
        scoreView.setText(String.valueOf(score));
    }

    public void setReset2 (View v) {
        displayForTeamA(0);
        displayForTeamB(0);
        scoreTeamA = 0;
        scoreTeamB = 0;
    }


}