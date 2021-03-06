package com.example.cloud.sheep2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;

public class DatabaseActivity extends AppCompatActivity {
    private Realm mRealm;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DatabaseActivity.this,ItemEditActivity.class));
            }
        });
        mRealm = Realm.getDefaultInstance();

        mListView=(ListView) findViewById(R.id.listView);
        RealmResults<Item> item=mRealm.where(Item.class).findAll();
        SheepAdapter adapter=new SheepAdapter(item);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                        Item item=(Item) parent.getItemAtPosition(position);
                        startActivity(new Intent(DatabaseActivity.this,ItemEditActivity.class).putExtra("item_id",item.getId()));
                    }
                }
        );
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mRealm.close();
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
