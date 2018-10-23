package com.example.rudra.criminalityapplication;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rudra.criminalityapplication.R;
import com.example.rudra.criminalityapplication.SliderAdapter;

public class SliderScreen extends AppCompatActivity {

    View view;
    private Context Context;
    LinearLayout layout_similar;
    private static ViewPager mPager1;
    int x = 0;
    int img_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_screen);



       /* ViewPager viewpager=findViewById(R.id.viewpager);
        SliderAdapter sliderAdapter=new SliderAdapter(this);
        ViewPager.setAdapter(sliderAdapter);*/
        bindid();
        //     Button btnskip=findViewById(R.id.btn_Skip);
        //btn_Skip.setOnClickListener(new View.OnClickListener()
        //{
        //  @Override
        //public void onClick(View v)
        //{
        //  Intent it = new Intent(SliderScreen.this, FirstPage.class);
        //StartActivity(it);
        // }
        //});


    }

    private void bindid() {
        //   TODO Auto-generated method stub
        Context = SliderScreen.this;
        String[] img_hint = new String[3];
        //      if (!ApplicationPreferences.getValue("HINT_IMG", "0", StartScreen_Activity.this))
        mPager1 = (ViewPager) findViewById(R.id.viewpager);
        final TextView btn_next = (TextView) findViewById(R.id.btn_Next);
        final TextView btn_done = (TextView) findViewById(R.id.btn_done);
        final TextView btn_prev = (TextView) findViewById(R.id.btn_prev);
        mPager1.setAdapter(new SliderAdapter(SliderScreen.this));

        mPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position,float positionOffset,int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                x = position;
                if (position > 1) {
                    btn_next.setVisibility(View.GONE);
                    btn_done.setVisibility(View.VISIBLE);
                } else {
                    btn_next.setVisibility(View.VISIBLE);
                    btn_done.setVisibility(View.GONE);
                }
                if (position == 0) {
                    btn_next.setVisibility(View.VISIBLE);
                    btn_prev.setVisibility(View.GONE);
                } else {
                    btn_prev.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        if (img_hint.length == 1) {
            btn_done.setVisibility((View.VISIBLE));
        }
        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x > (img_count - 1)) {
                    x--;
                    mPager1.setCurrentItem(x);
                }
                if (x >= 0) {
                    btn_next.setVisibility(View.VISIBLE);
                    btn_prev.setVisibility(View.VISIBLE);
                }
                if (x == 0) {
                    btn_next.setVisibility(View.VISIBLE);
                    btn_done.setVisibility(View.GONE);
                    btn_prev.setVisibility(View.GONE);
                }
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x >= 0) {
                    x++;
                    mPager1.setCurrentItem(x);
                }
                if (x == 0) {
                    btn_next.setVisibility(View.VISIBLE);
                    btn_prev.setVisibility((View.GONE));
                }

                if (x == (img_count - 1)) {
                    btn_next.setVisibility(View.VISIBLE);
                    btn_done.setVisibility(View.GONE);
                }
            }
        });

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SliderScreen.this,FirstPage.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}















