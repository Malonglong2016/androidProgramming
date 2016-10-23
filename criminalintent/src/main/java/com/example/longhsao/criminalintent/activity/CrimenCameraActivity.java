package com.example.longhsao.criminalintent.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;
import android.view.WindowManager;

import com.example.longhsao.criminalintent.SingleFragmentActivity;
import com.example.longhsao.criminalintent.fragment.CrimeCameraFragment;

/**
 * Created by 45411_000 on 2016/10/18.
 */
public class CrimenCameraActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment createFragment() {
        return new CrimeCameraFragment();
    }
}
