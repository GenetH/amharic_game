package com.example.semu.firstproject1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import edu.cmu.pocketsphinx.Assets;
import edu.cmu.pocketsphinx.Hypothesis;
import edu.cmu.pocketsphinx.RecognitionListener;
import edu.cmu.pocketsphinx.SpeechRecognizer;
import edu.cmu.pocketsphinx.SpeechRecognizerSetup;

import static java.lang.String.valueOf;

public class game2 extends AppCompatActivity implements RecognitionListener, View.OnClickListener {

    Button startbutton;
    Button playaginebutton;
    Button clikehereButton;
    Button addsoundButton;
    Button gameButton;
    TextView result;
    TextView resultTextview;
    TextView caption1Textview;
    TextView timerTextview;
    TextView corectTextview;
    TextView textView9;
    int locationofCorrectAnswer;
    int score;
    int numberofQuestio;
    RelativeLayout gamerelativelayout;
    File file;
    List<String> lesson;
    List<String> keys;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void chooseAnswer(View view) {
        if (view.getTag().toString().equals(Integer.toString(locationofCorrectAnswer))) {

            score++;
            corectTextview.setText("Correct");
        }
        else{
            corectTextview.setText("wrong");
        }
        numberofQuestio++;
        corectTextview.setText(Integer.toString(score) + "/" + Integer.toString(numberofQuestio));

    }

    public void start(View view) {
        startbutton.setVisibility(View.INVISIBLE);
        gamerelativelayout.setVisibility(RelativeLayout.VISIBLE);
    }


    private static final String MENU_SEARCH = "menu";
    private static final int PERMISSIONS_REQUEST_RECORD_AUDIO = 1;

    private SpeechRecognizer recognizer;
     private HashMap<String, Integer> captions;
    private Button start_reco;
    private CountDownTimer countDownTimer;


    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        Log.d("Reaches", "here");
        setContentView(R.layout.activity_game2);
        result = (TextView) findViewById(R.id.activity_game2textView6);
        startbutton = (Button) findViewById(R.id.activity_game2startbutton);
        playaginebutton = (Button) findViewById(R.id.activity_game2playaginebutton);
        clikehereButton = (Button) findViewById(R.id.activity_game2clikehereButton);
        gameButton = (Button) findViewById(R.id.activity_game2gameButton);
        timerTextview = (TextView) findViewById(R.id.activity_game2timerTextView);
        resultTextview = (TextView) findViewById(R.id.activity_game2resultTextView);
        corectTextview = (TextView) findViewById(R.id.activity_game2correctTextView);
        gamerelativelayout = (RelativeLayout) findViewById(R.id.activity_game2gamerelativelayout);
        addsoundButton = (Button) findViewById(R.id.activity_game2addsoundButton);
        caption1Textview = (TextView) findViewById(R.id.activity_game2cabtion1Textview);
        textView9 = (TextView) findViewById(R.id.textView9);

        if(numberofQuestio == 10)
        {
            resultTextview.setText(("YOUR Score:" + Integer.toString(score) + "/" + Integer.toString(numberofQuestio)));
            countDownTimer.cancel();
            playaginebutton.setVisibility(View.VISIBLE);
            return;
        }

            if(numberofQuestio == 10)
            {
                countDownTimer.cancel();
                corectTextview.setText(("YOUR Score:" + Integer.toString(score) + "/" + Integer.toString(numberofQuestio)));
                countDownTimer.cancel();
                playaginebutton.setVisibility(View.VISIBLE);
                return;
            }



         captions = new HashMap<String, Integer>();
//        captions.put(KWS_SEARCH, R.string.kws_caption);
          captions.put(MENU_SEARCH, R.string.menu_caption);
//         setContentView(R.layout.activity_game2);

        ((TextView) findViewById(R.id.activity_game2cabtion1Textview))
               .setText("ድምጻቹን ለመቅዳት በ ዝግጅት ላይ ነ");
        timerTextview = (TextView) findViewById(R.id.activity_game2timerTextView);
        //Check if user has given permission to record audio
        int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO);
        if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, PERMISSIONS_REQUEST_RECORD_AUDIO);
            Log.d("Permission", "Denied");
            return;
        }
        start_reco = (Button) findViewById(R.id.activity_game2clikehereButton);
        start_reco.setOnClickListener(this);
        keys = new ArrayList<String>();
