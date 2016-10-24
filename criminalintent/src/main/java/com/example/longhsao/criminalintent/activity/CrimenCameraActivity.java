package com.example.longhsao.criminalintent.activity;

import android.support.v4.app.Fragment;

import com.example.longhsao.criminalintent.SingleFragmentActivity;
import com.example.longhsao.criminalintent.fragment.CrimeCameraFragment;

/**
 * Created by 45411_000 on 2016/10/18.
 */
public class CrimenCameraActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeCameraFragment();
    }
}
