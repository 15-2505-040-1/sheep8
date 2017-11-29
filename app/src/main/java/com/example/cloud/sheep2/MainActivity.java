package com.example.cloud.sheep2;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

public class MainActivity extends AppCompatActivity {
    private AlphaAnimation alpha;
    private ScaleAnimation scale;
    private RotateAnimation rotate;
    AnimationSet set=new AnimationSet(true);
    private SoundPool mSoundPool;
    private int mSoundId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        mSoundId = mSoundPool.load(getApplicationContext(), R.raw.music, 0);
       // ((TextView)findViewById(textView)).setTypeface(Typeface.createFromAsset(getAssets(), "数式フォントver1.1.ttf"));



        Quiz.init();
    }
    @Override
    protected void onResume() {
        super.onResume();
        // 予め音声データを読み込む

    }
    @Override
    protected void onPause() {
        super.onPause();
        // リリース
        mSoundPool.release();
    }
    private void playFromSoundPool() {
        // 再生
    }


    public void openQuiz(View view1) {

        mSoundPool.play(mSoundId, 1.0F, 1.0F, 0, 0, 1.0F);
    /*    Button bt = (Button)findViewById(R.id.button);
        alpha=new AlphaAnimation(1,0);
        scale=new ScaleAnimation(1,0,1,0,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotate = new RotateAnimation(0, 360,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        set.addAnimation(alpha);
        set.addAnimation(rotate);
        set.addAnimation(scale);
        set.setInterpolator(new AnticipateOvershootInterpolator());
        rotate.setDuration(1000);
        rotate.setRepeatCount(0);
        rotate.setFillAfter(true);
        bt.startAnimation(set);
        */
        Intent intent = new Intent(getApplication(), SubjectActivity.class);
        startActivity(intent);

    }

    public void onTapped(View view2) {
        Intent intent = new Intent(getApplication(), DatabaseActivity.class);
        startActivity(intent);
    }
}

