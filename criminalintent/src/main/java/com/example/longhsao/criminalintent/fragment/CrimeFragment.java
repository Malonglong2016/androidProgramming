package com.example.longhsao.criminalintent.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.longhsao.criminalintent.R;
import com.example.longhsao.criminalintent.bean.Crime;
import com.example.longhsao.criminalintent.bean.CrimeLab;

import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * Created by 45411_000 on 2016/6/28.
 */
public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckbox;
    public static final String EXTRA_CRIME_ID = "com.bignerdranch.android.criminalintent.crime_id";
    private static final String DIALOG_DATE = "date";

    public static CrimeFragment newIntance(UUID id){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_CRIME_ID, id);
        CrimeFragment crimeFragment = new CrimeFragment();
        crimeFragment.setArguments(args);
        return crimeFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID id = (UUID) getArguments().getSerializable(EXTRA_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(id);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mDateButton = (Button) v.findViewById(R.id.crime_date);
        mSolvedCheckbox = (CheckBox) v.findViewById(R.id.crime_solved);

        mTitleField.setText(mCrime.getmTitle());
        mSolvedCheckbox.setChecked(mCrime.ismSolved());
        SimpleDateFormat format = new SimpleDateFormat("E yyyy-MM-dd HH:mm");
        mDateButton.setText(format.format(mCrime.getmDate()));
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(mCrime.getmDate());
                dialog.show(manager, DIALOG_DATE);
            }
        });

        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setmTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSolvedCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setmSolved(isChecked);
            }
        });
        return v;
    }


}
