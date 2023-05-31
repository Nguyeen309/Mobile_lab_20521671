package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode, btnBlinkXml,
            btnBlinkCode, btnZoomInXml, btnZoomInCode, btnZoomOutXml, btnZoomOutCode, btnRotateXml,
            btnRotateCode, btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode, btnBounceXml,
            btnBounceCode, btnCombineXml, btnCombineCode;
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsByIds();
        initVariables();

        //HandleClickAnimationXML
        handleClickAnimationXml (btnFadeInXml, R.anim.anim_fade_in);
        handleClickAnimationXml (btnFadeOutXml, R.anim.anim_fade_out);
        handleClickAnimationXml (btnBlinkXml, R.anim.anim_blink);
        handleClickAnimationXml (btnZoomInXml, R.anim.anim_zoom_in);
        handleClickAnimationXml (btnZoomOutXml, R.anim.anim_zoom_out);
        handleClickAnimationXml (btnRotateXml, R.anim.anim_rotate);
        handleClickAnimationXml (btnMoveXml, R.anim.anim_rotate);
        handleClickAnimationXml (btnSlideUpXml, R.anim.anim_slide_up);
        handleClickAnimationXml (btnBounceXml, R.anim.anim_bounce);
        handleClickAnimationXml (btnCombineXml, R.anim.anim_combine);
        //HandleClickAnimationCode
        handleClickAnimationCode (btnFadeInCode, initFadeInAnimation());
        handleClickAnimationCode (btnFadeOutCode, initFadeOutAnimation());
        handleClickAnimationCode (btnBlinkCode, initBlinkAnimation());
//        handleClickAnimationXml (btnZoomInXml, R.anim.anim_zoom_in);
//        handleClickAnimationXml (btnZoomOutXml, R.anim.anim_zoom_out);
//        handleClickAnimationXml (btnRotateXml, R.anim.anim_rotate);
//        handleClickAnimationXml (btnMoveXml, R.anim.anim_rotate);
//        handleClickAnimationXml (btnSlideUpXml, R.anim.anim_slide_up);
//        handleClickAnimationXml (btnBounceXml, R.anim.anim_bounce);
//        handleClickAnimationXml (btnCombineXml, R.anim.anim_combine);

    }

    private void handleClickAnimationXml(Button btn, int animId) {
        //HandleClickAnimationXML
        // load the animation
        final Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_fade_in);
        final Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_fade_out);
        final Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_blink);
        final Animation animation4 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_zoom_in);
        final Animation animation5 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_zoom_out);
        final Animation animation6 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_rotate);
        final Animation animation7 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_move);
        final Animation animation8= AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_slide_up);
        final Animation animation9 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_bounce);
        final Animation animation10 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_combine);

        //set animation listener
        //handle onClickListener to start animation
        btnFadeInXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivUitLogo.startAnimation(animation1);
            }
        });
        btnFadeOutXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivUitLogo.startAnimation(animation2);
            }
        });
        btnBlinkXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivUitLogo.startAnimation(animation3);
            }
        });
        btnZoomInXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivUitLogo.startAnimation(animation4);
            }
        });
        btnZoomOutXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivUitLogo.startAnimation(animation5);
            }
        });
        btnRotateXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivUitLogo.startAnimation(animation6);
            }
        });
        btnMoveXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivUitLogo.startAnimation(animation7);
            }
        });
        btnSlideUpXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivUitLogo.startAnimation(animation8);
            }
        });
        btnBounceXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivUitLogo.startAnimation(animation9);
            }
        });
        btnCombineXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivUitLogo.startAnimation(animation10);
            }
        });
    }

    private void handleClickAnimationCode(Button btn, final Animation animation) {

        // Handle onclickListener to start animation
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });
    }
    private Animation initFadeInAnimation() {
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initFadeOutAnimation() {
        AlphaAnimation animation = new AlphaAnimation(1f, 0f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initBlinkAnimation() {
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(300);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private void findViewsByIds() {
        ivUitLogo = (ImageView) findViewById(R.id.iv_uit_logo);
        btnFadeInXml = (Button) findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = (Button) findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = (Button) findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = (Button) findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = (Button) findViewById(R.id.btn_blink_xml);
        btnBlinkCode = (Button) findViewById(R.id.btn_blink_code);
        btnZoomInXml = (Button) findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = (Button) findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = (Button) findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = (Button) findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = (Button) findViewById(R.id.btn_rotate_xml);
        btnRotateCode = (Button) findViewById(R.id.btn_rotate_code);
        btnMoveXml = (Button) findViewById(R.id.btn_move_xml);
        btnMoveCode = (Button) findViewById(R.id.btn_move_code);
        btnSlideUpXml = (Button) findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = (Button) findViewById(R.id.btn_slide_up_code);
        btnBounceXml = (Button) findViewById(R.id.btn_bounce_xml);
        btnBounceCode = (Button) findViewById(R.id.btn_bounce_code);
        btnCombineXml = (Button) findViewById(R.id.btn_combine_xml);
        btnCombineCode = (Button) findViewById(R.id.btn_combine_code);
    }

    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };
    }

}


