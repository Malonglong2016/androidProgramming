package com.example.longhsao.criminalintent.bean;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by 45411_000 on 2016/6/29.
 */
public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private ArrayList<Crime> mCrimes;
    private static final String TAG = "CrimeLab";
    private static final String FILENAME = "cirme.json";
    private CriminnalIntentJSONSerializer mSerializer;
    private static CrimeLab mCrimeLab;

    private CrimeLab(Context appContext){
        mAppContext = appContext;
        mSerializer = new CriminnalIntentJSONSerializer(appContext, FILENAME);
        try {
            mCrimes = mSerializer.loadCrimes();
        } catch (Exception e) {
            mCrimes = new ArrayList<Crime>();
        }
    }

    public static CrimeLab get(Context context){
        if(sCrimeLab == null)
            sCrimeLab = new CrimeLab(context.getApplicationContext());
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime c : mCrimes){
            if (c.getmId().equals(id))
                return c;
        }
        return null;
    }

    public void addCrime(Crime c){
        mCrimes.add(c);
    }

    public void deleteCrime(Crime c){
        mCrimes.remove(c);
    }

    public boolean saveCrimes(){
        try {
            mSerializer.saveCirmes(mCrimes);
            Log.d("Log", "crimes saved to file");
            return true;
        } catch (Exception e) {
            Log.d("Log", "Error saving crimes: ",e);
            return false;
        }
    }

}
