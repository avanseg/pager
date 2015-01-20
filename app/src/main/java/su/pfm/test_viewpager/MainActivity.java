package su.pfm.test_viewpager;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    ViewPager mViewPager;
    SamplePagerAdapter mSectionsPagerAdapter;
    RadioButton rb,rb1,rb2,rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = LayoutInflater.from(this);
        List<View> pages = new ArrayList<View>();

        View page = inflater.inflate(R.layout.activity2, null);
        pages.add(page);
        View page2 = inflater.inflate(R.layout.activity3, null);
        pages.add(page2);
        View page3 = inflater.inflate(R.layout.activity4, null);
        pages.add(page3);

        rb1=(RadioButton) findViewById(R.id.rb1);
        rb1.setOnClickListener(this);
        rb2=(RadioButton) findViewById(R.id.rb2);
        rb2.setOnClickListener(this);
        rb3=(RadioButton) findViewById(R.id.rb3);
        rb3.setOnClickListener(this);

        mSectionsPagerAdapter = new SamplePagerAdapter(pages);
        mViewPager = (ViewPager) findViewById(R.id.pager);

        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch(position)
                {
                    case 0: rb=(RadioButton) findViewById(R.id.rb1); break;
                    case 1: rb=(RadioButton) findViewById(R.id.rb2); break;
                    case 2: rb=(RadioButton) findViewById(R.id.rb3); break;
                }
                rb.setChecked(true);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb1:  mViewPager.setCurrentItem(0); break;
            case R.id.rb2:  mViewPager.setCurrentItem(1); break;
            case R.id.rb3:  mViewPager.setCurrentItem(2); break;
        }

        Toast.makeText(this, Integer.toString(mViewPager.getCurrentItem()+1)  , Toast.LENGTH_SHORT).show();
    }


    public class SamplePagerAdapter extends PagerAdapter {

        List<View> pages = null;

        public SamplePagerAdapter(List<View> pages){
            this.pages = pages;
        }

        @Override
        public Object instantiateItem(View collection, int position){
            View v = pages.get(position);
            ((ViewPager) collection).addView(v, 0);
            return v;
        }

        @Override
        public void destroyItem(View collection, int position, Object view){
            ((ViewPager) collection).removeView((View) view);
        }

        @Override
        public int getCount(){
            return pages.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object){
            return view.equals(object);
        }

        @Override
        public void finishUpdate(View arg0){
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1){
        }

        @Override
        public Parcelable saveState(){
            return null;
        }

        @Override
        public void startUpdate(View arg0){
        }
    }
}
