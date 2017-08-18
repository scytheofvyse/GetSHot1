package com.example.scytheofvyse.getshot;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class game2 extends AppCompatActivity {
    Button home1, back2, volley, tennis, tableTennis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game2);

        home1 = (Button) findViewById(R.id.home1);
        back2 = (Button) findViewById(R.id.back2);
        volley = (Button) findViewById(R.id.volley);
        tennis = (Button) findViewById(R.id.tennis);
        tableTennis = (Button) findViewById(R.id.tableTennis);

        home1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(game2.this, opening.class);
                                        game2.this.startActivity(intent);
                                        game2.this.finish();
                                    }
                                }
        );
        back2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(game2.this, game.class);
                                        game2.this.startActivity(intent);
                                        game2.this.finish();
                                    }
                                }
        );
        volley.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         Intent intent = new Intent(game2.this, volley.class);
                                         game2.this.startActivity(intent);
                                         game2.this.finish();
                                     }
                                 }
        );
        tennis.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(game2.this, tennis.class);
                                          game2.this.startActivity(intent);
                                          game2.this.finish();
                                      }
                                  }
        );
        tableTennis.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent intent = new Intent(game2.this, tabletennis.class);
                                               game2.this.startActivity(intent);
                                               game2.this.finish();
                                           }
                                       }
        );

    }
}