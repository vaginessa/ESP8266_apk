package com.gta.administrator.infraredcontrol.setTopBoxes;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.gta.administrator.infraredcontrol.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanwen on 16/10/2.
 */
public class HW_TV extends AppCompatActivity {
    private ViewPager my_viewpage;
    private List<View> views = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hw_iptv_layout);


        my_viewpage = (ViewPager) findViewById(R.id.my_viewpage);

        views.add(getLayoutInflater().inflate(R.layout.layout_hw_tv_one, null));
        views.add(getLayoutInflater().inflate(R.layout.layout_hw_tv_tow, null));
        my_viewpage.setAdapter(new MyViewPageAdapter());
    }


    /**
     * MyViewPageAdapter
     */
    private class MyViewPageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }
    }

}
