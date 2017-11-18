package com.example.cloud.sheep2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by cloud on 2017/11/08.
 */

public class Quiz implements Serializable {
        int q_num; // 問題番号
        String q_string; // 第○問というString
        String question; //問題文
        int image; // 画像ID
        String[] choices = new String[4]; // 選択肢
        int answer_index; // 正解の選択肢


        private static Quiz[] quizzes = new Quiz[4]; // クイズの配列

        private Quiz(int q_num, String q_string, String question, int image, String[] choices, int answer_index) {
                this.q_num = q_num;
                this.q_string = q_string;
                this.question = question;
                this.image = image;
                this.choices = choices;
                this.answer_index = answer_index;
        }

        // 問題の登録(ここでは1問のみ)
        public static void init() {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = 0; i <= 3; i++) {
                        list.add(i);
                }
                //listをシャッフル
                Collections.shuffle(list);

                int r=0;

                quizzes[list.get(r)] = new Quiz(list.get(r), "問", "これどこの国でしょう", R.drawable.france, new String[]{"イタリア", "フランス", "ロシア", "オランダ"}, 1);
                quizzes[list.get(r+1)] = new Quiz(list.get(r+1), "問", "これどこの国でしょう", R.drawable.denmark, new String[]{"デンマーク", "スウェーデン", "ノルウェー", "フィンランド"}, 0);
                quizzes[list.get(r+2)] = new Quiz(list.get(r+2), "問", "これどこの国でしょう", R.drawable.new_zealand, new String[]{"ニュージーランド", "スイス", "カナダ", "オーストラリア"}, 0);
                quizzes[list.get(r+3)] = new Quiz(list.get(r+3), "問", "これどこの国でしょう", R.drawable.japan, new String[]{"中国", "韓国", "アメリカ", "日本"}, 3);

        }

        // 問題を取得する
        public static Quiz getQuiz(int num) {
                if (num >= quizzes.length) {
                        return null;
                }
                return quizzes[num];
        }
}



