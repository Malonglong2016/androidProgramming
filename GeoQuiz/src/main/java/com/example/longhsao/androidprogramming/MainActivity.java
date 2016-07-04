package com.example.longhsao.androidprogramming;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.longhsao.androidprogramming.bean.TrueFalse;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private Button cheatButton;
    private TextView mQuestionTextView;
    private static final String TAG = "MainActivity";
    private static final String KEY_INDEX = "index";
    private static final String KEY_IS_CHEAT = "isCheat";
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_ocean, true),
            new TrueFalse(R.string.question_mideast, false),
            new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia, true)
    };

    private int mCurrentIndex = 0;
    private boolean mIsCheater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        mTrueButton = (Button) findViewById(R.id.true_botton);
        mFalseButton = (Button) findViewById(R.id.false_botton);
        mNextButton = (ImageButton) findViewById(R.id.next);
        mPrevButton = (ImageButton) findViewById(R.id.prev);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        cheatButton = (Button) findViewById(R.id.cheat_button);
        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mPrevButton.setOnClickListener(this);
        mQuestionTextView.setOnClickListener(this);
        cheatButton.setOnClickListener(this);
        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX);
            mIsCheater = savedInstanceState.getBoolean(KEY_IS_CHEAT);
        }
        initData();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    private void initData() {
        Log.d(TAG, "Updating question text for question #" + mCurrentIndex, new Exception());
        int question = mQuestionBank[mCurrentIndex].getmQuestion();
        mQuestionTextView.setText(question);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.true_botton:
                checkAnswer(true);
                break;
            case R.id.false_botton:
                checkAnswer(false);
                break;
            case R.id.question_text_view:
            case R.id.next:
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                mIsCheater = false;
                initData();
                break;
            case R.id.prev:
                if (mCurrentIndex == 0)
                    mCurrentIndex = mQuestionBank.length - 1;
                else
                    mCurrentIndex = Math.abs((mCurrentIndex - 1) % mQuestionBank.length);
                Log.i("Log", "mCurrentIndex-------------->" + mCurrentIndex);
                initData();
                break;

            case R.id.cheat_button:
                Intent i = new Intent(this, CheatActivity.class);
                boolean answer = mQuestionBank[mCurrentIndex].ismTrueQuestion();
                i.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE, answer);
                startActivityForResult(i, 0);
                break;
        }
    }

    private void checkAnswer(boolean b) {
        boolean ismTrueQuestion = mQuestionBank[mCurrentIndex].ismTrueQuestion();
        int messageResId = 0;
        if (mIsCheater)
            messageResId = R.string.judgment_toast;
        else {
            if (b == ismTrueQuestion)
                messageResId = R.string.correct_toast;
            else
                messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
        outState.putInt(KEY_INDEX, mCurrentIndex);
        outState.putBoolean(KEY_IS_CHEAT, mIsCheater);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null)
            return;
        mIsCheater = data.getBooleanExtra(CheatActivity.EXTRA_ANSWER_SHOWN, false);
    }
}
