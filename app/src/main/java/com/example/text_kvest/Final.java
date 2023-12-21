package com.example.text_kvest;

import static com.example.text_kvest.Pers.act;
import static com.example.text_kvest.Pers.rep;
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

import com.example.text_kvest.databinding.ActivityBumagaBinding;
import com.example.text_kvest.databinding.ActivityCafeBinding;
import com.example.text_kvest.databinding.ActivityFinalBinding;

public class Final extends AppCompatActivity {
    Handler handler;
    TextView textView;
    MyThread myThread;
    static int currentState = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityFinalBinding binding = ActivityFinalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Final.this, MainActivity.class);
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
        if (ysp <= 30) {
            myThread = new MyThread("Ну, вы стали дворником, кстати, у вас метла упала, поднимите, пока начальство не усидело");
            myThread.start();
            rootView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    myThread.sled();
                    binding.TV.setText("Ну, вы стали дворником, кстати, у вас метла упала, поднимите, пока начальство не усидело");
                    rootView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            myThread = new MyThread("СПАСИБО ЧТО ДОЧИТАЛИ ЭТОТ ЮМОРИСТИЧЕСКИЙ ПРОЕКТ ДО КОНЦА");
                            myThread.start();
                            rootView.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    myThread.sled();
                                    binding.TV.setText("СПАСИБО ЧТО ДОЧИТАЛИ ЭТОТ ЮМОРИСТИЧЕСКИЙ ПРОЕКТ ДО КОНЦА");
                                }
                            });
                        }
                    });
                }
            });
        }
        else {
            myThread = new MyThread("Поздравляю с окончанием этой сессии ☼");
            myThread.start();
            rootView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    myThread.sled();
                    binding.TV.setText("Поздравляю с окончанием этой сессии ☼");
                    rootView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            myThread = new MyThread("СПАСИБО ЧТО ДОЧИТАЛИ ЭТОТ ЮМОРИСТИЧЕСКИЙ ПРОЕКТ ДО КОНЦА");
                            myThread.start();
                            rootView.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    myThread.sled();
                                    binding.TV.setText("СПАСИБО ЧТО ДОЧИТАЛИ ЭТОТ ЮМОРИСТИЧЕСКИЙ ПРОЕКТ ДО КОНЦА");
                                }
                            });
                        }
                    });
                }
            });
        }
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
