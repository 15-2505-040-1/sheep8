package com.example.cloud.sheep2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import io.realm.Realm;
import io.realm.RealmResults;

public class ItemEditActivity extends AppCompatActivity {
    private Realm mRealm;
    EditText mNameEdit;
    EditText mDetailEdit;
    EditText mKEdit;
    Button mDelete;
    String i;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_edit);
        mRealm=Realm.getDefaultInstance();
        mNameEdit=(EditText) findViewById(R.id.nameEdit);
        mDetailEdit=(EditText) findViewById(R.id.detailEdit);
        mKEdit=(EditText) findViewById(R.id.kEdit);
        mDelete=(Button)findViewById(R.id.delete);
        img=(ImageView) findViewById(R.id.image);

        mNameEdit.setEnabled(false);
        mDetailEdit.setEnabled(false);
        mKEdit.setEnabled(false);

        mNameEdit.setTextColor(0xff000000);
        mDetailEdit.setTextColor(0xff000000);
        mKEdit.setTextColor(0xff000000);



        long itemId=getIntent().getLongExtra("item_id",-1);
        if(itemId!=-1) {
            RealmResults<Item> results = mRealm.where(Item.class).equalTo("id", itemId).findAll();
            Item item = results.first();

            mNameEdit.setText(item.getName());
            mDetailEdit.setText(item.getDetail());
            mKEdit.setText("所持数: "+item.getK());

            if(itemId==0){
                Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item2);
                img.setImageBitmap(bmitem);
            }
            if(itemId==1){
                Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item4);
                img.setImageBitmap(bmitem);
            }
            if(itemId==2){
                Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item1);
                img.setImageBitmap(bmitem);
            }
            if(itemId==3){
                Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item5);
                img.setImageBitmap(bmitem);
            }
            if(itemId==4){
                Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item7);
                img.setImageBitmap(bmitem);
            }
            if(itemId==5){
                Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item6);
                img.setImageBitmap(bmitem);
            }
            if(itemId==6){
                Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item9);
                img.setImageBitmap(bmitem);
            }
            if(itemId==7){
                Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.nezumi);
                img.setImageBitmap(bmitem);
            }
            if(itemId==8){
                Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item8);
                img.setImageBitmap(bmitem);
            }
            if(itemId==9){
                Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item3);
                img.setImageBitmap(bmitem);
            }
            if(itemId==10){
                Bitmap bmitem = BitmapFactory.decodeResource(getResources(), R.drawable.item10);
                img.setImageBitmap(bmitem);
            }

        }
    }
    public void onSaveTapped(View view) {

            final RealmResults<Item>results=mRealm.where(Item.class).equalTo("name",i).findAll();
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Item item=results.first();
                    item.setName("アイテム名: "+mNameEdit.getText().toString());
                    item.setK("所持数: "+mKEdit.getText().toString());
                    item.setDetail(mDetailEdit.getText().toString());

                }
            });

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
