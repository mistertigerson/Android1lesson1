package com.example.android1lesson1;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private EditText editText1;
    private Button button;
    private TextView textView;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.my_edit_text);
        editText1 = findViewById(R.id.my_edit_text1);
        button = findViewById(R.id.my_button_come_in);
        textView = findViewById(R.id.tup_me);

        String name;


        button.setOnClickListener(v -> my_click(v));
    }


    public void my_click(View view) {
        String login = editText.getText().toString().trim();
        String password = editText1.getText().toString().trim();
        if (login.equals("a") && password.equals("p")) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "неправильный логин или пароль",
                    Toast.LENGTH_LONG).show();
        }
    }
}