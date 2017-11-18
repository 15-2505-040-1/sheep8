package com.example.cloud.sheep2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by cloud on 2017/11/15.
 */

public class Physques1 implements Serializable {
    int q_num; // 問題番号
    String q_string; // 第○問というString
    String question; //問題文
    int image; // 画像ID
    String[] choices = new String[4]; // 選択肢
    int answer_index; // 正解の選択肢


    private static Physques1[] quizzes = new Physques1[4]; // クイズの配列

    private Physques1(int q_num, String q_string, String question, int image, String[] choices, int answer_index) {
        this.q_num = q_num;
        this.q_string = q_string;
        this.question = question;
        this.image = image;
        this.choices = choices;
        this.answer_index = answer_index;
    }

    // 問題の登録
    public static void init() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= 3; i++) {
            list.add(i);
        }
        //listをシャッフル
        Collections.shuffle(list);

        int r=0;

        quizzes[list.get(r)] = new Physques1(list.get(r), "問", "", R.drawable.p1, new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+1)] = new Physques1(list.get(r+1), "問", "", R.drawable.p2, new String[]{"(1)", "(2)", "(3)", "(4)"}, 2);
        quizzes[list.get(r+2)] = new Physques1(list.get(r+2), "問", "", R.drawable.p3, new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);

    }

    // 問題を取得する
    public static Physques1 getQuiz(int num) {
        if (num >= quizzes.length) {
            return null;
        }
        return quizzes[num];
    }
}
