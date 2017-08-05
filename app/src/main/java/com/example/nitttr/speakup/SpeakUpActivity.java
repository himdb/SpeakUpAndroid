package com.example.nitttr.speakup;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpeakUpActivity extends ActionBarActivity implements OnInitListener {

    private int MY_DATA_CHECK_CODE = 0;
    private TextToSpeech tts;
    private EditText inputText;
    private Button speakUp;
    private Button clearText;
    private AudioManager volumeManager;
    AlertDialog ad;
    private SeekBar seek_Bar;
    private TextView text_view;
    String item ;
    String item_spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //seebbarr();
        final Button hi = (Button) findViewById(R.id.hi);
        final Button hello = (Button) findViewById(R.id.hello);
        final Button how = (Button) findViewById(R.id.how);
        final Button water = (Button) findViewById(R.id.water);
        final Button takecare = (Button) findViewById(R.id.takecare);
        final Button Behappy = (Button) findViewById(R.id.behappy);
        final Button Welcome = (Button) findViewById(R.id.welcome);
        final Button See = (Button) findViewById(R.id.see);


        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Speed, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item_spinner = parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        volumeManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = volumeManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = volumeManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        SeekBar volumeControl = (SeekBar) findViewById(R.id.VolumeBar);
        volumeControl.setMax(maxVolume);

        text_view = (TextView) findViewById(R.id.text_view);
        text_view.setText("Volume : " + volumeControl.getProgress() + " / " + volumeControl.getMax());

        volumeControl.setProgress(curVolume);
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            int progress_value;
            //text_view.setText("Volume : " + seek_Bar.getProgress() + " / " +seek_Bar.getMax());

            @Override
            public void onStartTrackingTouch(SeekBar seekbar) {
                Log.d("NITTTR", Integer.toString(progress_value));
                progress_value = seekbar.getProgress();
                Log.d("NITTTR", Integer.toString(progress_value));
                text_view.setText("Volume :" + progress_value + " / " + seekbar.getMax());
                Toast.makeText(getApplicationContext(), "SeekBar in StartTracking", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekbar) {
                Log.d("NITTTR", Integer.toString(progress_value));
                progress_value = seekbar.getProgress();
                Log.d("NITTTR", Integer.toString(progress_value));
                text_view.setText("Volume :" + progress_value + " / " + seekbar.getMax());
                Toast.makeText(getApplicationContext(), "SeekBar in StopTracking", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                volumeManager.setStreamVolume(AudioManager.STREAM_MUSIC, arg1, 0);

                String progress_value = Integer.toString(arg1);
                Log.d("NITTTR", progress_value);
                text_view.setText("Volume :" + progress_value + " / " + arg0.getMax());
                Toast.makeText(getApplicationContext(), "SeekBar in progess", Toast.LENGTH_SHORT).show();
            }
        });

        Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);

        initControls();

        hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hi1 = hi.getText().toString();
                inputText.setText(hi1);
            }
        });
        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hello1 = hello.getText().toString();
                inputText.setText(hello1);
            }
        });
        how.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String how1 = how.getText().toString();
                inputText.setText(how1);
            }
        });
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String water1 = water.getText().toString();
                inputText.setText(water1);
            }
        });
        takecare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String takecare1 = takecare.getText().toString();
                inputText.setText(takecare1);
            }
        });
        Behappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Behappy1 = Behappy.getText().toString();
                inputText.setText(Behappy1);
            }
        });
        Welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Welcome1 = Welcome.getText().toString();
                inputText.setText(Welcome1);

            }
        });
        See.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String see1 = See.getText().toString();
                inputText.setText(see1);
            }
        });
    }

     /*void  seebbarr(){

        seek_Bar = (SeekBar) findViewById(R.id.VolumeBar);
        text_view = (TextView) findViewById(R.id.text_view);
        text_view.setText("Volume : " + seek_Bar.getProgress() + " / " +seek_Bar.getMax());

        seek_Bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            int progress_value;

            @Override
            public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser) {
                Log.d("NITTTR", Integer.toString(progress_value));
                progress_value = progress;
                Log.d("NITTTR", Integer.toString(progress_value));
                text_view.setText("Volume :" + progress + " / " + seek_Bar.getMax());
                Toast.makeText(getApplicationContext(), "SeekBar in progess", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekbar) {
                Log.d("NITTTR", Integer.toString(progress_value));
                progress_value = seekbar.getProgress();
                Log.d("NITTTR", Integer.toString(progress_value));
                text_view.setText("Volume :" + progress_value + " / " + seek_Bar.getMax());
                Toast.makeText(getApplicationContext(), "SeekBar in StartTracking", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekbar) {
                Log.d("NITTTR", Integer.toString(progress_value));
                progress_value = seekbar.getProgress();
                Log.d("NITTTR", Integer.toString(progress_value));
                text_view.setText("Volume :" + progress_value + " / " + seek_Bar.getMax());
                Toast.makeText(getApplicationContext(), "SeekBar in StopTracking", Toast.LENGTH_SHORT).show();
            }
        });
    }
    */

    private void initControls() {
        inputText = (EditText) findViewById(R.id.InputField);
        speakUp = (Button) findViewById(R.id.SpeakButton);
        clearText = (Button) findViewById(R.id.ClearField);


        speakUp.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpeakText(v);
            }
        });

        clearText.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Clear(v);
            }
        });


    }


    private void SpeakText(View v) {
        String text = inputText.getText().toString();
        if (text != null && text.length() > 0) {

            if(item_spinner.equals("Very Slow")) {
                float f = (float)0.5;
                tts.setSpeechRate(f);
            } else if (item_spinner.equals("Slow")){
                float f = (float) 1.0;
                tts.setSpeechRate(f);
            } else if (item_spinner.equals("Normal")){
                float f = (float) 1.5;
                tts.setSpeechRate(f);
            } else if (item_spinner.equals("Fast")){
                float f = (float) 2.0;
                tts.setSpeechRate(f);
            } else if (item_spinner.equals("Very Fast")){
                float f = (float) 2.5;
                tts.setSpeechRate(f);
            }
            tts.speak(text, TextToSpeech.QUEUE_ADD, null);

        }
    }

    private void Clear(View v) {
        inputText.setText("");
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                // success, create the TTS instance
                tts = new TextToSpeech(this, this);
            } else {
                // missing data, install it
                Intent installIntent = new Intent();
                installIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installIntent);

            }
        }

    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            Toast.makeText(SpeakUpActivity.this,
                    "Text-To-Speech engine is initialized", Toast.LENGTH_LONG).show();
        } else if (status == TextToSpeech.ERROR) {
            Toast.makeText(SpeakUpActivity.this,
                    "Error occurred while initializing Text-To-Speech engine", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onBackPressed() {
        ad = new AlertDialog.Builder(this)
                .setTitle("Confirm Action")
                .setMessage("Do You Want To Exit ?")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ad.cancel();
                    }
                })
                .create();
        ad.show();
    }
}

