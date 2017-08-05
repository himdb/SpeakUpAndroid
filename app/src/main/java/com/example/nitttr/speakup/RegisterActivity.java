package com.example.nitttr.speakup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class RegisterActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText text = (EditText) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.reg);
        button.setEnabled(false);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String btn1 = text.getText().toString();

                if(!(btn1.contains("@gmail.com"))){
                    Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(RegisterActivity.this, Main2Activity.class);
                    startActivity(intent);

                }
            }

        });
        YoYo.with(Techniques.Shake)
                .duration(2000)
                .playOn(button);
        YoYo.with(Techniques.Shake)
                .duration(2000)
                .playOn(text);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox:
                if (checked) {
                    button.setEnabled(true);
                    Toast.makeText(getApplicationContext(), "Checked", Toast.LENGTH_SHORT).show();

                } else {
                    button.setEnabled(false);
                    Toast.makeText(getApplicationContext(), "Click on CheckBox To Register", Toast.LENGTH_SHORT).show();
                }
        }

    }

}
