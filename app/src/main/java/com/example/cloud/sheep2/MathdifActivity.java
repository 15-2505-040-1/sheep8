package com.example.cloud.sheep2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.example.cloud.sheep2.R.id.dif1;
import static com.example.cloud.sheep2.R.id.dif2;
import static com.example.cloud.sheep2.R.id.dif3;

public class MathdifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathdif);
    }


    public void onTapped(View view) {
        if(view==findViewById(dif1)){
            Mathques1.init();
            Intent intent = new Intent(getApplication(), Mathquiz1Activity.class);
            intent.putExtra("Mathques1", Mathques1.getQuiz(0));
            startActivity(intent);

        }

        if(view==findViewById(dif2)){
            Mathques2.init();
            Intent intent = new Intent(getApplication(), Mathquiz2Activity.class);
            intent.putExtra("Mathques2", Mathques2.getQuiz(0));
            startActivity(intent);
        }

        if(view==findViewById(dif3)){
            Mathques3.init();
            Intent intent = new Intent(getApplication(), Mathquiz3Activity.class);
            intent.putExtra("Mathques3", Mathques3.getQuiz(0));
            startActivity(intent);
        }
    }
}