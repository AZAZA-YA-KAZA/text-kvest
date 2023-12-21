package com.example.text_kvest;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

import static com.example.text_kvest.Pers.act;
import static com.example.text_kvest.Pers.rep;
import static com.example.text_kvest.Pers.ysp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.text_kvest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    final static int REQUESTCODE = 1234;
    public static int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        /*MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.musicc);

        // Запуск воспроизведения музыки
        mediaPlayer.start();*/
        if (num == 0){
            binding.BT2.setVisibility(View.GONE);
        }
        else{binding.BT2.setVisibility(View.VISIBLE);}
        binding.BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                mediaPlayer.stop();*/
                Intent intent = new Intent(MainActivity.this, Pers.class);
                intent.putExtra("act", act);
                act = 0;
                intent.putExtra("rep", rep);
                rep = 5;
                intent.putExtra("ysp", ysp);
                ysp = 100;
                intent = new Intent(MainActivity.this, Start.class);
                intent.putExtra("num", num);
                num = 0;
                intent = new Intent(MainActivity.this, Start.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });
        binding.BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {/*
                mediaPlayer.stop();*/
                if (num == 1) {
                    Intent intent = new Intent(MainActivity.this, Start.class);
                    intent.putExtra("num", num);
                    intent = new Intent(MainActivity.this, Start.class);
                    startActivityForResult(intent, REQUESTCODE);
                }
                else{
                    Intent intentt = new Intent(MainActivity.this, Pers.class);
                    intentt.putExtra("num", num);
                    Intent intent = new Intent(MainActivity.this, Pers.class);
                    startActivityForResult(intent, REQUESTCODE);
                }
            }
        });
        binding.BT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {/*
                mediaPlayer.stop();*/
                finish();
            }
        });
        binding.BT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pravila.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODE && resultCode == RESULT_OK) {
            String str = data.getStringExtra("key2");
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }
}