package com.example.longhsao.criminalintent.bean;

import android.content.Context;

import org.json.JSONArray;

import java.io.FileNotFoundException;
import java.io.IOException;
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

    public CriminnalIntentJSONSerializer(String mFilename, Context mContext) {
        this.mFilename = mFilename;
        this.mContext = mContext;
    }

    public void saveCirmes(ArrayList<Crime> crimes) {
        JSONArray array = new JSONArray();
        for (Crime crime : crimes)
            array.put(crime.toJSON());

        //Writer the file to disk
        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput(mFilename, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
