package com.example.cloud.sheep2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dd.realmbrowser.RealmBrowser;
import com.dd.realmbrowser.RealmFilesActivity;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class RealmActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm realm = Realm.getInstance(this);
        RealmQuery<Engineer> query = realm.where(Engineer.class);
        query.equalTo("name", "ABC123");
        RealmResults<Engineer> result = query.findAll();

        if(result.size() > 0) {
            // 検索結果が見つかった場合
            Engineer engineer = result.first();
            int level = engineer.getLevel();
            String name = engineer.getName();
            String businessTitle = engineer.getBusinessTitle();
            RealmList<Skill> skills = engineer.getSkills();
            Date createDateTime = engineer.getCreateDateTime();

            Log.d("MainActivity", "name: " + name + ", businessTitle: " + businessTitle);
        } else {
            // 検索結果が見つからなかった場合
            realm.beginTransaction();
            Engineer engineer = realm.createObject(Engineer.class);
            engineer.setLevel(1);
            engineer.setName("ABC123");
            engineer.setBusinessTitle("新米エンジニア");

            Skill skill = realm.createObject(Skill.class);
            skill.setSkill("Java");
            engineer.getSkills().add(skill);
            engineer.setCreateDateTime(new Date());

            realm.commitTransaction();
        }
        RealmBrowser.getInstance().addRealmModel(Engineer.class);
        RealmFilesActivity.start(this);
    }

}
