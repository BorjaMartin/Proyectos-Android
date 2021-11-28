package com.example.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class SecondActivity extends AppCompatActivity {

    // Elementos UI
    private SeekBar seekBarAge;
    private TextView textViewAge;
    private Button btnNext;
    private RadioButton radioButtonGreeter;
    private RadioButton radioButtonFarewell;

    // Otros valores
    private String name = "";
    private int age = 18;
    private final int MAX_AGE = 60;
    private final int MIN_AGE = 16;

    // Para compartir
    public static final int GREETER_OPTION = 1;
    public static final int FAREWELL_OPTION = 2;

    private TextView textView;
    private Button buttonBack;
    private  Button buttonThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Activar flecha de ir hacia atrás.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView = (TextView) findViewById(R.id.textView2);

        //Recogemos los parametros del intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.getString("greeter") != null)
        {
           String greeter = bundle.getString("greeter");
           Toast.makeText(SecondActivity.this,greeter,Toast.LENGTH_LONG).show();
            textView.setText(greeter);
        }else{
            Toast.makeText(SecondActivity.this,"It is empty! ",Toast.LENGTH_LONG).show();
        }


        buttonBack = (Button) findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondActivity.this.finish();
                onBackPressed();
            }
        });


        buttonThird = (Button) findViewById(R.id.buttonThird);

        buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentThird = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intentThird);


            }
        });
    }
}