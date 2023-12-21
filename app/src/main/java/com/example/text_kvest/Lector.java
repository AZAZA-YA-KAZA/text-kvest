package com.example.text_kvest;

import static com.example.text_kvest.List.starosta;
import static com.example.text_kvest.MainActivity.num;

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

import com.example.text_kvest.databinding.ActivityLectorBinding;

public class Lector extends AppCompatActivity {
    Handler handler;
    TextView textView;
    MyThread myThread;
    static int currentState = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLectorBinding binding = ActivityLectorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lector.this, MainActivity.class);
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
        myThread = new MyThread("Рядом с кабинетом столпилась толпа. Это были толпы толп, которые столпляясь, увеличивали толпу в геометрической прогрессии, создавая ещё более напряжённую атмосферу, которая давила на толпу, она ещё больше волновалась, кучковалась, создавая ещё большую толпу.. Господи, вывел бы вас кто-то уже из этой рекурсии");
        myThread.start();
        currentState = 1;
        binding.IV5.setVisibility(View.GONE);
        binding.IV6.setVisibility(View.GONE);
        binding.IV.setVisibility(View.GONE);
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
                        binding.TV.setText("Рядом с кабинетом столпилась толпа. Это были толпы толп, которые столпляясь, увеличивали толпу в геометрической прогрессии, создавая ещё более напряжённую атмосферу, которая давила на толпу, она ещё больше волновалась, кучковалась, создавая ещё большую толпу.. Господи, вывел бы вас кто-то уже из этой рекурсии");
                        break;
                    case 2:
                        binding.TV.setVisibility(View.GONE);
                        binding.IV5.setVisibility(View.VISIBLE);
                        binding.TV1.setVisibility(View.VISIBLE);
                        textView = findViewById(R.id.TV1);
                        myThread = new MyThread("-- Ну, как готовы, ребята?");
                        myThread.start();
                        break;
                    case 3:
                        binding.TV1.setText("-- Ну, как готовы, ребята?");
                        break;
                    case 4:
                        binding.TV.setVisibility(View.VISIBLE);
                        binding.IV5.setVisibility(View.GONE);
                        binding.TV1.setVisibility(View.GONE);
                        textView = findViewById(R.id.TV);
                        myThread = new MyThread("Соня, улыбаясь нервной полукривой улыбкой, ответила");
                        myThread.start();
                        break;
                    case 5:
                        binding.TV.setText("Соня, улыбаясь нервной полукривой улыбкой, ответила");
                        break;
                    case 6:
                        textView = findViewById(R.id.TV1);
                        binding.TV.setVisibility(View.GONE);
                        binding.IV3.setVisibility(View.VISIBLE);
                        binding.TV1.setVisibility(View.VISIBLE);
                        if (starosta == 0){
                            myThread = new MyThread("-- У меня всё под контролем! Главное ничего не бояться наc готовил лучший из лучших.");
                        }
                        else if (starosta == 1){
                            myThread = new MyThread("-- У меня всё под контролем! Главное ничего не бояться. От лица того, кто вас всех готовил и наблюдал за вашей учёбой, скажу лишь одно - вы всё знаете и умеете.");
                        }
                        else if (starosta == 2){
                            myThread = new MyThread("-- У меня всё под контролем! Главное ничего не бояться. Федя, ты нас всех подготовил, мы готовы.");
                        }
                        else if (starosta == 3){
                            myThread = new MyThread("-- У меня всё под контролем! Главное ничего не бояться. Дима, ты нас всех подготовил, мы готовы.");
                        }
                        myThread.start();
                        break;
                    case 7:
                        if (starosta == 0){binding.TV1.setText("-- У меня всё под контролем! Главное ничего не бояться наc готовил лучший из лучших.");}
                        else if (starosta == 1){binding.TV1.setText("-- У меня всё под контролем! Главное ничего не бояться. От лица того, кто вас всех готовил и наблюдал за вашей учёбой, скажу лишь одно - вы всё знаете и умеете.");}
                        else if (starosta == 2){binding.TV1.setText("-- У меня всё под контролем! Главное ничего не бояться. Федя, ты нас всех подготовил, мы готовы.");}
                        else if (starosta == 3){binding.TV1.setText("-- У меня всё под контролем! Главное ничего не бояться. Дима, ты нас всех подготовил, мы готовы.");}
                        break;
                    case 8:
                        textView = findViewById(R.id.TV1);
                        binding.IV3.setVisibility(View.GONE);
                        binding.IV4.setVisibility(View.VISIBLE);
                        binding.TV1.setVisibility(View.VISIBLE);
                        myThread = new MyThread("-- Да, лекции были весьма содержательны");
                        myThread.start();
                        break;
                    case 9:
                        binding.TV1.setText("-- Да, лекции были весьма содержательны");
                        break;
                    case 10:
                        textView = findViewById(R.id.TV3);
                        binding.IV2.setVisibility(View.VISIBLE);
                        binding.TV3.setVisibility(View.VISIBLE);
                        binding.IV4.setVisibility(View.GONE);
                        binding.TV1.setVisibility(View.GONE);
                        myThread = new MyThread("-- Все вместе мы справимся. Поехали, время заходить на экзамен!");
                        myThread.start();
                        break;
                    case 11:
                        binding.TV3.setText("-- Все вместе мы справимся. Поехали, время заходить на экзамен!");
                        break;
                    case 12:
                        textView = findViewById(R.id.TV);
                        binding.TV.setVisibility(View.VISIBLE);
                        binding.IV2.setVisibility(View.GONE);
                        binding.TV3.setVisibility(View.GONE);
                        myThread = new MyThread("Сессия начинается, а преподаватель раздает билеты.");
                        myThread.start();
                        break;
                    case 13:
                        binding.TV.setText("Сессия начинается, а преподаватель раздает билеты.");
                        break;
                    case 14:
                        textView = findViewById(R.id.TV1);
                        binding.TV.setVisibility(View.GONE);
                        binding.IV6.setVisibility(View.VISIBLE);
                        binding.TV1.setVisibility(View.VISIBLE);
                        myThread = new MyThread("-- Удачи, студенты!");
                        myThread.start();
                        break;
                    case 15:
                        binding.TV1.setText("-- Удачи, студенты!");
                        break;
                    case 16:
                        textView = findViewById(R.id.TV);
                        binding.TV.setVisibility(View.VISIBLE);
                        binding.IV6.setVisibility(View.GONE);
                        binding.TV1.setVisibility(View.GONE);
                        myThread = new MyThread("Экзамен в разгаре. Некоторые уходили в истерике, глупо спаленые со шпорами, другие же активно строчили на листочках");
                        myThread.start();
                        break;
                    case 17:
                        binding.TV.setText("Экзамен в разгаре. Некоторые уходили в истерике, глупо спаленые со шпорами, другие же активно строчили на листочках");
                        break;
                    case 18:
                        binding.TV.setVisibility(View.GONE);
                        binding.IV.setVisibility(View.VISIBLE);
                        break;
                    case 19:
                        binding.IV.setVisibility(View.GONE);
                        textView = findViewById(R.id.TV);
                        binding.TV.setVisibility(View.VISIBLE);
                        myThread = new MyThread("И вот, студенты сдают билеты. Дима что-то обсуждает с Соней, активно жестикулируя руками. Федя подходит к ним, за ним к разговору подключаетесь и вы");
                        myThread.start();
                        break;
                    case 20:
                        binding.TV.setText("И вот, студенты сдают билеты. Дима что-то обсуждает с Соней, активно жестикулируя руками. Федя подходит к ним, за ним к разговору подключаетесь и вы");
                        break;
                    case 21:
                        textView = findViewById(R.id.TV1);
                        binding.TV.setVisibility(View.GONE);
                        binding.IV4.setVisibility(View.VISIBLE);
                        binding.TV1.setVisibility(View.VISIBLE);
                        myThread = new MyThread("-- Ну как? Справились со всем? Я вот волнуюсь..");
                        myThread.start();
                    case 22:
                        binding.TV1.setText("-- Ну как? Справились со всем? Я вот волнуюсь..");
                        break;
                    case 23:
                        textView = findViewById(R.id.TV3);
                        binding.TV3.setVisibility(View.VISIBLE);
                        binding.IV2.setVisibility(View.VISIBLE);
                        binding.IV4.setVisibility(View.GONE);
                        binding.TV1.setVisibility(View.GONE);
                        myThread = new MyThread("-- Ты ведь как всегда, Федя, всё выучил наизусть. Да не ссы, уже ничего не исправить. Да и я уверен, что ты блестяще ответил на все вопросы");
                        myThread.start();
                        break;
                    case 24:
                        binding.TV3.setText("-- Ты ведь как всегда, Федя, всё выучил наизусть. Да не ссы, уже ничего не исправить. Да и я уверен, что ты блестяще ответил на все вопросы");
                        break;
                    case 25:
                        textView = findViewById(R.id.TV1);
                        binding.TV3.setVisibility(View.GONE);
                        binding.IV2.setVisibility(View.GONE);
                        binding.IV4.setVisibility(View.VISIBLE);
                        binding.TV1.setVisibility(View.VISIBLE);
                        myThread = new MyThread("-- Просто стараюсь не оставлять ничего на случайность... Ладно, пошли перекусим чего-нибудь.");
                        myThread.start();
                        break;
                    case 26:
                        binding.TV1.setText("-- Просто стараюсь не оставлять ничего на случайность... Ладно, пошли перекусим чего-нибудь.");
                        break;
                    case 27:
                        num = 8;
                        Intent intent = new Intent(Lector.this, Kafe.class);
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