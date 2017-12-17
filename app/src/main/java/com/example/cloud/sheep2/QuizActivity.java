package com.example.cloud.sheep2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.cloud.sheep2.R.id.question;


public class QuizActivity extends AppCompatActivity {private TextView tv_num;
    private TextView ques_num;
    private ImageView imageView;
    private Button[] buttons;
    private TextView result;
    private ImageView maru;
    private ImageView batu;

    private Button next;

    private Mathques1 quizm1;
    private Mathques2 quizm2;
    private Mathques3 quizm3;
    private Physques1 quizp1;
    private Physques2 quizp2;
    private Physques3 quizp3;

    Global global;
    Thread thread = null;


    private AlphaAnimation alpha1;
    private AlphaAnimation alpha2;
    private ScaleAnimation scale1;
    private ScaleAnimation scale2;
    private TranslateAnimation translate1;
    private TranslateAnimation translate2;
    AnimationSet set1 = new AnimationSet(true);
    AnimationSet set2 = new AnimationSet(true);

    private AlphaAnimation al1;
    private AlphaAnimation al2;
    private RotateAnimation rotate1;
    private TranslateAnimation trans1;

    private int g=0;
    private int q=0;
    private boolean clear=true;
    private float x=0.8f;
    private float y=1;
    private float n=1;
    private float m=1.2f;
    private float l=0.8f;
    private float a=70;
    private float b=80;
    private boolean judge = true;
    //private ImageView img = (ImageView)findViewById(R.id.monster1);

    private final Handler hdl = new Handler();
    private final Handler hdl2 = new Handler();


    public class Seikai implements Runnable{
        public void run() {
            show();
        }
    }

    public class Huseikai implements Runnable{
        public void run() {
            ImageView img = (ImageView)findViewById(R.id.monster1);
            alpha2 = new AlphaAnimation(y, x);
            scale2 = new ScaleAnimation(n, m, n, m, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            //translate2 = new TranslateAnimation(0, 0, a, b);
            set2.addAnimation(alpha2);
            set2.addAnimation(scale2);
            //set2.addAnimation(translate2);
            set2.setDuration(1000);
            set2.setFillAfter(true);
            img.startAnimation(set2);
            //x=y;
            //y=y+0.2f;
            //n=m;
            //m=m+0.1f;
            //a=b;
            //b=b+5;
            if(x>=1.0 || y>=1.0){
                x=1.0f;
                y=1.0f;
                n=m;
                m=m+0.1f;
            }else if(n>=1.5 || m>=1.5){
                x=y;
                y=y+0.2f;
                n=1.2f;
                m=1.2f;
            }else{
                x=y;
                y=y+0.2f;
                n=m;
                m=m+0.1f;
            }
        }

    }

    public class Gameover implements Runnable{
        public void run() {
            Intent intent = new Intent(QuizActivity.this, MainActivity.class);
            startActivity(intent);
            QuizActivity.this.finish();
        }
    }

    public class Tap implements Runnable{
        public void run(){
            for(int b=0;b<4;b++){
                buttons[b].setEnabled(true);
            }
        }
    }

