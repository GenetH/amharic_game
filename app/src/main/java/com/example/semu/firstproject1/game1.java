package com.example.semu.firstproject1;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static java.lang.String.valueOf;

public class game1 extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener {
    private boolean isStop = false;
    Button startButton;
    //Button button2;
    // int j;
    TextView textView5;
    TextView textView3;
    game1 game1;
    List<String> an;
    TextView timerTextView;
    ArrayList<String> answer = new ArrayList<String>();
    Button playGameSound;
    List<String> askedQuestion;
    List<String> listOfQuestions;
    List<String> unique_ids;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button playAgainButton;
    RelativeLayout gameRelativelayout;
    ArrayList<String> answers = new ArrayList<String>();
    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer;
    SoundPool soundPool;
    AudioManager audioManager;
    float volume;
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;
    int position;
    List<String> lesson;
    boolean loaded;
    int tekikile;
    int setet;



    public void playagain(View view) {
        score = 0;
        numberOfQuestions = 0;

        timerTextView.setText("30s");
        textView3.setText("0/0");
        textView5.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);
        generateQuestions();

    }

    public void generateQuestions() {
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
        playAgainButton.setEnabled(true);


        textView3.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));

        //TODO get it to work
        Intent inent = getIntent();

        lesson = inent.getStringArrayListExtra("string");
        for (String l : lesson) {
            Log.d("A", l);
        }
        assert !(lesson == null);

        Random rand = new Random();
        int t;
        while (true) {
            t = rand.nextInt(lesson.size());
            if (t % 8 != 0)
                break;
        }
        final int j = t;
//        if(j%8!=0){

        Log.d("t", valueOf(lesson));

//            if (j % 8 != 0) {
        final int h;
        int k;
        k = j / 8;
        h = k * 8;


        final int z = j % 8;

        playGameSound.setTag(Integer.toString(-1) + " " + Integer.toString(h) + " " + Integer.toString(z));
        playGameSound.setOnClickListener(this);
        playGameSound.performClick();

        // Random rand = new Random();
        locationOfCorrectAnswer = rand.nextInt(4);
        String incorrectAnswer;
        answers.clear();

        List<String> ll  = returnNonAnswers(lesson.get(j));
        Iterator<String> iterator = ll.iterator();
        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAnswer) {
                //MediaPlayer answers = MediaPlayer.create(game1.this, getResources().getIdentifier(lesson[0] + "" + j, "raw", getPackageName()));
                Log.d("char is ansr:", lesson.get(j));
                answers.add(lesson.get(j));
            } else {
                answers.add(iterator.next());
            }
        }


//            }
        int s= lesson.indexOf(answers.get(0));
//            if(s%8!=0){

        button6.setText(answers.get(0));


        int q = lesson.indexOf(answers.get(0));
        Log.d("sssszzzzzzzzzd", valueOf(q));
        final int h1;
        int k1;
        k1 = q / 8;
        h1 = k1 * 8;

        final int z1 = q % 8;

        button6.setOnClickListener(this);
        button6.setTag("0 " + Integer.toString(h1) + " " + Integer.toString(z1));




        button7.setText(answers.get(1));

        int q2 = lesson.indexOf(answers.get(1));
        Log.d("sssszzzzzzzzzd", valueOf(q2));
        int h2;
        int k2;
        k2 = q2 / 8;
        h2 = k2 * 8;
        int z2 = q2 % 8;

        button7.setOnClickListener(this);

        button7.setTag("1 " + Integer.toString(h2) + " " + Integer.toString(z2));


        button8.setText(answers.get(2));

        int q3 = lesson.indexOf(answers.get(2));

        final int h3;
        int k3;
        k3 = q3 / 8;
        h3 = k3 * 8;
        final int z3 = q3 % 8;


        button8.setOnClickListener(this);

        button8.setTag("2 " + Integer.toString(h3) + " " + Integer.toString(z3));



        button9.setText(answers.get(3));
//        {
        int q4 = lesson.indexOf(answers.get(3));

        int h4;
        int k4;
        int z4;
        k4 = q4 / 8;
        h4 = k4 * 8;
        z4 = q4 % 8;


        button9.setOnClickListener(this);
        button9.setTag("3 " + Integer.toString(h4) + " " + Integer.toString(z4));

//        }
//            }
        //  playAgainButton.setVisibility(View.INVISIBLE);<
        if (countDownTimer != null)
        {
            countDownTimer.cancel();
        }

        countDownTimer = new CountDownTimer(10100, 1000) {
            @Override

            public void onFinish() {


//                if(Integer.parseInt(String.valueOf(numberOfQuestions)) == 10) {
//
//                    playAgainButton.setVisibility(View.VISIBLE);
//                }

                timerTextView.setText(String.format(":%02d", 0));
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);


                playAgainButton.setEnabled(false);
                countDownTimer.cancel();

                numberOfQuestions++;
                generateQuestions();






            }

            public void onTick(long l) {
                timerTextView.setText(String.format(":%02d", (int) (l / 1000)));


            }


        }.start();
//    }

    }


    /*public void chooseAnswer(View view) {

     if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {

         score++;
         textView5.setText("Correct!");
     }
     else
     {
         textView5.setText("Wrong!");
     }

     numberOfQuestions++;
        textView3.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        generateQuestions();

 }}*/
    public void start(View view) {
        startButton.setVisibility(View.INVISIBLE);
        gameRelativelayout.setVisibility(View.VISIBLE);

        playagain(findViewById(R.id.playAgainButton));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // Current volumn Index of particular stream type.
        float currentVolumeIndex = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        // Get the maximum volume index for a particular stream type.
        float maxVolumeIndex  = (float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        if (Build.VERSION.SDK_INT >= 21 ) {

            AudioAttributes audioAttrib = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            SoundPool.Builder builder= new SoundPool.Builder();
            builder.setAudioAttributes(audioAttrib).setMaxStreams(5);

            this.soundPool = builder.build();
        }
        // for Android SDK < 21
        else {
            // SoundPool(int maxStreams, int streamType, int srcQuality)
            this.soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        this.soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;

            }
        });

        tekikile= soundPool.load(game1.this, R.raw.betikikl,1);
        setet = soundPool.load(game1.this, R.raw.ayidelem,1);
        // Volumn (0 --> 1)
        volume = currentVolumeIndex / maxVolumeIndex;
