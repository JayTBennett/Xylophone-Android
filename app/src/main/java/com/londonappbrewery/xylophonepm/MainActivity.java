package com.londonappbrewery.xylophonepm;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.Dictionary;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // Helpful Constants
    private final int NR_OF_SIMULTANEOUS_SOUNDS = 7;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int NO_LOOP = 0;
    private final int PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

    // TODO: Add member variables here
    private HashMap<String, Integer> mNotes = new HashMap<String, Integer>();

    private SoundPool mSoundPool = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Create a new SoundPool
        mSoundPool = new SoundPool(NR_OF_SIMULTANEOUS_SOUNDS, AudioManager.STREAM_MUSIC, 0);


        mNotes.put("C", mSoundPool.load(getApplicationContext(), R.raw.note1_c, 1));
        mNotes.put("D", mSoundPool.load(getApplicationContext(), R.raw.note2_d, 1));
        mNotes.put("E", mSoundPool.load(getApplicationContext(), R.raw.note3_e, 1));
        mNotes.put("F", mSoundPool.load(getApplicationContext(), R.raw.note4_f, 1));
        mNotes.put("G", mSoundPool.load(getApplicationContext(), R.raw.note5_g, 1));
        mNotes.put("A", mSoundPool.load(getApplicationContext(), R.raw.note6_a, 1));
        mNotes.put("B", mSoundPool.load(getApplicationContext(), R.raw.note7_b, 1));
    }

    // TODO: Add the play methods triggered by the buttons
    public void PlayNote(View view) {
        Log.d("Xylophone", "" + view.getTag());
        Log.d("Xylophone", mNotes.get(view.getTag().toString()).toString());
        mSoundPool.play(mNotes.get(view.getTag().toString()), LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
    }

}
