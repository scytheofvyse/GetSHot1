package com.example.scytheofvyse.getshot;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class game extends AppCompatActivity {
    Button next1;
    Button back1;
    Button football;
    Button basketball;
    Button badminton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        next1 = (Button) findViewById(R.id.next1);
        back1 = (Button) findViewById(R.id.back1);
        football = (Button) findViewById(R.id.football);
        basketball = (Button) findViewById(R.id.basketball);
        badminton = (Button) findViewById(R.id.badminton);

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(game.this, game2.class);
                game.this.startActivity(intent);
                game.this.finish();
            }
        }
        );
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(game.this, opening.class);
                game.this.startActivity(intent);
                game.this.finish();
            }
        }
        );
        football.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(game.this, football.class);
                                            game.this.startActivity(intent);
                                            game.this.finish();
                                        }
                                    }
        );

        basketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(game.this, basketball.class);
                game.this.startActivity(intent);
                game.this.finish();
            }
        });
        badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(game.this, badminton.class);
                game.this.startActivity(intent);
                game.this.finish();
            }
        });



    }

    }