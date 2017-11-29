package com.example.cloud.sheep2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.example.cloud.sheep2.R.id.dif1;
import static com.example.cloud.sheep2.R.id.dif2;
import static com.example.cloud.sheep2.R.id.dif3;

public class DifActivity extends AppCompatActivity {

    Global global;
    TextView subtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dif);

        //グローバル変数を取得
        global = (Global) this.getApplication();
        subtitle = (TextView) findViewById(R.id.subtitle);

        if(global.sub==1){
            subtitle.setText("数学");
        }
        if(global.sub==2){
            subtitle.setText("物理");
        }


    }


    public void onTapped(View view) {
        if(global.sub==1){
            if(view==findViewById(dif1)){
                global.m=1;
                Mathques1.init();
                Intent intent = new Intent(getApplication(), QuizActivity.class);
                intent.putExtra("Mathques1", Mathques1.getQuiz(0));
                startActivity(intent);

            }

            if(view==findViewById(dif2)){
                global.m=2;
                Mathques2.init();
                Intent intent = new Intent(getApplication(), QuizActivity.class);
                intent.putExtra("Mathques2", Mathques2.getQuiz(0));
                startActivity(intent);
            }

            if(view==findViewById(dif3)){
                global.m=3;
                Mathques3.init();
                Intent intent = new Intent(getApplication(), QuizActivity.class);
                intent.putExtra("Mathques3", Mathques3.getQuiz(0));
                startActivity(intent);
            }
        }
        if(global.sub==2){
            if(view==findViewById(dif1)){
                global.x=1;
                Physques1.init();
                Intent intent = new Intent(getApplication(), QuizActivity.class);
                intent.putExtra("Physques1", Physques1.getQuiz(0));
                startActivity(intent);

            }

            if(view==findViewById(dif2)){
                global.x=2;
                Physques2.init();
                Intent intent = new Intent(getApplication(), QuizActivity.class);
                intent.putExtra("Physques2", Physques2.getQuiz(0));
                startActivity(intent);
            }

            if(view==findViewById(dif3)){
                global.x=3;
                Physques3.init();
                Intent intent = new Intent(getApplication(), QuizActivity.class);
                intent.putExtra("Physques3", Physques3.getQuiz(0));
                startActivity(intent);
            }
        }
    }
}
