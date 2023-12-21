package com.example.text_kvest;

import static com.example.text_kvest.MainActivity.num;
import static com.example.text_kvest.Pers.act;
import static com.example.text_kvest.Pers.rep;
import static com.example.text_kvest.Pers.ysp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.text_kvest.databinding.ActiviryPersBinding;
import com.example.text_kvest.databinding.ActivityFacelBinding;

public class Facel extends AppCompatActivity {
    final static int REQUESTCODEs = 1234;
    private boolean isTextSwitched = false;
    static String str = "";
    TextView textView;
    private int currentState = 0;
    Handler handler;
    MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityFacelBinding binding = ActivityFacelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        textView = findViewById(R.id.TV);
        binding.BT1.setVisibility(View.GONE);
        binding.BT2.setVisibility(View.GONE);
        myThread = new MyThread((String) binding.TV.getText());
        myThread.start();
        handler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                char[] chars = (char[]) msg.obj;
                textView.setText(String.valueOf(chars));
            }
        };
        View rootView = findViewById(android.R.id.content);
        rootView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myThread.sled();
                binding.BT1.setVisibility(View.VISIBLE);
                binding.BT2.setVisibility(View.VISIBLE);
                binding.TV.setText("И так, сегодня первое важное мероприятие, не хотелось бы на него опоздать.\nФакел - это собрание, в рамках которого нужно подписать документы, есть возможность познакомиться со своими одногруппниками, куратором.\n\nИ так, пойдём ли мы на Факел?");            }
        });
        binding.TVV.setText("Репутация "+rep+"\nАктивность "+act+"\nУспеваемость "+ysp);
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Facel.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODEs);
                intent = new Intent(Facel.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        binding.BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 3;
                Toast.makeText(Facel.this, "(Активность + 10)", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Facel.this, Pers.class);
                intent.putExtra("act", act);
                act += 10;
                binding.TVV.setText("Репутация "+rep+"\nАктивность "+act+"\nУспеваемость "+ysp);
                str = "Замечательно, давайте знакомиться с группой!\n\n___________________________________________\n\nИ вот вы уже в коридоре с толпой незнакомых ребят.\n" +
                        "К вам подходит одна девочка";
                intent = new Intent(Facel.this, Scenary.class);
                startActivityForResult(intent, REQUESTCODEs);
                intent = new Intent(Facel.this, Scenary.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        binding.BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 3;
                Toast.makeText(Facel.this, "(Репутация - 3)", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Facel.this, Pers.class);
                intent.putExtra("rep", rep);
                Toast.makeText(Facel.this, "(Активность - 30)", Toast.LENGTH_SHORT).show();
                intent.putExtra("act", act);
                rep -= 3;
                ysp -= 30;
                binding.TVV.setText("Репутация "+rep+"\nАктивность "+act+"\nУспеваемость "+ysp);
                str = "A вы думали репутация не может уйти в минус? Ошибаетесь, ваша беответственность к таким мероприятиям влечёт последствия";
                intent = new Intent(Facel.this, Scenary.class);
                startActivityForResult(intent, REQUESTCODEs);
                intent = new Intent(Facel.this, Scenary.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
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
