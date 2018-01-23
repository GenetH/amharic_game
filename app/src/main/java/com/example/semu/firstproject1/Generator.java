package com.example.semu.firstproject1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generator {
    private JSONObject obj = null;

    public String[] create_entry(InputStream in) {
        String json = null;

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
            obj = new JSONObject(json);
            List<String> array = new ArrayList<String>();
            Iterator<String> stringIterator = obj.keys();
            while (stringIterator.hasNext()) {
                array.add(stringIterator.next() + "");
            }
            String[] bete_array = new String[array.size()];
            array.toArray(bete_array);
            return bete_array;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }
    public String[] create_lesson(String key)
    {
        List<String> array = new ArrayList<String>();
        try {
            JSONArray objJSONArray = obj.getJSONArray(key);
            int size = objJSONArray.length();
            Log.d("JSON Object", objJSONArray.toString());
            for (int i = 0; i< size; i++)
            {
                Log.d("JSON Object", objJSONArray.getString(i));
                array.add(objJSONArray.getString(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        String[] betoche = new String[array.size()];
        array.toArray(betoche);
        Log.d("Betoche: ", betoche[0]);
        return betoche;
    }
}
