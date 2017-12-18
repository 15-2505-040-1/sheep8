package com.example.cloud.sheep2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import static com.example.cloud.sheep2.R.id.an1;

public class BokuActivity extends AppCompatActivity {

    Global global;
    ImageView i1,i2,i3,i4,i5,i6;
    private Realm mRealm;
    Random r1 = new Random();
    Random r2 = new Random();
    private float n,m,s,t,x,y;
    private final Handler handler = new Handler();

    ImageView im[] = new ImageView[3];
    ImageView bs[] = new ImageView[3];

    MediaPlayer mMediaPlayer;



    public class Move1 implements Runnable{


        public void run() {
            n = r1.nextInt(100);
            m = r2.nextInt(300);
            TranslateAnimation trans = new TranslateAnimation(0, n, 0, m);
            trans.setDuration(3000);
            trans.setRepeatCount(-1);
            trans.setInterpolator(new BounceInterpolator());
            trans.setInterpolator(new CycleInterpolator(Animation.INFINITE));
            trans.setRepeatCount(1);
            trans.setFillAfter(true);
            i6.startAnimation(trans);
        }

    }
    public class Move2 implements Runnable{
        public void run() {
            s = r1.nextInt(100);
            t = r2.nextInt(300);
            n = r1.nextInt(100);
            m = r2.nextInt(300);
            TranslateAnimation trans = new TranslateAnimation(0, n, 0, m);
            TranslateAnimation trans2 = new TranslateAnimation(0, s, 0, t);
            trans.setDuration(4000);
            trans.setRepeatCount(-1);
            trans.setInterpolator(new BounceInterpolator());
            trans.setInterpolator(new CycleInterpolator(Animation.INFINITE));
            trans.setFillAfter(true);
            trans2.setDuration(4000);
            trans2.setRepeatCount(-1);
            trans2.setInterpolator(new BounceInterpolator());
            trans2.setInterpolator(new CycleInterpolator(Animation.INFINITE));
            trans2.setFillAfter(true);
            i1.startAnimation(trans);
            i2.startAnimation(trans2);
        }

    }

    public class Move3 implements Runnable{
        public void run() {
            s = r1.nextInt(100);
            t = r2.nextInt(300);
            n = r1.nextInt(100);
            m = r2.nextInt(300);
            x = r1.nextInt(100);
            y = r2.nextInt(300);
            TranslateAnimation trans3 = new TranslateAnimation(0, x, 0, y);
            TranslateAnimation trans = new TranslateAnimation(0, n, 0, m);
            TranslateAnimation trans2 = new TranslateAnimation(0, s, 0, t);
            trans.setDuration(4000);
            trans.setRepeatCount(-1);
            trans.setInterpolator(new BounceInterpolator());
            trans.setInterpolator(new CycleInterpolator(Animation.INFINITE));
            trans.setFillAfter(true);
            trans2.setDuration(4000);
            trans2.setRepeatCount(-1);
            trans2.setInterpolator(new BounceInterpolator());
            trans2.setInterpolator(new CycleInterpolator(Animation.INFINITE));
            trans2.setFillAfter(true);
            trans3.setDuration(4000);
            trans3.setRepeatCount(-1);
            trans3.setInterpolator(new BounceInterpolator());
            trans3.setInterpolator(new CycleInterpolator(Animation.INFINITE));
            trans3.setFillAfter(true);
            i3.startAnimation(trans3);
            i2.startAnimation(trans2);
            i1.startAnimation(trans);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boku);
        mMediaPlayer= MediaPlayer.create(this,R.raw.mattari);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();

        i1=(ImageView) findViewById(an1);
        i2=(ImageView) findViewById(R.id.an2);
        i3=(ImageView) findViewById(R.id.an3);
        i4=(ImageView) findViewById(R.id.an4);
        i5=(ImageView) findViewById(R.id.an5);
        i6=(ImageView) findViewById(R.id.an6);



        global = (Global) this.getApplication();

        mRealm = Realm.getDefaultInstance();

        RealmQuery<Animal> query1 = mRealm.where(Animal.class);
        query1.equalTo("name", "羊");
        final RealmResults<Animal> result1 = query1.findAll();
        RealmQuery<Animal> query2 = mRealm.where(Animal.class);
        query2.equalTo("name", "黒羊");
        final RealmResults<Animal> result2 = query2.findAll();
        RealmQuery<Animal> query3 = mRealm.where(Animal.class);
        query3.equalTo("name", "豚");
        final RealmResults<Animal> result3 = query3.findAll();
        RealmQuery<Animal> query4 = mRealm.where(Animal.class);
        query4.equalTo("name", "鶏");
        final RealmResults<Animal> result4 = query4.findAll();
        RealmQuery<Animal> query5 = mRealm.where(Animal.class);
        query5.equalTo("name", "牛");
        final RealmResults<Animal> result5 = query5.findAll();
        RealmQuery<Animal> query6 = mRealm.where(Animal.class);
        query6.equalTo("name", "馬");
        final RealmResults<Animal> result6 = query6.findAll();

        Animal animal1=result1.get(0);
        if(animal1.isBo()==true){
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.hitsuji);
            i1.setImageBitmap(bmitem);
            i1.setVisibility(View.VISIBLE);
            n = r1.nextInt(150);
            m = r2.nextInt(300);
            TranslateAnimation trans = new TranslateAnimation(0, n, 0, m);
            trans.setDuration(4500);
            trans.setRepeatCount(-1);
            trans.setInterpolator(new BounceInterpolator());
            trans.setInterpolator(new CycleInterpolator(Animation.INFINITE));
            trans.setFillAfter(true);
            i1.startAnimation(trans);
        }

