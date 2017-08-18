package com.example.scytheofvyse.getshot;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by Scythe of Vyse on 8/17/2017.
 */

public class badminton extends AppCompatActivity {

    TextView timer1, scoreA, scoreB;

    EditText nameTeamA, nameTeamB, fromA, fromB;
    CheckBox ms, ws, md, wd, mxd;

    Button start1, pause1, reset1, addScoreA, addScoreB, back3, reset4;

    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L;

    Handler handler;

    int Seconds, Minutes, MilliSeconds;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.badminton);
        displayForTeamA(0);
        displayForTeamB(0);
        timer1 = (TextView) findViewById(R.id.timer1);
        scoreA = (TextView) findViewById(R.id.score_a);
        scoreB = (TextView) findViewById(R.id.score_b);
        start1 = (Button) findViewById(R.id.start1);
        pause1 = (Button) findViewById(R.id.pause1);
        reset1 = (Button) findViewById(R.id.reset1);
        addScoreA = (Button) findViewById(R.id.addScoreA);
        addScoreB = (Button) findViewById(R.id.addScoreB);
        back3 = (Button)  findViewById(R.id.back3);
        reset4 = (Button) findViewById(R.id.reset4);
        nameTeamA = (EditText) findViewById(R.id.nameTeamA);
        nameTeamB = (EditText) findViewById(R.id.nameTeamB);
        fromA = (EditText) findViewById(R.id.fromA);
        fromB = (EditText) findViewById(R.id.fromB);
        ms = (CheckBox) findViewById(R.id.ms);
        ws = (CheckBox) findViewById(R.id.ws);
        md = (CheckBox) findViewById(R.id.md);
        wd = (CheckBox) findViewById(R.id.wd);
        mxd = (CheckBox) findViewById(R.id.mxd);
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
                Intent intent = new Intent (badminton.this ,game.class );
                badminton.this.startActivity(intent);
                badminton.this.finish();

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

    public void setAddScoreA (View v){


        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);

        if ( (scoreTeamA == scoreTeamB) && (scoreTeamA == 20))  {
                Toast.makeText(this, "DEUCE",
                        Toast.LENGTH_SHORT).show();}
        else  if ( (scoreTeamA == scoreTeamB) && (scoreTeamA == 21))  {
            Toast.makeText(this, "DEUCE",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == scoreTeamB) && (scoreTeamA == 22))  {
            Toast.makeText(this, "DEUCE",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == scoreTeamB) && (scoreTeamA == 23))  {
            Toast.makeText(this, "DEUCE",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == scoreTeamB) && (scoreTeamA == 24))  {
            Toast.makeText(this, "DEUCE",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == scoreTeamB) && (scoreTeamA == 25))  {
            Toast.makeText(this, "DEUCE",
                    Toast.LENGTH_SHORT).show();}


        if ( (scoreTeamA == 21) && (scoreTeamB <= 19))  {
            Toast.makeText(this, "Player/s A WIN",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == 21) && (scoreTeamB >= 23))  {
            Toast.makeText(this, "Player/s A WIN",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == scoreTeamB + 2 ) && (scoreTeamB == 20))  {
            Toast.makeText(this, "Player/s A WIN",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == scoreTeamB + 2 ) && (scoreTeamB == 21))  {
            Toast.makeText(this, "Player/s A WIN",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == scoreTeamB + 2 ) && (scoreTeamB == 22))  {
            Toast.makeText(this, "Player/s A WIN",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == scoreTeamB + 2 ) && (scoreTeamB == 23))  {
            Toast.makeText(this, "Player/s A WIN",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == scoreTeamB + 2 ) && (scoreTeamB == 24))  {
            Toast.makeText(this, "Player/s A WIN",
                    Toast.LENGTH_SHORT).show();}

    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_a);
        scoreView.setText(String.valueOf(score));
    }

    public void setAddScoreB (View v){
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);

        if ( (scoreTeamA == scoreTeamB) && (scoreTeamA == 20))  {
            Toast.makeText(this, "DEUCE",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == scoreTeamB) && (scoreTeamA == 21))  {
            Toast.makeText(this, "DEUCE",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == scoreTeamB) && (scoreTeamA == 22))  {
            Toast.makeText(this, "DEUCE",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == scoreTeamB) && (scoreTeamA == 23))  {
            Toast.makeText(this, "DEUCE",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == scoreTeamB) && (scoreTeamA == 24))  {
            Toast.makeText(this, "DEUCE",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamA == scoreTeamB) && (scoreTeamA == 25))  {
            Toast.makeText(this, "DEUCE",
                    Toast.LENGTH_SHORT).show();}

        if ( (scoreTeamB == 21) && (scoreTeamA <= 19))  {
            Toast.makeText(this, "Player/s B WIN",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamB == 21) && (scoreTeamA >= 23))  {
            Toast.makeText(this, "Player/s B WIN",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamB == scoreTeamA + 2) && (scoreTeamA == 20))  {
            Toast.makeText(this, "Player/s B WIN",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamB == scoreTeamA + 2) && (scoreTeamA == 21))  {
            Toast.makeText(this, "Player/s B WIN",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamB == scoreTeamA + 2) && (scoreTeamA == 22))  {
            Toast.makeText(this, "Player/s B WIN",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamB == scoreTeamA + 2) && (scoreTeamA == 23))  {
            Toast.makeText(this, "Player/s B WIN",
                    Toast.LENGTH_SHORT).show();}
        else if ( (scoreTeamB == scoreTeamA + 2) && (scoreTeamA == 24))  {
            Toast.makeText(this, "Player/s B WIN",
                    Toast.LENGTH_SHORT).show();}
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_b);
        scoreView.setText(String.valueOf(score));
    }

    public void setReset4 (View v) {
        displayForTeamA(0);
        displayForTeamB(0);
        scoreTeamA = 0;
        scoreTeamB = 0;
    }
    public void onCheckboxClicked(View view) {

        switch(view.getId()) {

            case R.id.ms:

                ws.setChecked(false);
                md.setChecked(false);
                wd.setChecked(false);
                mxd.setChecked(false);

                break;

            case R.id.ws:

                ms.setChecked(false);
                md.setChecked(false);
                wd.setChecked(false);
                mxd.setChecked(false);

                break;

            case R.id.md:

                ms.setChecked(false);
                ws.setChecked(false);
                wd.setChecked(false);
                mxd.setChecked(false);

                break;
            case R.id.wd:

                ms.setChecked(false);
                ws.setChecked(false);
                md.setChecked(false);
                mxd.setChecked(false);

                break;
            case R.id.mxd:

                ms.setChecked(false);
                ws.setChecked(false);
                wd.setChecked(false);
                md.setChecked(false);

                break;
        }
    }
}
