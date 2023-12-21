package com.example.text_kvest;

import static com.example.text_kvest.MainActivity.num;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.text_kvest.databinding.ActivityStartBinding;

public class Start extends AppCompatActivity {
    final static int REQUESTCODE = 1234;

    private boolean isTextSwitched = false;
    private int currentState = 0;
    TextView textView;
    Handler handler;
    MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityStartBinding binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.TV.setText("Предисловие");
        binding.IV1.setVisibility(View.GONE);
        binding.IV.setVisibility(View.GONE);
        binding.TV2.setVisibility(View.GONE);
        binding.TV3.setVisibility(View.GONE);
        binding.TV4.setVisibility(View.GONE);
        binding.TV5.setVisibility(View.GONE);
        binding.TV6.setVisibility(View.GONE);
        binding.TV7.setVisibility(View.GONE);
        binding.BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 1;
                Intent intent = new Intent(Start.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODE);
                Intent intenttr = new Intent(Start.this, MainActivity.class);
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
                myThread.sled();
                long currentTime = System.currentTimeMillis();

                switch (currentState) {
                    case 0:
                        binding.TV1.setText("На улице светило солнце, его лучи проникали в комнату, овсещая три лица: напряжённое отца, бледное, как полотно, матери и моё, исхудавшее, не выражающее никаких эмоций...\nУ меня всегда было такое лицо, точнее, за последние пол года оно превратилось в безжизненную физиономию из-за постоянных стрессов, срывов, недосыпов и переживаний.");
                        break;
                    case 1:
                        textView = findViewById(R.id.TV2);
                        myThread = new MyThread((String) binding.TV2.getText());
                        myThread.start();
                        binding.TV1.setVisibility(View.GONE);
                        binding.TV2.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        binding.TV2.setText("Всё ещё не догадались почему?\nЭкзамены\nДа, можно забить болт на подготовку и наслаждаться подростковой жизнью, но что потом?\nИз-за недостаточной работы написать тесты на низкие баллы и поступить в ЮУРГУ?\nНу уж нет, перспектива куда заманчивее - окно, открытое в жаркую погоду нараспашку. Прыгать высоко, шанса выжить практически не...");
                        break;
                    case 3:
                        textView = findViewById(R.id.TV3);
                        myThread = new MyThread((String) binding.TV3.getText());
                        myThread.start();
                        binding.TV2.setVisibility(View.GONE);
                        binding.TV3.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        binding.TV3.setText("А! Экзамен, вернёмся к нему.\nПричина, по которой мы здесь собрались - именно он.\nНедавно появились результакты, по этому мы сразу же ринулись смотреть их.\nДрожащими пальцами, вбив фамилию и имя, дважды ошибившись в номере паспорта, загрузились результаты.");
                        break;
                    case 5:
                        textView = findViewById(R.id.TV4);
                        myThread = new MyThread((String) binding.TV4.getText());
                        myThread.start();
                        binding.TV3.setVisibility(View.GONE);
                        binding.TV4.setVisibility(View.VISIBLE);
                        binding.IV.setVisibility(View.VISIBLE);
                        break;
                    case 6:
                        binding.TV4.setText("24...\nМоё сердце уходит в пятки, я начинаю впадать в пучину отчаянья и непонимания, как....\nПогодите, такими темпами и умереть не сложно!\nЯ посмотрел на минимальный балл, а не на свой, никогда так не было приятно ошибаться.\nСердце начало биться чуть медленее, а в голове стучала барабанная дробь, не хотелось смотреть ещё на один столбец левее...");
                        break;
                    case 7:
                        textView = findViewById(R.id.TV5);
                        myThread = new MyThread((String) binding.TV5.getText());
                        myThread.start();
                        binding.IV.setVisibility(View.GONE);
                        binding.TV4.setVisibility(View.GONE);
                        binding.IV1.setVisibility(View.VISIBLE);
                        binding.TV5.setVisibility(View.VISIBLE);
                        break;
                    case 8:
                        binding.TV5.setText("97\nЭто была победа!\nНа глазах навернулись слёзы счастья. Русский прошёл успешно!\nНе буду долго таить, в математике налажал конкретно - 84 балла получил, по информатике же меня чуть не прибил флешкой репетитор, когда узнала, что я не смог набрать сотку только из-за задачи на среднее арифметическое в экселе. Да там разница была в сотые!! Было обидно, но своими 98-ю баллами я всё же гордился.");
                        break;
                    case 9:
                        textView = findViewById(R.id.TV6);
                        myThread = new MyThread((String) binding.TV6.getText());
                        myThread.start();
                        binding.IV1.setVisibility(View.GONE);
                        binding.TV5.setVisibility(View.GONE);
                        binding.TV6.setVisibility(View.VISIBLE);
                        break;
                    case 10:
                        binding.TV6.setText("В школе я не был отличником, но и троек у меня не было. Я был лучшим из хорошистов, если так можно сказать. Но за это баллы не дают, так что мои сырые 279 баллов курили молча в сторонке.\nЗато повезло в другом - значок ГТО дал приятный бонус в качестве 3-х баллов, что в будущем сказалось на моей стипендии, да и на рейтинге среди поступающих.\nЕстественно, со своими баллами я не проходил ни в Бауманку, ни тем более в МФТИ, но зато идеально подходил в списке Программной инженерии МИРЭА.\nНе буду томить, я прошёл в группу ИКБО-10-23, заселился в первую общагу.\nДа начнётся моя история с востановленными за август месяц психикой и ментальным здоровьем, большими амбициями и грандиозными планами.");
                        textView = findViewById(R.id.TV7);
                        myThread = new MyThread((String) binding.TV7.getText());
                        myThread.start();
                        binding.TV7.setVisibility(View.VISIBLE);
                        break;
                    case 11:
                        binding.TV7.setText("РТУ МИРЭА, таких студентов ты ещё не видел!!!");
                        break;
                    case 12:
                        Intent intentt = new Intent(Start.this, Pers.class);
                        intentt.putExtra("num", num);
                        Intent intent = new Intent(Start.this, Pers.class);
                        startActivityForResult(intent, REQUESTCODE);
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
