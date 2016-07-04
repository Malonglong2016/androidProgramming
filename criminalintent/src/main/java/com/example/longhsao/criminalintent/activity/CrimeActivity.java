package com.example.longhsao.criminalintent.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.longhsao.criminalintent.SingleFragmentActivity;
import com.example.longhsao.criminalintent.fragment.CrimeFragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        return CrimeFragment.newIntance(crimeId);
    }

}
