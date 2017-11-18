package com.example.cloud.sheep2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.example.cloud.sheep2.R.id.dif1;
import static com.example.cloud.sheep2.R.id.dif2;
import static com.example.cloud.sheep2.R.id.dif3;

public class PhysdifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physdif);
    }


    public void onTapped(View view) {
        if(view==findViewById(dif1)){
            Physques1.init();
            Intent intent = new Intent(getApplication(), Physquiz1Activity.class);
            intent.putExtra("Physques1", Physques1.getQuiz(0));
            startActivity(intent);

        }

        if(view==findViewById(dif2)){
            Physques2.init();
            Intent intent = new Intent(getApplication(), Physquiz2Activity.class);
            intent.putExtra("Physques2", Physques2.getQuiz(0));
            startActivity(intent);
        }

        if(view==findViewById(dif3)){
            Physques3.init();
            Intent intent = new Intent(getApplication(), Physquiz3Activity.class);
            intent.putExtra("Physques3", Physques3.getQuiz(0));
            startActivity(intent);
        }
    }
}
