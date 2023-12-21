package com.example.text_kvest;

import static com.example.text_kvest.List.REQUESTCODE;
import static com.example.text_kvest.List.starosta;
import static com.example.text_kvest.Pers.act;
import static com.example.text_kvest.MainActivity.num;
import static com.example.text_kvest.Pers.rep;
import static com.example.text_kvest.Pers.ysp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.text_kvest.databinding.ActivityListBinding;
import com.example.text_kvest.databinding.ActivityMomentiBinding;

public class Momenti extends AppCompatActivity {
    Handler handler;
    TextView textView;
    MyThread myThread;
    static int currentState = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMomentiBinding binding = ActivityMomentiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Momenti.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODE);
                intent = new Intent(Momenti.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                char[] chars = (char[]) msg.obj;
                textView.setText(String.valueOf(chars));
            }
        };
        binding.IV.setVisibility(View.GONE);
        binding.IV1.setVisibility(View.GONE);
        binding.IV2.setVisibility(View.GONE);
        View rootView = findViewById(android.R.id.content);
        textView = findViewById(R.id.TV);
        myThread = new MyThread("Дни летели");
        myThread.start();
        currentState = 1;
        ImageView imageView = findViewById(R.id.IV);
        ImageView imageVieww = findViewById(R.id.IV1);
        ImageView imageVie = findViewById(R.id.IV2);

        // Устанавливаем изображение из ресурсов
        rootView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myThread.sled();
                switch (currentState){
                    case 1:
                        binding.TV.setText("Дни летели");
                        binding.IV.setVisibility(View.VISIBLE);
                        imageView.setImageResource(R.drawable.c1);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.c2);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.c3);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.c4);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.c5);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.c6);
                        break;
                    case 7:
                        imageView.setImageResource(R.drawable.c7);
                        break;
                    case 8:
                        imageView.setImageResource(R.drawable.c8);
                        break;
                    case 9:
                        imageView.setImageResource(R.drawable.c9);
                        break;
                    case 10:
                        imageView.setImageResource(R.drawable.c10);
                        break;
                    case 11:
                        imageView.setImageResource(R.drawable.c11);
                        break;
                    case 12:
                        imageView.setImageResource(R.drawable.c12);
                        break;
                    case 13:
                        imageView.setImageResource(R.drawable.c13);
                        break;
                    case 14:
                        imageView.setImageResource(R.drawable.c14);
                        break;
                    case 15:
                        imageView.setImageResource(R.drawable.c15);
                        break;
                    case 16:
                        imageView.setImageResource(R.drawable.c16);
                        break;
                    case 17:
                        imageView.setImageResource(R.drawable.c17);
                        break;
                    case 18:
                        imageView.setImageResource(R.drawable.c18);
                        break;
                    case 19:
                        imageView.setImageResource(R.drawable.c19);
                        break;
                    case 20:
                        imageView.setImageResource(R.drawable.c20);
                        break;
                    case 21:
                        imageView.setImageResource(R.drawable.c21);
                        break;
                    case 22:
                        imageView.setImageResource(R.drawable.c22);
                        break;
                    case 23:
                        imageView.setImageResource(R.drawable.c23);
                        break;
                    case 24:
                        imageView.setImageResource(R.drawable.c24);
                        break;
                    case 25:
                        imageView.setImageResource(R.drawable.c25);
                        break;
                    case 26:
                        imageView.setImageResource(R.drawable.c26);
                        break;
                    case 27:
                        imageView.setImageResource(R.drawable.c27);
                        break;
                    case 28:
                        imageView.setImageResource(R.drawable.c28);
                        break;
                    case 29:
                        imageView.setImageResource(R.drawable.c29);
                        break;
                    case 30:
                        imageView.setImageResource(R.drawable.c30);
                        break;
                    case 31:
                        imageView.setImageResource(R.drawable.c31);
                        break;
                    case 32:
                        binding.IV.setVisibility(View.GONE);
                        textView = findViewById(R.id.TV);
                        myThread = new MyThread("Bы учились");
                        myThread.start();
                        break;
                    case 33:
                        binding.TV.setText("Bы учились");
                        binding.IV1.setVisibility(View.VISIBLE);
                        imageVieww.setImageResource(R.drawable.vosp1);
                        break;
                    case 34:
                        imageVieww.setImageResource(R.drawable.vosp2);
                        break;
                    case 35:
                        imageVieww.setImageResource(R.drawable.vosp3);
                        break;
                    case 36:
                        imageVieww.setImageResource(R.drawable.vosp4);
                        break;
                    case 37:
                        imageVieww.setImageResource(R.drawable.vosp5);
                        break;
                    case 38:
                        textView = findViewById(R.id.TV);
                        binding.IV1.setVisibility(View.GONE);
                        if (starosta == 0){
                            myThread = new MyThread("Bы, как лидер, ходили на все старостаты, во время передавали информацию и вели за собой ребят. Вашу группу хвалили многие преподаватели, что не могло не радовать.");
                        }
                        else if (starosta == 1){
                            myThread = new MyThread("Соня, как лидер, ходил на все старостаты, во время передавал информацию и вёл за собой ребят. Вашу группу хвалили многие преподаватели, что не могло не радовать.");
                        }
                        else if (starosta == 2){
                            myThread = new MyThread("Федя, как лидер, ходил на все старостаты, во время передавал информацию и вёл за собой ребят. Вашу группу хвалили многие преподаватели, что не могло не радовать.");
                        }
                        else if (starosta == 3){
                            myThread = new MyThread("Даня, как лидер, ходил на все старостаты, во время передавал информацию и вёл за собой ребят. Вашу группу хвалили многие преподаватели, что не могло не радовать.");
                        }
                        myThread.start();
                        break;
                    case 39:
                        if (starosta == 0){
                            binding.TV.setText("Bы, как лидер, ходили на все старостаты, во время передавали информацию и вели за собой ребят. Вашу группу хвалили многие преподаватели, что не могло не радовать.");
                        }
                        else if (starosta == 1){
                            binding.TV.setText("Соня, как лидер, ходил на все старостаты, во время передавал информацию и вёл за собой ребят. Вашу группу хвалили многие преподаватели, что не могло не радовать.");
                        }
                        else if (starosta == 2){
                            binding.TV.setText("Федя, как лидер, ходил на все старостаты, во время передавал информацию и вёл за собой ребят. Вашу группу хвалили многие преподаватели, что не могло не радовать.");
                        }
                        else if (starosta == 3){
                            binding.TV.setText("Даня, как лидер, ходил на все старостаты, во время передавал информацию и вёл за собой ребят. Вашу группу хвалили многие преподаватели, что не могло не радовать.");
                        }
                        break;
                    case 40:
                        textView = findViewById(R.id.TV);
                        myThread = new MyThread("В студенческой рутине было много смешных и не очень моментов.");
                        myThread.start();
                        break;
                    case 41:
                        binding.TV.setText("В студенческой рутине было много смешных и не очень моментов.");
                        break;
                    case 42:
                        textView = findViewById(R.id.TV);
                        myThread = new MyThread("Одним из таких моментов была сессия. Было очень больно, она окончательно разрушила всю вашу хрупкую школьную натуру. Эта неделя помнится как вчера:");
                        myThread.start();
                        break;
                    case 43:
                        binding.TV.setText("Одним из таких моментов была сессия. Было очень больно, она окончательно разрушила всю вашу хрупкую школьную натуру. Эта неделя помнится как вчера:");
                        break;
                    case 44:
                        binding.BT.setVisibility(View.GONE);
                        binding.TT.setVisibility(View.GONE);
                        binding.TV.setVisibility(View.GONE);
                        binding.IV2.setVisibility(View.VISIBLE);
                        imageVie.setImageResource(R.drawable.st1);
                        break;
                    case 45:
                        imageVie.setImageResource(R.drawable.st2);
                        break;
                    case 46:
                        imageVie.setImageResource(R.drawable.st3);
                        break;
                    case 47:
                        imageVie.setImageResource(R.drawable.st4);
                        break;
                    case 48:
                        imageVie.setImageResource(R.drawable.st5);
                        break;
                    case 49:
                        imageVie.setImageResource(R.drawable.st6);
                        break;
                    case 50:
                        imageVie.setImageResource(R.drawable.lec1);
                        break;
                    case 51:
                        imageVie.setImageResource(R.drawable.lec2);
                        break;
                    case 52:
                        imageVie.setImageResource(R.drawable.lec3);
                        break;
                    case 53:
                        imageVie.setImageResource(R.drawable.lec4);
                        break;
                    case 54:
                        num = 7;
                        Intent intent = new Intent(Momenti.this, Lector.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                }
                currentState++;
            }
        });
    }

    class MyThread extends Thread {
        private String str;
        private char[] texttoview;

        public MyThread(String str) {
            this.str = str;
            this.texttoview = new char[str.length()];
        }

        @Override
        public void run() {
            super.run();
            char[] chars = str.toCharArray();
            String punct500 = ".!?;";
            String punct200 = ",:-";

            for (int i = 0; i < str.length(); i++) {
                if (Thread.interrupted()) {
                    return;
                }
                texttoview[i] = chars[i];

                Message msg = new Message();//отправить соо с этого потока на внутренний
                msg.obj = texttoview;
                handler.sendMessage(msg);

                if (punct500.contains(String.valueOf(chars[i]))) {
                    try {
                        sleep(250);
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                } else if (punct200.contains(String.valueOf(chars[i]))) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                } else {
                    try {
                        sleep(50);
                    } catch (InterruptedException e) {
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
