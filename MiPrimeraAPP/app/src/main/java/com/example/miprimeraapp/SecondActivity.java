package com.example.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private Button buttonBack;
    private  Button buttonThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

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