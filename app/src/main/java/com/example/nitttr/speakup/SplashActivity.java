package com.example.nitttr.speakup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by HIMALAYA on 11-01-2017.
 */


public class SplashActivity extends AppCompatActivity {
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        /** final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Please Wait.....");
        pd.setCancelable(false);
        pd.show();*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,RegisterActivity.class);
                startActivity(intent);
               // pd.dismiss();
                finish();
            }
        },3000);
    }
   /** @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (counter < 1) {
            Toast.makeText(getApplicationContext(), "Press Again to Exit", Toast.LENGTH_SHORT).show();
            counter++;

        } else if (counter == 1) {
            super.onBackPressed();
            finish();
        }

    }*/
}
