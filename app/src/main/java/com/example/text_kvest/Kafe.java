package com.example.text_kvest;

import static com.example.text_kvest.List.starosta;
import static com.example.text_kvest.MainActivity.num;
import static com.example.text_kvest.Pers.ysp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.text_kvest.databinding.ActivityCafeBinding;
import com.example.text_kvest.databinding.ActivityLectorBinding;

public class Kafe extends AppCompatActivity {
    Handler handler;
    TextView textView;
    MyThread myThread;
    static int currentState = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityCafeBinding binding = ActivityCafeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kafe.this, MainActivity.class);
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
        View rootView = findViewById(android.R.id.content);
        textView = findViewById(R.id.TV);
        myThread = new MyThread("Вы всей группой решили пойти в кафе, отметить неплохое написание экаменов.");
        myThread.start();
        currentState = 1;
        binding.IV5.setVisibility(View.GONE);
        binding.IV6.setVisibility(View.GONE);
        binding.IV3.setVisibility(View.GONE);
        binding.IV4.setVisibility(View.GONE);
        binding.IV2.setVisibility(View.GONE);
        binding.TV3.setVisibility(View.GONE);
        binding.TV1.setVisibility(View.GONE);
        rootView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myThread.sled();
                switch (currentState){
                    case 1:
                        binding.TV.setText("Вы всей группой решили пойти в кафе, отметить неплохое написание экаменов.");
                        break;
                    case 2:
                        textView = findViewById(R.id.TV1);
                        binding.TV.setVisibility(View.GONE);
                        binding.IV5.setVisibility(View.VISIBLE);
                        binding.TV1.setVisibility(View.VISIBLE);
                        myThread = new MyThread("-- Представляете, как мы будем скучать без информатики...");
                        myThread.start();
                        break;
                    case 3:
                        binding.TV1.setText("-- Представляете, как мы будем скучать без информатики...");
                        break;
                    case 4:
                        textView = findViewById(R.id.TV1);
                        binding.IV5.setVisibility(View.GONE);
                        binding.IV3.setVisibility(View.VISIBLE);
                        binding.TV1.setVisibility(View.VISIBLE);
                        myThread = new MyThread("-- Дааа, вот это предмет, вот это перегибы!");
                        myThread.start();
                        break;
                    case 5:
                        binding.TV1.setText("-- Дааа, вот это предмет, вот это перегибы!");
                        break;
                    case 6:
                        textView = findViewById(R.id.TV);
                        binding.TV.setVisibility(View.VISIBLE);
                        binding.IV3.setVisibility(View.GONE);
                        binding.TV1.setVisibility(View.GONE);
                        myThread = new MyThread("По группе пошли смешки.\nБыло приятно проводить вместе время.\nВаша группа сильно сдружилась за эти пол года.\nВы ни разу не пожалели о поступлении и сейчас, попивая неспешно кофе, наслаждались компанией новых знакомых\nПозади оставалось много приятных моментов, но вы знали, что впереди вас ждёт их ещё больше");
                        myThread.start();
                        break;
                    case 7:
                        binding.TV.setText("По группе пошли смешки.\nБыло приятно проводить вместе время.\nВаша группа сильно сдружилась за эти пол года.\nВы ни разу не пожалели о поступлении и сейчас, попивая неспешно кофе, наслаждались компанией новых знакомых\nПозади оставалось много приятных моментов, но вы знали, что впереди вас ждёт их ещё больше");
                        break;
                    case 8:
                        if (ysp > 50){
                            currentState++;
                        }else if (ysp > 30){
                            myThread = new MyThread("Хотя нет, мой хороший, у вас слишком ужасная успеваемость. Вы по сюжету не могли сдать всё с первого раза, вы шли ещё пару раз на пересдачу. вас лишили стипендии, теперь вы учитесь во втором семестре не так ражужно и роскошно, как раньше");
                            myThread.start();
                        }
                        else {
                            myThread = new MyThread("Слишком низкая успеваемость. Вас отчислили");
                            myThread.start();
                        }
                        break;
                    case 9:
                        if (ysp > 30){
                            binding.TV.setText("Хотя нет, мой хороший, у вас слишком ужасная успеваемость. Вы по сюжету не могли сдать всё с первого раза, вы шли ещё пару раз на пересдачу. вас лишили стипендии, теперь вы учитесь во втором семестре не так ражужно и роскошно, как раньше");
                        }
                        else {
                            binding.TV.setText("Слишком низкая успеваемость. Вас отчислили");
                        }
                        break;
                    case 10:
                        num = 9;
                        Intent intent = new Intent(Kafe.this, Final.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        break;
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