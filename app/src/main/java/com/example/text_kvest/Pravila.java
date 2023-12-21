package com.example.text_kvest;

import static com.example.text_kvest.MainActivity.num;

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

import com.example.text_kvest.databinding.ActivityPravilaBinding;
import com.example.text_kvest.databinding.ActivityStartBinding;

public class Pravila extends AppCompatActivity {
    final static int REQUESTCODE = 1234;

    private boolean isTextSwitched = false;
    private int currentState = 0;
    TextView textView;
    Handler handler;
    MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityPravilaBinding binding = ActivityPravilaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pravila.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODE);
                Intent intenttr = new Intent(Pravila.this, MainActivity.class);
                intenttr.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intenttr);
            }
        });
        View rootView = findViewById(android.R.id.content);
        textView = findViewById(R.id.TV1);
        myThread = new MyThread((String) binding.TV1.getText());
        myThread.start();
        handler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                char[] chars = (char[]) msg.obj;
                textView.setText(String.valueOf(chars));
            }
        };
        rootView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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