//      start_reco.setOnClickListener((View.OnClickListener));
        runRecognizerSetup();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        gameButton.setText("");
    }

    private void runRecognizerSetup() {
        // Recognizer initialization is a time-consuming and it involves IO,
        // so we execute it in async task
        new AsyncTask<Void, Void, Exception>() {
            @Override
            protected Exception doInBackground(Void... params) {
                try {
//                    Log.d("The File is not loaded", "");
                    Assets assets = new Assets(game2.this);

                    File assetDir = assets.syncAssets();
                    setupRecognizer(assetDir);

                } catch (IOException e) {
                    Log.d("Error loading assets",e.toString());
                    return e;
                }
                return null;
            }

            @Override
            protected void onPostExecute(Exception result) {
                if (result != null) {
                    ((TextView) findViewById(R.id.activity_game2correctTextView))
                            .setText("Failed to init recognizer " + "Failed");
                } else {
                    ((TextView) findViewById(R.id.activity_game2cabtion1Textview))
                            .setText("");
//                    switchSearch(KWS_SEARCH);
                }
            }
        }.execute();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSIONS_REQUEST_RECORD_AUDIO) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                runRecognizerSetup();
            } else {
                finish();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (recognizer != null) {
            recognizer.cancel();
            recognizer.shutdown();
        }
    }


    @Override
    public void onPartialResult(Hypothesis hypothesis) {

//        generateQuestions();
//        if (hypothesis == null)
//        {
//            Log.d("This is","Error");
//            addsoundButton.setText("try again");
//            return;
//        }
//
//        String text = hypothesis.getHypstr();
//        addsoundButton.setText(text);
       // result.setText(text);
        // if (text.equals(KEYPHRASE))
        //  switchSearch(MENU_SEARCH);
//        else
//        if (text.equals(DIGITS_SEARCH))
//            switchSearch(DIGITS_SEARCH);
//        else if (text.equals(PHONE_SEARCH))
//            switchSearch(PHONE_SEARCH);
//        else if (text.equals(FORECAST_SEARCH))
//            switchSearch(FORECAST_SEARCH);
//        else
        //((TextView) findViewById(R.id.activity_game2gameButton)).setText(text);
    }

    @Override
    public void onResult(Hypothesis hypothesis) {
        //  ((TextView) findViewById(R.id.activity_game2gameButton)).setText("");
        Log.d("It Reaches Result","Says");
         if (hypothesis != null) {
             String text = hypothesis.getHypstr();
             //  makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
             // ((TextView) findViewById(R.id.activity_game2gameButton)).setText(text);
             addsoundButton.setText(text);
//             generateQuestions();
         }
        else
         {
             addsoundButton.setText("እንደገና ይሞከሩ");
         }

    }

