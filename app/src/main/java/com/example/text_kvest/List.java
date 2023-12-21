package com.example.text_kvest;

import static com.example.text_kvest.Bumaga.ac;
import static com.example.text_kvest.Bumaga.re;
import static com.example.text_kvest.Bumaga.ys;
import static com.example.text_kvest.MainActivity.num;
import static com.example.text_kvest.Pers.act;
import static com.example.text_kvest.Pers.rep;
import static com.example.text_kvest.Pers.ysp;
import static com.example.text_kvest.Scenary.otn;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.text_kvest.databinding.ActivityBumagaBinding;
import com.example.text_kvest.databinding.ActivityListBinding;

import java.util.Objects;

public class List extends AppCompatActivity {
    TextView textView;
    Handler handler;
    MyThread myThread;
    static String str = "";
    static int currentState = 0;
    static int ccurrentState = 0;
    static int cccurrentState = 0;
    static boolean f = false;
    static int star = -1;
    static int re = rep;
    static int ac = act;
    static int ys = ysp;
    static int starosta = 0;

    final static int REQUESTCODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityListBinding binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        re = rep;
        ys = ysp;
        ac = act;
        binding.TVV.setText("Репутация " + rep + "\nАктивность " + act + "\nУспеваемость " + ysp);
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODE);
                intent = new Intent(List.this, MainActivity.class);
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
        starosta = 0;
        binding.TV1.setVisibility(View.GONE);
        binding.TV3.setVisibility(View.GONE);
        binding.IV1.setVisibility(View.GONE);
        binding.IV3.setVisibility(View.GONE);
        binding.IV5.setVisibility(View.GONE);
        binding.IV4.setVisibility(View.GONE);
        binding.IV2.setVisibility(View.GONE);
        binding.BT1.setVisibility(View.GONE);
        binding.BT2.setVisibility(View.GONE);
        binding.BT11.setVisibility(View.GONE);
        binding.I1.setVisibility(View.GONE);
        binding.I2.setVisibility(View.GONE);
        binding.I3.setVisibility(View.GONE);
        binding.BT12.setVisibility(View.GONE);
        View rootView = findViewById(android.R.id.content);
        textView = findViewById(R.id.TV);
        myThread = new MyThread("Факел прошёл, началась учёба");
        myThread.start();
        ccurrentState = 0;
        rootView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myThread.sled();
                binding.BT11.setVisibility(View.VISIBLE);
                binding.BT12.setVisibility(View.VISIBLE);
                binding.TV.setText("Факел прошёл, началась учёба");
                binding.BT11.setText("Пропускать пару занятий");
                binding.BT12.setText("Ходить на всё");
                binding.BT11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        binding.BT11.setVisibility(View.GONE);
                        binding.BT12.setVisibility(View.GONE);
                        str = "И так, вы выбрали быть счаслитвы и ходить как карта ляжет, как Бог подскажет.\nЧто ж, за ваш выбор вас никто не осуждает, все вас понимают, но и вы поймите, за халтуру ваша успеваемость понизится на пару делений";
                        Sled();
                    }
                });
                binding.BT12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        binding.BT11.setVisibility(View.GONE);
                        binding.BT12.setVisibility(View.GONE);
                        str = "А вы оказывается трудяга-симпотяга, которая, вероятно, надеется получить автомат за ультра посещаемость? Безусловно, это приветствуется";
                        Sled();
                    }
                });
            }
        });
    }
    public void Sled() {
        ActivityListBinding binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.TV1.setVisibility(View.GONE);
        binding.IV1.setVisibility(View.GONE);
        binding.TV3.setVisibility(View.GONE);
        binding.IV3.setVisibility(View.GONE);
        binding.IV4.setVisibility(View.GONE);
        binding.I1.setVisibility(View.GONE);
        binding.I2.setVisibility(View.GONE);
        binding.I3.setVisibility(View.GONE);
        binding.IV2.setVisibility(View.GONE);
        binding.IV2.setVisibility(View.GONE);
        binding.IV5.setVisibility(View.GONE);
        binding.BT1.setVisibility(View.GONE);
        binding.BT2.setVisibility(View.GONE);
        binding.BT11.setVisibility(View.GONE);
        binding.BT12.setVisibility(View.GONE);
        textView = findViewById(R.id.TV);
        cccurrentState = 0;
        myThread = new MyThread(str);
        myThread.start();
        binding.TVV.setText("Репутация " + re + "\nАктивность " + ac + "\nУспеваемость " + ys);
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODE);
                intent = new Intent(List.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        View rootView = findViewById(android.R.id.content);
        rootView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myThread.sled();
                switch (cccurrentState) {
                    case 0:
                        binding.TV.setText(str);
                        if (Objects.equals(str, "А вы оказывается трудяга-симпотяга, которая, вероятно, надеется получить автомат за ультра посещаемость? Безусловно, это приветствуется")) {
                            ys += 20;
                            binding.TVV.setText("Репутация " + re + "\nАктивность " + ac + "\nУспеваемость " + ys);
                            Toast.makeText(List.this, "(Успеваемость + 20)", Toast.LENGTH_SHORT).show();
                        } else {
                            ys -= 40;
                            binding.TVV.setText("Репутация " + re + "\nАктивность " + ac + "\nУспеваемость " + ys);
                            Toast.makeText(List.this, "(Успеваемость - 40)", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 1:
                        textView = findViewById(R.id.TV);
                        myThread = new MyThread("В один из дней вас собрал куратор и сообщил одну важную новость для группы");
                        myThread.start();
                        break;
                    case 2:
                        binding.TV.setText("В один из дней вас собрал куратор и сообщил одну важную новость для группы");
                        break;
                    case 3:
                        binding.TV.setVisibility(View.GONE);
                        binding.TV1.setVisibility(View.VISIBLE);
                        binding.IV1.setVisibility(View.VISIBLE);
                        textView = findViewById(R.id.TV1);
                        myThread = new MyThread("-- И так, сейчас вам предстоит выбрать старосту группы. Понимаю, вы ещё мало знакомы, по этому я предлагаю выйти вперёд кандидатам и кратко объяснить, почему именно его должны выбрать на роль представителя группы.");
                        myThread.start();
                        break;
                    case 4:
                        binding.TV1.setText("-- И так, сейчас вам предстоит выбрать старосту группы. Понимаю, вы ещё мало знакомы, по этому я предлагаю выйти вперёд кандидатам и кратко объяснить, почему именно его должны выбрать на роль представителя группы.");
                        binding.BT1.setVisibility(View.VISIBLE);
                        binding.BT2.setVisibility(View.VISIBLE);
                        binding.BT1.setText("Остаться на месте");
                        binding.BT2.setText("Выйти");
                        binding.BT1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                binding.BT1.setVisibility(View.GONE);
                                binding.BT2.setVisibility(View.GONE);
                                binding.IV1.setVisibility(View.GONE);
                                binding.TV1.setVisibility(View.GONE);
                                binding.TV.setVisibility(View.VISIBLE);
                                textView = findViewById(R.id.TV);
                                myThread = new MyThread("~~Зачем париться, если можно не париться~~\nподумали вы и остались сидеть на месте в качестве человека, отдающего голос за одного из кандидатов");
                                star = 0;
                                myThread.start();

                                rootView.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        myThread.sled();
                                        binding.TV.setText("~~Зачем париться, если можно не париться~~\nподумали вы и остались сидеть на месте в качестве человека, отдающего голос за одного из кандидатов");
                                        rootView.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {Starosta();}});
                                    }});
                            }
                        });
                        binding.BT2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                binding.BT1.setVisibility(View.GONE);
                                binding.BT2.setVisibility(View.GONE);
                                binding.IV1.setVisibility(View.GONE);
                                binding.TV1.setVisibility(View.GONE);
                                binding.TV.setVisibility(View.VISIBLE);
                                textView = findViewById(R.id.TV);
                                myThread = new MyThread("~~Старосты же получают плюшки за свою работу? Тем более звучит очень престижно, чувствуется некая ответственность~~\nподумали вы и решительно вышли к Вите");
                                star = 0;
                                myThread.start();

                                rootView.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        myThread.sled();
                                        binding.TV.setText("~~Старосты же получают плюшки за свою работу? Тем более звучит очень престижно, чувствуется некая ответственность~~\nподумали вы и решительно вышли к Вите");
                                        rootView.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                if (rep > 2 && act >= 20 && ysp >= 80){
                                                    star = 1;
                                                    Starosta();}
                                                else{
                                                    star = 0;
                                                    String r = "Когда вы выходили, в кабинете поднялся шум.\nЗа вами было замечено слишком много косяков, из-за которых многие не хотели видеть вас в роли старосты.\nИз-за возмущений вы поспешили сесть на место.";
                                                    textView = findViewById(R.id.TV);
                                                    myThread = new MyThread(r);
                                                    myThread.start();
                                                    rootView.setOnClickListener(new View.OnClickListener() {
                                                        public void onClick(View v) {
                                                            myThread.sled();
                                                            binding.TV.setText(r);
                                                            rootView.setOnClickListener(new View.OnClickListener() {
                                                                public void onClick(View v) {Starosta();}});
                                                        }
                                                    });
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                        });
                        break;
                }
                cccurrentState++;
            }
        });
    }
    public void Starosta(){
        ActivityListBinding binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.TV1.setVisibility(View.GONE);
        binding.IV1.setVisibility(View.GONE);
        binding.IV2.setVisibility(View.GONE);
        binding.IV3.setVisibility(View.GONE);
        binding.I1.setVisibility(View.GONE);
        binding.I2.setVisibility(View.GONE);
        binding.I3.setVisibility(View.GONE);
        binding.IV4.setVisibility(View.GONE);
        binding.IV5.setVisibility(View.GONE);
        binding.IV2.setVisibility(View.GONE);
        binding.TV3.setVisibility(View.GONE);
        binding.BT1.setVisibility(View.GONE);
        binding.BT2.setVisibility(View.GONE);
        binding.BT11.setVisibility(View.GONE);
        binding.BT12.setVisibility(View.GONE);
        currentState = 0;
        textView = findViewById(R.id.TV);
        myThread = new MyThread("И так, начали выступать по очереди кандидаты.\nПервой вышла Соня");
        myThread.start();
        binding.TVV.setText("Репутация " + re + "\nАктивность " + ac + "\nУспеваемость " + ys);
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODE);
                intent = new Intent(List.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        View rootView = findViewById(android.R.id.content);
        rootView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myThread.sled();
                switch (ccurrentState) {
                    case 0:
                        binding.TV.setText("И так, начали выступать по очереди кандидаты.\nПервой вышла Соня");
                        break;
                    case 1:
                        binding.IV3.setVisibility(View.VISIBLE);
                        binding.TV.setVisibility(View.GONE);
                        binding.TV1.setVisibility(View.VISIBLE);
                        textView = findViewById(R.id.TV1);
                        myThread = new MyThread("-- Всем привет, меня уже многие знают, представлюсь ещё раз, я София, окончила школу с золотой медалью, была старостой в школе, не пропускаю занятия, буду выкладывать информацию сразу после её получения. Ко мне всегда можно обратиться за помощью, к заданию отношусь ответственно и выполняю его при любом раскладе");
                        myThread.start();
                        break;
                    case 2:
                        binding.TV1.setText("-- Всем привет, меня уже многие знают, представлюсь ещё раз, я София, окончила школу с золотой медалью, была старостой в школе, не пропускаю занятия, буду выкладывать информацию сразу после её получения. Ко мне всегда можно обратиться за помощью, к заданию отношусь ответственно и выполняю его при любом раскладе");
                        break;
                    case 3:
                        binding.IV3.setVisibility(View.GONE);
                        binding.TV.setVisibility(View.VISIBLE);
                        binding.TV1.setVisibility(View.GONE);
                        textView = findViewById(R.id.TV);
                        myThread = new MyThread("Дальше вышел мальчик, на которого вы раньше внимания не обращали");
                        myThread.start();
                        break;
                    case 4:
                        binding.TV.setText("Дальше вышел мальчик, на которого вы раньше внимания не обращали");
                        break;
                    case 5:
                        binding.TT.setVisibility(View.GONE);
                        binding.TV.setText("Внимание, ОООООЧЕНЬ много текста");
                        binding.IV3.setVisibility(View.GONE);
                        binding.IV4.setVisibility(View.VISIBLE);
                        binding.TV1.setVisibility(View.VISIBLE);
                        textView = findViewById(R.id.TV1);
                        myThread = new MyThread("-- Меня зовут Федя, и я хотел бы поделиться с вами своими идеями и видением того, как мы можем сделать нашу группной лучшей. Во-первых, я считаю, что важно создать дружественную и поддерживающую атмосферу в нашем классе. Мы все разные, но вместе мы можем сформировать сильную и сплоченную команду.");
                        myThread.start();
                        break;
                    case 6:
                        binding.TV1.setText("-- Меня зовут Федя, и я хотел бы поделиться с вами своими идеями и видением того, как мы можем сделать нашу группной лучшей. Во-первых, я считаю, что важно создать дружественную и поддерживающую атмосферу в нашем классе. Мы все разные, но вместе мы можем сформировать сильную и сплоченную команду.");
                        break;
                    case 7:
                        myThread = new MyThread("-- Я обещаю слушать вас и быть голосом каждого из вас во всех вопросах, связанных с университетом. Во-вторых, я полагаю, что академический успех - ключевой аспект нашей ВУЗовской жизни. Я буду стимулировать вас к достижению высоких результатов, организовывать учебные группы, где мы можем взаимно помогать друг другу и делиться знаниями.");
                        myThread.start();
                        break;
                    case 8:
                        binding.TV1.setText("-- Я обещаю слушать вас и быть голосом каждого из вас во всех вопросах, связанных с университетом. Во-вторых, я полагаю, что академический успех - ключевой аспект нашей ВУЗовской жизни. Я буду стимулировать вас к достижению высоких результатов, организовывать учебные группы, где мы можем взаимно помогать друг другу и делиться знаниями.");
                        break;
                    case 9:
                        myThread = new MyThread("-- Я также буду работать над установлением связи между нами и преподавателями, чтобы обеспечить оптимальную поддержку в наших учебных усилиях. Наконец, я обещаю быть доступным и открытым для всех вас. Я всегда буду слушать ваши предложения, замечания и вопросы. Вместе мы можем создать класс, в котором каждый будет чувствовать ");
                        myThread.start();
                        break;
                    case 10:
                        binding.TV1.setText("-- Я также буду работать над установлением связи между нами и преподавателями, чтобы обеспечить оптимальную поддержку в наших учебных усилиях. Наконец, я обещаю быть доступным и открытым для всех вас. Я всегда буду слушать ваши предложения, замечания и вопросы. Вместе мы можем создать класс, в котором каждый будет чувствовать ");
                        break;
                    case 11:
                        myThread = new MyThread("-- Cебя приветствованным и важным. Я верю, что мы, как класс, имеем огромный потенциал для достижения больших вещей. Давайте вместе работать над тем, чтобы сделать наш класс замечательным местом для обучения и развития. Если вы доверите мне должность старосты, я буду прилагать все усилия, чтобы оправдать ваше доверие.");
                        myThread.start();
                        break;
                    case 12:
                        binding.TV1.setText("-- Cебя приветствованным и важным. Я верю, что мы, как класс, имеем огромный потенциал для достижения больших вещей. Давайте вместе работать над тем, чтобы сделать наш класс замечательным местом для обучения и развития. Если вы доверите мне должность старосты, я буду прилагать все усилия, чтобы оправдать ваше доверие.");
                        break;
                    case 13:
                        myThread = new MyThread("-- Спасибо вам за ваше внимание, и я надеюсь на вашу поддержку!");
                        myThread.start();
                        break;
                    case 14:
                        binding.TV1.setText("-- Спасибо вам за ваше внимание, и я надеюсь на вашу поддержку!");
                        break;
                    case 15:
                        binding.IV4.setVisibility(View.GONE);
                        binding.TV.setVisibility(View.VISIBLE);
                        binding.TV1.setVisibility(View.GONE);
                        textView = findViewById(R.id.TV);
                        myThread = new MyThread("Ну и персонаж! Всю всою речь он выпалил практически на одном дыхании, но она была настолько быстрой и малопонятной, что создавалось ощущение, что нам лили воду в уши, но какую-то ледяную...");
                        myThread.start();
                        break;
                    case 16:
                        binding.TT.setVisibility(View.VISIBLE);
                        binding.TV.setText("Ну и персонаж! Всю всою речь он выпалил практически на одном дыхании, но она была настолько быстрой и малопонятной, что создавалось ощущение, что нам лили воду в уши, но какую-то ледяную...");
                        break;
                    case 17:
                        binding.TV.setVisibility(View.VISIBLE);
                        if (star == 0) {
                            textView = findViewById(R.id.TV);
                            binding.IV5.setVisibility(View.GONE);
                            binding.TV1.setVisibility(View.GONE);
                            myThread = new MyThread("И вот пришла очередь выступать последнего перед группой. Парень вышел вперёд, подмигнул какой-то девочке из группы, широко улыбнулся и заговорил:");
                            myThread.start();
                        }
                        else{
                            textView = findViewById(R.id.TV);
                            binding.IV2.setVisibility(View.GONE);
                            binding.TV3.setVisibility(View.GONE);
                            myThread = new MyThread("И вот пришла ваша очередь выступать перед группой. Вы вышли вперёд, подмигнули какой-то девочке из группы, широко улыбнулись и заговорили:");
                            myThread.start();
                        }
                        break;
                    case 18:
                        if (star == 0) {
                            binding.TV.setText("И вот пришла очередь выступать последнего перед группой. Парень вышел вперёд, подмигнул какой-то девочке из группы, широко улыбнулся и заговорил:");
                        }
                        else{
                            binding.TV.setText("И вот пришла ваша очередь выступать перед группой. Вы вышли вперёд, подмигнули какой-то девочке из группы, широко улыбнулись и заговорили:");
                        }
                        break;
                    case 19:
                        binding.TV.setVisibility(View.GONE);
                        if (star == 0) {
                            textView = findViewById(R.id.TV1);
                            binding.IV5.setVisibility(View.VISIBLE);
                            binding.TV1.setVisibility(View.VISIBLE);
                            myThread = new MyThread("-- Я Дима, скажу одно: выберете меня - не ошибётесь. Со мной всегда реально договориться, обладаю невероятной харизмой, не обделён искусством убеждения. На этом всё, спасибо за внимание!");
                            myThread.start();
                        }
                        else{
                            textView = findViewById(R.id.TV3);
                            binding.IV2.setVisibility(View.VISIBLE);
                            binding.TV3.setVisibility(View.VISIBLE);
                            myThread = new MyThread("-- Всем здрасьте, скажу одно: выберете меня - не ошибётесь. Со мной реально договориться, обладаю невероятной харизмой, не обделён искусством убеждения. На этом всё, спасибо за внимание!");
                            myThread.start();
                        }
                        break;
                    case 20:
                        if (star == 0) {
                            binding.TV1.setText("-- Я Дима, скажу одно: выберете меня - не ошибётесь. Со мной реально договориться, обладаю невероятной харизмой, не обделён искусством убеждения. На этом всё, спасибо за внимание!");
                        }
                        else{
                            binding.TV3.setText("-- Всем здрасьте, скажу одно: выберете меня - не ошибётесь. Со мной реально договориться, обладаю невероятной харизмой, не обделён искусством убеждения. На этом всё, спасибо за внимание!");
                        }
                        break;
                    case 21:
                        binding.TV.setVisibility(View.VISIBLE);
                        if (star == 0) {
                            textView = findViewById(R.id.TV);
                            binding.IV5.setVisibility(View.GONE);
                            binding.TV1.setVisibility(View.GONE);
                            myThread = new MyThread("Это было нескромное заявление, но в парне и вправду мыло что-то притягивающее, заставляющее верить ему.");
                            myThread.start();
                        }
                        else{
                            textView = findViewById(R.id.TV);
                            binding.IV2.setVisibility(View.GONE);
                            binding.TV3.setVisibility(View.GONE);
                            myThread = new MyThread("Это было нескромное заявление, но по реакции аудитории можно было понять, что моя речь произвела определённое впечатление.\nКак только я закончил, Соня решила сказать пару слов в мой адрес");
                            myThread.start();
                        }
                        break;
                    case 22:
                        if (star == 0) {
                            binding.TV.setText("Это было нескромное заявление, но в парне и вправду мыло что-то притягивающее, заставляющее верить ему.");
                            rootView.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    myThread.sled();
                                    switch (currentState) {
                                        case 0:
                                            myThread = new MyThread("Немного подождав, пока мы определимся с выбором, куратор сказал");
                                            myThread.start();
                                            break;
                                        case 1:
                                            binding.TV.setText("Немного подождав, пока мы выберем, куратор сказал");
                                            break;
                                        case 2:
                                            binding.IV1.setVisibility(View.VISIBLE);
                                            binding.TV.setVisibility(View.GONE);
                                            binding.TV1.setVisibility(View.VISIBLE);
                                            textView = findViewById(R.id.TV1);
                                            myThread = new MyThread("-- Ребята определились. Кандидаты, к стене!");
                                            myThread.start();
                                            break;
                                        case 3:
                                            binding.TV1.setText("-- Ребята определились. Кандидаты, к стене!");
                                            break;
                                        case 4:
                                            binding.IV1.setVisibility(View.GONE);
                                            binding.TV.setVisibility(View.VISIBLE);
                                            binding.TV1.setVisibility(View.GONE);
                                            textView = findViewById(R.id.TV);
                                            myThread = new MyThread("Выберите старосту");
                                            myThread.start();
                                            break;
                                        case 5:
                                            binding.TV.setText("Выберите старосту");
                                            binding.I1.setVisibility(View.VISIBLE);
                                            binding.I2.setVisibility(View.VISIBLE);
                                            binding.I3.setVisibility(View.VISIBLE);
                                            binding.I1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    starosta = 1;
                                                    itog();
                                                }
                                            });
                                            binding.I2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    starosta = 2;
                                                    itog();
                                                }
                                            });
                                            binding.I3.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    starosta = 3;
                                                    itog();
                                                }
                                            });
                                            currentState--;
                                            break;
                                    }
                                    currentState++;
                                }
                            });
                        }
                        else{
                            binding.TV.setText("Это было нескромное заявление, но по реакции аудитории можно было понять, что моя речь произвела определённое впечатление.\nКак только я закончил, Соня решила сказать пару слов в мой адрес");
                            View rootView = findViewById(android.R.id.content);
                            Intent intent = new Intent(List.this, Scenary.class);
                            intent.putExtra("otn", otn);
                            if (otn == 1) {
                                rootView.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        myThread.sled();
                                        switch (currentState) {
                                            case 0:
                                                binding.IV3.setVisibility(View.VISIBLE);
                                                binding.TV.setVisibility(View.GONE);
                                                binding.TV1.setVisibility(View.VISIBLE);
                                                textView = findViewById(R.id.TV1);
                                                myThread = new MyThread("-- Ну а пока вы ещё не выбрали, за кого голосовать, хочу напомнить о малоприятном поступке этого человека,** когда на моё приветствие на факеле он грубейшим образом меня проигнорировал! Староста так поступать не может!");
                                                myThread.start();
                                                break;
                                            case 1:
                                                binding.TV1.setText("-- Ну а пока вы ещё не выбрали, за кого голосовать, хочу напомнить о малоприятном поступке этого человека,** когда на моё приветствие на факеле он грубейшим образом меня проигнорировал! Староста так поступать не может!");
                                                break;
                                            case 2:
                                                binding.IV3.setVisibility(View.GONE);
                                                binding.TV.setVisibility(View.VISIBLE);
                                                binding.TV1.setVisibility(View.GONE);
                                                textView = findViewById(R.id.TV);
                                                myThread = new MyThread("Сама себя закапывает - подумали вы, глубоко вздохнули и развернулись к ней");
                                                myThread.start();
                                                break;
                                            case 3:
                                                binding.TV.setText("Сама себя закапывает - подумали вы, глубоко вздохнули и развернулись к ней");
                                                break;
                                            case 4:
                                                binding.IV2.setVisibility(View.VISIBLE);
                                                binding.TV.setVisibility(View.GONE);
                                                binding.TV3.setVisibility(View.VISIBLE);
                                                textView = findViewById(R.id.TV3);
                                                myThread = new MyThread(" -- Я был в глубоких мысленных размышлениях о дальнейшем развити нашего пути и мне было не до подпитки вашего эго.");
                                                myThread.start();
                                                break;
                                            case 5:
                                                binding.TV3.setText(" -- Я был в глубоких мысленных размышлениях о дальнейшем развити нашего пути и мне было не до подпитки вашего эго.");
                                                break;
                                            case 6:
                                                binding.IV3.setVisibility(View.VISIBLE);
                                                binding.TV1.setVisibility(View.VISIBLE);
                                                binding.IV2.setVisibility(View.GONE);
                                                binding.TV3.setVisibility(View.GONE);
                                                textView = findViewById(R.id.TV1);
                                                myThread = new MyThread("-- ЧТООО! Да как ты смеешь!");
                                                myThread.start();
                                                break;
                                            case 7:
                                                binding.TV1.setText("-- ЧТООО! Да как ты смеешь!");
                                                break;
                                            case 8:
                                                binding.IV3.setVisibility(View.GONE);
                                                binding.TV1.setVisibility(View.GONE);
                                                binding.IV2.setVisibility(View.VISIBLE);
                                                binding.TV3.setVisibility(View.VISIBLE);
                                                textView = findViewById(R.id.TV3);
                                                myThread = new MyThread("--Тихо, тихо, ты и так уже показала, что в стрессовых ситуациях держать себя в руках не способна. Как же ты хочешь стать старостой?");
                                                myThread.start();
                                                break;
                                            case 9:
                                                binding.TV3.setText("--Тихо, тихо, ты и так уже показала, что в стрессовых ситуациях держать себя в руках не способна. Как же ты хочешь стать старостой?");
                                                break;
                                            case 10:
                                                binding.IV2.setVisibility(View.GONE);
                                                binding.TV.setVisibility(View.VISIBLE);
                                                binding.TV3.setVisibility(View.GONE);
                                                textView = findViewById(R.id.TV);
                                                myThread = new MyThread("В аудитории зашептались и (О БОГИ, он ДОГАДАЛСЯ), к разговору присоединился куратор.");
                                                myThread.start();
                                                break;
                                            case 11:
                                                binding.TV.setText("В аудитории зашептались и (О БОГИ, он ДОГАДАЛСЯ), к разговору присоединился куратор.");
                                                break;
                                            case 12:
                                                binding.IV1.setVisibility(View.VISIBLE);
                                                binding.TV.setVisibility(View.GONE);
                                                binding.TV1.setVisibility(View.VISIBLE);
                                                textView = findViewById(R.id.TV1);
                                                myThread = new MyThread("-- Воу, ребят, достаточно. Думаю, ребята уже определились ");
                                                myThread.start();
                                                break;
                                            case 13:
                                                binding.TV1.setText("-- Воу, ребят, достаточно. Думаю, ребята уже определились ");
                                                break;
                                            case 14:
                                                binding.IV1.setVisibility(View.GONE);
                                                binding.TV.setVisibility(View.VISIBLE);
                                                binding.TV1.setVisibility(View.GONE);
                                                textView = findViewById(R.id.TV);
                                                myThread = new MyThread("Ещё раз агрессивно на вас зыркнув, Соня всиала рядом с вами\nВас развернули спиной е ребятам. Когда куратор пазывал имя, ребята полнимали руку, если хотели видеть этого человека в роли старосты\nЧерез некоторое время вас развернули.");
                                                myThread.start();
                                                break;
                                            case 15:
                                                binding.TV.setText("Ещё раз агрессивно на вас зыркнув, Соня всиала рядом с вами\nВас развернули спиной е ребятам. Когда куратор пазывал имя, ребята полнимали руку, если хотели видеть этого человека в роли старосты\nЧерез некоторое время вас развернули.");
                                                break;
                                            case 16:
                                                myThread = new MyThread("Все смотрели на вас, а куратор улыбаясь, подошёл и сказал");
                                                myThread.start();
                                                break;
                                            case 17:
                                                binding.TV.setText("Все смотрели на вас, а куратор улыбаясь, подошёл и сказал");
                                                break;
                                            case 18:
                                                binding.IV1.setVisibility(View.VISIBLE);
                                                binding.TV.setVisibility(View.GONE);
                                                binding.TV1.setVisibility(View.VISIBLE);
                                                textView = findViewById(R.id.TV1);
                                                myThread = new MyThread("-- Ну, наш новый староста, веди группу за собой)");
                                                myThread.start();
                                                break;
                                            case 19:
                                                binding.TV1.setText("-- Ну, наш новый староста, веди группу за собой)");
                                                break;
                                            case 20:
                                                binding.IV1.setVisibility(View.GONE);
                                                binding.TV.setVisibility(View.VISIBLE);
                                                binding.TV1.setVisibility(View.GONE);
                                                textView = findViewById(R.id.TV);
                                                myThread = new MyThread("Вам начали апплодировать. Некоторые ребята подходили и пожимали руки. За этот день вы со многими познакомились, удалось даже найти общий язык с букой-Соней. Она, конечно, оказалась той ещё букой, но староста должен дружить со всеми, по этому, стиснув зубы, вы не перебивали её словесный поток негодования в вашу сторону, а после сказали пару комплиментов в её адрес, что растопило её ледяной взгляд и позволило адекватно с ней общаться");
                                                myThread.start();
                                                break;
                                            case 21:
                                                binding.TV.setText("Вам начали апплодировать. Некоторые ребята подходили и пожимали руки. За этот день вы со многими познакомились, удалось даже найти общий язык с букой-Соней. Она, конечно, оказалась той ещё букой, но староста должен дружить со всеми, по этому, стиснув зубы, вы не перебивали её словесный поток негодования в вашу сторону, а после сказали пару комплиментов в её адрес, что растопило её ледяной взгляд и позволило адекватно с ней общаться");
                                                break;
                                            case 22:
                                                Intent intent = new Intent(List.this, Momenti.class);
                                                intent.putExtra("act", act);
                                                intent.putExtra("rep", rep);
                                                intent.putExtra("ysp", ysp);
                                                act = ac;
                                                rep = re;
                                                ysp = ys;
                                                num = 6;
                                                intent = new Intent(List.this, Momenti.class);
                                                startActivityForResult(intent, REQUESTCODE);
                                                intent = new Intent(List.this, Momenti.class);
                                                startActivityForResult(intent, REQUESTCODE);
                                                intent = new Intent(List.this, Momenti.class);
                                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                startActivity(intent);
                                                break;

                                        }
                                        currentState++;
                                    }
                                });
                            }
                            else{
                                rootView.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        myThread.sled();
                                        switch (currentState) {
                                            case 0:
                                                myThread = new MyThread("Немного подождав, пока группа определится с выбором, куратор сказал");
                                                myThread.start();
                                                break;
                                            case 1:
                                                binding.TV.setText("Немного подождав, пока группа определится с выбором, куратор сказал");
                                                break;
                                            case 2:
                                                binding.IV1.setVisibility(View.VISIBLE);
                                                binding.TV.setVisibility(View.GONE);
                                                binding.TV1.setVisibility(View.VISIBLE);
                                                textView = findViewById(R.id.TV1);
                                                myThread = new MyThread("-- Ребята определились с выбором. Кандидаты, к стене!");
                                                myThread.start();
                                                break;
                                            case 3:
                                                binding.TV1.setText("-- Ребята определились с выбором. Кандидаты, к стене!");
                                                break;
                                            case 4:
                                                binding.IV1.setVisibility(View.GONE);
                                                binding.TV.setVisibility(View.VISIBLE);
                                                binding.TV1.setVisibility(View.GONE);
                                                textView = findViewById(R.id.TV);
                                                myThread = new MyThread("Вы развернулись спиной к ребятам. Когда куратор пазывал имя, ребята полнимали руку, если хотели видеть этого человека в роли старосты\nЧерез некоторое время вас развернули.");
                                                myThread.start();
                                                break;
                                            case 5:
                                                binding.TV.setText("Вы развернулись спиной к ребятам. Когда куратор пазывал имя, ребята полнимали руку, если хотели видеть этого человека в роли старосты\nЧерез некоторое время вас развернули.");
                                                break;
                                            case 6:
                                                myThread = new MyThread("Все смотрели на вас, а куратор улыбаясь, подошёл и сказал");
                                                myThread.start();
                                                break;
                                            case 7:
                                                binding.TV.setText("Все смотрели на вас, а куратор улыбаясь, подошёл и сказал");
                                                break;
                                            case 8:
                                                binding.IV1.setVisibility(View.VISIBLE);
                                                binding.TV.setVisibility(View.GONE);
                                                binding.TV1.setVisibility(View.VISIBLE);
                                                textView = findViewById(R.id.TV1);
                                                myThread = new MyThread("-- Ну, наш новый староста, веди группу за собой)");
                                                myThread.start();
                                                break;
                                            case 9:
                                                binding.TV1.setText("-- Ну, наш новый староста, веди группу за собой)");
                                                break;
                                            case 10:
                                                binding.IV1.setVisibility(View.GONE);
                                                binding.TV.setVisibility(View.VISIBLE);
                                                binding.TV1.setVisibility(View.GONE);
                                                textView = findViewById(R.id.TV);
                                                myThread = new MyThread("Вам начали аплодировать. Некоторые ребята подходили и пожимали руки. За этот день вы со многими познакомились, удалось даже найти общий язык с букой-Соней. Она, конечно, оказалась той ещё букой, но староста должен дружить со всеми, по этому, стиснув зубы, вы не перебивали её словестный поток негодования в вашу сторону, а после сказали пару комплиментов в её адрес, что растопило её ледяной взгляд и позволило адекватно с ней общаться");
                                                myThread.start();
                                                break;
                                            case 11:
                                                binding.TV.setText("Вам начали аплодировать. Некоторые ребята подходили и пожимали руки. За этот день вы со многими познакомились, удалось даже найти общий язык с букой-Соней. Она, конечно, оказалась той ещё букой, но староста должен дружить со всеми, по этому, стиснув зубы, вы не перебивали её словестный поток негодования в вашу сторону, а после сказали пару комплиментов в её адрес, что растопило её ледяной взгляд и позволило адекватно с ней общаться");
                                                break;
                                            case 12:
                                                Intent intent = new Intent(List.this, Momenti.class);
                                                intent.putExtra("act", act);
                                                intent.putExtra("rep", rep);
                                                intent.putExtra("ysp", ysp);
                                                act = ac;
                                                rep = re;
                                                ysp = ys;
                                                num = 6;
                                                intent = new Intent(List.this, Momenti.class);
                                                startActivityForResult(intent, REQUESTCODE);
                                                intent = new Intent(List.this, Momenti.class);
                                                startActivityForResult(intent, REQUESTCODE);
                                                intent = new Intent(List.this, Momenti.class);
                                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                startActivity(intent);
                                                break;
                                        }
                                        currentState++;
                                    }
                                });
                            }
                        }
                        break;
                }
                ccurrentState++;
            }
        });
    }

    public void itog() {
        ActivityListBinding binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.TV1.setVisibility(View.GONE);
        binding.IV1.setVisibility(View.GONE);
        binding.IV2.setVisibility(View.GONE);
        binding.IV3.setVisibility(View.GONE);
        binding.I1.setVisibility(View.GONE);
        binding.I2.setVisibility(View.GONE);
        binding.I3.setVisibility(View.GONE);
        binding.IV4.setVisibility(View.GONE);
        binding.IV5.setVisibility(View.GONE);
        binding.IV2.setVisibility(View.GONE);
        binding.TV3.setVisibility(View.GONE);
        binding.BT1.setVisibility(View.GONE);
        binding.BT2.setVisibility(View.GONE);
        binding.BT11.setVisibility(View.GONE);
        binding.BT12.setVisibility(View.GONE);
        currentState = 0;
        textView = findViewById(R.id.TV);
        myThread = new MyThread("И так, симпатии оказались симпатичнее к выступающему под номером " + starosta);
        myThread.start();
        binding.TVV.setText("Репутация " + re + "\nАктивность " + ac + "\nУспеваемость " + ys);
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODE);
                intent = new Intent(List.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        View rootView = findViewById(android.R.id.content);
        rootView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myThread.sled();
                switch (currentState) {
                    case 0:
                        binding.TV.setText("И так, симпатии оказались симпатичнее к выступающему под номером " + starosta);
                        break;
                    case 1:
                        textView = findViewById(R.id.TV);
                        myThread = new MyThread("Куратор улыбаясь, подошёл к кандидату, набравшему наибольшее количество голосов, и сказал");
                        myThread.start();
                        break;
                    case 2:
                        binding.TV.setText("Куратор улыбаясь, подошёл к кандидату, набравшему наибольшее количество голосов, и сказал");
                        break;
                    case 3:
                        binding.IV1.setVisibility(View.VISIBLE);
                        binding.TV.setVisibility(View.GONE);
                        binding.TV1.setVisibility(View.VISIBLE);
                        textView = findViewById(R.id.TV1);
                        myThread = new MyThread("-- Ну, наш новый староста, веди группу за собой)");
                        myThread.start();
                        break;
                    case 4:
                        binding.TV1.setText("-- Ну, наш новый староста, веди группу за собой)");
                        break;
                    case 5:
                        binding.IV1.setVisibility(View.GONE);
                        binding.TV.setVisibility(View.VISIBLE);
                        binding.TV1.setVisibility(View.GONE);
                        textView = findViewById(R.id.TV);
                        myThread = new MyThread("Ему начали аплодировать. Некоторые ребята подходили и пожимали руки. Этот день принёс много впечатлений. Было приятно, что старостой  оказался именно тот человек, за которого и вы голосовали, по этому оставалось лишь надеяться, что он вас не разочарует.");
                        myThread.start();
                        break;
                    case 6:
                        binding.TV.setText("Ему начали аплодировать. Некоторые ребята подходили и пожимали руки.  Было приятно, что старостой  оказался именно тот человек, за которого и вы голосовали, по этому оставалось лишь надеяться, что он вас не разочарует.");
                        break;
                    case 7:
                        Intent intent = new Intent(List.this, Momenti.class);
                        intent.putExtra("act", act);
                        intent.putExtra("rep", rep);
                        intent.putExtra("ysp", ysp);
                        act = ac;
                        rep = re;
                        ysp = ys;
                        num = 6;
                        intent = new Intent(List.this, Momenti.class);
                        startActivityForResult(intent, REQUESTCODE);
                        intent = new Intent(List.this, Momenti.class);
                        startActivityForResult(intent, REQUESTCODE);
                        intent = new Intent(List.this, Momenti.class);
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