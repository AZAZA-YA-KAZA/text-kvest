package com.example.text_kvest;

import static com.example.text_kvest.Facel.str;
import static com.example.text_kvest.MainActivity.num;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.text_kvest.databinding.ActivityBumagaBinding;
import com.example.text_kvest.databinding.ActivityScenaryBinding;

public class Bumaga extends AppCompatActivity {
    TextView textView;
    Handler handler;
    MyThread myThread;
    final static int REQUESTCODE = 1234;
    private boolean isTextSwitched = false;
    private int currentState = 0;
    private int ccurrentState = 0;
    private int cccurrentState = 0;
    private int ccccurrentState = 0;
    private int cccccurrentState = 0;
    static int re = rep;
    static int ac = act;
    static int ys = ysp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        re = rep;
        ys = ysp;
        ac = act;
        ActivityBumagaBinding binding = ActivityBumagaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.TVV.setText("Репутация "+rep+"\nАктивность "+act+"\nУспеваемость "+ysp);
        binding.IV1.setVisibility(View.GONE);
        binding.IV3.setVisibility(View.GONE);
        binding.IV2.setVisibility(View.GONE);
        binding.TV3.setVisibility(View.GONE);
        binding.BT11.setVisibility(View.GONE);
        binding.BT12.setVisibility(View.GONE);
        binding.BT1.setVisibility(View.GONE);
        binding.BT2.setVisibility(View.GONE);
        binding.TV1.setVisibility(View.GONE);
        binding.TV.setVisibility(View.VISIBLE);
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bumaga.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODE);
                intent = new Intent(Bumaga.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        View rootView = findViewById(android.R.id.content);
        textView = findViewById(R.id.TV);
        myThread = new MyThread("В кабинет зашло много ребят, все одни были примерно вашего возраста.\n" +
                "Последним пришёл куратор-студент и прикрыл дверь");
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
                myThread.sled();
                long currentTime = System.currentTimeMillis();
                switch (currentState) {
                    case 0:
                        binding.TV.setText("В кабинет зашло много ребят, все одни были примерно вашего возраста.\nПоследним пришёл куратор-студент и прикрыл дверь");
                        break;
                    case 1:
                        textView = findViewById(R.id.TV1);
                        myThread = new MyThread("-- Всем привет, я Виталя, ваш куратор, по всем вопросам можете смело обращаться ко мне. Друг друга вы видете впервые, поэтому моя задача вас хоть немного сегодня сплотить.");
                        myThread.start();
                        binding.TV.setVisibility(View.GONE);
                        binding.TV1.setVisibility(View.VISIBLE);
                        binding.IV1.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        binding.TV1.setText("-- Всем привет, я Виталя, ваш куратор, по всем вопросам можете смело обращаться ко мне. Друг друга вы видете впервые, поэтому моя задача вас хоть немного сегодня сплотить.");
                        break;
                    case 3:
                        textView = findViewById(R.id.TV1);
                        myThread = new MyThread("-- Ну, коллектив сплощают трудности, так что нанесу вам сразу сокрушительный удар - заполняем бумажкиии.");
                        myThread.start();
                        break;
                    case 4:
                        binding.TV1.setText("-- Ну, коллектив сплощают трудности, так что нанесу вам сразу сокрушительный удар - заполняем бумажкиии.");
                        break;
                    case 5:
                        textView = findViewById(R.id.TV);
                        myThread = new MyThread("По аудитории прошёлся обречённый вздох - никто не был явным мазохистом, так что идея скурпулёно сидеть и подписывать документы не вдохновила ни одно живое существо, находящееся в помещении.\n" +
                                "\n" +
                                "Хах, будто у нас был выбор!\n" +
                                "Хотяяяяя...");
                        myThread.start();
                        binding.IV1.setVisibility(View.GONE);
                        binding.TV1.setVisibility(View.GONE);
                        binding.TV.setVisibility(View.VISIBLE);
                        break;
                    case 6:
                        binding.TV.setText("По аудитории прошёлся обречённый вздох - никто не был явным мазохистом, так что идея скурпулёно сидеть и подписывать документы не вдохновила ни одно живое существо, находящееся в помещении.\nХах, будто у нас был выбор!\nХотяяяяя...");
                        binding.BT11.setVisibility(View.VISIBLE);
                        binding.BT12.setVisibility(View.VISIBLE);
                        binding.BT11.setText("Взбунтоваться");
                        binding.BT12.setText("Заполнить бумаги");
                        binding.BT11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                binding.BT11.setVisibility(View.GONE);
                                binding.BT12.setVisibility(View.GONE);
                                binding.TV.setVisibility(View.GONE);
                                binding.TV3.setVisibility(View.VISIBLE);
                                binding.IV2.setVisibility(View.VISIBLE);
                                Toast.makeText(Bumaga.this, "(Репутация - 2)", Toast.LENGTH_SHORT).show();
                                Toast.makeText(Bumaga.this, "(Успеваемость - 20)", Toast.LENGTH_SHORT).show();
                                ys -= 20;
                                re -= 2;
                                binding.TVV.setText("Репутация " + re + "\nАктивность " + ac + "\nУспеваемость " + ys);
                                Intent intent = new Intent(Bumaga.this, Pers.class);
                                textView = findViewById(R.id.TV3);
                                myThread = new MyThread("-- Я пришёл в свой выходной сюда не чтобы корячиться над бумажками!");
                                myThread.start();
                                View rootVieww = findViewById(android.R.id.content);
                                rootVieww.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        myThread.sled();
                                        switch (ccurrentState) {
                                            case 0:
                                                binding.TV3.setText("-- Я пришёл в свой выходной сюда не чтобы корячиться над бумажками!");
                                                break;
                                            case 1:
                                                binding.TV.setVisibility(View.VISIBLE);
                                                binding.TV3.setVisibility(View.GONE);
                                                binding.IV2.setVisibility(View.GONE);
                                                textView = findViewById(R.id.TV);
                                                myThread = new MyThread("Все ребята с удивлением начасли оглядываться, ища чудака, но вас это не волновало.\n" +
                                                        "Куратор, выразительно выгнув бровь, встал из-за стола");
                                                myThread.start();
                                                break;
                                            case 2:
                                                binding.TV.setText("Все ребята с удивлением начасли оглядываться, ища чудака, но вас это не волновало.\nКуратор, выразительно выгнув бровь, встал из-за стола");
                                                break;
                                            case 3:
                                                binding.TV.setVisibility(View.GONE);
                                                binding.TV1.setVisibility(View.VISIBLE);
                                                binding.IV1.setVisibility(View.VISIBLE);
                                                textView = findViewById(R.id.TV1);
                                                myThread = new MyThread("-- Слушай, ты вроде не ребёнок, ты уже студент, пора входить во взрослую жизнь. Всё, мамы и папы рядом нету, в университете клоуны не бегают, тут преподают люди, добившиеся невероятных высот.");
                                                myThread.start();
                                                break;
                                            case 4:
                                                binding.TV1.setText("-- Слушай, ты вроде не ребёнок, ты уже студент, пора входить во взрослую жизнь. Всё, мамы и папы рядом нету, в университете клоуны не бегают, тут преподают люди, добившиеся невероятных высот.");
                                                break;
                                            case 5:
                                                textView = findViewById(R.id.TV1);
                                                myThread = new MyThread("-- Как же ты сюда поступил с такой позицией? Не хочешь заполнять документы? Ты не очень умный персонаж? Как же ты собрался без них учиться?");
                                                myThread.start();
                                                break;
                                            case 6:
                                                binding.TV1.setText("-- Как же ты сюда поступил с такой позицией? Не хочешь заполнять документы? Ты не очень умный персонаж? Как же ты собрался без них учиться?");
                                                break;
                                            case 7:
                                                textView = findViewById(R.id.TV1);
                                                myThread = new MyThread("-- Не дури, бери листочек и заполняй. В противном случае информация о тебе без твоего бумажного согласия просто не будет обработана и тебя исключат.");
                                                myThread.start();
                                                break;
                                            case 8:
                                                binding.TV1.setText("-- Не дури, бери листочек и заполняй. В противном случае информация о тебе без твоего бумажного согласия просто не будет обработана и тебя исключат.");
                                                break;
                                            case 9:
                                                textView = findViewById(R.id.TV1);
                                                myThread = new MyThread("Получается, ты тут довыпендривался, а кого-то, жаждущего получить знания из-за тебя не взяли.");
                                                myThread.start();
                                                break;
                                            case 10:
                                                binding.TV1.setText("Получается, ты тут довыпендривался, а кого-то, жаждущего получить знания из-за тебя не взяли.");
                                                binding.BT1.setVisibility(View.VISIBLE);
                                                binding.BT2.setVisibility(View.VISIBLE);
                                                binding.BT1.setText("Взбунтоваться");
                                                binding.BT2.setText("Заполнить бумаги");
                                                binding.BT1.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        binding.BT1.setVisibility(View.GONE);
                                                        binding.BT2.setVisibility(View.GONE);
                                                        binding.TV1.setVisibility(View.GONE);
                                                        binding.IV1.setVisibility(View.GONE);
                                                        binding.TV3.setVisibility(View.VISIBLE);
                                                        binding.IV2.setVisibility(View.VISIBLE);
                                                        textView = findViewById(R.id.TV3);
                                                        myThread = new MyThread("-- Ваши бумаги-фуфло полное, не хочу");
                                                        myThread.start();
                                                        View rootViewww = findViewById(android.R.id.content);
                                                        rootViewww.setOnClickListener(new View.OnClickListener() {
                                                            public void onClick(View v) {
                                                                myThread.sled();
                                                                 switch (cccurrentState) {
                                                                     case 0:
                                                                         Toast.makeText(Bumaga.this, "(Репутация - 1)", Toast.LENGTH_SHORT).show();
                                                                         re--;
                                                                         Toast.makeText(Bumaga.this, "(Активность - 20)", Toast.LENGTH_SHORT).show();
                                                                         ac-=20;
                                                                         Toast.makeText(Bumaga.this, "(Успеваемость - 20)", Toast.LENGTH_SHORT).show();
                                                                         ys-=20;
                                                                         binding.TVV.setText("Репутация " + re + "\nАктивность " + ac + "\nУспеваемость " + ys);
                                                                         binding.TV3.setText("-- Ваши бумаги-фуфло полное, не хочу");
                                                                         break;
                                                                     case 1:
                                                                         binding.TV.setVisibility(View.VISIBLE);
                                                                         binding.TV3.setVisibility(View.GONE);
                                                                         binding.IV2.setVisibility(View.GONE);
                                                                         textView = findViewById(R.id.TV);
                                                                         myThread = new MyThread("Вы вышли из кабинета и пошли в сторону выхода.\nПо пути, ненадолго задумавшись о правильности совершённого поступка, вы столкнулись с молодым человеком, лет 26-и.Если бы в нашем мире не существовало понятия физики и гравитации, то всё могло обойтись, но суровая реальность оказалась слишком жестока по отношению к вам, и вы упали на пол. Машинально хватаясь за воздух, вы зацепились за чудом устоявшего на ногах молодого человека, потянув его на пол за собой.");
                                                                         myThread.start();
                                                                         break;
                                                                     case 2:
                                                                         binding.TV.setText("Вы вышли из кабинета и пошли в сторону выхода.\nПо пути, ненадолго задумавшись о правильности совершённого поступка, вы столкнулись с молодым человеком, лет 26-и.\nЕсли бы в нашем мире не существовало понятия физики и гравитации, то всё могло обойтись, но суровая реальность оказалась слишком жестока по отношению к вам, и вы упали на пол. Машинально хватаясь за воздух, вы зацепились за чудом устоявшего на ногах молодого человека, потянув его на пол за собой.");
                                                                         break;
                                                                     case 3:
                                                                         binding.TV.setVisibility(View.GONE);
                                                                         binding.TV3.setVisibility(View.VISIBLE);
                                                                         binding.IV2.setVisibility(View.VISIBLE);
                                                                         textView = findViewById(R.id.TV3);
                                                                         myThread = new MyThread("-- Я РАЗОЧАРОВАН, КАКАЯ НЕПРИЯТНОСТЬ!");
                                                                         myThread.start();
                                                                         break;
                                                                     case 4:
                                                                         binding.TV3.setText("-- Я РАЗОЧАРОВАН, КАКАЯ НЕПРИЯТНОСТЬ!");
                                                                         break;
                                                                     case 5:
                                                                         binding.TV.setVisibility(View.VISIBLE);
                                                                         binding.TV3.setVisibility(View.GONE);
                                                                         binding.IV2.setVisibility(View.GONE);
                                                                         textView = findViewById(R.id.TV);
                                                                         myThread = new MyThread("Это неприличное слово вырвалось случайно, когда оппонент всем своим весом приземлился прямо на вас.\n" +
                                                                                 "Когда вы оба поднялись, молодой человек хмуро на вас посмортел");
                                                                         myThread.start();
                                                                         break;
                                                                     case 6:
                                                                         binding.TV.setText("Это неприличное слово вырвалось случайно, когда оппонент всем своим весом приземлился прямо на вас.\nКогда вы оба поднялись, молодой человек хмуро на вас посмортел");
                                                                         break;
                                                                     case 7:
                                                                         binding.TV.setVisibility(View.GONE);
                                                                         binding.TV1.setVisibility(View.VISIBLE);
                                                                         binding.IV3.setVisibility(View.VISIBLE);
                                                                         textView = findViewById(R.id.TV1);
                                                                         myThread = new MyThread("-- У нас материться не принято в университете. Тут учатся и преподают культурные люди.");
                                                                         myThread.start();
                                                                         break;
                                                                     case 8:
                                                                         binding.TV1.setText("-- У нас материться не принято в университете. Тут учатся и преподают культурные люди.");
                                                                         break;
                                                                     case 9:
                                                                         binding.TV3.setVisibility(View.VISIBLE);
                                                                         binding.IV2.setVisibility(View.VISIBLE);
                                                                         binding.TV1.setVisibility(View.GONE);
                                                                         binding.IV3.setVisibility(View.GONE);
                                                                         textView = findViewById(R.id.TV3);
                                                                         myThread = new MyThread("-- Простите..");
                                                                         myThread.start();
                                                                         break;
                                                                     case 10:
                                                                         binding.TV3.setText("-- Простите..");
                                                                         break;
                                                                     case 11:
                                                                         binding.TV3.setVisibility(View.GONE);
                                                                         binding.IV2.setVisibility(View.GONE);
                                                                         binding.TV1.setVisibility(View.VISIBLE);
                                                                         binding.IV3.setVisibility(View.VISIBLE);
                                                                         textView = findViewById(R.id.TV1);
                                                                         myThread = new MyThread("-- Группа?");
                                                                         myThread.start();
                                                                         break;
                                                                     case 12:
                                                                         binding.TV1.setText("-- Группа?");
                                                                         break;
                                                                     case 13:
                                                                         binding.TV3.setVisibility(View.VISIBLE);
                                                                         binding.IV2.setVisibility(View.VISIBLE);
                                                                         binding.TV1.setVisibility(View.GONE);
                                                                         binding.IV3.setVisibility(View.GONE);
                                                                         textView = findViewById(R.id.TV3);
                                                                         myThread = new MyThread("-- ИКБО-**-23..");
                                                                         myThread.start();
                                                                         break;
                                                                     case 14:
                                                                         binding.TV3.setText("-- ИКБО-**-23..");
                                                                         break;
                                                                     case 15:
                                                                         binding.TV3.setVisibility(View.GONE);
                                                                         binding.IV2.setVisibility(View.GONE);
                                                                         binding.TV1.setVisibility(View.VISIBLE);
                                                                         binding.IV3.setVisibility(View.VISIBLE);
                                                                         textView = findViewById(R.id.TV1);
                                                                         myThread = new MyThread("-- О Господи... Ещё и мой подопечный.. Ты почему не на факеле?");
                                                                         myThread.start();
                                                                         break;
                                                                     case 16:
                                                                         binding.TV1.setText("-- О Господи... Ещё и мой подопечный.. Ты почему не на факеле?");
                                                                         break;
                                                                     case 17:
                                                                         binding.TV3.setVisibility(View.VISIBLE);
                                                                         binding.IV2.setVisibility(View.VISIBLE);
                                                                         binding.TV1.setVisibility(View.GONE);
                                                                         binding.IV3.setVisibility(View.GONE);
                                                                         textView = findViewById(R.id.TV3);
                                                                         myThread = new MyThread("-- Там бумажки сказали заполнить и я...");
                                                                         myThread.start();
                                                                         break;
                                                                     case 18:
                                                                         binding.TV3.setText("-- Там бумажки сказали заполнить и я...");
                                                                         break;
                                                                     case 19:
                                                                         binding.TV3.setVisibility(View.GONE);
                                                                         binding.IV2.setVisibility(View.GONE);
                                                                         binding.TV1.setVisibility(View.VISIBLE);
                                                                         binding.IV3.setVisibility(View.VISIBLE);
                                                                         textView = findViewById(R.id.TV1);
                                                                         myThread = new MyThread("-- Я-я, что ты? Ну и ребёнок! А ну кыш в кабинет, а то выговор как сделаю.. Ты вроде умный, раз поступил сюда, так что взбунтовался? Фобия бумажек?");
                                                                         myThread.start();
                                                                         break;
                                                                     case 20:
                                                                         binding.TV1.setText("-- Я-я, что ты? Ну и ребёнок! А ну кыш в кабинет, а то выговор как сделаю.. Ты вроде умный, раз поступил сюда, так что взбунтовался? Фобия бумажек?");
                                                                         break;
                                                                     case 21:
                                                                         textView = findViewById(R.id.TV1);
                                                                         myThread = new MyThread("-- Ну-ну. Может, у тебя заиграло просто в одном месте? А? Ну и подростки пошли... Убрались контрольные рамки родителей, крышу в первый же день снесло?");
                                                                         myThread.start();
                                                                         break;
                                                                     case 22:
                                                                         binding.TV1.setText("-- Ну-ну. Может, у тебя заиграло просто в одном месте? А? Ну и подростки пошли... Убрались контрольные рамки родителей, крышу в первый же день снесло?");
                                                                         break;
                                                                     case 23:
                                                                         binding.TV.setVisibility(View.VISIBLE);
                                                                         binding.TV1.setVisibility(View.GONE);
                                                                         binding.IV3.setVisibility(View.GONE);
                                                                         textView = findViewById(R.id.TV);
                                                                         myThread = new MyThread("Говорил этот человек, тащя меня обратно за ухо. - Витя, я вернул твоего чудика!\n" +
                                                                                 "И вот, все взгяды вновь сконцентрированы на вас");
                                                                         myThread.start();
                                                                         break;
                                                                     case 24:
                                                                         binding.TV.setText("Говорил этот человек, тащя меня обратно за ухо. - Витя, я вернул твоего чудика!\nИ вот, все взгяды вновь сконцентрированы на вас");
                                                                         binding.BT11.setVisibility(View.VISIBLE);
                                                                         binding.BT12.setVisibility(View.VISIBLE);
                                                                         binding.BT11.setText("Отчислиться");
                                                                         binding.BT12.setText("Извиниться");
                                                                         binding.BT11.setOnClickListener(new View.OnClickListener() {
                                                                             @Override
                                                                             public void onClick(View v) {
                                                                                 binding.TV3.setVisibility(View.VISIBLE);
                                                                                 binding.IV2.setVisibility(View.VISIBLE);
                                                                                 binding.TV.setVisibility(View.GONE);
                                                                                 binding.BT11.setVisibility(View.GONE);
                                                                                 binding.BT12.setVisibility(View.GONE);
                                                                                 textView = findViewById(R.id.TV3);
                                                                                 myThread = new MyThread("-- Чудик - не чудик, но уважения к своей персоне здесь я не увидел, посему хочу отчислиться. Аривидерчи!");
                                                                                 myThread.start();
                                                                                 View rootViewww = findViewById(android.R.id.content);
                                                                                 rootViewww.setOnClickListener(new View.OnClickListener() {
                                                                                     public void onClick(View v) {
                                                                                         myThread.sled();
                                                                                         switch (cccccurrentState) {
                                                                                             case 0:
                                                                                                 binding.TV3.setText("-- Чудик - не чудик, но уважения к своей персоне здесь я не увидел, посему хочу отчислиться. Аривидерчи!");
                                                                                                 break;
                                                                                             case 1:
                                                                                                 binding.TV3.setVisibility(View.GONE);
                                                                                                 binding.IV2.setVisibility(View.GONE);
                                                                                                 binding.TV.setVisibility(View.VISIBLE);
                                                                                                 Toast.makeText(Bumaga.this, "(Репутация - 3)", Toast.LENGTH_SHORT).show();
                                                                                                 Toast.makeText(Bumaga.this, "(Активность - 20)", Toast.LENGTH_SHORT).show();
                                                                                                 Toast.makeText(Bumaga.this, "(Успеваемость - 30)", Toast.LENGTH_SHORT).show();
                                                                                                 Intent intent = new Intent(Bumaga.this, Pers.class);
                                                                                                 ac -= 20;
                                                                                                 ysp -= 30;
                                                                                                 re -= 3;
                                                                                                 textView = findViewById(R.id.TV);
                                                                                                 myThread = new MyThread("Больше вас никто не останавливал, ведь делать это уже было абсолютно бессмысленно. Вы вбили в свою голову мысль и никто не смог вас переубедить.");
                                                                                                 myThread.start();
                                                                                                 break;
                                                                                             case 2:
                                                                                                 binding.TV.setText("Больше вас никто не останавливал, ведь делать это уже было абсолютно бессмысленно. Вы вбили в свою голову мысль и никто не смог вас переубедить.");
                                                                                                 break;
                                                                                             case 3:
                                                                                                 intent = new Intent(Bumaga.this, Final.class);
                                                                                                 intent.putExtra("act", act);
                                                                                                 intent.putExtra("rep", rep);
                                                                                                 intent.putExtra("ysp", ysp);
                                                                                                 act = ac;
                                                                                                 rep = re;
                                                                                                 ysp = ys;
                                                                                                 startActivityForResult(intent, REQUESTCODE);
                                                                                                 intent = new Intent(Bumaga.this, Final.class);
                                                                                                 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                                                                 startActivity(intent);
                                                                                                 break;
                                                                                         }
                                                                                         cccccurrentState++;
                                                                                     }
                                                                                 });
                                                                             }
                                                                         });
                                                                         binding.BT12.setOnClickListener(new View.OnClickListener() {
                                                                             @Override
                                                                             public void onClick(View v) {
                                                                                 binding.TV3.setVisibility(View.VISIBLE);
                                                                                 binding.IV2.setVisibility(View.VISIBLE);
                                                                                 binding.TV.setVisibility(View.GONE);
                                                                                 binding.BT11.setVisibility(View.GONE);
                                                                                 binding.BT12.setVisibility(View.GONE);
                                                                                 textView = findViewById(R.id.TV3);
                                                                                 myThread = new MyThread("-- Виталий, простите, вероятно, - вы хмыкнули, - и правда заиграла фобия бумажек. Но я всё осознал, куратор от преподавательского состава направил меня на путь истинный, я теперь прележен и заполню хоть все бумаги, находящиеся в этом кабинете!");
                                                                                 myThread.start();
                                                                                 View rootViewwww = findViewById(android.R.id.content);
                                                                                 rootViewwww.setOnClickListener(new View.OnClickListener() {
                                                                                     public void onClick(View v) {
                                                                                         myThread.sled();
                                                                                         switch (ccccurrentState) {
                                                                                             case 0:
                                                                                                 binding.TV3.setText("-- Виталий, простите, вероятно, - вы хмыкнули, - и правда заиграла фобия бумажек. Но я всё осознал, куратор от преподавательского состава направил меня на путь истинный, я теперь прележен и заполню хоть все бумаги, находящиеся в этом кабинете!");
                                                                                                 break;
                                                                                             case 1:
                                                                                                 binding.TV3.setVisibility(View.GONE);
                                                                                                 binding.IV2.setVisibility(View.GONE);
                                                                                                 binding.TV.setVisibility(View.VISIBLE);
                                                                                                 textView = findViewById(R.id.TV);
                                                                                                 myThread = new MyThread("Сердце Вити постепенно начало оттаивать и он, улыбнувшись (правда, улыбка получилась чуть кривоватой), сказал:");
                                                                                                 myThread.start();
                                                                                                 ac += 10;
                                                                                                 binding.TVV.setText("Репутация " + re + "\nАктивность " + ac + "\nУспеваемость " + ys);
                                                                                                 Toast.makeText(Bumaga.this, "(Активность + 10)", Toast.LENGTH_SHORT).show();
                                                                                                 Intent intent = new Intent(Bumaga.this, Pers.class);
                                                                                                 break;
                                                                                             case 2:
                                                                                                 binding.TV.setText("Сердце Вити постепенно начало оттаивать и он, улыбнувшись (правда, улыбка получилась чуть кривоватой), сказал:");
                                                                                                 break;
                                                                                             case 3:
                                                                                                 binding.TV1.setVisibility(View.VISIBLE);
                                                                                                 binding.IV1.setVisibility(View.VISIBLE);
                                                                                                 binding.TV.setVisibility(View.GONE);
                                                                                                 textView = findViewById(R.id.TV1);
                                                                                                 myThread = new MyThread("-- Ну и кадр! Ты сведёшь меня в могилу. Но да ладно, извиняться никогда не поздно, садись, без тебя мы ещё ничего заполнить не успели!");
                                                                                                 myThread.start();
                                                                                                 break;
                                                                                             case 4:
                                                                                                 binding.TV1.setText("-- Ну и кадр! Ты сведёшь меня в могилу. Но да ладно, извиняться никогда не поздно, садись, без тебя мы ещё ничего заполнить не успели!");
                                                                                                 break;
                                                                                             case 5:
                                                                                                 binding.TV.setVisibility(View.VISIBLE);
                                                                                                 binding.TV1.setVisibility(View.GONE);
                                                                                                 binding.IV1.setVisibility(View.GONE);
                                                                                                 textView = findViewById(R.id.TV);
                                                                                                 myThread = new MyThread("И вот вы приступили к заполнению бумаг. Вы были сконцентрированы и не допускали ошибок, вчитывались в пункты, заполняли формы и подписывались в нужных местах. Некоторые ошибались и им давали чистые бланки, но вы заполнили всё с первой попытки.\n" +
                                                                                                         "Наконец, когда все бумаги были заполнены, было предложено развеяться и поиграть в разные командные игры, после которых мы стали ближе друг к другу.");
                                                                                                 myThread.start();
                                                                                                 break;
                                                                                             case 6:
                                                                                                 binding.TV.setText("И вот вы приступили к заполнению бумаг. Вы были сконцентрированы и не допускали ошибок, вчитывались в пункты, заполняли формы и подписывались в нужных местах. Некоторые ошибались и им давали чистые бланки, но вы заполнили всё с первой попытки.\nНаконец, когда все бумаги были заполнены, было предложено развеяться и поиграть в разные командные игры, после которых мы стали ближе друг к другу.");
                                                                                                 break;
                                                                                             case 7:
                                                                                                 intent = new Intent(Bumaga.this, List.class);
                                                                                                 startActivityForResult(intent, REQUESTCODE);
                                                                                                 intent.putExtra("act", act);
                                                                                                 intent.putExtra("rep", rep);
                                                                                                 intent.putExtra("ysp", ysp);
                                                                                                 act = ac;
                                                                                                 rep = re;
                                                                                                 ysp = ys;
                                                                                                 intent = new Intent(Bumaga.this, List.class);
                                                                                                 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                                                                 startActivity(intent);
                                                                                                 break;
                                                                                         }
                                                                                         ccccurrentState++;
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
                                                });
                                                binding.BT2.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        binding.TV1.setVisibility(View.GONE);
                                                        binding.IV1.setVisibility(View.GONE);
                                                        binding.TV3.setVisibility(View.VISIBLE);
                                                        binding.IV2.setVisibility(View.VISIBLE);
                                                        binding.TV.setVisibility(View.GONE);
                                                        binding.BT1.setVisibility(View.GONE);
                                                        binding.BT2.setVisibility(View.GONE);
                                                        textView = findViewById(R.id.TV3);
                                                        myThread = new MyThread("-- Ну и речь, у меня было просто хорошее настроение, по этому я решил в шутку возмутиться, а вы... Я уверен, что абсолютно никто не считает заполнение бумажек бесполезной тратой.");
                                                        myThread.start();
                                                        View rootViewwww = findViewById(android.R.id.content);
                                                        rootViewwww.setOnClickListener(new View.OnClickListener() {
                                                            public void onClick(View v) {
                                                                myThread.sled();
                                                                switch (ccccurrentState) {
                                                                    case 0:
                                                                        binding.TV3.setText("-- Ну и речь, - в сердцах сказали вы, - у меня было просто хорошее настроение, по этому я решил в шутку возмутиться, а вы... Я уверен, что абсолютно никто не считает заполнение бумажек бесполезной тратой.");
                                                                        break;
                                                                    case 1:
                                                                        textView = findViewById(R.id.TV3);
                                                                        myThread = new MyThread("-- Я могу в следующую нашу встречу преподнести вам презент в виде ромашкового чая - такой вы ещё не пили. Приготовленный на Урале, по рецепту моей прапрабабушки...");
                                                                        myThread.start();
                                                                        break;
                                                                    case 2:
                                                                        binding.TV3.setText("-- Я могу в следующую нашу встречу преподнести вам презент в виде ромашкового чая - такой вы ещё не пили. Приготовленный на Урале, по рецепту моей прапрабабушки...");
                                                                        break;
                                                                    case 3:
                                                                        binding.TV3.setVisibility(View.GONE);
                                                                        binding.IV2.setVisibility(View.GONE);
                                                                        binding.TV1.setVisibility(View.VISIBLE);
                                                                        binding.IV1.setVisibility(View.VISIBLE);
                                                                        textView = findViewById(R.id.TV1);
                                                                        myThread = new MyThread("-- С такими шутками увидишь меня в могиле в следующий раз");
                                                                        myThread.start();
                                                                        break;
                                                                    case 4:
                                                                        binding.TV1.setText("-- С такими шутками увидишь меня в могиле в следующий раз");
                                                                        Toast.makeText(Bumaga.this, "(Репутация + 1)", Toast.LENGTH_SHORT).show();
                                                                        Toast.makeText(Bumaga.this, "(Активность + 20)", Toast.LENGTH_SHORT).show();
                                                                        Toast.makeText(Bumaga.this, "(Успеваемость + 10)", Toast.LENGTH_SHORT).show();
                                                                        ac += 20;
                                                                        re ++;
                                                                        ys += 10;
                                                                        binding.TVV.setText("Репутация " + re + "\nАктивность " + ac + "\nУспеваемость " + ys);
                                                                        break;
                                                                    case 5:
                                                                        binding.TV.setVisibility(View.VISIBLE);
                                                                        binding.TV1.setVisibility(View.GONE);
                                                                        binding.IV1.setVisibility(View.GONE);
                                                                        textView = findViewById(R.id.TV);
                                                                        myThread = new MyThread("Пробурчал Виталий.\n" +
                                                                                "Через мгновение он хлопнул ладонями и воскликнул");
                                                                        myThread.start();
                                                                        break;
                                                                    case 6:
                                                                        binding.TV.setText("Пробурчал Виталий.\nЧерез мгновение он хлопнул ладонями и воскликнул");
                                                                        break;
                                                                    case 7:
                                                                        binding.TV.setVisibility(View.GONE);
                                                                        binding.TV1.setVisibility(View.VISIBLE);
                                                                        binding.IV1.setVisibility(View.VISIBLE);
                                                                        textView = findViewById(R.id.TV1);
                                                                        myThread = new MyThread("-- Бумаги!");
                                                                        myThread.start();
                                                                        break;
                                                                    case 8:
                                                                        binding.TV1.setText("-- Бумаги!");
                                                                        break;
                                                                    case 9:
                                                                        binding.TV.setVisibility(View.VISIBLE);
                                                                        binding.TV1.setVisibility(View.GONE);
                                                                        binding.IV1.setVisibility(View.GONE);
                                                                        textView = findViewById(R.id.TV);
                                                                        myThread = new MyThread("И вот вы приступили к заполнению бумаг. Вы были сконцентрированы и не допускали ошибок, вчитывались в пункты, заполняли формы и подписывались в нужных местах. Некоторые ошибались и им давали чистые бланки, но вы заполнили всё с первой попытки.\n" +
                                                                                "Наконец, когда все бумаги были заполнены, было предложено развеяться и поиграть в разные командные игры, после которых мы стали ближе друг к другу.");
                                                                        myThread.start();
                                                                        break;
                                                                    case 10:
                                                                        binding.TV.setText("И вот вы приступили к заполнению бумаг. Вы были сконцентрированы и не допускали ошибок, вчитывались в пункты, заполняли формы и подписывались в нужных местах. Некоторые ошибались и им давали чистые бланки, но вы заполнили всё с первой попытки.\nНаконец, когда все бумаги были заполнены, было предложено развеяться и поиграть в разные командные игры, после которых мы стали ближе друг к другу.");
                                                                        break;
                                                                    case 11:
                                                                        Intent intent = new Intent(Bumaga.this, List.class);
                                                                        startActivityForResult(intent, REQUESTCODE);
                                                                        intent.putExtra("act", act);
                                                                        intent.putExtra("rep", rep);
                                                                        intent.putExtra("ysp", ysp);
                                                                        act = ac;
                                                                        rep = re;
                                                                        ysp = ys;
                                                                        intent = new Intent(Bumaga.this, List.class);
                                                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                                        startActivity(intent);
                                                                        break;
                                                                }
                                                                ccccurrentState++;
                                                            }
                                                        });
                                                    }
                                                });
                                                break;
                                        }
                                        ccurrentState++;
                                    }
                                });
                            }
                        });
                        binding.BT12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(Bumaga.this, "(Активность + 20)", Toast.LENGTH_SHORT).show();
                                Toast.makeText(Bumaga.this, "(Успеваемость + 10)", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Bumaga.this, Pers.class);
                                ac += 20;
                                ys += 10;
                                binding.TVV.setText("Репутация " + re + "\nАктивность " + ac + "\nУспеваемость " + ys);
                                binding.TV.setVisibility(View.VISIBLE);
                                binding.BT11.setVisibility(View.GONE);
                                binding.BT12.setVisibility(View.GONE);
                                textView = findViewById(R.id.TV);
                                myThread = new MyThread("И вот вы приступили к заполнению бумаг. Вы были сконцентрированы и не допускали ошибок, вчитывались в пункты, заполняли формы и подписывались в нужных местах. Некоторые ошибались и им давали чистые бланки, но вы заполнили всё с первой попытки.\nНаконец, когда все бумаги были заполнены, было предложено развеяться и поиграть в разные командные игры, после которых мы стали ближе друг к другу.");
                                myThread.start();
                                View rootViewwww = findViewById(android.R.id.content);
                                rootViewwww.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        myThread.sled();
                                        binding.TV.setText("И вот вы приступили к заполнению бумаг. Вы были сконцентрированы и не допускали ошибок, вчитывались в пункты, заполняли формы и подписывались в нужных местах. Некоторые ошибались и им давали чистые бланки, но вы заполнили всё с первой попытки.\nНаконец, когда все бумаги были заполнены, было предложено развеяться и поиграть в разные командные игры, после которых мы стали ближе друг к другу.");
                                        rootViewwww.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                intent.putExtra("act", act);
                                                intent.putExtra("rep", rep);
                                                intent.putExtra("ysp", ysp);
                                                act = ac;
                                                rep = re;
                                                ysp = ys;
                                                num = 5;
                                                Intent intent = new Intent(Bumaga.this, Pers.class);
                                                startActivityForResult(intent, REQUESTCODE);
                                                intent = new Intent(Bumaga.this, List.class);
                                                startActivityForResult(intent, REQUESTCODE);
                                                intent = new Intent(Bumaga.this, List.class);
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
