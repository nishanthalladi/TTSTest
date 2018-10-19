package com.example.android.ttstest;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private EditText mEditText;
    private Button mButton;
    private TextToSpeech mTextToSpeech;
    private SeekBar mSeekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSeekBar = findViewById(R.id.seekBar2);
        mSeekBar.setMax(10);
        mTextView = findViewById(R.id.textView);
        mEditText = findViewById(R.id.editText);
        mButton = findViewById(R.id.button);
        mTextToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {}
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mEditText.getText().toString();
                mTextToSpeech.setSpeechRate( (float)(mSeekBar.getProgress()+0.01f) * 2.0f / (float)mSeekBar.getMax() );
                mTextToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
}
