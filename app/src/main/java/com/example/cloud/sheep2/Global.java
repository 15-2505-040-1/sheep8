package com.example.cloud.sheep2;

import android.app.Application;

public class Global extends Application {
    //グローバルに使用する変数たち
    int x,m,sub;
    //ぜんぶ初期化するメソッド
    public void GlobalsAllInit() {
        x=0;
        m=0;
        sub=0;
    }
}
