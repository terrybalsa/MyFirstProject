package com.example.ted.myfirstspecialtopic;


import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class FragmentDrawerAdapter extends ActionBarDrawerToggle {
    private final String[] pageTitles = {"tvymovie", "tvy7movie","tv14movie","tvmamovie"};
    private int itemSelected = 0;
    private ArrayList<Fragment> fragments = new ArrayList<Fragment>();

    private Toolbar toolbar;
    private int DRAWEROPEN, DRAWERCLOSE;


    public FragmentDrawerAdapter(AppCompatActivity activity, DrawerLayout drawerLayout, Toolbar toolbar, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
        super(activity, drawerLayout, toolbar, openDrawerContentDescRes, closeDrawerContentDescRes);

        fragments.add(new Video1Fragment());
        fragments.add(new Video2Fragment());
        fragments.add(new Video3Fragment());
        fragments.add(new Video4Fragment());
        this.toolbar = toolbar;
        DRAWEROPEN = openDrawerContentDescRes;
        DRAWERCLOSE = closeDrawerContentDescRes;
    }


    @Override
    public void onDrawerClosed(View drawerView) {
        toolbar.setTitle(pageTitles[itemSelected]);
        super.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toolbar.setTitle(DRAWEROPEN);
        super.onDrawerOpened(drawerView);
    }


    public Fragment getFragmentAtPos(int position) {
        return fragments.get(position);
    }

    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }



    public String[] getPageTitles() {
        return pageTitles;
    }

    public void setItemSelected(int pos) {
        itemSelected = pos;
    }


}







