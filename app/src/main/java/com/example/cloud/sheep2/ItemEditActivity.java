package com.example.cloud.sheep2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class ItemEditActivity extends AppCompatActivity {
    private Realm mRealm;
    EditText mNameEdit;
    EditText mDetailEdit;
    EditText mKEdit;
    Button mDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_edit);
        mRealm=Realm.getDefaultInstance();
        mNameEdit=(EditText) findViewById(R.id.nameEdit);
        mDetailEdit=(EditText) findViewById(R.id.detailEdit);
        mKEdit=(EditText) findViewById(R.id.kEdit);
        mDelete=(Button)findViewById(R.id.delete);

        long itemId=getIntent().getLongExtra("item_id",-1);
        if(itemId!=-1) {
            RealmResults<Item> results = mRealm.where(Item.class).equalTo("id", itemId).findAll();
            Item item = results.first();
            mNameEdit.setText(item.getName());
            mDetailEdit.setText(item.getDetail());
            mKEdit.setText(item.getK());
            mDelete.setVisibility(View.VISIBLE);
        }else{
            mDelete.setVisibility(View.INVISIBLE);
        }
    }
    public void onSaveTapped(View view) {
        long itemId=getIntent().getLongExtra("item_id",-1);
        if(itemId!=-1){
            final RealmResults<Item>results=mRealm.where(Item.class).equalTo("id",itemId).findAll();
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Item item=results.first();
                    item.setName(mNameEdit.getText().toString());
                    item.setK(mKEdit.getText().toString());
                    item.setDetail(mDetailEdit.getText().toString());

                }
            });
            Snackbar.make(findViewById(android.R.id.content),"アップデートしました",Snackbar.LENGTH_LONG).setAction("戻る",new View.OnClickListener(){
                @Override
                public void onClick(View V){
                    finish();
                }
            }).setActionTextColor(Color.YELLOW).show();
        }else {
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number maxId = realm.where(Item.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Item item = realm.createObject(Item.class, new Long(nextId));
                    item.setName(mNameEdit.getText().toString());
                    item.setK(mKEdit.getText().toString());
                    item.setDetail(mDetailEdit.getText().toString());
                }
            });
            Toast.makeText(this, "追加しました", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    public void onDeleteTapped(View view){
        final long itemId=getIntent().getLongExtra("item_id",-1);
        if(itemId!=-1){
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Item item=realm.where(Item.class).equalTo("id",itemId).findFirst();
                    item.deleteFromRealm();
                }
            });
        }
    }
}
