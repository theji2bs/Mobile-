package com.malidielhadad.lasalle.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.malidielhadad.lasalle.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenActivity extends AppCompatActivity {


    @BindView(R.id.splash_imageview)
    ImageView splashImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Scale

        // fade

        // ease out

        ButterKnife.bind(this);






    }

    @Override
    protected void onStart(){
        super.onStart();
        startAnimation();

    }

    public void startAnimation(){

        ObjectAnimator scaleXAnimator= ObjectAnimator.ofFloat(splashImageView, "scaleX", 10);

        scaleXAnimator.setDuration(1000);
        scaleXAnimator.setInterpolator(new DecelerateInterpolator());

        ObjectAnimator scaleYAnimator= ObjectAnimator.ofFloat(splashImageView, "scaleY", 10);
        scaleYAnimator.setDuration(1000);
        scaleXAnimator.setInterpolator(new DecelerateInterpolator());


        ObjectAnimator fadeAnimator = ObjectAnimator.ofFloat(splashImageView, "alpha", 0);
        fadeAnimator.setDuration(1000);
        fadeAnimator.setInterpolator(new DecelerateInterpolator());


        AnimatorSet awesomeAnimation = new AnimatorSet();
        awesomeAnimation.playTogether(scaleXAnimator, scaleYAnimator, fadeAnimator);
        awesomeAnimation.setInterpolator(new DecelerateInterpolator());
        awesomeAnimation.setDuration(1000);
        awesomeAnimation.setStartDelay(1000);

        awesomeAnimation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        awesomeAnimation.start();

    }
}
