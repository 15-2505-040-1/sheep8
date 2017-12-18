package com.example.cloud.sheep2;

import android.content.Intent;
import android.media.MediaPlayer;
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

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private AlphaAnimation alpha;
    private ScaleAnimation scale;
    private RotateAnimation rotate;
    AnimationSet set=new AnimationSet(true);
    private Realm mRealm;
    public MediaPlayer mMediaPlayer;

    Global global;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        mSoundId = mSoundPool.load(getApplicationContext(), R.raw.nohohon, 0);
        */
        // ((TextView)findViewById(textView)).setTypeface(Typeface.createFromAsset(getAssets(), "数式フォントver1.1.ttf"));
        mMediaPlayer= MediaPlayer.create(this,R.raw.haru);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();

        mRealm = Realm.getDefaultInstance();
        RealmQuery<Item> query = mRealm.where(Item.class);
        query.equalTo("name", "キノコ");
        RealmResults<Item> result = query.findAll();
        if(result.size() > 0) {

        }else{
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Item.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Item item = realm.createObject(Item.class, new Long(nextId));
                    item.setName("キノコ");
                    item.setDetail("繁殖力の高いキノコ。\n食べても体が大きくなったりはしない。");
                    item.setK(Integer.toString(0));
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Item.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Item item = realm.createObject(Item.class, new Long(nextId));
                    item.setName("木馬");
                    item.setDetail("アインシュタインが3歳の頃に使っていたといわれる木馬。\n実は三角木馬。");
                    item.setK(Integer.toString(0));
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Item.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Item item = realm.createObject(Item.class, new Long(nextId));
                    item.setName("葉っぱ");
                    item.setDetail("ただの葉っぱです。\n使い道は特にない。");
                    item.setK(Integer.toString(0));
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Item.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Item item = realm.createObject(Item.class, new Long(nextId));
                    item.setName("卵");
                    item.setDetail("エチオピアで拾ってきたが、何の卵かはわからない。\n若干腐乱臭がする。");
                    item.setK(Integer.toString(0));
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Item.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Item item = realm.createObject(Item.class, new Long(nextId));
                    item.setName("鈴");
                    item.setDetail("某人間型ロボットから引きちぎってきた代物。\nオークションにでも出すか。");
                    item.setK(Integer.toString(0));
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Item.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Item item = realm.createObject(Item.class, new Long(nextId));
                    item.setName("骨");
                    item.setDetail("じぃちゃんの骨。\n骨太である。");
                    item.setK(Integer.toString(0));
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Item.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Item item = realm.createObject(Item.class, new Long(nextId));
                    item.setName("ミルク");
                    item.setDetail("カルシウム豊富で骨が丈夫になりそうだ。\nじぃちゃんがよく飲んでいた。");
                    item.setK(Integer.toString(0));
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Item.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Item item = realm.createObject(Item.class, new Long(nextId));
                    item.setName("ネズミ");
                    item.setDetail("哺乳類ネズミ目（齧歯目）の数科の総称である。ネズミのほとんどが夜行性である。また、ネズミの門歯は一生伸び続けるというげっ歯類の特徴を持っているため、常に何か硬いものをよくk(ry\n結論、出っ歯である。");
                    item.setK(Integer.toString(0));
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Item.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Item item = realm.createObject(Item.class, new Long(nextId));
                    item.setName("チョコ");
                    item.setDetail("水1000ccにこのルーを1個溶かしたらおいしいカレーがでｋ。。。あ、これチョコじゃん。");
                    item.setK(Integer.toString(0));
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Item.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Item item = realm.createObject(Item.class, new Long(nextId));
                    item.setName("ラッパ");
                    item.setDetail("パンツ");
                    item.setK(Integer.toString(0));
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Item.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Item item = realm.createObject(Item.class, new Long(nextId));
                    item.setName("わたあめ");
                    item.setDetail("じぃちゃんが嫌いなもの。カルシウムには関係ないらしい。");
                    item.setK("0");
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Animal.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Animal animal = realm.createObject(Animal.class, new Long(nextId));
                    animal.setName("羊");
                    animal.setDetail("羊だよ");
                    animal.setBo(false);
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Animal.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Animal animal = realm.createObject(Animal.class, new Long(nextId));
                    animal.setName("黒羊");
                    animal.setDetail("黒羊だよ");
                    animal.setBo(false);
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Animal.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Animal animal = realm.createObject(Animal.class, new Long(nextId));
                    animal.setName("豚");
                    animal.setDetail("豚だよ");
                    animal.setBo(false);
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Animal.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Animal animal = realm.createObject(Animal.class, new Long(nextId));
                    animal.setName("鶏");
                    animal.setDetail("鶏だよ");
                    animal.setBo(false);
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Animal.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Animal animal = realm.createObject(Animal.class, new Long(nextId));
                    animal.setName("牛");
                    animal.setDetail("牛だよ");
                    animal.setBo(false);
                }
            });
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Animal.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Animal animal = realm.createObject(Animal.class, new Long(nextId));
                    animal.setName("馬");
                    animal.setDetail("馬だよ");
                    animal.setBo(false);
                }
            });
        }

        }



    public void openQuiz(View view1) {
        mMediaPlayer.stop();

//        mSoundPool.play(mSoundId, 1.0F, 1.0F, 0, 0, 1.0F);
        Button bt = (Button)findViewById(R.id.button);
        alpha=new AlphaAnimation(1,0);
        scale=new ScaleAnimation(1,0,1,0, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotate = new RotateAnimation(0, 360,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        set.addAnimation(alpha);
        set.addAnimation(rotate);
        set.addAnimation(scale);
        set.setInterpolator(new AnticipateOvershootInterpolator());
        rotate.setDuration(1000);
        rotate.setRepeatCount(0);
        rotate.setFillAfter(true);
        bt.startAnimation(set);
        Intent intent = new Intent(getApplication(), SubjectActivity.class);
        startActivity(intent);
    }

    public void onDetele(View view){
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.deleteAll();
            }
        });
    }
    public void onItem(View view1) {
        Intent intent = new Intent(getApplication(), DatabaseActivity.class);
        startActivity(intent);
    }

    public void onAnimal(View view1) {
        Intent intent = new Intent(getApplication(), AnimalActivity.class);
        startActivity(intent);
    }

    public void onBoku(View view1) {
        mMediaPlayer.stop();
        Intent intent = new Intent(getApplication(), BokuActivity.class);
        startActivity(intent);
    }
    public void onInventory(View view1) {
        Intent intent = new Intent(getApplication(), InventoryActivity.class);
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

