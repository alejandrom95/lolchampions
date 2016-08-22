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
 * Created by Alex on 8/21/16.
 */
public class FragmentChampionLore extends Fragment {
    private LOLChampions champion;

    private String championKey;
    private String dirImageRoot = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/";
    private String dirImageEnd = ".jpg";

    public static FragmentChampionLore newInstance(LOLChampions c) {
        FragmentChampionLore fragment = new FragmentChampionLore();
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
        View view = inflater.inflate(R.layout.fragment_champion_lore, container, false);


        TextView textChampionLore = (TextView) view.findViewById(R.id.textChampionLore);
        textChampionLore.setText(champion.getLoreString());



        return view;
    }

}
