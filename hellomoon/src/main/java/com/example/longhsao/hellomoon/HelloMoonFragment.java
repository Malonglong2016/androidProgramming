package com.example.longhsao.hellomoon;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by 45411_000 on 2016/7/5.
 */
public class HelloMoonFragment extends Fragment {

    private AudioPlayer mPlayer = new AudioPlayer();
    private Button mPlayButton;
    private Button mStopButton;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i("Log", "---HelloMoonFragment--------onAttach--------------->");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("Log", "---HelloMoonFragment--------onCreateView--------------->");
        View view = inflater.inflate(R.layout.fragment_hello_moon, container, false);

        mPlayButton = (Button) view.findViewById(R.id.hellmoon_playButton);
        mStopButton = (Button) view.findViewById(R.id.hellmoon_stopButton);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.play(getActivity());
            }
        });

        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Log.i("Log", "---HelloMoonFragment--------onCreate--------------->");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("Log", "---HelloMoonFragment--------onActivityCreated--------------->");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i("Log", "---HelloMoonFragment--------onResume--------------->");
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.i("Log", "----HelloMoonFragment-------onStart--------------->");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Log", "------HelloMoonFragment-----onPause--------------->");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Log", "---HelloMoonFragment--------onStop--------------->");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("Log", "---HelloMoonFragment--------onDestroyView--------------->");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
        Log.i("Log", "---HelloMoonFragment--------onDestroy--------------->");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("Log", "---HelloMoonFragment--------onDetach--------------->");
    }
}
