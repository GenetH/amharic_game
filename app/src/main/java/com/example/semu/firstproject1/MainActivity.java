package com.example.semu.firstproject1;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {


    public Button button;
    public Button button1;



    int position;
    List<List<String>> fidel_list;
    List<List<String>> fidel_list_1;
    Lessons lessons;
    Lessons lessons_1;

    List<String> lesson_list;
    InputStream in;
    InputStream char_list;

    InputStream in_1;
    InputStream char_list_1;

    ListView listView;
    List<String> keys;

    // List<String> lesson1;

    List<List<String>> lesson_list_iter;
    List<List<String>> lesson_list_iter_1;

    List<List<String>> lesson;
    List<List<String>> lesson1;

    List<String> strings;

    Map<String, List<String>> character_list;
    Map<String, List<String>> character_list_1;


    List<String> simpleList;

    public void init() {

        button = (Button) findViewById(R.id.መማሪያ);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sem = new Intent(MainActivity.this,memarya.class);
                startActivity(sem);
            }
        });

        button = (Button) findViewById(R.id.እርዳታ);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sem = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(sem);

            }
        });




        in = getResources().openRawResource(R.raw.lessons);
        char_list = getResources().openRawResource(R.raw.amharic);

        in_1 = getResources().openRawResource(R.raw.lessons1);
        char_list_1 = getResources().openRawResource(R.raw.amharic3);

        lessons = new Lessons(in, char_list);
        lessons_1 = new Lessons(in_1, char_list_1);

        fidel_list = lessons.returnListCharList();
        character_list = lessons.returnCharListAll();
        lesson_list_iter = lessons.returnLessonEntry();

        fidel_list_1 = lessons_1.returnListCharList();
        character_list_1 = lessons_1.returnCharListAll();
        lesson_list_iter_1 = lessons_1.returnLessonEntry();



        keys = lesson_list_iter.get(1);



        button = (Button) findViewById(R.id.የፊደል);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, button);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.stage_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListen
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.button1: {
                                Intent sem = new Intent(MainActivity.this, game1.class);
                                //lesson = new ArrayList<List<String>>();
                                simpleList = new ArrayList<String>();

                                keys = lesson_list_iter.get(2);
                                lesson1 = new ArrayList<List<String>>();

                                lesson1 = lessons.character_list(lesson_list_iter.get(0));

                                List<String> quiz_q = new ArrayList<String>();
                                List<String> quiz_q1 = new ArrayList<String>();

                                for (List<String> t : lesson1) {




                                    for (String t_ : t) {
                                        quiz_q.add(t_);


                                    }


                                    Log.d("7", String.valueOf(quiz_q));

                                }


                                sem.putStringArrayListExtra("string", (ArrayList<String>) quiz_q);
                                startActivity(sem);
                                break;
                            }
                            case R.id.button2: {
                                Intent ge = new Intent(MainActivity.this, game1.class);

                                //   final String lesson[] = gen.create_lesson("ለ");
                                lesson1 = lessons.character_list(lesson_list_iter.get(1));

                                List<String> quiz_q = new ArrayList<String>();
                                List<String> quiz_q1 = new ArrayList<String>();
                                for (List<String> t : lesson1) {




                                    for (String t_ : t) {
                                        quiz_q.add(t_);


                                    }


                                    Log.d("7", String.valueOf(quiz_q));

                                }

                                // ge.putExtra("string", lesson);
                                ge.putStringArrayListExtra("string", (ArrayList<String>) quiz_q);
                                startActivity(ge);
                                break;
                            }
                            case R.id.button3: {
                                Intent ge1 = new Intent(MainActivity.this, game1.class);
                                lesson1 = lessons.character_list(lesson_list_iter.get(2));

                                List<String> quiz_q = new ArrayList<String>();
                                List<String> quiz_q1 = new ArrayList<String>();
                                for (List<String> t : lesson1) {




                                    for (String t_ : t) {
                                        quiz_q.add(t_);


                                    }


                                    Log.d("7", String.valueOf(quiz_q));

                                }



                                ge1.putStringArrayListExtra("string", (ArrayList<String>) quiz_q);
                                startActivity(ge1);
                                break;
                            }
                            case R.id.button4: {
                                Intent ge2 = new Intent(MainActivity.this, game1.class);
                                lesson1 = lessons.character_list(lesson_list_iter.get(3));

                                List<String> quiz_q = new ArrayList<String>();
                                List<String> quiz_q1 = new ArrayList<String>();
                                for (List<String> t : lesson1) {



                                    for (String t_ : t) {
                                        quiz_q.add(t_);


                                    }

                                    //Log.d("A", String.valueOf(quiz_q));
                                    Log.d("7", String.valueOf(quiz_q));

                                }

                                // final String lessons[] = gen.create_lesson("ክ");

                                ge2.putStringArrayListExtra("string", (ArrayList<String>) quiz_q);
                                // ge2.putExtra("string", lessons);
                                startActivity(ge2);
                                break;
                            }

                            case R.id.button5: {
                                Intent ge3 = new Intent(MainActivity.this, game1.class);
                                lesson1 = lessons.character_list(lesson_list_iter.get(4));

                                List<String> quiz_q = new ArrayList<String>();
                                List<String> quiz_q1 = new ArrayList<String>();
                                for (List<String> t : lesson1) {



                                    // while( Integer.parseInt(t) == 0)
                                    // if(t.equals(0)&&t.equals(8)&&t.equals(16)&&t.equals(24)&&t.equals(32))
                                    //   break;
                                    for (String t_ : t) {
                                        quiz_q.add(t_);


                                    }

                                    //Log.d("A", String.valueOf(quiz_q));
                                    Log.d("7", String.valueOf(quiz_q));

                                }

                                // final String lesson[] = gen.create_lesson("ክ");

                                ge3.putStringArrayListExtra("string", (ArrayList<String>) quiz_q);
                                // ge3.putExtra("string", lesson);
                                startActivity(ge3);
                                break;
                            }
                            case R.id.button6: {
                                Intent ge4 = new Intent(MainActivity.this, game1.class);
                                lesson1 = lessons.character_list(lesson_list_iter.get(5));

                                List<String> quiz_q = new ArrayList<String>();
                                List<String> quiz_q1 = new ArrayList<String>();
                                for (List<String> t : lesson1) {




                                    for (String t_ : t) {
                                        quiz_q.add(t_);


                                    }


                                    Log.d("7", String.valueOf(quiz_q));

                                }



                                ge4.putStringArrayListExtra("string", (ArrayList<String>) quiz_q);

                                startActivity(ge4);
                            }
                            default:{
                                Intent ge5 = new Intent(MainActivity.this, game1.class);
                                startActivity(ge5);
                                break;

                            }}


                        return true;
                    }  });


                popup.show();
            }
