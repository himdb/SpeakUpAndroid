package com.example.nitttr.speakup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, SpeakUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
        YoYo.with(Techniques.Wave)
                .duration(2000)
                .playOn(findViewById(R.id.imageView2));
        YoYo.with(Techniques.ZoomIn)
                .duration(2000)
                .playOn(findViewById(R.id.button1));
    }

}
