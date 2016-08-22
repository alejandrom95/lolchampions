package com.example.alex.lolchampions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Alex on 8/19/16.
 */
public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 5;
    private String tabTitles[] = new String[] { "Info", "Skins", "Lore", "Tips", "Abilities" };
    private Context context;

    LOLChampions champion;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context, LOLChampions c) {
        super(fm);
        this.context = context;
        champion = c;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                //SEND CHAMPION TO NEW ACTIVITY
//                Intent i = new Intent(SampleFragmentPagerAdapter.this, FragmentChampionInfo.class);
//                Bundle b = new Bundle();
//                b.putParcelable("Champion", champion);
//                i.putExtras(b);
//                startActivity(i);
                return FragmentChampionInfo.newInstance(champion);
            case 1:
                return FragmentChampionSkins.newInstance(champion);
            case 2:
                return FragmentChampionLore.newInstance(champion);
            case 3:
                return FragmentChampionTips.newInstance(champion);
            default:
                return FragmentChampionInfo.newInstance(champion);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
