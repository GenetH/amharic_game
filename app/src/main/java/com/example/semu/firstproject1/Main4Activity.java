package com.example.semu.firstproject1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent inent = getIntent();
        String key = (String) getIntent().getStringExtra("key");

        Generator gen = new Generator();
        InputStream in = getResources().openRawResource(R.raw.amharic);
        gen.create_entry(in);
        final String[] lesson = gen.create_lesson("ሀ");







        String showTitle = "ሀ";
        Button button = (Button) findViewById(R.id.button);
        button.setText(lesson[1]);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                MediaPlayer mediaPlayer = MediaPlayer.create(Main4Activity.this, getResources().getIdentifier(lesson[0]+""+1,"raw", getPackageName()));
                getResources().getIdentifier(lesson[0]+""+1,"raw", getPackageName());
                mediaPlayer.start();

            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText(lesson[2]);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(Main4Activity.this, getResources().getIdentifier(lesson[0]+""+2,"raw", getPackageName()));
                mediaPlayer.start();
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setText(lesson[3]);
        button3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                MediaPlayer mediaPlayer = MediaPlayer.create(Main4Activity.this, getResources().getIdentifier(lesson[0]+""+2,"raw", getPackageName()));
                mediaPlayer.start();



            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setText(lesson[4]);
        button4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                MediaPlayer mediaPlayer = MediaPlayer.create(Main4Activity.this, getResources().getIdentifier(lesson[0]+""+3,"raw", getPackageName()));
                mediaPlayer.start();



            }
        });

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setText(lesson[5]);
        button5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                MediaPlayer mediaPlayer = MediaPlayer.create(Main4Activity.this, getResources().getIdentifier(lesson[0]+""+4,"raw", getPackageName()));
                mediaPlayer.start();



            }
        });

        Button button6 = (Button) findViewById(R.id.button6);
        button6.setText(lesson[6]);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                MediaPlayer mediaPlayer = MediaPlayer.create(Main4Activity.this, getResources().getIdentifier(lesson[0]+""+5,"raw", getPackageName()));
                mediaPlayer.start();



            }
        });

        Button button7 = (Button) findViewById(R.id.button7);
        button7.setText(lesson[7]);
        button7.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                MediaPlayer mediaPlayer = MediaPlayer.create(Main4Activity.this, getResources().getIdentifier(lesson[0]+""+6,"raw", getPackageName()));
                mediaPlayer.start();
            }
        });


    }
}
