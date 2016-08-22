package com.example.alex.lolchampions;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ChampionDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_display);

        //SET UP MENUBAR

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_menubar);
        setSupportActionBar(myToolbar);
        //END MENUBAR

        //GET CHAMPION OBJECT
        LOLChampions champion = null;
        Bundle b = this.getIntent().getExtras();
        if (b != null)
            champion = b.getParcelable("Champion");
        //END GET CHAMPION OBJECT

//        myToolbar.setTitle("Champion: " + champion.getName());
//        setSupportActionBar(myToolbar);
        //END MENUBAR


        SampleFragmentPagerAdapter sfpa = new SampleFragmentPagerAdapter(getSupportFragmentManager(),
                ChampionDisplayActivity.this, champion);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(sfpa);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        tabLayout.setSelectedTabIndicatorHeight(16);
        tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.white), Color.GREEN);

    }


















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
//            case R.id.about:
//                Intent intent = new Intent(this, AboutActivity.class);
////                EditText editText = (EditText) findViewById(R.id.edit_message);
////                String message = editText.getText().toString();
////                intent.putExtra(EXTRA_MESSAGE, message);
//                startActivity(intent);
//                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}

/*
public class ChampionDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_display);

        //SET UP MENUBAR

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_menubar);

        //GET CHAMPION OBJECT
        LOLChampions champion = null;
        Bundle b = this.getIntent().getExtras();
        if (b != null)
            champion = b.getParcelable("Champion");
        //END GET CHAMPION OBJECT

        myToolbar.setTitle("Champion: " + champion.getName());
        setSupportActionBar(myToolbar);
        //END MENUBAR





        ImageView imageView = (ImageView) findViewById(R.id.championLoadingImage);
        Picasso.with(this).load("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/Velkoz_0.jpg").resize(616,1120).into(imageView);
//        Picasso.with(this).load("http://ddragon.leagueoflegends.com/cdn/6.16.2/img/champion/Amumu.png").into(imageView);
        TextView titleChampionName = (TextView) findViewById(R.id.titleChampionName);
        titleChampionName.setText(champion.getName());
        TextView titleChampionSubtitle = (TextView) findViewById(R.id.titleChampionSubtitle);
        titleChampionSubtitle.setText(champion.getTitle());
        TextView infoAttackPower = (TextView) findViewById(R.id.infoAttack);
        infoAttackPower.setText("Attack Power: " + champion.getAttackPower() + "/10");
        ProgressBar pbInfoAttackPower = (ProgressBar) findViewById(R.id.progressBarAttack);
        pbInfoAttackPower.setProgress(champion.getAttackPower());
    }


















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
//            case R.id.about:
//                Intent intent = new Intent(this, AboutActivity.class);
////                EditText editText = (EditText) findViewById(R.id.edit_message);
////                String message = editText.getText().toString();
////                intent.putExtra(EXTRA_MESSAGE, message);
//                startActivity(intent);
//                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
*/