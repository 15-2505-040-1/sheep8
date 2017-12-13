package com.example.cloud.sheep2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    Random r = new Random();
    int n;

    private AlphaAnimation alpha;
    private RotateAnimation rotate;
    private ScaleAnimation scale1;
    private ScaleAnimation scale2;
    AnimationSet set = new AnimationSet(true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        ImageButton item = (ImageButton)findViewById(R.id.item);
        item.setVisibility(View.INVISIBLE);


    }
    public void onOpen(View v){
        ImageButton imbt = (ImageButton)findViewById(R.id.close);

        Bitmap bmpt = BitmapFactory.decodeResource(getResources(), R.drawable.takarabako02);
        imbt.setImageBitmap(bmpt);

        //Random r = new Random();
        n = r.nextInt(50);

        if(n>=1){
            ImageButton item = (ImageButton)findViewById(R.id.item);
            item.setVisibility(View.VISIBLE);
            alpha = new AlphaAnimation(0, 1);
            rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            scale1 = new ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            set.addAnimation(alpha);
            set.addAnimation(rotate);
            set.addAnimation(scale1);
            //set.setInterpolator(new BounceInterpolator());
            set.setInterpolator(new AnticipateOvershootInterpolator());
            set.setDuration(1000);
            set.setFillAfter(true);
            item.startAnimation(set);


        }


    }
}