        Animal animal2=result2.get(0);
        if(animal2.isBo()==true){
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.kurohiysuji);
            i2.setImageBitmap(bmitem);
            i2.setVisibility(View.VISIBLE);
            n = r1.nextInt(150);
            m = r2.nextInt(300);
            TranslateAnimation trans = new TranslateAnimation(0, n, 0, m);
            trans.setDuration(3300);
            trans.setRepeatCount(-1);
            trans.setInterpolator(new BounceInterpolator());
            trans.setInterpolator(new CycleInterpolator(Animation.INFINITE));
            trans.setFillAfter(true);
            i2.startAnimation(trans);
        }
        Animal animal3=result3.get(0);
        if(animal3.isBo()==true){
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.buta);
            i3.setImageBitmap(bmitem);
            i3.setVisibility(View.VISIBLE);
            n = r1.nextInt(150);
            m = r2.nextInt(300);
            TranslateAnimation trans = new TranslateAnimation(0, n, 0, m);
            trans.setDuration(6000);
            trans.setRepeatCount(-1);
            trans.setInterpolator(new BounceInterpolator());
            trans.setInterpolator(new CycleInterpolator(Animation.INFINITE));
            trans.setFillAfter(true);
            i3.startAnimation(trans);
        }
        Animal animal4=result4.get(0);
        if(animal4.isBo()==true){
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.niwatori);
            i4.setImageBitmap(bmitem);
            i4.setVisibility(View.VISIBLE);
            n = r1.nextInt(150);
            m = r2.nextInt(300);
            TranslateAnimation trans = new TranslateAnimation(0, n, 0, m);
            trans.setDuration(5000);
            trans.setRepeatCount(-1);
            trans.setInterpolator(new BounceInterpolator());
            trans.setInterpolator(new CycleInterpolator(Animation.INFINITE));
             
            trans.setFillAfter(true);
            i4.startAnimation(trans);
        }
        Animal animal5=result5.get(0);
        if(animal5.isBo()==true){
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.ushi);
            i5.setImageBitmap(bmitem);
            i5.setVisibility(View.VISIBLE);
            n = r1.nextInt(150);
            m = r2.nextInt(300);
            TranslateAnimation trans = new TranslateAnimation(0, n, 0, m);
            trans.setDuration(3700);
            trans.setRepeatCount(Animation.INFINITE);
            trans.setInterpolator(new BounceInterpolator());
            trans.setInterpolator(new CycleInterpolator(Animation.INFINITE));
            trans.setFillAfter(true);
            i5.startAnimation(trans);
        }
        Animal animal6=result6.get(0);
        if(animal6.isBo()==true){
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.uma);
            i6.setImageBitmap(bmitem);
            i6.setVisibility(View.VISIBLE);
            n = r1.nextInt(150);
            m = r2.nextInt(300);
            TranslateAnimation trans = new TranslateAnimation(0, n, 0, m);
            trans.setDuration(4000);
            trans.setRepeatCount(Animation.INFINITE);
            trans.setInterpolator(new BounceInterpolator());
            trans.setInterpolator(new CycleInterpolator(Animation.INFINITE));
            trans.setFillAfter(true);
            i6.startAnimation(trans);
        }



        
/*
        
        if(global.z==1){
            //sheepw.setVisibility(View.VISIBLE);
            if(global.animal[0]==1) {
                sheep  = BitmapFactory.decodeResource(getResources(), R.drawable.buyo);
                im[0].setImageBitmap(sheep);
                handler.post(new Move1());
            }
            if(global.animal[0]==2) {
                sheep  = BitmapFactory.decodeResource(getResources(), R.drawable.buyo);
                im[0].setImageBitmap(sheep);
                im[1].setImageBitmap(sheep);
                handler.post(new Move2());
            }
            if(global.animal[0]==3) {
                sheep  = BitmapFactory.decodeResource(getResources(), R.drawable.buyo);
                im[0].setImageBitmap(sheep);
                im[1].setImageBitmap(sheep);
                im[2].setImageBitmap(sheep);
                handler.post(new Move3());
            }
        }

        if(global.z==2){
            //sheepw.setVisibility(View.VISIBLE);
            if(global.animal[1]==1) {
                sheepb  = BitmapFactory.decodeResource(getResources(), R.drawable.buyo);
                bs[0].setImageBitmap(sheepb);
                im[0]=bs[0];
                handler.post(new Move1());
            }
            if(global.animal[1]==2) {
                sheepb = BitmapFactory.decodeResource(getResources(), R.drawable.buyo);
                bs[0].setImageBitmap(sheepb);
                bs[1].setImageBitmap(sheepb);
                im[0]=bs[0];
                im[1]=bs[1];
                handler.post(new Move2());
            }
            if(global.animal[1]==3) {
                sheepb  = BitmapFactory.decodeResource(getResources(), R.drawable.buyo);
                bs[0].setImageBitmap(sheepb);
                bs[1].setImageBitmap(sheepb);
                bs[2].setImageBitmap(sheepb);
                im[0]=bs[0];
                im[1]=bs[1];
                im[2]=bs[2];
                handler.post(new Move3());
            }
        }*/

    }
    public void onShop(View view1) {
        mMediaPlayer.stop();
        Intent intent = new Intent(getApplication(), ShopActivity.class);
        startActivity(intent);
    }

    public void onBack(View view1) {
        mMediaPlayer.stop();
        Intent intent = new Intent(getApplication(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction()==KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    // ダイアログ表示など特定の処理を行いたい場合はここに記述
                    // 親クラスのdispatchKeyEvent()を呼び出さずにtrueを返す
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

}