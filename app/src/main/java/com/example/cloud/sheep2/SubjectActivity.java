package com.example.cloud.sheep2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.example.cloud.sheep2.R.id.sub1;
import static com.example.cloud.sheep2.R.id.sub2;
import static com.example.cloud.sheep2.R.id.sub3;

public class SubjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
    }
    public void onTapped(View view) {
        if(view==findViewById(sub1)){
            Intent intent = new Intent(getApplication(), MathdifActivity.class);
            startActivity(intent);

        }

        if(view==findViewById(sub2)){
            Intent intent = new Intent(getApplication(), PhysdifActivity.class);
            startActivity(intent);
        }

        if(view==findViewById(sub3)){
            Intent intent = new Intent(getApplication(), EngdifActivity.class);
            startActivity(intent);
        }




    }
}
