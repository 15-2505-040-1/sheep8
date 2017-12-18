package com.example.cloud.sheep2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by cloud on 2017/11/15.
 */

public class Physques3 implements Serializable {
    int q_num; // 問題番号
    String q_string; // 第○問というString
    String question; //問題文
    int image; // 画像ID
    String[] choices = new String[4]; // 選択肢
    int answer_index; // 正解の選択肢


    private static Physques3[] quizzes = new Physques3[100]; // クイズの配列

    private Physques3(int q_num, String question, String[] choices, int answer_index) {
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
        for (int i = 0; i <= 20; i++) {
            list.add(i);
        }
        //listをシャッフル
        Collections.shuffle(list);

        int r=0;
        quizzes[list.get(r)] = new Physques3(list.get(r),"ハギソフィア大聖堂がある都市は？\n\n1.ロンドン　\t2.ウィーン　\n\n3.イスタンブール　\t4.グラナダ", new String[]{"(1)", "(2)", "(3)", "(4)"}, 2);
        quizzes[list.get(r+1)] = new Physques3(list.get(r+1),"OPECの本部が都市はウィーンですが、OAPECの本部があるのは？\n\n1.リヤド　\t2.ウィーン　\n\n3.クウェート　\t4.シンガポール", new String[]{"(1)", "(2)", "(3)", "(4)"}, 2);
        quizzes[list.get(r+2)] = new Physques3(list.get(r+2),"2008年11月に「第1回金融サミット」が開催された都市は？\n\n1.フランクフルト　\t2.ワシントンD．C　\n\n3.ロンドン　\t4.東京", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+3)] = new Physques3(list.get(r+3),"世界で最も深い湖は？\n\n1.チャド湖　\t2.チチカカ湖　\n\n3.ビクトリア湖　\t4.バイカル湖", new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+4)] = new Physques3(list.get(r+4),"日本の国道で、次のうち欠番となっているのはどれ？\n\n1.300号線　\t2.100号線　\n\n3.200号線　\t4.400号線", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+5)] = new Physques3(list.get(r+5),"コーヒー豆の生産量が世界一多い国は？\n\n1.コロンビア　\t2.ブラジル　\n\n3.ベトナム　\t4.コートジボワール", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+6)] = new Physques3(list.get(r+6),"日露戦争の講和会議が開かれた都市「ポーツマス」があるのは？\n\n1.イギリス　\t2.フランス　\n\n3.ロシア　\t4.アメリカ", new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+7)] = new Physques3(list.get(r+7),"赤十字マークの由来となったのはどこの国旗？\n\n1.フランス　\t2.スイス　\n\n3.バチカン　\t4.イタリア", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+8)] = new Physques3(list.get(r+8),"リンゴの生産量が最も多い国は？\n\n1.ブラジル　\t2.スペイン　\n\n3.アメリカ　\t4.中国", new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+9)] = new Physques3(list.get(r+9),"世界最大の湖、カスピ海に面している国は？　　\n\n1.ウズベキスタン　\t2.アフガニスタン　\n\n3.タジキスタン　\t4.トルクメニスタン", new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+10)] = new Physques3(list.get(r+10),"次のうち国連安全保障理事会の常任理事国でないのは？\n\n1.イギリス　\t2.アメリカ　\n\n3.フランス　\t4.ドイツ", new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+11)] = new Physques3(list.get(r+11),"地球上の経度を表す東経と西経はそれぞれ何度まである？\n\n1.240度　\t2.90度　\n\n3.360度　\t4.180度", new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+12)] = new Physques3(list.get(r+12),"国連サッカー連盟、FIFAがある国は？\n\n1.イギリス　\t2.ドイツ　\n\n3.スイス　\t4.オランダ", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+13)] = new Physques3(list.get(r+13),"2006年に国土地理院が定めた新しい地図記号は風車ともう一つは何？\n\n1.ヘリポート　\t2.老人ホーム　\n\n3.携帯電話基地局　\t4.充電スタンド", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+14)] = new Physques3(list.get(r+14),"カカオ豆の生産量が世界一多い国は？\n\n1.コートジボワール　\t2.ブラジル　\n\n3.インドネシア　\t4.コロンビア", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+15)] = new Physques3(list.get(r+15),"次のうち、周囲がすべて海に囲まれている国は？\n\n1.フィリピン　\t2.アルゼンチン　\n\n3.タイ　\t4.フィンランド", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+16)] = new Physques3(list.get(r+16),"次のうち、主要国際会議（サミット）に参加していない国は？\n\n1.イタリア　\t2.中国　\n\n3.ロシア共和国　\t4.カナダ", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+17)] = new Physques3(list.get(r+17),"史上最大の海難事故を起こした豪華客船「タイタニック号」が向かっていた目的地は？\n\n1.ニューヨーク　\t2.ロサンゼルス　\n\n3.ボストン　\t4.サンディエゴ", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+18)] = new Physques3(list.get(r+18),"地図記号で、卍の記号で表されているものは？\n\n1.寺院　\t2.学校　\n\n3.病院　\t4.交番", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+19)] = new Physques3(list.get(r+19),"次の水産物のうち、日本の輸入額が最も多いのは？\n\n1.カニ　\t2.ウナギ　\n\n3.エビ　\t4.マグロ", new String[]{"(1)", "(2)", "(3)", "(4)"}, 2);
        quizzes[list.get(r+20)] = new Physques3(list.get(r+20),"アメリカの五大湖の中で一番面積が大きいのは？\n\n1.スペリオル湖　\t2.エリー湖　\n\n3.ヒューロン湖　\t4.ミシガン湖", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);

    }

    // 問題取得
    public static Physques3 getQuiz(int num) {
        if (num >= quizzes.length) {
            return null;
        }
        return quizzes[num];
    }
}
