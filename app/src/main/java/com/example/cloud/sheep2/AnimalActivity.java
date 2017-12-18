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

public class AnimalActivity extends AppCompatActivity {
    private Realm mRealm;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnimalActivity.this,AnimalEditActivity.class));
            }
        });
        mRealm = Realm.getDefaultInstance();

        mListView=(ListView) findViewById(R.id.listView);
        RealmResults<Animal> animal=mRealm.where(Animal.class).findAll();
        AnimalAdapter adapter=new AnimalAdapter(animal);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                        Animal animal=(Animal) parent.getItemAtPosition(position);
                        startActivity(new Intent(AnimalActivity.this,AnimalEditActivity.class).putExtra("animal_id",animal.getId()));
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
