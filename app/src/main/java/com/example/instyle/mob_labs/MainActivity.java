package com.example.instyle.mob_labs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Button clear, show;
    private EditText pass;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Hello world!");
        init();
    }


    public void init() {
        clear = findViewById(R.id.clearButton);
        show =  findViewById(R.id.helloButton);
        pass = findViewById(R.id.nameEditText);
        text = findViewById(R.id.sayHello);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass.setText((""));

//                Intent mainIntent = new Intent(MainActivity.this, SecondActivity.class);
//                mainIntent.putExtra("name",pass.getText().toString());
//                startActivity(mainIntent);


            }


        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("Привіт - " + pass.getText().toString());
                pass.getText().clear();
            }
        });

    }

}
