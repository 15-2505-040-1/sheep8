package com.example.cloud.sheep2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import static com.example.cloud.sheep2.R.id.animal;
import static com.example.cloud.sheep2.R.id.item;

public class ShopActivity extends AppCompatActivity {
    ImageView img;
    TextView txt;
    Button btn;

    Realm mRealm;
    EditText mNameEdit;

    String item1,item2,item3;
    String type,name;
    int a0=0,b0=0,c0=0,a1,b1,c1;

    ImageView huki;
    TextView hukitxt;

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        mMediaPlayer= MediaPlayer.create(this,R.raw.nohohon);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();

        mRealm=Realm.getDefaultInstance();

        img=(ImageView) findViewById(animal) ;
        txt=(TextView) findViewById(item);
        btn=(Button) findViewById(R.id.tradebtn);
        huki=(ImageView) findViewById(R.id.huki);
        hukitxt=(TextView) findViewById(R.id.hukitxt);
    }

    public void SHEEP(View view1) {
        txt.setVisibility(View.VISIBLE);
        txt.setText("生命の葉x1\n骨x1\nわたあめx1");
        btn.setVisibility(View.VISIBLE);
        img.setVisibility(View.VISIBLE);

        Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.hitsuji);
        img.setImageBitmap(bmitem);

        item1="葉っぱ";
        item2="骨";
        item3="わたあめ";

        a0=1;
        b0=1;
        c0=1;

        RealmQuery<Item> query1 = mRealm.where(Item.class);
        query1.equalTo("name", item1);
        RealmResults<Item> result = query1.findAll();
        RealmQuery<Item> query2 = mRealm.where(Item.class);
        query2.equalTo("name", item2);
        RealmResults<Item> result2 = query2.findAll();
        RealmQuery<Item> query3 = mRealm.where(Item.class);
        query3.equalTo("name", item3);
        RealmResults<Item> result3 = query3.findAll();

        Item item1=result.get(0);
        Item item2=result2.get(0);
        Item item3=result3.get(0);

        a1=Integer.valueOf(item1.getK()).intValue();
        b1=Integer.valueOf(item2.getK()).intValue();
        c1=Integer.valueOf(item3.getK()).intValue();

        if(a1>=a0&&b1>=b0&&c1>=c0){
            huki.setVisibility(View.INVISIBLE);
            hukitxt.setVisibility(View.INVISIBLE);
            btn.setEnabled(true);
        }else{
            huki.setVisibility(View.VISIBLE);
            hukitxt.setVisibility(View.VISIBLE);
            btn.setEnabled(false);
        }

        type="羊";
        name="羊";


    }

    public void BLACK(View view1) {

        Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.kurohiysuji);
        img.setImageBitmap(bmitem);
        txt.setVisibility(View.VISIBLE);
        txt.setText("生命の葉x2\nわたあめx1\nチョコx1");
        btn.setVisibility(View.VISIBLE);
        img.setVisibility(View.VISIBLE);

        item1="葉っぱ";
        item2="わたあめ";
        item3="チョコ";

        a0=2;
        b0=1;
        c0=1;

        RealmQuery<Item> query1 = mRealm.where(Item.class);
        query1.equalTo("name", item1);
        RealmResults<Item> result = query1.findAll();
        RealmQuery<Item> query2 = mRealm.where(Item.class);
        query2.equalTo("name", item2);
        RealmResults<Item> result2 = query2.findAll();
        RealmQuery<Item> query3 = mRealm.where(Item.class);
        query3.equalTo("name", item3);
        RealmResults<Item> result3 = query3.findAll();

        Item item1=result.get(0);
        Item item2=result2.get(0);
        Item item3=result3.get(0);

        a1=Integer.valueOf(item1.getK()).intValue();
        b1=Integer.valueOf(item2.getK()).intValue();
        c1=Integer.valueOf(item3.getK()).intValue();

        if(a1>=a0&&b1>=b0&&c1>=c0){
            huki.setVisibility(View.INVISIBLE);
            hukitxt.setVisibility(View.INVISIBLE);
            btn.setEnabled(true);
        }else{
            huki.setVisibility(View.VISIBLE);
            hukitxt.setVisibility(View.VISIBLE);
            btn.setEnabled(false);
        }
        type="黒羊";
        name="黒羊";


    }

    public void PIG(View view1) {
        Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.buta);
        img.setImageBitmap(bmitem);
        txt.setVisibility(View.VISIBLE);
        txt.setText("生命の葉x3\n骨x1\nキノコx1");
        btn.setVisibility(View.VISIBLE);
        img.setVisibility(View.VISIBLE);

        item1="葉っぱ";
        item2="骨";
        item3="キノコ";

        a0=3;
        b0=1;
        c0=1;

        RealmQuery<Item> query1 = mRealm.where(Item.class);
        query1.equalTo("name", item1);
        RealmResults<Item> result = query1.findAll();
        RealmQuery<Item> query2 = mRealm.where(Item.class);
        query2.equalTo("name", item2);
        RealmResults<Item> result2 = query2.findAll();
        RealmQuery<Item> query3 = mRealm.where(Item.class);
        query3.equalTo("name", item3);
        RealmResults<Item> result3 = query3.findAll();

        Item item1=result.get(0);
        Item item2=result2.get(0);
        Item item3=result3.get(0);

        a1=Integer.valueOf(item1.getK()).intValue();
        b1=Integer.valueOf(item2.getK()).intValue();
        c1=Integer.valueOf(item3.getK()).intValue();

        if(a1>=a0&&b1>=b0&&c1>=c0){
            huki.setVisibility(View.INVISIBLE);
            hukitxt.setVisibility(View.INVISIBLE);
            btn.setEnabled(true);
        }else{
            huki.setVisibility(View.VISIBLE);
            hukitxt.setVisibility(View.VISIBLE);
            btn.setEnabled(false);
        }

        type="豚";
        name="豚";

    }

    public void CHICKEN(View view1) {
        Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.niwatori);
        img.setImageBitmap(bmitem);
        txt.setVisibility(View.VISIBLE);
        txt.setText("生命の葉x3\n卵x1\nラッパx1");
        btn.setVisibility(View.VISIBLE);
        img.setVisibility(View.VISIBLE);

        item1="葉っぱ";
        item2="卵";
        item3="ラッパ";

        a0=5;
        b0=1;
        c0=1;

        RealmQuery<Item> query1 = mRealm.where(Item.class);
        query1.equalTo("name", item1);
        RealmResults<Item> result = query1.findAll();
        RealmQuery<Item> query2 = mRealm.where(Item.class);
        query2.equalTo("name", item2);
        RealmResults<Item> result2 = query2.findAll();
        RealmQuery<Item> query3 = mRealm.where(Item.class);
        query3.equalTo("name", item3);
        RealmResults<Item> result3 = query3.findAll();

        Item item1=result.get(0);
        Item item2=result2.get(0);
        Item item3=result3.get(0);

        a1=Integer.valueOf(item1.getK()).intValue();
        b1=Integer.valueOf(item2.getK()).intValue();
        c1=Integer.valueOf(item3.getK()).intValue();

        if(a1>=a0&&b1>=b0&&c1>=c0){
            huki.setVisibility(View.INVISIBLE);
            hukitxt.setVisibility(View.INVISIBLE);
            btn.setEnabled(true);
        }else{
            huki.setVisibility(View.VISIBLE);
            hukitxt.setVisibility(View.VISIBLE);
            btn.setEnabled(false);
        }

        type="鶏";
        name="鶏";

    }

    public void COW(View view1) {
        Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.ushi);
        img.setImageBitmap(bmitem);
        txt.setVisibility(View.VISIBLE);
        txt.setText("生命の葉x5\n鈴x1\nミルクx1");
        btn.setVisibility(View.VISIBLE);
        img.setVisibility(View.VISIBLE);

        item1="葉っぱ";
        item2="鈴";
        item3="ミルク";

        a0=5;
        b0=1;
        c0=1;

        RealmQuery<Item> query1 = mRealm.where(Item.class);
        query1.equalTo("name", item1);
        RealmResults<Item> result = query1.findAll();
        RealmQuery<Item> query2 = mRealm.where(Item.class);
        query2.equalTo("name", item2);
        RealmResults<Item> result2 = query2.findAll();
        RealmQuery<Item> query3 = mRealm.where(Item.class);
        query3.equalTo("name", item3);
        RealmResults<Item> result3 = query3.findAll();

        Item item1=result.get(0);
        Item item2=result2.get(0);
        Item item3=result3.get(0);

        a1=Integer.valueOf(item1.getK()).intValue();
        b1=Integer.valueOf(item2.getK()).intValue();
        c1=Integer.valueOf(item3.getK()).intValue();

        if(a1>=a0&&b1>=b0&&c1>=c0){
            huki.setVisibility(View.INVISIBLE);
            hukitxt.setVisibility(View.INVISIBLE);
            btn.setEnabled(true);
        }else{
            huki.setVisibility(View.VISIBLE);
            hukitxt.setVisibility(View.VISIBLE);
            btn.setEnabled(false);
        }

        type="牛";
        name="牛";

    }

    public void HORSE(View view1) {

        Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.uma);
        img.setImageBitmap(bmitem);
        txt.setVisibility(View.VISIBLE);
        txt.setText("生命の葉x20\n木馬x1\n鈴x1");
        btn.setVisibility(View.VISIBLE);
        img.setVisibility(View.VISIBLE);

        item1="葉っぱ";
        item2="木馬";
        item3="鈴";

        a0=20;
        b0=1;
        c0=1;

        RealmQuery<Item> query1 = mRealm.where(Item.class);
        query1.equalTo("name", item1);
        RealmResults<Item> result = query1.findAll();
        RealmQuery<Item> query2 = mRealm.where(Item.class);
        query2.equalTo("name", item2);
        RealmResults<Item> result2 = query2.findAll();
        RealmQuery<Item> query3 = mRealm.where(Item.class);
        query3.equalTo("name", item3);
        RealmResults<Item> result3 = query3.findAll();

        Item item1=result.get(0);
        Item item2=result2.get(0);
        Item item3=result3.get(0);

        a1=Integer.valueOf(item1.getK()).intValue();
        b1=Integer.valueOf(item2.getK()).intValue();
        c1=Integer.valueOf(item3.getK()).intValue();

        if(a1>=a0&&b1>=b0&&c1>=c0){
            huki.setVisibility(View.INVISIBLE);
            hukitxt.setVisibility(View.INVISIBLE);
            btn.setEnabled(true);
        }else{
            huki.setVisibility(View.VISIBLE);
            hukitxt.setVisibility(View.VISIBLE);
            btn.setEnabled(false);
        }

        type="馬";
        name="馬";

    }

    public void onTradeTapped(View view){
        RealmQuery<Item> query1 = mRealm.where(Item.class);
        query1.equalTo("name", item1);
        final RealmResults<Item> result1 = query1.findAll();
        RealmQuery<Item> query2 = mRealm.where(Item.class);
        query2.equalTo("name", item2);
        final RealmResults<Item> result2 = query2.findAll();
        RealmQuery<Item> query3 = mRealm.where(Item.class);
        query3.equalTo("name", item3);
        final RealmResults<Item> result3 = query3.findAll();

        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Item item1=result1.get(0);
                Item item2=result2.get(0);
                Item item3=result3.get(0);

                item1.setK(Integer.toString(a1-a0));
                item2.setK(Integer.toString(b1-b0));
                item3.setK(Integer.toString(c1-c0));

                if(a1<a0||b1<b0||c1<c0){
                    btn.setEnabled(false);
                }

            }
        });


       /* mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Number maxId = realm.where(Animal.class).max("id");
                long nextId = 1;
                if (maxId != null) nextId = maxId.longValue() + 1;
                Animal animal = realm.createObject(Animal.class, new Long(nextId));
                animal.setName(name);
                animal.setType(type);

                animal.setBo(true);

            }
        });
        */
        RealmQuery<Animal> query = mRealm.where(Animal.class);
        query.equalTo("name", name);
        RealmResults<Animal> result = query.findAll();
        if (result.size() > 0) {
            final RealmResults<Animal> results = mRealm.where(Animal.class).equalTo("name", name).findAll();
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Animal animal = results.first();
                    animal.setBo(true);
                }
            });
        }
        Toast.makeText(this, "交換しました", Toast.LENGTH_SHORT).show();

mMediaPlayer.stop();
            Intent intent = new Intent(getApplication(), BokuActivity.class);
            startActivity(intent);

    }

    public void onInventory(View view1) {
        Intent intent = new Intent(getApplication(), InventoryActivity.class);
        startActivity(intent);
    }

    public void onBack(View view1) {
        mMediaPlayer.stop();
        Intent intent = new Intent(getApplication(), BokuActivity.class);
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
