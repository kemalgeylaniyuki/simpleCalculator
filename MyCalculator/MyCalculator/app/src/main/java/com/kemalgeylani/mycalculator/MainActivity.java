package com.kemalgeylani.mycalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.kemalgeylani.mycalculator.databinding.ActivityMainBinding;

/*
Bir hesap makinesi uygulaması geliştirin. Kullanıcı, uygulama arayüzünde iki sayı girer ve
ardından bir işlem seçer (toplama, çıkarma, çarpma veya bölme). Uygulama, seçilen işleme göre
sonucu hesaplar ve gösterir. Bu örnekte, kullanıcının seçtiği işlemi saklamak için
RadioButton bileşenlerini kullanabilirsiniz ve hesaplamalar için
daha önce yazdığınız hesap makinesi kodunu kullanabilirsiniz.
*/

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    SharedPreferences sharedPreferences;
    AlertDialog.Builder alert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        Toast.makeText(this, "Calculator Started", Toast.LENGTH_SHORT).show();

        sharedPreferences = this.getSharedPreferences("com.kemalgeylani.mycalculator", Context.MODE_PRIVATE);

        int storedResult = sharedPreferences.getInt("storedResult",0);

        if (storedResult == 0){
            binding.resultText.setText("Result : ");
        }
        else {
            binding.resultText.setText("Stored Result : " + storedResult);
        }

    }

    public void sum(View view) {
        if (binding.number1Text.getText().toString().matches("") || binding.number2Text.getText().toString().matches("")) {
            binding.resultText.setText("Enter the Number !");
        } else {
            int number1 = Integer.parseInt(binding.number1Text.getText().toString());
            int number2 = Integer.parseInt(binding.number2Text.getText().toString());
            int result = number1 + number2;

            binding.resultText.setText("Result : " + result);

            sharedPreferences.edit().putInt("storedResult",result).apply();
        }
    }

    public void deduct(View view) {
        if (binding.number1Text.getText().toString().matches("") || binding.number2Text.getText().toString().matches("")) {
            binding.resultText.setText("Enter the Number !");
        } else {
            int number1 = Integer.parseInt(binding.number1Text.getText().toString());
            int number2 = Integer.parseInt(binding.number2Text.getText().toString());
            int result = number1 - number2;

            binding.resultText.setText("Result : " + result);

            sharedPreferences.edit().putInt("storedResult",result).apply();
        }
    }

    public void multipl(View view) {
        if (binding.number1Text.getText().toString().matches("") || binding.number2Text.getText().toString().matches("")) {
            binding.resultText.setText("Enter the Number !");
        } else {
            int number1 = Integer.parseInt(binding.number1Text.getText().toString());
            int number2 = Integer.parseInt(binding.number2Text.getText().toString());
            int result = number1 * number2;

            binding.resultText.setText("Result : " + result);

            sharedPreferences.edit().putInt("storedResult",result).apply();
        }
    }

    public void divide(View view) {
        if (binding.number1Text.getText().toString().matches("") || binding.number2Text.getText().toString().matches("")) {
            binding.resultText.setText("Enter the Number !");
        } else if (Integer.parseInt(binding.number2Text.getText().toString()) == 0) {
            binding.resultText.setText("Uncertain");
        } else {
            int number1 = Integer.parseInt(binding.number1Text.getText().toString());
            int number2 = Integer.parseInt(binding.number2Text.getText().toString());
            int result = number1 / number2;

            binding.resultText.setText("Result : " + result);

            sharedPreferences.edit().putInt("storedResult",result).apply();
        }
    }

    public void average(View view){

        alert = new AlertDialog.Builder(this);

        alert.setTitle("Go to Average Page");
        alert.setMessage("Are you sure ?");

        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (binding.number1Text.getText().toString().isEmpty() || binding.number2Text.getText().toString().isEmpty()) {

                    Toast.makeText(MainActivity.this, "Please Enter the Values !", Toast.LENGTH_SHORT).show();
                }

                else {

                    int number1 = Integer.parseInt(binding.number1Text.getText().toString());
                    int number2 = Integer.parseInt(binding.number2Text.getText().toString());

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                    Singleton singleton = Singleton.getInstance();
                    singleton.setSentNumber1(number1);
                    singleton.setSentNumber2(number2);

                    startActivity(intent);
                }
            }
        });

        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Not Go to Average Page", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }
}