    public class Clear implements Runnable{
        public void run(){
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            startActivity(intent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        global=(Global) this.getApplication();
        // 画面上のウィジェットを取得しておく
        tv_num = (TextView) findViewById(R.id.q_string);
        ques_num = (TextView)  findViewById(question);
        imageView = (ImageView) findViewById(R.id.flag_image);
        buttons = new Button[4];

        maru=(ImageView) findViewById(R.id.maru);
        batu=(ImageView) findViewById(R.id.batu);

        buttons[0] = (Button) findViewById(R.id.btn1);
        buttons[1] = (Button) findViewById(R.id.btn2);
        buttons[2] = (Button) findViewById(R.id.btn3);
        buttons[3] = (Button) findViewById(R.id.btn4);

        result = (TextView) findViewById(R.id.result);

        next = (Button) findViewById(R.id.next);

        // データを受け取る
        Intent intent = getIntent();
        if (intent != null) {
            quizm1 = (Mathques1) intent.getSerializableExtra("Mathques1");
            quizm2 = (Mathques2) intent.getSerializableExtra("Mathques2");
            quizm3 = (Mathques3) intent.getSerializableExtra("Mathques3");

            quizp1 = (Physques1) intent.getSerializableExtra("Physques1");
            quizp2 = (Physques2) intent.getSerializableExtra("Physques2");
            quizp3 = (Physques3) intent.getSerializableExtra("Physques3");

            show();
        }
        thread = new Thread();
        thread.start();

    }

    // 表示に反映させる
    void show() {
        if(clear==true){
            for(int b=0;b<4;b++){
                buttons[b].setEnabled(true);
            }



            if (global.m == 1) {
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setText(quizm1.choices[i]);
                    buttons[i].setTextColor(0xFF000000);
                }
                if (quizm1 != null) {
                    tv_num.setText(quizm1.q_string);
                    ques_num.setText(quizm1.question);
                    imageView.setImageResource(quizm1.image);
                    result.setText("");

                    next.setVisibility(View.INVISIBLE);
                }
            }
            if (global.m == 2) {
                ImageView img = (ImageView)findViewById(R.id.monster1);
                ImageView imgb = (ImageView)findViewById(R.id.back1);
          /*  Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.monster2);
            Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.back2);
            img.setImageBitmap(bmp1);
            imgb.setImageBitmap(bmp2);
            */
                if (quizm2 != null) {
                    tv_num.setText(quizm2.q_string);
                    ques_num.setText(quizm2.question);
                    imageView.setImageResource(quizm2.image);
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setText(quizm2.choices[i]);
                    }
                    result.setText("");

                    next.setVisibility(View.INVISIBLE);
                }
            }
            if (global.m == 3) {
                if (quizm3 != null) {
                    tv_num.setText(quizm3.q_string);
                    ques_num.setText(quizm3.question);
                    imageView.setImageResource(quizm3.image);
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setText(quizm3.choices[i]);
                    }
                    result.setText("");

                    next.setVisibility(View.INVISIBLE);
                }
            }
            if (global.x == 1) {
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setText(quizp1.choices[i]);
                    buttons[i].setTextColor(0xFF000000);
                }
                if (quizp1 != null) {
                    tv_num.setText(quizp1.q_string);
                    ques_num.setText(quizp1.question);
                    imageView.setImageResource(quizp1.image);
                    result.setText("");

                    next.setVisibility(View.INVISIBLE);
                }
            }
            if (global.x == 2) {
                if (quizp2 != null) {
                    tv_num.setText(quizp2.q_string);
                    ques_num.setText(quizp2.question);
                    imageView.setImageResource(quizp2.image);
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setText(quizp2.choices[i]);
                    }
                    result.setText("");

                    next.setVisibility(View.INVISIBLE);
                }
            }
            if (global.x == 3) {
                if (quizp3 != null) {
                    tv_num.setText(quizp3.q_string);
                    ques_num.setText(quizp3.question);
                    imageView.setImageResource(quizp3.image);
                    for (int i = 0; i < buttons.length; i++) {
                        buttons[i].setText(quizp3.choices[i]);
                    }
                    result.setText("");

                    next.setVisibility(View.INVISIBLE);
                }
            }
        }
        else{
            clear=true;
        }

    }
    public void answer(View view) {
        for(int b=0;b<4;b++){
            buttons[b].setEnabled(false);
        }
        for (int i = 0; i < buttons.length; i++) {
            if (global.m== 1) {
                if (view.getId() == buttons[i].getId()) {

                    if (i == quizm1.answer_index) {
                        AnimationSet s1 = new AnimationSet(true);
                        al1 = new AlphaAnimation(0, 1);
                        s1.addAnimation(al1);
                        s1.setDuration(900);
                        s1.setInterpolator(new CycleInterpolator(3));
                        maru.startAnimation(s1);

                        if (quizm1 != null) {

                            quizm1 = Mathques1.getQuiz(quizm1.q_num + 1);
                            hdl2.postDelayed(new Seikai(), 1400);
                            q++;
                        }
                        if(q==1){
                            hdl.postDelayed(new Clear(),1000);
                        }

                    } else {


                        if(judge==true) {
                            float q = x;
                            x = y;
                            y = q;
                            n = l;
                            set1.setFillAfter(false);
                            set2.setFillAfter(false);
                            //    q = a;
                            //    a = b;
                            //    b = q;
                        }
                        hdl.postDelayed(new Huseikai(),1000);
                        judge = false;
                        AnimationSet s1 = new AnimationSet(true);
                        al1 = new AlphaAnimation(0, 1);
                        //al1.setInterpolator(new CycleInterpolator(1));
                        //rotate1.setRepeatCount(Animation.INFINITE);

                        s1.addAnimation(al1);
                        s1.setDuration(900);
                        s1.setInterpolator(new CycleInterpolator(3));

                        batu.startAnimation(s1);
                        g++;

                        buttons[quizm1.answer_index].setTextColor(0xFFFF4040);
                        if(g==3){
                            clear=false;
                            hdl.postDelayed(new Gameover(), 2000);
                        }
                        if (quizm1 != null) {

                            quizm1 = Mathques1.getQuiz(quizm1.q_num + 1);
                            hdl2.postDelayed(new Seikai(), 1200);

                        }
                        else {
                            finish();
                        }

                    }
                }
            }

            if (global.m == 2) {
                if (view.getId() == buttons[i].getId()) {
                    if (i == quizm2.answer_index) {
                        result.setText("正解!");
                        next.setVisibility(View.VISIBLE);
                    } else {
                        result.setText("不正解...");
                        next.setVisibility(View.INVISIBLE);
                    }
                }
            }
            if (global.m == 3) {
                if (view.getId() == buttons[i].getId()) {
                    if (i == quizm3.answer_index) {
                        result.setText("正解!");
                        next.setVisibility(View.VISIBLE);
                    } else {
                        result.setText("不正解...");
                        next.setVisibility(View.INVISIBLE);
                    }
                }
            }
            if (global.x == 1) {
                if (view.getId() == buttons[i].getId()) {

                    if (i == quizp1.answer_index) {
                        AnimationSet s1 = new AnimationSet(true);
                        al1 = new AlphaAnimation(0, 1);
                        s1.addAnimation(al1);
                        s1.setDuration(900);
                        s1.setInterpolator(new CycleInterpolator(3));
                        maru.startAnimation(s1);

                        if (quizp1 != null) {

                            quizp1 = Physques1.getQuiz(quizp1.q_num + 1);
                            hdl2.postDelayed(new Seikai(), 1400);
                            q++;
                        }
                        if(q==1){
                            hdl.postDelayed(new Clear(),1000);
                        }

                    } else {


                        if(judge==true) {
                            float q = x;
                            x = y;
                            y = q;
                            n = l;
                            set1.setFillAfter(false);
                            set2.setFillAfter(false);
                            //    q = a;
                            //    a = b;
                            //    b = q;
                        }
                        hdl.postDelayed(new Huseikai(),1000);
                        judge = false;
                        AnimationSet s1 = new AnimationSet(true);
                        al1 = new AlphaAnimation(0, 1);
                        //al1.setInterpolator(new CycleInterpolator(1));
                        //rotate1.setRepeatCount(Animation.INFINITE);

                        s1.addAnimation(al1);
                        s1.setDuration(900);
                        s1.setInterpolator(new CycleInterpolator(3));

                        batu.startAnimation(s1);
                        g++;

                        buttons[quizp1.answer_index].setTextColor(0xFFFF4040);
                        if(g==3){
                            hdl.postDelayed(new Gameover(), 2000);
                        }
                        if (quizp1 != null) {

                            quizp1 = Physques1.getQuiz(quizp1.q_num + 1);
                            hdl2.postDelayed(new Seikai(), 1200);

                        }
                        else {
                            finish();
                        }

                    }
                }
            }

            if (global.x == 2) {
                if (view.getId() == buttons[i].getId()) {
                    if (i == quizp2.answer_index) {
                        result.setText("正解!");
                        next.setVisibility(View.VISIBLE);
                    } else {
                        result.setText("不正解...");
                        next.setVisibility(View.INVISIBLE);
                    }
                }
            }
            if (global.x == 3) {
                if (view.getId() == buttons[i].getId()) {
                    if (i == quizp3.answer_index) {
                        result.setText("正解!");
                        next.setVisibility(View.VISIBLE);
                    } else {
                        result.setText("不正解...");
                        next.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }
    }
    // 次の問題へ移る
    public void next(View view){
        if(global.m==1){
            if (quizm1 != null) {
                quizm1 = Mathques1.getQuiz(quizm1.q_num + 1);
                show();
            }
            else {
                finish(); // 最後の問題の時は移る先がないので一旦MainActivityに戻す
            }
        }
        else if(global.m==2){
            if (quizm2 != null) {
                quizm2 = Mathques2.getQuiz(quizm2.q_num + 1);
                show();
            }
            else {
                finish(); // 最後の問題の時は移る先がないので一旦MainActivityに戻す
            }
        }
        else if(global.m==3){
            if (quizm3 != null) {
                quizm3 = Mathques3.getQuiz(quizm3.q_num + 1);
                show();
            }
            else {
                finish(); // 最後の問題の時は移る先がないので一旦MainActivityに戻す
            }
        }
        if(global.x==1){
            if (quizp1 != null) {
                quizp1 = Physques1.getQuiz(quizp1.q_num + 1);
                show();
            }
            else {
                finish(); // 最後の問題の時は移る先がないので一旦MainActivityに戻す
            }
        }
        else if(global.x==2){
            if (quizp2 != null) {
                quizp2 = Physques2.getQuiz(quizp2.q_num + 1);
                show();
            }
            else {
                finish(); // 最後の問題の時は移る先がないので一旦MainActivityに戻す
            }
        }
        else if(global.x==3){
            if (quizp3 != null) {
                quizp3 = Physques3.getQuiz(quizp3.q_num + 1);
                show();
            }
            else {
                finish(); // 最後の問題の時は移る先がないので一旦MainActivityに戻す
            }
        }
    }
}