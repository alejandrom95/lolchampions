package com.example.alex.lolchampions;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.os.ParcelableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Alex on 8/21/16.
 */
public class FragmentChampionTips extends Fragment{
    private LOLChampions champion;

    private String championKey;
    private String dirImageRoot = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/";
    private String dirImageEnd = ".jpg";

    public static FragmentChampionTips newInstance(LOLChampions c) {
        FragmentChampionTips fragment = new FragmentChampionTips();
        Bundle bundle = new Bundle();
        bundle.putParcelable("C", c);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        champion = (LOLChampions) this.getArguments().getParcelable("C");
        championKey = champion.getKey();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_champion_tips, container, false);


        TextView textChampionTipsAlly = (TextView) view.findViewById(R.id.textChampionTipsAlly);
        String allyTipsText = "";
        for(String i : champion.getAllyTips()) {
            allyTipsText = allyTipsText + i;
        }
        textChampionTipsAlly.setText(allyTipsText);

        TextView textChampionTipsEnemy = (TextView) view.findViewById(R.id.textChampionTipsEnemy);
        String enemyTipsText = "";
        for(String i : champion.getEnemyTips()) {
            enemyTipsText = enemyTipsText + i;
        }
        textChampionTipsEnemy.setText(enemyTipsText);



        return view;
    }

}

