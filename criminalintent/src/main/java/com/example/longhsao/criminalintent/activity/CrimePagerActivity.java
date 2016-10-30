package com.example.longhsao.criminalintent.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.example.longhsao.criminalintent.R;
import com.example.longhsao.criminalintent.bean.Crime;
import com.example.longhsao.criminalintent.bean.CrimeLab;
import com.example.longhsao.criminalintent.fragment.CrimeFragment;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by 45411_000 on 2016/7/4.
 */
public class CrimePagerActivity extends AppCompatActivity implements CrimeFragment.Callbacks{

    private ViewPager mViewPager;

    private ArrayList<Crime> mCrimes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewpager);
        setContentView(mViewPager);

        mCrimes = CrimeLab.get(this).getCrimes();
        FragmentManager manager = getSupportFragmentManager();

        mViewPager.setAdapter(new FragmentStatePagerAdapter(manager) {
            @Override
            public Fragment getItem(int position) {
                Crime crime = mCrimes.get(position);
                return CrimeFragment.newIntance(crime.getmId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Crime crime = mCrimes.get(position);
                if (!TextUtils.isEmpty(crime.getmTitle()))
                    setTitle(crime.getmTitle());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        UUID mId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        for (int i = 0; i < mCrimes.size(); i++){
            if (mCrimes.get(i).getmId().equals(mId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    @Override
    public void onCrimeUpdated(Crime crime) {

    }
}
