package com.example.text_kvest;

import static com.example.text_kvest.Facel.str;
import static com.example.text_kvest.MainActivity.num;
import static com.example.text_kvest.Pers.act;
import static com.example.text_kvest.Pers.rep;
import static com.example.text_kvest.Pers.ysp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.text_kvest.databinding.ActivityFacelBinding;
import com.example.text_kvest.databinding.ActivityScenaryBinding;

import java.util.Objects;

public class Scenary extends AppCompatActivity {
    private boolean isTextSwitched = false;
    final static int REQUESTCODE = 1234;
    private int currentState = 0;
    static int otn = 0;
    TextView textView;
    Handler handler;
    MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityScenaryBinding binding = ActivityScenaryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.TVV.setText("Репутация " + rep + "\nАктивность " + act + "\nУспеваемость " + ysp);
        binding.IV1.setVisibility(View.GONE);
        binding.IV2.setVisibility(View.GONE);
        binding.TV3.setVisibility(View.GONE);
        binding.BT1.setVisibility(View.GONE);
        binding.BT2.setVisibility(View.GONE);
        binding.TV1.setVisibility(View.GONE);
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scenary.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODE);
                intent = new Intent(Scenary.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        Intent intent = new Intent(Scenary.this, Facel.class);
        intent.putExtra("str", str);
        textView = findViewById(R.id.TV);
        myThread = new MyThread(str);
        myThread.start();
        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                char[] chars = (char[]) msg.obj;
                textView.setText(String.valueOf(chars));
            }
        };
        if (str.charAt(0) == 'З') {
            View rootView = findViewById(android.R.id.content);
            rootView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    myThread.sled();
                    long currentTime = System.currentTimeMillis();
                    switch (currentState) {
                        case 0:
                            binding.TV.setText(str);
                            break;
                        case 1:
                            binding.TV.setVisibility(View.GONE);
                            binding.TV1.setVisibility(View.VISIBLE);
                            binding.IV1.setVisibility(View.VISIBLE);
                            textView = findViewById(R.id.TV1);
                            myThread = new MyThread((String) binding.TV1.getText());
                            myThread.start();
                            break;
                        case 2:
                            binding.BT1.setVisibility(View.VISIBLE);
                            binding.BT2.setVisibility(View.VISIBLE);
                            binding.TV1.setText("-- Привет, меня зовут Соня и, чтобы пропустить момент неловкого знакомства, я нашла большинство ребят в соц сетях, увы, тебя не обнаружила, так что решила с тобой познакомиться на месте.");
                            binding.BT1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    binding.TV1.setVisibility(View.GONE);
                                    binding.IV1.setVisibility(View.GONE);
                                    binding.BT1.setVisibility(View.GONE);
                                    binding.BT2.setVisibility(View.GONE);
                                    num = 4;
                                    textView = findViewById(R.id.TV3);
                                    myThread = new MyThread((String) binding.TV3.getText());
                                    myThread.start();
                                    binding.TV3.setVisibility(View.VISIBLE);
                                    binding.IV2.setVisibility(View.VISIBLE);
                                    Toast.makeText(Scenary.this, "(Активность + 10)", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Scenary.this, Pers.class);
                                    intent.putExtra("act", act);
                                    act += 10;
                                    binding.TVV.setText("Репутация " + rep + "\nАктивность " + act + "\nУспеваемость " + ysp);
                                    rootView.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                            myThread.sled();
                                            binding.TV3.setText("-- Приятно познакомиться, надеюсь, ты поможешь мне освоиться и поближе познакомиться с группой, - улыбнувшись, сказал я и предложил пойти в только что открывшийся кабинет");
                                            rootView.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View v) {
                                                    long currentTime = System.currentTimeMillis();
                                                    Intent intent = new Intent(Scenary.this, Bumaga.class);
                                                    startActivityForResult(intent, REQUESTCODE);
                                                    intent = new Intent(Scenary.this, Bumaga.class);
                                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                    startActivity(intent);
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                            binding.BT2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    binding.TV1.setVisibility(View.GONE);
                                    binding.IV1.setVisibility(View.GONE);
                                    binding.BT1.setVisibility(View.GONE);
                                    binding.BT2.setVisibility(View.GONE);
                                    binding.TV.setVisibility(View.VISIBLE);
                                    textView = findViewById(R.id.TV);
                                    myThread = new MyThread("Ну вы и грубиян!!\nНе обратив на неё абсолютно никакого внимания, я направился в только что открывшийся кабинет, оставив девушку позади себя\nУслышал, как она, хмыкнув и пробурчав что-то про невежливость, направилась за мной");
                                    myThread.start();
                                    rootView.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                            myThread.sled();
                                            binding.TV.setText("Ну вы и грубиян!!)\nНе обратив на неё абсолютно никакого внимания, я направился в только что открывшийся кабинет, оставив девушку позади себя\nУслышал, как она, хмыкнув и пробурчав что-то про невежливость, направилась за мной");
                                            Toast.makeText(Scenary.this, "(Активность - 10)", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(Scenary.this, Pers.class);
                                            intent.putExtra("act", act);
                                            act -= 10;
                                            otn = 1;
                                            binding.TVV.setText("Репутация " + rep + "\nАктивность " + act + "\nУспеваемость " + ysp);
                                            View rootView = findViewById(android.R.id.content);
                                            rootView.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View v) {
                                                    long currentTime = System.currentTimeMillis();
                                                    num = 4;
                                                    Intent intent = new Intent(Scenary.this, Bumaga.class);
                                                    startActivityForResult(intent, REQUESTCODE);
                                                    intent = new Intent(Scenary.this, Bumaga.class);
                                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                    startActivity(intent);
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                            break;
                    }
                    currentState++;
                }
            });
        }
        else{
            View rootView = findViewById(android.R.id.content);
            rootView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    myThread.sled();
                    binding.TV.setText("A вы думали репутация не может уйти в минус? Ошибаетесь, ваша беответственность к таким мероприятиям влечёт последствия");
                    rootView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            long currentTime = System.currentTimeMillis();
                            num = 5;
                            Intent intent = new Intent(Scenary.this, List.class);
                            startActivityForResult(intent, REQUESTCODE);
                            intent = new Intent(Scenary.this, List.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                    });
                }
            });
        }
    }
    class MyThread extends Thread {
        private String str;
        private char[] texttoview;
        public MyThread(String str){
            this.str = str;
            this.texttoview = new char[str.length()];
        }

        @Override
        public void run() {
            super.run();
            char[] chars = str.toCharArray();
            String punct500 = ".!?;";
            String punct200 = ",:-";

            for (int i = 0;i < str.length();i++){
                if (Thread.interrupted()) {
                    return;
                }
                texttoview[i] = chars[i];

                Message msg = new Message();//отправить соо с этого потока на внутренний
                msg.obj = texttoview;
                handler.sendMessage(msg);

                if(punct500.contains(String.valueOf(chars[i]))){
                    try {
                        sleep(250);
                    }catch (InterruptedException e){
                        throw new RuntimeException();
                    }
                }else if(punct200.contains(String.valueOf(chars[i]))){
                    try {
                        sleep(100);
                    }catch (InterruptedException e){
                        throw new RuntimeException();
                    }
                }else{
                    try {
                        sleep(50);
                    }catch (InterruptedException e){
                        throw new RuntimeException();
                    }
                }
            }
        }

        public void sled() {
            this.str = "";
            return;
        }
    }
}
