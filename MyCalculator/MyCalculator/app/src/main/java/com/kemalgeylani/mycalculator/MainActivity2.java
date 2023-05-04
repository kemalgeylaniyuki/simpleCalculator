package com.kemalgeylani.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kemalgeylani.mycalculator.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;
    double number1;
    double number2;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        sharedPreferences = this.getSharedPreferences("com.kemalgeylani.mycalculator", Context.MODE_PRIVATE);

        Singleton singleton = Singleton.getInstance();
        number1 = (double) singleton.getSentNumber1();
        number2 = (double) singleton.getSentNumber2();

        double storedAverage = sharedPreferences.getFloat("storedAverage",0.00f);

        if (storedAverage == 0){
            binding.textView2.setText("Result : ");
        }
        else {
            binding.textView2.setText("Stored Average : " + storedAverage);
        }
    }

    public void calculate(View view){

        double average = (number1 + number2) / 2;
        binding.textView2.setText("Average : " + average);

        sharedPreferences.edit().putFloat("storedAverage", (float) average).apply();
    }

    public void returnmain(View view){

        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }
}