package com.example.cloud.sheep2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by cloud on 2017/11/15.
 */

public class Mathques1 implements Serializable {
    int q_num; // 問題番号
    String q_string; // 第○問というString
    String question; //問題文
    int image; // 画像ID
    String[] choices = new String[4]; // 選択肢
    int answer_index; // 正解の選択肢


    private static Mathques1[] quizzes = new Mathques1[4]; // クイズの配列

    private Mathques1(int q_num, String q_string, String question, int image, String[] choices, int answer_index) {
        this.q_num = q_num;
        this.q_string = q_string;
        this.question = question;
        this.image = image;
        this.choices = choices;
        this.answer_index = answer_index;
    }

    // 問題登録
    public static void init() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= 2; i++) {
            list.add(i);
        }
        //listをシャッフル
        Collections.shuffle(list);

        int r=0;

        quizzes[list.get(r)] = new Mathques1(list.get(r), "問", "現在のところ、火の使用が確認されているのはどの時代からか\n1.猿人\t2.新人\t3.原人\t4.旧人", R.drawable.m1 , new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+1)] = new Mathques1(list.get(r+1), "問", "ああああああああああああああああああああ\nいいいいいいいいいいい", R.drawable.m2, new String[]{"(1)", "(2)", "(3)", "(4)"}, 2);
        quizzes[list.get(r+2)] = new Mathques1(list.get(r+2), "問", "あああああああああああああああああああああ\nいいいいいいいいいいい", R.drawable.m3, new String[]{"(1)", "(2)", "(3)", "(4)"}, 2);

    }

    // 問題取得
    public static Mathques1 getQuiz(int num) {
        if (num >= quizzes.length) {
            return null;
        }
        return quizzes[num];
    }
}
