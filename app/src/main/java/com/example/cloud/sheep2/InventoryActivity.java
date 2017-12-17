package com.example.cloud.sheep2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;

public class InventoryActivity extends AppCompatActivity {
    private Realm mRealm;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRealm = Realm.getDefaultInstance();

        mListView=(ListView) findViewById(R.id.listView);
        RealmResults<Item> item=mRealm.where(Item.class).findAll();
        SheepAdapter adapter=new SheepAdapter(item);
        mListView.setAdapter(adapter);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mRealm.close();
    }
}