//closing the setOnClickListener method
        });
        button = (Button) findViewById(R.id.የድምጽ);
        strings = new ArrayList<String>();
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(MainActivity.this, button);
                popup.getMenuInflater().inflate(R.menu.stage_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.button1: {
                                Intent sem = new Intent(MainActivity.this, game2.class);
                                //lesson = new ArrayList<List<String>>();
                                simpleList = new ArrayList<String>();
//                                keys = lesson_list_iter.get(2);
                                lesson1 = new ArrayList<List<String>>();
                                strings =     lesson_list_iter_1.get(0);
                                for (String s: strings)
                                {
                                    Log.d("--->",s);
                                }
                                lesson1 = lessons_1.character_list(strings);
                                List<String> quiz_q = new ArrayList<String>();
                                List<String> quiz_q1 = new ArrayList<String>();

                                for (List<String> t : lesson1) {
                                    for (String t_ : t) {
                                        quiz_q.add(t_);
                                    }
//                                    Log.d("7", String.valueOf(quiz_q));
                                }

//                                sem.putStringArrayListExtra("string", (ArrayList<String>) quiz_q);
//                                sem.putStringArrayListExtra("string_1",(ArrayList<String>) strings);
                                Bundle b = new Bundle();
                                b.putStringArrayList("string",(ArrayList<String>) quiz_q);
                                b.putStringArrayList("string_1",(ArrayList<String>) strings);

                                sem.putExtras(b);
                                startActivity(sem);
                                break;
                            }
                            case R.id.button2: {
                                Intent ge = new Intent(MainActivity.this, game2.class);
                                //   final String lesson[] = gen.create_lesson("ለ");
                                strings.clear();
                                for (String s : lesson_list_iter_1.get(1))
                                {
                                    strings.add(s);
                                }
                                lesson1 = lessons_1.character_list(strings);
                                List<String> quiz_q = new ArrayList<String>();
                                List<String> quiz_q1 = new ArrayList<String>();
                                for (List<String> t : lesson1) {
                                    for (String t_ : t) {
                                        quiz_q.add(t_);
                                    }
                                    Log.d("7", String.valueOf(quiz_q));
                                }
                                // ge.putExtra("string", lesson);
                                Bundle b = new Bundle();
                                b.putStringArrayList("string",(ArrayList<String>) quiz_q);
                                b.putStringArrayList("string_1",(ArrayList<String>) strings);
//                                b.putString("string_1","1 2 3");
//                                ge.putStringArrayListExtra("string", (ArrayList<String>) quiz_q);
//                                ge.putStringArrayListExtra("string_1",(ArrayList<String>) strings);
                                ge.putExtras(b);
                                startActivity(ge);
                                break;
                            }
                            case R.id.button3: {
                                Intent ge1 = new Intent(MainActivity.this, game2.class);
                                strings.clear();
                                for (String s : lesson_list_iter_1.get(2))
                                {
                                    strings.add(s);
                                }
                                lesson1 = lessons_1.character_list(strings);
                                List<String> quiz_q = new ArrayList<String>();
                                List<String> quiz_q1 = new ArrayList<String>();
                                for (List<String> t : lesson1) {
                                    for (String t_ : t) {
                                        quiz_q.add(t_);
                                    }
                                    Log.d("7", String.valueOf(quiz_q));
                                }
                                Bundle b = new Bundle();
                                b.putStringArrayList("string",(ArrayList<String>) quiz_q);
                                b.putStringArrayList("string_1",(ArrayList<String>) strings);
//                                b.putString("string_1","1 2 3");
//                                ge1.putStringArrayListExtra("string", (ArrayList<String>) quiz_q);
//                                ge1.putStringArrayListExtra("string_1",(ArrayList<String>) strings);
                                ge1.putExtras(b);
                                startActivity(ge1);
                                break;
                            }
                            case R.id.button4: {
                                Intent ge2 = new Intent(MainActivity.this, game2.class);
                                strings.clear();
                                for (String s : lesson_list_iter_1.get(3))
                                {
                                    strings.add(s);
                                }
                                lesson1 = lessons_1.character_list(strings);
                                List<String> quiz_q = new ArrayList<String>();
                                List<String> quiz_q1 = new ArrayList<String>();
                                for (List<String> t : lesson1) {
                                    for (String t_ : t) {
                                        quiz_q.add(t_);
                                    }
                                    //Log.d("A", String.valueOf(quiz_q));
                                    Log.d("7", String.valueOf(quiz_q));
                                }
                                // final String lessons[] = gen.create_lesson("ክ");
                                Bundle b = new Bundle();
                                b.putStringArrayList("string",(ArrayList<String>) quiz_q);
                                b.putStringArrayList("string_1",(ArrayList<String>) strings);
//                                b.putString("string_1","1 2 3");
//                                ge2.putStringArrayListExtra("string", (ArrayList<String>) quiz_q);
//                                ge2.putStringArrayListExtra("string_1",(ArrayList<String>) strings);
                                // ge2.putExtra("string", lessons);
                                ge2.putExtras(b);
                                startActivity(ge2);
                                break;
                            }

                            case R.id.button5: {
                                Intent ge3 = new Intent(MainActivity.this, game2.class);
                                strings.clear();
                                for (String s : lesson_list_iter_1.get(4))
                                {
                                    strings.add(s);
                                }
                                lesson1 = lessons_1.character_list(strings);
                                List<String> quiz_q = new ArrayList<String>();
                                List<String> quiz_q1 = new ArrayList<String>();
                                for (List<String> t : lesson1) {
                                    // while( Integer.parseInt(t) == 0)
                                    // if(t.equals(0)&&t.equals(8)&&t.equals(16)&&t.equals(24)&&t.equals(32))
                                    //   break;
                                    for (String t_ : t) {
                                        quiz_q.add(t_);
                                    }
                                    //Log.d("A", String.valueOf(quiz_q));
                                    Log.d("7", String.valueOf(quiz_q));

                                }

                                // final String lesson[] = gen.create_lesson("ክ");
                                Bundle b = new Bundle();
                                b.putStringArrayList("string",(ArrayList<String>) quiz_q);
                                b.putStringArrayList("string_1",(ArrayList<String>) strings);
//                                b.putString("string_1","1 2 3");
//                                ge3.putStringArrayListExtra("string", (ArrayList<String>) quiz_q);
//                                ge3.putStringArrayListExtra("string_1",(ArrayList<String>) strings);
                                // ge3.putExtra("string", lesson);
                                ge3.putExtras(b);
                                startActivity(ge3);
                                break;
                            }
                            case R.id.button6: {
                                Intent ge4 = new Intent(MainActivity.this, game2.class);
                                strings.clear();
                                for (String s : lesson_list_iter_1.get(5))
                                {
                                    strings.add(s);
                                }
                                lesson1 = lessons_1.character_list(strings);

                                List<String> quiz_q = new ArrayList<String>();
                                List<String> quiz_q1 = new ArrayList<String>();
                                for (List<String> t : lesson1) {
                                    for (String t_ : t) {
                                        quiz_q.add(t_);
                                    }
                                    Log.d("7", String.valueOf(quiz_q));
                                }
                                Bundle b = new Bundle();
                                b.putStringArrayList("string",(ArrayList<String>) quiz_q);
                                b.putStringArrayList("string_1",(ArrayList<String>) strings);
//                                b.putString("string_1","1 2 3");
//                                ge4.putStringArrayListExtra("string", (ArrayList<String>) quiz_q);
//                                ge4.putStringArrayListExtra("string_1",(ArrayList<String>) strings);
                                ge4.putExtras(b);
                                startActivity(ge4);

                            }
                            default:{
//                                Intent ge5 = new Intent(MainActivity.this, game1.class);
//                                startActivity(ge5);
                                break;

                            }}


                        return true;

                    }

                });


                popup.show();//showing popup menu
            }

        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();}

}

