package com.example.text_kvest;

import static com.example.text_kvest.MainActivity.num;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.text_kvest.databinding.ActiviryPersBinding;
import com.example.text_kvest.databinding.ActivityStartBinding;

public class Pers extends AppCompatActivity {
    final static int REQUESTCODE = 1234;
    static int rep = 5;
    static int ysp = 100;
    static int act = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActiviryPersBinding binding = ActiviryPersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.BT1.setText("Репутация: "+rep);
        binding.BT2.setText("Успеваемость: "+ysp);
        binding.BT3.setText("Активность: "+act);
        binding.BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.BT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.BTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 2;
                Intent intent = new Intent(Pers.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODE);
                Intent intenttr = new Intent(Pers.this, MainActivity.class);
                intenttr.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intenttr);
            }
        });
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num < 3) {
                    Intent intent = new Intent(Pers.this, Facel.class);
                    startActivityForResult(intent, REQUESTCODE);
                    Intent intenttr = new Intent(Pers.this, Facel.class);
                    intenttr.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intenttr);
                }
                else if (num == 3) {
                    Intent intent = new Intent(Pers.this, Scenary.class);
                    startActivityForResult(intent, REQUESTCODE);
                    Intent intenttr = new Intent(Pers.this, Scenary.class);
                    intenttr.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intenttr);
                }
                else if (num == 4) {
                    Intent intent = new Intent(Pers.this, Bumaga.class);
                    startActivityForResult(intent, REQUESTCODE);
                    Intent intenttr = new Intent(Pers.this, Bumaga.class);
                    intenttr.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intenttr);
                }
                else if (num == 5) {
                    Intent intent = new Intent(Pers.this, List.class);
                    startActivityForResult(intent, REQUESTCODE);
                    Intent intenttr = new Intent(Pers.this, List.class);
                    intenttr.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intenttr);
                }
                else if (num == 6) {
                    Intent intent = new Intent(Pers.this, Momenti.class);
                    startActivityForResult(intent, REQUESTCODE);
                    Intent intenttr = new Intent(Pers.this, Momenti.class);
                    intenttr.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intenttr);
                }
                else if (num == 7) {
                    Intent intent = new Intent(Pers.this, Lector.class);
                    startActivityForResult(intent, REQUESTCODE);
                    Intent intenttr = new Intent(Pers.this, Lector.class);
                    intenttr.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intenttr);
                }
                else if (num == 8) {
                    Intent intent = new Intent(Pers.this, Kafe.class);
                    startActivityForResult(intent, REQUESTCODE);
                    Intent intenttr = new Intent(Pers.this, Kafe.class);
                    intenttr.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intenttr);
                }
                else if (num == 9) {
                    Intent intent = new Intent(Pers.this, Final.class);
                    startActivityForResult(intent, REQUESTCODE);
                    Intent intenttr = new Intent(Pers.this, Final.class);
                    intenttr.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intenttr);
                }
            }
        });
    }
}
