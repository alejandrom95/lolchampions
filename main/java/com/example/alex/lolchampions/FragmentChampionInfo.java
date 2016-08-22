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

import com.squareup.picasso.Picasso;

/**
 * Created by Alex on 8/19/16.
 */
public class FragmentChampionInfo extends Fragment {

    private LOLChampions champion;

    private String championKey;
    private String dirImageRoot = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/";
    private String dirImageEnd = ".jpg";

    public static FragmentChampionInfo newInstance(LOLChampions c) {
        FragmentChampionInfo fragment = new FragmentChampionInfo();
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
        View view = inflater.inflate(R.layout.fragment_champion_info, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.championLoadingImage);
        Picasso.with(imageView.getContext()).load(dirImageRoot + championKey + "_0" + dirImageEnd).resize(616,1120).into(imageView);
//        Picasso.with(this).load("http://ddragon.leagueoflegends.com/cdn/6.16.2/img/champion/Amumu.png").into(imageView);

        TextView titleChampionName = (TextView) view.findViewById(R.id.titleChampionName);
        titleChampionName.setText(champion.getName());

        TextView titleChampionSubtitle = (TextView) view.findViewById(R.id.titleChampionSubtitle);
        titleChampionSubtitle.setText(champion.getTitle());

        TextView titleChampionTags = (TextView) view.findViewById(R.id.titleChampionTags);
        String tags = "Type: ";
        for(String i : champion.getTags()) {
            tags = tags + i + " ";
        }
        titleChampionTags.setText(tags);

        TextView infoAttackPower = (TextView) view.findViewById(R.id.infoAttack);
        infoAttackPower.setText("Attack Power: " + champion.getAttackPower() + "/10");
        ProgressBar pbInfoAttackPower = (ProgressBar) view.findViewById(R.id.progressBarAttack);
        pbInfoAttackPower.setProgress(champion.getAttackPower());

        TextView infoDefensePower = (TextView) view.findViewById(R.id.infoDefense);
        infoDefensePower.setText("Defense Power: " + champion.getDefensePower() + "/10");
        ProgressBar pbInfoDefensePower = (ProgressBar) view.findViewById(R.id.progressBarDefense);
        pbInfoDefensePower.setProgress(champion.getDefensePower());

        TextView infoAbilityPower = (TextView) view.findViewById(R.id.infoAbility);
        infoAbilityPower.setText("Ability Power: " + champion.getAbilityPower() + "/10");
        ProgressBar pbInfoAbilityPower = (ProgressBar) view.findViewById(R.id.progressBarAbility);
        pbInfoAbilityPower.setProgress(champion.getAbilityPower());

        TextView infoDifficulty = (TextView) view.findViewById(R.id.infoDifficulty);
        infoDifficulty.setText("Difficulty: " + champion.getDifficulty() + "/10");
        ProgressBar pbInfoDifficulty = (ProgressBar) view.findViewById(R.id.progressBarDifficulty);
        pbInfoDifficulty.setProgress(champion.getDifficulty());

        TextView titleChampionStats = (TextView) view.findViewById(R.id.titleChampionStats);
        titleChampionStats.setText("Stats");

        TextView textChampionStats = (TextView) view.findViewById(R.id.textChampionStats);
        textChampionStats.setText(champion.getStatsText());


        return view;
    }

}
