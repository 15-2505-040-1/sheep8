package com.example.cloud.sheep2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.example.cloud.sheep2.R.id.sub1;
import static com.example.cloud.sheep2.R.id.sub2;
import static com.example.cloud.sheep2.R.id.sub3;

public class SubjectActivity extends AppCompatActivity {
    Global global;
    TextView subtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        subtitle = (TextView) findViewById(R.id.subtitle);
        global=(Global)this.getApplication();
        global.GlobalsAllInit();
    }
    public void onTapped(View view) {
        if(view==findViewById(sub1)){
            global.sub=1;

            Intent intent = new Intent(getApplication(), DifActivity.class);
            startActivity(intent);
        }
        if(view==findViewById(sub2)){
            global.sub=2;
            Intent intent = new Intent(getApplication(), DifActivity.class);
            startActivity(intent);
        }
        if(view==findViewById(sub3)){
            global.sub=3;
            Intent intent = new Intent(getApplication(), BokuActivity.class);
        startActivity(intent);
        }
    }
}
