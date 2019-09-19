package me.haowen.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.VideoView;

public class HomeActivity extends AppCompatActivity {

    private AlphaAnimation mHideAnimation	= null;
    private AlphaAnimation mShowAnimation	= null;
    private TextView mTv1;
    private View mBgVideo;
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
        mBgVideo = findViewById(R.id.bg_video);
        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag==0){
                    setShowAnimation(mTv1,2000);
                    mTv1.setText("两只眼睛四条腿");
                }
                else if (flag==1){
                    setShowAnimation(mTv1,2000);
                    mTv1.setText("扑通扑通跳下水");
                }else if (flag==2){
                    setShowAnimation(mTv1,2000);
                    mTv1.setText("蛤蟆不喝水太平年");
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
