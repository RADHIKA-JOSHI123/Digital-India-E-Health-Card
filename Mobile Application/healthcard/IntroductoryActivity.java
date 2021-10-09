package com.example.healthcard;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;
import com.example.healthcard.OnBoardingFragment1;
import com.example.healthcard.OnBoardingFragment2;
import com.example.healthcard.OnBoardingFragment3;

public class IntroductoryActivity extends AppCompatActivity {

    ImageView logo,appName,splashImg;
    LottieAnimationView lottieAnimationView;

    private static final int NUM_PAGES =3;
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

    Animation anim;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        logo=findViewById(R.id.logo);
        appName=findViewById(R.id.app_name);
        splashImg=findViewById(R.id.img);
        lottieAnimationView=findViewById(R.id.lottie);

        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

        anim= AnimationUtils.loadAnimation( this,R.anim.o_b_anim);
        viewPager.startAnimation(anim);


        splashImg.animate().translationY(-2500).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(2000).setDuration(1000).setStartDelay(4000);


    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{
        @Deprecated

        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    OnBoardingFragment1 tab1 = new OnBoardingFragment1();
                    return tab1;
                case 1:
                    OnBoardingFragment2 tab2 = new OnBoardingFragment2();
                    return tab2;
                case 2:
                    OnBoardingFragment3 tab3 = new OnBoardingFragment3();
                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}