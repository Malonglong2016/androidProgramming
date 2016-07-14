package com.example.longhsao.criminalintent.bean;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by 45411_000 on 2016/7/7.
 */
public class CriminnalIntentJSONSerializer {

    private String mFilename;
    private Context mContext;

    public CriminnalIntentJSONSerializer(Context mContext, String mFilename) {
        this.mFilename = mFilename;
        this.mContext = mContext;
    }

    public ArrayList<Crime> loadCrimes() throws IOException, JSONException {
        ArrayList<Crime> crimes = new ArrayList<Crime>();
        BufferedReader reader = null;
        try {
            FileInputStream in = mContext.openFileInput(mFilename);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null){
                jsonString.append(line);
            }

            //Pare the JSON using JSONTokener
            JSONArray array =(JSONArray) new JSONTokener(jsonString.toString()).nextValue();

            for (int i= 0; i < array.length(); i++){
                crimes.add(new Crime(array.getJSONObject(i)));
            }
        } finally {
            if (reader != null)
                reader.close();
        }

        return crimes;

    }

    public void saveCirmes(ArrayList<Crime> crimes) throws IOException, JSONException {
        JSONArray array = new JSONArray();
        for (Crime crime : crimes)
            array.put(crime.toJSON());

        //Writer the file to disk
        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput(mFilename, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        } finally {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
