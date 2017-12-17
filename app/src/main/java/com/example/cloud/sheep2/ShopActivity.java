package com.example.cloud.sheep2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import static com.example.cloud.sheep2.R.id.item;

public class ShopActivity extends AppCompatActivity {
    ImageView img;
    TextView txt;
    Button btn;

    Realm mRealm;

    int b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        mRealm=Realm.getDefaultInstance();

        img=(ImageView) findViewById(R.id.animal) ;
        txt=(TextView) findViewById(item);
    }

    public void SHEEP(View view1) {
        btn=(Button) findViewById(R.id.tradebtn);
        txt.setVisibility(View.VISIBLE);
        txt.setText("生命の葉x1\n角x1");
        btn.setVisibility(View.VISIBLE);
        img.setVisibility(View.VISIBLE);


        RealmQuery<Item> query1 = mRealm.where(Item.class);
        query1.equalTo("name", "葉っぱ");
        RealmResults<Item> result = query1.findAll();
        RealmQuery<Item> query2 = mRealm.where(Item.class);
        query2.equalTo("name", "骨");
        RealmResults<Item> result2 = query2.findAll();

        Item item=result.get(0);
        Item item2=result2.get(0);
        item.getK();

        if(Integer.valueOf(item.getK()).intValue()>=1&&Integer.valueOf(item2.getK()).intValue()>=1){
            btn.setEnabled(true);
        }else{
            btn.setEnabled(false);
        }


        b=1;

    }

    public void onTradeTapped(View view){

    }
}
