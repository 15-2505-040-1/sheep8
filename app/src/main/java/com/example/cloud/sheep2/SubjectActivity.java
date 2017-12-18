package com.example.cloud.sheep2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import static com.example.cloud.sheep2.R.id.sub1;
import static com.example.cloud.sheep2.R.id.sub2;
import static com.example.cloud.sheep2.R.id.sub3;

public class SubjectActivity extends AppCompatActivity {
    Global global;
    TextView subtitle;
    MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        mMediaPlayer= MediaPlayer.create(this,R.raw.haru);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();

        subtitle = (TextView) findViewById(R.id.subtitle);
        global=(Global)this.getApplication();
        global.GlobalsAllInit();
    }
    public void onTapped(View view) {
        mMediaPlayer.stop();
        if(view==findViewById(sub1)){
            global.sub=1;
            global.m=1;
            Mathques1.init();
            Intent intent = new Intent(getApplication(), QuizActivity.class);
            intent.putExtra("Mathques1", Mathques1.getQuiz(0));
            startActivity(intent);
        }
        if(view==findViewById(sub2)){
            global.sub=2;
            global.x=1;
            Physques1.init();
            Intent intent = new Intent(getApplication(), QuizActivity.class);
            intent.putExtra("Physques1", Physques1.getQuiz(0));
            startActivity(intent);
        }
        if(view==findViewById(sub3)){
            global.sub=3;
            global.y=3;
            Physques3.init();
            Intent intent = new Intent(getApplication(), QuizActivity.class);
            intent.putExtra("Physques3", Physques3.getQuiz(0));
            startActivity(intent);
        }
    }

    public void onBack(View view1) {
        mMediaPlayer.stop();
        Intent intent = new Intent(getApplication(), MainActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction()==KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    // ダイアログ表示など特定の処理を行いたい場合はここに記述
                    // 親クラスのdispatchKeyEvent()を呼び出さずにtrueを返す
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}