//}

    @Override
    public void onError(Exception e) {
        ((TextView) findViewById(R.id.activity_game2cabtion1Textview)).setText(e.getMessage());

    }


    @Override
    public void onBeginningOfSpeech() {

    }

    @Override
    public void onEndOfSpeech() {

    }

    private void switchSearch(String searchName) {
        recognizer.stop();

        // If we are not spotting, start listening with timeout (10000 ms or 10 seconds).
//       if (searchName.equals(KWS_SEARCH))
//            recognizer.startListening(searchName);
//        else
        recognizer.startListening(searchName);
//        corectTextview.setText(searchName);
//        String caption = "Say something";
//        ((TextView) findViewById(R.id.activity_game2correctTextView)).setText(caption);
    }

    private void setupRecognizer(File assetsDir) throws IOException {
        //The recognizer can be configured to perform multiple searches
        // of different kind and switch between them

        recognizer = SpeechRecognizerSetup.defaultSetup()
                .setAcousticModel(new File(assetsDir, "en-us-ptm"))
                .setDictionary(new File(assetsDir, "cmudict-en-us.dict"))

                .setRawLogDir(assetsDir) // To disable logging of raw audio comment out this call (takes a lot of space on the device)

                .getRecognizer();
        recognizer.addListener(this);

        /** In your application you might not need to add all those searches.
         * They are added here for demonstration. You can leave just one.
         */

        // Create keyword-activation search.
//        recognizer.addKeyphraseSearch(KWS_SEARCH, KEYPHRASE);

        // Create grammar-based search for selection between demos
//       File menuGrammar_1 = new File(assetsDir, "ha.gram");
//        File menuGrammar_2 = new File(assetsDir, "la.gram");
//        File menuGrammar_3 = new File(assetsDir, "sa.gram");
//        File menuGrammar_4 = new File(assetsDir, "la.gram");
//        File menuGrammar_5 = new File(assetsDir, "la.gram");
//        recognizer.addGrammarSearch(MENU_SEARCH, menuGrammar_1);
//        recognizer.addGrammarSearch(MENU_SEARCH, menuGrammar_2);
//        recognizer.addGrammarSearch(MENU_SEARCH, menuGrammar_3);
          file = assetsDir;
//        recognizer.addGrammarSearch(MENU_SEARCH, menuGrammar_4);
//        recognizer.addGrammarSearch(MENU_SEARCH, menuGrammar_5);

        // Create grammar-based search for digit recognition
//        File digitsGrammar = new File(assetsDir, "digits.gram");
//        recognizer.addGrammarSearch(DIGITS_SEARCH, digitsGrammar);
//
//        // Create language model search
//        File languageModel = new File(assetsDir, "weather.dmp");
//        recognizer.addNgramSearch(FORECAST_SEARCH, languageModel);
//
        //  Phonetic search
//        File phoneticModel = new File(assetsDir, "en-phone.dmp");
//        recognizer.addAllphoneSearch(MENU_SEARCH, phoneticModel);
    }

    public void reloadGrammer(String string)
    {
        File menuGrammar_1 = new File(file, string);
//        File menuGrammar_2 = new File(file, "la.gram");
//        File menuGrammar_3 = new File(file, "sa.gram");
//        File menuGrammar_4 = new File(assetsDir, "la.gram");
//        File menuGrammar_5 = new File(assetsDir, "la.gram");
        recognizer.addGrammarSearch(MENU_SEARCH, menuGrammar_1);
//        recognizer.addGrammarSearch(MENU_SEARCH, menuGrammar_2);
//        recognizer.addGrammarSearch(MENU_SEARCH, menuGrammar_3);
    }

    @Override
    public void onTimeout() {
//        countDownTimer.cancel();
//        recognizer.stop();
//        timerTextview.setText("Time's Up");

    }

    @Override
    public void onClick(View v) {
        //Now we start listening.
        if (recognizer != null)
        {
            recognizer.stop();
        }

        generateQuestions();

        switchSearch(MENU_SEARCH);

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        countDownTimer = new CountDownTimer(3100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextview.setText(String.format("%02ds", (int) millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {

                timerTextview.setText(String.format("%02ds", 0));
                recognizer.stop();
            }
        }.start();
        addsoundButton.setText("ድምጽ ያሰሙ");
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("game2 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }
    public void generateQuestions() {


        Intent inent = getIntent();
        Bundle bunder = inent.getExtras();
        lesson = bunder.getStringArrayList("string");
//        boolean keys1 = inent.hasExtra("keys");
//        if(keys1)
//        {
//            Log.d("There is the string","");
//        }
//        else
//        {
//            Log.d("there is the not","");
//        }
        keys = bunder.getStringArrayList("string_1");

        assert !(keys == null);

        Log.d("j",lesson.get(0));
        for (String l : lesson) {
            Log.d("A", l);
        }
        assert !(lesson == null);

        Random rand = new Random();
        int t;
        while (true) {
            t = rand.nextInt(lesson.size());
//            if (t % 8 != 0)
                break;
        }
        final int j = t;
//        if(j%8!=0){

        Log.d("t", valueOf(lesson));

//            if (j % 8 != 0) {
        final int h;
        int k;
        k = j / 7;
        h = k * 7;
        gameButton.setText(lesson.get(j));
        gameButton.setTag( Integer.toString(h) + " " + Integer.toString(j));
        Log.d("tag", Integer.toString(h) + " " + Integer.toString(j));
//
        for (String s : keys)
        {
            Log.d("values is",s);
        }
        result.setText(keys.get(((int) h / 7)  ) + " " + Integer.toString(j-h + 1));
        gameButton.setTag(keys.get(((int) h / 7)  ) + " " + Integer.toString(j-h + 1));
        String s = keys.get(((int) h / 7));
        s = s + ".gram";
        reloadGrammer(s);
        result.setText(s);
//        Log.d("sertt",lesson.get(j));
    }
    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        AppIndex.AppIndexApi.end(client, getIndexApiAction());
//        client.disconnect();
    }


}