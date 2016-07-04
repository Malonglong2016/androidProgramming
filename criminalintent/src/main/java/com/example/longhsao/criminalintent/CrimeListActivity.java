package com.example.longhsao.criminalintent;

import android.support.v4.app.Fragment;

import com.example.longhsao.criminalintent.fragment.CrimeListFragment;

/**
 * Created by 45411_000 on 2016/7/1.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
