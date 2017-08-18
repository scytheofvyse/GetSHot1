package com.example.scytheofvyse.getshot;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Handler;

public class tennis extends AppCompatActivity {

    TextView timer1, scoreA, scoreB;
    EditText nameTeamA, nameTeamB;

    Button start2, pause2, reset2, addFourtyTeamA, addThirtyTeamA, addFifteenTeamA, addFourtyTeamB, addThirtyTeamB, addFifteenTeamB, Deuce, gamePointA, gamePointB, back4, reset3;

    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L;

    Handler handler;

    int Seconds, Minutes, MilliSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tennis);


        displayForTeamA("0");
        displayForTeamB("0");
        timer1 = (TextView) findViewById(R.id.timer2);
        scoreA = (TextView) findViewById(R.id.score_a);
        scoreB = (TextView) findViewById(R.id.score_b);
        start2 = (Button) findViewById(R.id.start2);
        pause2 = (Button) findViewById(R.id.pause2);
        reset2 = (Button) findViewById(R.id.reset2);
        back4 = (Button)  findViewById(R.id.back4);
        reset3 = (Button) findViewById(R.id.reset3);
        addFourtyTeamA = (Button) findViewById(R.id.addFourtyTeamA);
        addFourtyTeamB = (Button) findViewById(R.id.addFourtyTeamB);
        addThirtyTeamA = (Button) findViewById(R.id.addThirtyTeamA);
        addThirtyTeamB = (Button) findViewById(R.id.addThirtyTeamB);
        addFifteenTeamA = (Button) findViewById(R.id.addFifteenTeamA);
        addFifteenTeamB = (Button) findViewById(R.id.addFifteenTeamB);
        Deuce = (Button) findViewById(R.id.deuce);
        gamePointA = (Button) findViewById(R.id.gamePointA);
        gamePointB = (Button) findViewById(R.id.gamePointB);
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
                Intent intent = new Intent (tennis.this ,game2.class );
                tennis.this.startActivity(intent);
                tennis.this.finish();

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


    public void addFourtyForTeamA (View v){
        displayForTeamA("40");
    }

    public void addThirtyForTeamA (View v){
        displayForTeamA("30");
    }

    public void addFifteenForTeamA (View v){
        displayForTeamA("15");
    }

    public void deuce(View v){
        displayForTeamA("Deuce");
        displayForTeamB("Deuce");
    }
    public void setGamePointA (View v){
        displayForTeamA("Game Point");
    }

    public void displayForTeamA(String score) {
        TextView scoreView = (TextView) findViewById(R.id.score_a);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamB(String score) {
        TextView scoreView = (TextView) findViewById(R.id.score_b);
        scoreView.setText(String.valueOf(score));
    }

    public void addFourtyForTeamB (View v){
        displayForTeamB("40");
    }

    public void addThirtyForTeamB (View v){
        displayForTeamB("30");
    }

    public void addFifteenForTeamB (View v) {
        displayForTeamB("15");
    }
    public void setGamePointB (View v){
        displayForTeamB("Game Point");
    }

    public void setReset3 (View v) {
        displayForTeamA("0");
        displayForTeamB("0");

    }

}
