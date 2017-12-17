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

public class AnimalEditActivity extends AppCompatActivity {
    private Realm mRealm;
    EditText mNameEdit;
    EditText mDetailEdit;
    EditText mTypeEdit;
    Button mDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_edit);
        mRealm=Realm.getDefaultInstance();
        mNameEdit=(EditText) findViewById(R.id.nameEdit);
        mDetailEdit=(EditText) findViewById(R.id.detailEdit);
        mTypeEdit=(EditText) findViewById(R.id.typeEdit);
        mDelete=(Button)findViewById(R.id.delete);

        long animalId=getIntent().getLongExtra("animal_id",-1);
        if(animalId!=-1) {
            RealmResults<Animal> results = mRealm.where(Animal.class).equalTo("id", animalId).findAll();
            Animal animal = results.first();
            mNameEdit.setText(animal.getName());
            mDetailEdit.setText(animal.getDetail());
            mTypeEdit.setText(animal.getType());
            mDelete.setVisibility(View.VISIBLE);
        }else{
            mDelete.setVisibility(View.INVISIBLE);
        }
    }
    public void onSaveTapped(View view) {
        long animalId=getIntent().getLongExtra("animal_id",-1);
        if(animalId!=-1){
            final RealmResults<Animal>results=mRealm.where(Animal.class).equalTo("id",animalId).findAll();
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Animal animal=results.first();
                    animal.setName(mNameEdit.getText().toString());
                    animal.setType(mTypeEdit.getText().toString());
                    animal.setDetail(mDetailEdit.getText().toString());

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
                    Number maxId = realm.where(Animal.class).max("id");
                    long nextId = 0;
                    if (maxId != null) nextId = maxId.longValue() + 1;
                    Animal animal = realm.createObject(Animal.class, new Long(nextId));
                    animal.setName(mNameEdit.getText().toString());
                    animal.setDetail(mDetailEdit.getText().toString());
                    animal.setType(mTypeEdit.getText().toString());
                }
            });
            Toast.makeText(this, "追加しました", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    public void onDeleteTapped(View view){
        final long animalId=getIntent().getLongExtra("animal_id",-1);
        if(animalId!=-1){
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Animal animal=realm.where(Animal.class).equalTo("id",animalId).findFirst();
                    animal.deleteFromRealm();
                }
            });
        }
    }
}
