package com.example.cloud.sheep2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;

public class GameoverActivity extends AppCompatActivity {

    private AlphaAnimation alpha1;
    private AlphaAnimation alpha2;
    AnimationSet set = new AnimationSet(true);
    AnimationSet set2 = new AnimationSet(true);
    ImageView img;
    Button btn;
    private final Handler hdl = new Handler();

    public class game implements Runnable{
        public void run(){
            alpha2 = new AlphaAnimation(0, 1);
            set2.addAnimation(alpha2);
            set2.setDuration(900);
            set2.setFillAfter(true);
            btn.startAnimation(set);

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        img=(ImageView) findViewById(R.id.imageView8);
        btn=(Button) findViewById(R.id.button13);
        alpha1 = new AlphaAnimation(0, 1);
        set.addAnimation(alpha1);
        set.setDuration(1500);
        set.setFillAfter(true);
        img.startAnimation(set);

        alpha2 = new AlphaAnimation(0, 1);
        set2.addAnimation(alpha2);
        set2.setDuration(900);
        set2.setFillAfter(true);
        btn.startAnimation(set);


    }

    public void title(View view){
        Intent intent=new Intent(getApplication(),MainActivity.class);
        startActivity(intent);
    }
}
