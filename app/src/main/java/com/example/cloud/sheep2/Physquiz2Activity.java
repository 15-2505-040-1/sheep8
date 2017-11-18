package com.example.cloud.sheep2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Physquiz2Activity extends AppCompatActivity {
    private TextView tv_num;
    private TextView ques_num;
    private ImageView imageView;
    private Button[] buttons;
    private TextView result;

    private Button next;

    private Physques2 quiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physquiz2);



        // 画面上のウィジェットを取得しておく
        tv_num = (TextView) findViewById(R.id.q_string);
        ques_num = (TextView)  findViewById(R.id.question);
        imageView = (ImageView) findViewById(R.id.flag_image);
        buttons = new Button[4];

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= 3; i++) {
            list.add(i);
        }
        //listをシャッフル
        Collections.shuffle(list);
        int i=0;

        buttons[list.get(i)] = (Button) findViewById(R.id.btn1);
        buttons[list.get(i+1)] = (Button) findViewById(R.id.btn2);
        buttons[list.get(i+2)] = (Button) findViewById(R.id.btn3);
        buttons[list.get(i+3)] = (Button) findViewById(R.id.btn4);

        result = (TextView) findViewById(R.id.result);

        next = (Button) findViewById(R.id.next);


        // データを受け取る
        Intent intent = getIntent();
        if (intent != null) {
            quiz = (Physques2) intent.getSerializableExtra("Physques2");
            show();
        }
    }

    // 表示に反映させる
    void show() {
        if (quiz != null) {
            tv_num.setText(quiz.q_string);
            ques_num.setText(quiz.question);
            imageView.setImageResource(quiz.image);
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setText(quiz.choices[i]);
            }
            result.setText("");

            next.setVisibility(View.INVISIBLE);
        }
    }
    public void answer(View view) {
        for (int i = 0; i < buttons.length; i++) {
            if (view.getId() == buttons[i].getId()) {
                if (i == quiz.answer_index) {
                    result.setText("正解!");
                    next.setVisibility(View.VISIBLE);
                } else {
                    result.setText("不正解...");
                    next.setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    // 次の問題へ移る
    public void next(View view){



        if (quiz != null) {
            quiz = Physques2.getQuiz(quiz.q_num + 1);

            show();
        }
        else {
            finish(); // 最後の問題の時は移る先がないので一旦MainActivityに戻す
        }
    }

}
