package com.example.cloud.sheep2;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Global extends Application {
    //グローバルに使用する変数たち
    int x,m,sub;
    //ぜんぶ初期化するメソッド
    @Override
    public void onCreate(){
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfig);
    }
    public void GlobalsAllInit() {
        x=0;
        m=0;
        sub=0;
    }
}
