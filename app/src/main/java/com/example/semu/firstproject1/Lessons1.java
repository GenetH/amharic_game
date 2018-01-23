package com.example.semu.firstproject1;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by semu on 2/5/17.
 */

public class Lessons1 {




        private JSONObject obj_demes = null;
        private JSONObject obj_lessons = null;

        private String[] lessons;
        private List<String> lesson_entry;

        private List<List<String>> lesson_keys;

        private Map<String, List<String>> alphabet_all;

        boolean loaded;

        public Lessons1(InputStream in_demes, InputStream in_whole_demes) {
            create_list_lessons(in_demes);
            create_lessons_fidels(in_whole_demes); //Get all the values here. And if the user wants everything then return the value.
        }

        /**
         * Create the list of all aphabets.
         *
         * @param in JSON iterator to the file.
         */
        private void create_lessons_fidels(InputStream in) {
            String json = null;
            alphabet_all = new HashMap<String, List<String>>();

            try {
                int size = in.available();
                byte[] buffer = new byte[size];
                in.read(buffer);
                in.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                obj_lessons = new JSONObject(json);
                List<String> array = new ArrayList<String>();
                Iterator<String> stringIterator = obj_lessons.keys();

                while (stringIterator.hasNext()) {
                    String key = stringIterator.next();
                    Log.d("Key is", key);

                    JSONArray one_set = obj_lessons.getJSONArray(key);
                    List<String> al = new ArrayList<String>();
                    for (int i = 0; i < one_set.length(); i++) {
                        al.add(one_set.getString(i));
                    }
                    alphabet_all.put(key, al);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private void create_list_lessons(InputStream in) {
            String json = null;
            lesson_keys = new ArrayList<List<String>>();
            try {
                int size = in.available();
                byte[] buffer = new byte[size];
                in.read(buffer);
                in.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                obj_lessons = new JSONObject(json);
                List<String> array = new ArrayList<String>();
                Iterator<String> stringIterator = obj_lessons.keys();
                while (stringIterator.hasNext()) {
                    //                array.add(stringIterator.next() + " ");
                    String key = stringIterator.next();
                    JSONArray array_ = obj_lessons.getJSONArray(key);
                    List<String> lesson_ = new ArrayList<String>();
                    for (int i = 0; i < array_.length(); i++) {
                        lesson_.add(array_.getString(i));
                    }
                    lesson_keys.add(lesson_);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public List<List<String>> returnLessonEntry() {
            return lesson_keys;
        }

        /**
         * @return A Dictionary of the following format
         * <p>
         * "ha" : ["ha","ha", "hu"]
         * <p>
         * This holds evertyhing that matters.
         */
        public Map<String, List<String>> returnCharListAll() {
            return alphabet_all;
        }

        /**
         * @return Just like the above one without the key.
         * [['ha','hu','hi'],['le','lu','li]]
         */
        public List<List<String>> returnListCharList() {
            List<List<String>> list = new ArrayList<List<String>>();
            for (String key : alphabet_all.keySet()) {
                list.add(alphabet_all.get(key));
            }
            return list;
        }


        public List<List<String>> character_list(List<String> keys) {

            //this return's the arrays that have that values.
            List<List<String>> list = new ArrayList<List<String>>();
            for (String key : keys) {
                list.add(alphabet_all.get(key));
            }

            return list;
        }

    }

