package com.example.cloud.sheep2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class BokuActivity extends AppCompatActivity {

    Global global;
    private Realm mRealm;
    ImageView img;
    Random r1 = new Random();
    Random r2 = new Random();
    private float n,m,s,t;
    private int a,b;
    private final Handler handler = new Handler();
    private final Handler handler2 = new Handler();


    public class Move1 implements Runnable{

        public void run() {
            n = r1.nextInt(100);
            m = r2.nextInt(300);
            TranslateAnimation trans = new TranslateAnimation(0, n, 0, m);
            trans.setDuration(3000);
            trans.setRepeatCount(1);
            trans.setFillAfter(true);
            img.startAnimation(trans);
        }

    }
    public class Move2 implements Runnable{
        public void run() {
            s = r1.nextInt(100);
            t = r2.nextInt(300);
            TranslateAnimation trans2 = new TranslateAnimation(0, s, 0, t);
            trans2.setDuration(4000);
            trans2.setRepeatCount(0);
            trans2.setInterpolator(new BounceInterpolator());
            trans2.setFillAfter(true);
            img.startAnimation(trans2);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boku);

        img = (ImageView)findViewById(R.id.sheep1);

        global = (Global) this.getApplication();

        //n = r1.nextInt(100);
        //m = r2.nextInt(300);


        img.setVisibility(View.INVISIBLE);
        a=1;
        b=0;

        mRealm = Realm.getDefaultInstance();
        RealmQuery<Item> query = mRealm.where(Item.class);
        query.equalTo("name", "キノコ");
        RealmResults<Item> result = query.findAll();



        //if(global.a[1]==1 || global.a[2]==1){
            //ImageView img = (ImageView)findViewById(R.id.sheep1);
            img.setVisibility(View.VISIBLE);
            for(int c=0 ; c < 100 ; c++) {
                    handler.post(new Move1());
                    //a = 0;
                    //b = 1;
                 /*else if (b == 1) {
                    handler.post(new Move2());
                    a = 1;
                    b = 0;
                }*/

        }

    }
    public void onShop(View view1) {
        Intent intent = new Intent(getApplication(), ShopActivity.class);
        startActivity(intent);
    }


}
