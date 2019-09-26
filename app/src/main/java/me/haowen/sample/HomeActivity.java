package me.haowen.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

public class HomeActivity extends AppCompatActivity {

    private AlphaAnimation mHideAnimation	= null;
    private AlphaAnimation mShowAnimation	= null;
    private TextView mTv1;
    private TextView mTv2;
    private View mBgVideo;
    private RelativeLayout mText;
    int flag = 0;//定义标记变量
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final VideoView videoview =findViewById(R.id.videoView);
        final String videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.p1).toString();
        videoview.setVideoPath(videoPath);
        videoview.start();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }
        });
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoview.setVideoPath(videoPath);
                videoview.start();
            }
        });

        mTv1 = findViewById(R.id.bg_tv1);
        mTv2 = findViewById(R.id.bg_tv2);
        mText = findViewById(R.id.bg_text);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/浮生未歇By：伊筠&阿影.ttf");
        Typeface customEN_font = Typeface.createFromAsset(getAssets(),  "fonts/American Scribe.ttf");
        mTv1.setTypeface(custom_font);
        mTv2.setTypeface(customEN_font);
        mBgVideo = findViewById(R.id.bg_video);
        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag==0){
                    setShowAnimation(mText,2000);
                    mTv1.setText("你喜欢的歌我也有去听");
                    mTv2.setText("I also listen to your favorite songs");
                }
                else if (flag==1){
                    setShowAnimation(mText,2000);
                    mTv1.setText("你看的电影我也偷偷去看过");
                    mTv2.setText("Watch the movies you've seen");
                }else if (flag==2){
                    setShowAnimation(mText,2000);
                    mTv1.setText("其实，我喜欢你");
                    mTv2.setText("Actually, I like you");
                }else if (flag==3){
                    setHideAnimation(mBgVideo,2000);
                    Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                flag=(flag+1)%4;
            }
        });
    }

    /**
     * View渐隐动画效果
     */
    private void setHideAnimation( View view, int duration ){
        if( null == view || duration < 0 ){
            return;
        }
        if( null != mHideAnimation ){
            mHideAnimation.cancel( );
        }
        mHideAnimation = new AlphaAnimation(1.0f, 0.0f);
        mHideAnimation.setDuration( duration );
        mHideAnimation.setFillAfter( true );
        view.startAnimation( mHideAnimation );
    }

    /**
     * View渐现动画效果
     */
    private void setShowAnimation( View view, int duration ){
        if( null == view || duration < 0 ){
            return;
        }
        if( null != mShowAnimation ){
            mShowAnimation.cancel( );
        }
        mShowAnimation = new AlphaAnimation(0.0f, 1.0f);
        mShowAnimation.setDuration( duration );
        mShowAnimation.setFillAfter( true );
        view.startAnimation( mShowAnimation );
    }

}