//        final MediaPlayer mp = MediaPlayer.create(game1.this, R.raw.betikikl);


        playGameSound = (Button) findViewById(R.id.textView4);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView3 = (TextView) findViewById(R.id.textView3);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        startButton = (Button) findViewById(R.id.startButton);
        playAgainButton = (Button) findViewById((R.id.playAgainButton));
        gameRelativelayout = (RelativeLayout) findViewById(R.id.gameRelativelayout) ;

    }


    @Override
    public void onClick(View v) {


        String tags = v.getTag().toString();
        final String[] tag = tags.split(" ");
        Log.d("The Tag is",tag[1] + " " + tag[2]);
        if(numberOfQuestions == 10)
        {
            textView5.setText(("YOUR Score:" + Integer.toString(score) + "/" + Integer.toString(numberOfQuestions)));
            countDownTimer.cancel();
            playAgainButton.setVisibility(View.VISIBLE);
            return;
        }
        if (tag[0].equals(Integer.toString(-1)))
        {
            if(numberOfQuestions == 10)
            {
                countDownTimer.cancel();
                textView5.setText(("YOUR Score:" + Integer.toString(score) + "/" + Integer.toString(numberOfQuestions)));
                countDownTimer.cancel();
                playAgainButton.setVisibility(View.VISIBLE);
                return;
            }
        }
        else if (tag[0].equals(Integer.toString(locationOfCorrectAnswer)))
        {
            score++;
            numberOfQuestions++;
            textView3.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));

            // mediaPlayer=MediaPlayer(R.raw.betikikl);
            //  textView5.setText("ትክክል!");
            if (countDownTimer != null)
            {
                countDownTimer.cancel();
            }

            countDownTimer = new CountDownTimer(2200, 1100) {
                public void onTick(long l) {


//                    MediaPlayer mp = MediaPlayer.create(game1.this, R.raw.betikikl);
//                    mp.start();
//                    mp.setOnCompletionListener(game1.this);
                    int streamid = game1.this.soundPool.play(tekikile,5,5,1,0,1f);
                }

                @Override
                public void onFinish() {

                    generateQuestions();
                }

            }.start();
        }
        else {
            countDownTimer.cancel();
            numberOfQuestions++;
            textView3.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
            generateQuestions();
            if (countDownTimer != null)
            {
                countDownTimer.cancel();
            }
            countDownTimer = new CountDownTimer(2100, 1100) {
                public void onTick(long l) {


//            MediaPlayer mp1=MediaPlayer.create(game1.this,R.raw.ayidelem);
//            mp1.start();
//                    mp1.setOnCompletionListener(game1.this);
                    int streamid = game1.this.soundPool.play(setet,5,5,1,0,1f);
                    Log.d("kjjd", (String) button6.getTag());
                    if(tag[0].equals(Integer.toString(locationOfCorrectAnswer)==button6.getTag())){
                        button6.setBackgroundColor(Color.GREEN);
                    } else if(tag[0].equals(Integer.toString(locationOfCorrectAnswer)==button7.getTag())){
                        button7.setBackgroundColor(Color.GREEN);
                    } else if(tag[0].equals(Integer.toString(locationOfCorrectAnswer)==button8.getTag())){
                        button8.setBackgroundColor(Color.GREEN);
                    } else if(tag[0].equals(Integer.toString(locationOfCorrectAnswer)==button9.getTag())){
                        button9.setBackgroundColor(Color.GREEN);
                    }}

                @Override
                public void onFinish() {

                    generateQuestions();
                }

            }.start();
            //textView5.setText("መልሱ፡"+locationOfCorrectAnswer);

            //textView5.setText("ስህተት!");
        }

        try {

//            mediaPlayer = MediaPlayer.create(game1.this, getResources().getIdentifier(lesson.get(Integer.parseInt(tag[1])) + "" +
//                    Integer.parseInt(tag[2]), "raw", getPackageName()));
            position = soundPool.load(game1.this, getResources().getIdentifier(lesson.get(Integer.parseInt(tag[1])) + "" +
                    Integer.parseInt(tag[2]), "raw", getPackageName()),1);
            soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                @Override
                public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                    soundPool.play(position,5,5,1,0,1f);
                }
            });
//            int streamid =
//            mediaPlayer.start();
//            mediaPlayer.setOnCompletionListener(this);

        }
        catch (Exception e)
        {
            Log.e("The sound",lesson.get(Integer.parseInt(tag[1])) + "" +
                    Integer.parseInt(tag[2]));
        }
    }

    private List<String> returnNonAnswers(String answer)
    {
        //TODO we can make this a variable array.
        List<String> nonanswers= new ArrayList<String>();


        for(int i=0; i<3;i++)
        {
            while(true) {
                Random random = new Random();
                int rand = random.nextInt(lesson.size());
                String nonanswer = (String)lesson.get(rand);
                if (rand % 8 != 0 && !answer.equals(nonanswer) && !nonanswers.contains(nonanswer)) {
                    nonanswers.add(i, nonanswer);
                    break;
                }
            }
        }
        return nonanswers;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.stop();

    }
}
