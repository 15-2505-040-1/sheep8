package com.example.cloud.sheep2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import static com.example.cloud.sheep2.R.id.item;

public class ResultActivity extends AppCompatActivity {


    Random r = new Random();
    Random r2 = new Random();
    int n,m;

    int k=0;

    Realm mRealm;

    private AlphaAnimation alpha;
    private RotateAnimation rotate;
    private ScaleAnimation scale1;
    private ScaleAnimation scale2;
    AnimationSet set = new AnimationSet(true);

    Global global;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mRealm=Realm.getDefaultInstance();


        ImageButton item = (ImageButton)findViewById(R.id.item);
        item.setVisibility(View.INVISIBLE);

        global = (Global) this.getApplication();
        global.GlobalsAllInit();
    }
    public void onOpen(View v){
        ImageButton imbt = (ImageButton)findViewById(R.id.close);

        Bitmap bmpt = BitmapFactory.decodeResource(getResources(), R.drawable.takarabako02);
        imbt.setImageBitmap(bmpt);

        imbt.setEnabled(false);

        n = r.nextInt(100);
        m = r2.nextInt(5);

        if(n>=1 && n<20) {
            ImageButton item = (ImageButton) findViewById(R.id.item);
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item1);
            item.setImageBitmap(bmitem);
            //item.setVisibility(View.VISIBLE);
            alpha = new AlphaAnimation(0, 1);
            rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            scale1 = new ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            set.addAnimation(alpha);
            set.addAnimation(rotate);
            set.addAnimation(scale1);
            //set.setInterpolator(new BounceInterpolator());
            set.setInterpolator(new AnticipateOvershootInterpolator());
            set.setDuration(1000);
            set.setFillAfter(true);
            item.startAnimation(set);
            RealmQuery<Item> query = mRealm.where(Item.class);
            query.equalTo("name", "ハエ");
            RealmResults<Item> result = query.findAll();
            if(result.size() > 0) {
                final RealmResults<Item> results = mRealm.where(Item.class).equalTo("name", "ハエ").findAll();
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Item item=results.first();
                        item.setK(Integer.toString(Integer.valueOf(item.getK()).intValue()+1));
                    }
                });
            }
        }if(n>=20 && n<=50) {

            ImageButton item = (ImageButton) findViewById(R.id.item);
            RealmQuery<Item> query = mRealm.where(Item.class);
            query.equalTo("name", "キノコ");
            RealmResults<Item> result = query.findAll();
            if (result.size() > 0) {
                final RealmResults<Item> results = mRealm.where(Item.class).equalTo("name", "キノコ").findAll();
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Item item = results.first();
                        item.setK(Integer.toString(Integer.valueOf(item.getK()).intValue() + 1));
                    }
                });
            }
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.kinoko);
            item.setImageBitmap(bmitem);
        }
            if(n>=20 && n<=50) {

                ImageButton item = (ImageButton) findViewById(R.id.item);
                RealmQuery<Item> query = mRealm.where(Item.class);
                query.equalTo("name", "おもちゃ");
                RealmResults<Item> result = query.findAll();
                if (result.size() > 0) {
                    final RealmResults<Item> results = mRealm.where(Item.class).equalTo("name", "おもちゃ").findAll();
                    mRealm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            Item item = results.first();
                            item.setK(Integer.toString(Integer.valueOf(item.getK()).intValue() + 1));
                        }
                    });
                }

                Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.omocha);
                item.setImageBitmap(bmitem);
            }
                if(n>=20 && n<=50){

                    ImageButton item = (ImageButton) findViewById(R.id.item);
                Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.vuvu);
                item.setImageBitmap(bmitem);
            }

        ImageButton item = (ImageButton) findViewById(R.id.item);
            alpha = new AlphaAnimation(0, 1);
            rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            scale1 = new ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            set.addAnimation(alpha);
            set.addAnimation(rotate);
            set.addAnimation(scale1);
            //set.setInterpolator(new BounceInterpolator());
            set.setInterpolator(new AnticipateOvershootInterpolator());
            set.setDuration(1000);
            set.setFillAfter(true);
            item.startAnimation(set);
        }


    public void onGet(View view){
        Intent intent = new Intent(getApplication(), MainActivity.class);
        startActivity(intent);
    }
}
