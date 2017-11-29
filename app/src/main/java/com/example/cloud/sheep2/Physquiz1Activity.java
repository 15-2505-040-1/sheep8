package com.example.cloud.sheep2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.cloud.sheep2.R.id.question;


public class Physquiz1Activity extends AppCompatActivity {
    private TextView tv_num;
    private TextView ques_num;
    private ImageView imageView;
    private Button[] buttons;
    private TextView result;

    private Button next;

    private Mathques1 quizm1;
    private Mathques2 quizm2;
    private Mathques3 quizm3;
    private Physques1 quizp1;
    private Physques2 quizp2;
    private Physques3 quizp3;

    Global global;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physquiz1);

        global=(Global) this.getApplication();
        // 画面上のウィジェットを取得しておく
        tv_num = (TextView) findViewById(R.id.q_string);
        ques_num = (TextView)  findViewById(question);
        imageView = (ImageView) findViewById(R.id.flag_image);
        buttons = new Button[4];

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
    }

    // 表示に反映させる
    void show() {
        if(global.m==1){
            if (quizm1 != null) {
                tv_num.setText(quizm1.q_string);
                ques_num.setText(quizm1.question);
                imageView.setImageResource(quizm1.image);
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setText(quizm1.choices[i]);
                }
                result.setText("");

                next.setVisibility(View.INVISIBLE);
            }
        }
        if(global.m==2){
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
        if(global.m==3){
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
        if(global.x==1){
            if (quizp1 != null) {
                tv_num.setText(quizp1.q_string);
                ques_num.setText(quizp1.question);
                imageView.setImageResource(quizp1.image);
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setText(quizp1.choices[i]);
                }
                result.setText("");

                next.setVisibility(View.INVISIBLE);
            }
        }
        if(global.x==2){
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
        if(global.x==3){
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
    public void answer(View view) {

        for (int i = 0; i < buttons.length; i++) {
            if (global.m== 1) {
                if (view.getId() == buttons[i].getId()) {
                    if (i == quizm1.answer_index) {
                        result.setText("正解!");
                        next.setVisibility(View.VISIBLE);
                    } else {
                        result.setText("不正解...");
                        next.setVisibility(View.INVISIBLE);
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
                        result.setText("正解!");
                        next.setVisibility(View.VISIBLE);
                    } else {
                        result.setText("不正解...");
                        next.setVisibility(View.INVISIBLE);
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