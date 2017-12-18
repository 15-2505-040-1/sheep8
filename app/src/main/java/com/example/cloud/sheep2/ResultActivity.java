package com.example.cloud.sheep2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

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
    public void onOpen(View v) {
        ImageButton imbt = (ImageButton) findViewById(R.id.close);

        Button btn=(Button)findViewById(R.id.button8);
        btn.setVisibility(View.VISIBLE);
        Bitmap bmpt = BitmapFactory.decodeResource(getResources(), R.drawable.takarabako02);
        imbt.setImageBitmap(bmpt);

        imbt.setEnabled(false);

        n = r.nextInt(100);
        m = r2.nextInt(5);

        if (n >= 1 && n <= 15) {
            ImageButton item = (ImageButton) findViewById(R.id.item);
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item1);
            item.setImageBitmap(bmitem);
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
            query.equalTo("name", "葉っぱ");
            RealmResults<Item> result = query.findAll();
            if (result.size() > 0) {
                final RealmResults<Item> results = mRealm.where(Item.class).equalTo("name", "葉っぱ").findAll();
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Item item = results.first();
                        item.setK(Integer.toString(Integer.valueOf(item.getK()).intValue() + 1));
                    }
                });
            }
        } else if (n >= 16 && n <= 22) {
            ImageButton item = (ImageButton) findViewById(R.id.item);
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item3);
            item.setImageBitmap(bmitem);
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
            query.equalTo("name", "ラッパ");
            RealmResults<Item> result = query.findAll();
            if (result.size() > 0) {
                final RealmResults<Item> results = mRealm.where(Item.class).equalTo("name", "ラッパ").findAll();
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Item item = results.first();
                        item.setK(Integer.toString(Integer.valueOf(item.getK()).intValue() + 1));
                    }
                });
            }
        } else if (n >= 23 && n <= 27) {
            ImageButton item = (ImageButton) findViewById(R.id.item);
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item5);
            item.setImageBitmap(bmitem);
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
            query.equalTo("name", "卵");
            RealmResults<Item> result = query.findAll();
            if (result.size() > 0) {
                final RealmResults<Item> results = mRealm.where(Item.class).equalTo("name", "卵").findAll();
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Item item = results.first();
                        item.setK(Integer.toString(Integer.valueOf(item.getK()).intValue() + 1));
                    }
                });
            }
        } else if (n >= 28 && n <= 35) {
            ImageButton item = (ImageButton) findViewById(R.id.item);
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item2);
            item.setImageBitmap(bmitem);
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
        } else if (n == 36) {
            ImageButton item = (ImageButton) findViewById(R.id.item);
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item4);
            item.setImageBitmap(bmitem);
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
            query.equalTo("name", "木馬");
            RealmResults<Item> result = query.findAll();
            if (result.size() > 0) {
                final RealmResults<Item> results = mRealm.where(Item.class).equalTo("name", "木馬").findAll();
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Item item = results.first();
                        item.setK(Integer.toString(Integer.valueOf(item.getK()).intValue() + 1));
                    }
                });
            }
        } else if (n >= 37 && n <= 41) {
            ImageButton item = (ImageButton) findViewById(R.id.item);
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item7);
            item.setImageBitmap(bmitem);
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
            query.equalTo("name", "鈴");
            RealmResults<Item> result = query.findAll();
            if (result.size() > 0) {
                final RealmResults<Item> results = mRealm.where(Item.class).equalTo("name", "鈴").findAll();
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Item item = results.first();
                        item.setK(Integer.toString(Integer.valueOf(item.getK()).intValue() + 1));
                    }
                });
            }
        } else if (n >= 42 && n <= 56) {
            ImageButton item = (ImageButton) findViewById(R.id.item);
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item1);
            item.setImageBitmap(bmitem);
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
            query.equalTo("name", "葉っぱ");
            RealmResults<Item> result = query.findAll();
            if (result.size() > 0) {
                final RealmResults<Item> results = mRealm.where(Item.class).equalTo("name", "葉っぱ").findAll();
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Item item = results.first();
                        item.setK(Integer.toString(Integer.valueOf(item.getK()).intValue() + 1));
                    }
                });
            }
        } else if (n >= 57 && n <= 60) {
            ImageButton item = (ImageButton) findViewById(R.id.item);
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item9);
            item.setImageBitmap(bmitem);
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
            query.equalTo("name", "ミルク");
            RealmResults<Item> result = query.findAll();
            if (result.size() > 0) {
                final RealmResults<Item> results = mRealm.where(Item.class).equalTo("name", "ミルク").findAll();
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Item item = results.first();
                        item.setK(Integer.toString(Integer.valueOf(item.getK()).intValue() + 1));
                    }
                });
            }
        } else if (n >= 61 && n <= 65) {
            ImageButton item = (ImageButton) findViewById(R.id.item);
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item6);
            item.setImageBitmap(bmitem);
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
            query.equalTo("name", "骨");
            RealmResults<Item> result = query.findAll();
            if (result.size() > 0) {
                final RealmResults<Item> results = mRealm.where(Item.class).equalTo("name", "骨").findAll();
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Item item = results.first();
                        item.setK(Integer.toString(Integer.valueOf(item.getK()).intValue() + 1));
                    }
                });
            }
        } else if (n >= 66 && n <= 75) {
            ImageButton item = (ImageButton) findViewById(R.id.item);
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.nezumi);
            item.setImageBitmap(bmitem);
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
            query.equalTo("name", "ネズミ");
            RealmResults<Item> result = query.findAll();
            if (result.size() > 0) {
                final RealmResults<Item> results = mRealm.where(Item.class).equalTo("name", "ネズミ").findAll();
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Item item = results.first();
                        item.setK(Integer.toString(Integer.valueOf(item.getK()).intValue() + 1));
                    }
                });
            }
        } else if (n >= 76 && n <= 90) {
            ImageButton item = (ImageButton) findViewById(R.id.item);
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item10);
            item.setImageBitmap(bmitem);
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
            query.equalTo("name", "わたあめ");
            RealmResults<Item> result = query.findAll();
            if (result.size() > 0) {
                final RealmResults<Item> results = mRealm.where(Item.class).equalTo("name", "わたあめ").findAll();
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Item item = results.first();
                        item.setK(Integer.toString(Integer.valueOf(item.getK()).intValue() + 1));
                    }
                });
            }
        } else if (n >= 91 && n <= 100) {
            ImageButton item = (ImageButton) findViewById(R.id.item);
            Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item8);
            item.setImageBitmap(bmitem);
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
            query.equalTo("name", "チョコ");
            RealmResults<Item> result = query.findAll();
            if (result.size() > 0) {
                final RealmResults<Item> results = mRealm.where(Item.class).equalTo("name", "チョコ").findAll();
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Item item = results.first();
                        item.setK(Integer.toString(Integer.valueOf(item.getK()).intValue() + 1));
                    }
                });
            }
        }
    }

    public void onGet(View view){
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
