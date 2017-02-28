package com.kobe.ubersplash.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.kobe.ubersplash.R;
import com.kobe.ubersplash.fragment.FragmentApdater;
import com.kobe.ubersplash.fragment.FragmentEasy;
import com.kobe.ubersplash.fragment.FragmentImpro;
import com.kobe.ubersplash.fragment.FragmentRecycler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 2017/2/7.
 */

public class LeftMenu extends AppCompatActivity {

    private TextView userName, gxName;
    private ListView userList;

    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private FragmentApdater fragmentApdater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        initView();
        initData();
    }

    public void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    public void initData() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        List<String> titleList = new ArrayList<>();
        titleList.add("简单");
        titleList.add("瀑布流");
        titleList.add("优化");
        tabLayout.addTab(tabLayout.newTab().setTag(titleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setTag(titleList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setTag(titleList.get(2)));

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentEasy());
        fragments.add(new FragmentRecycler());
        fragments.add(new FragmentImpro());

        fragmentApdater = new FragmentApdater(getSupportFragmentManager(), titleList, fragments);
        viewPager.setAdapter(fragmentApdater);
        //为tabLayout设置ViewPager
        tabLayout.setupWithViewPager(viewPager);
        //该方法支持点击
        tabLayout.setTabsFromPagerAdapter(fragmentApdater);
    }
}
