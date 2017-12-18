package com.example.cloud.sheep2;

import android.app.Application;
import android.media.MediaPlayer;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Global extends Application {
    //グローバルに使用する変数たち
    int x,m,y,sub;
    MediaPlayer menu;

    //ぜんぶ初期化するメソッド
    @Override
    public void onCreate(){
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfig);
    }
    public void GlobalsAllInit() {
        menu=MediaPlayer.create(this,R.raw.haru);
        x=0;
        m=0;
        y=0;
        sub=0;
    }
}
