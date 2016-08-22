package com.example.alex.lolchampions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Alex on 8/21/16.
 */
public class FragmentChampionSkins extends Fragment{

    private LOLChampions champion;

    private String championKey;
    private String dirImageRoot = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/";
    private String dirImageEnd = ".jpg";

    public static FragmentChampionSkins newInstance(LOLChampions c) {
        FragmentChampionSkins fragment = new FragmentChampionSkins();
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
        View view = inflater.inflate(R.layout.fragment_champion_skins, container, false);

//        ImageView imageView = (ImageView) view.findViewById(R.id.championLoadingImage);
//        Picasso.with(imageView.getContext()).load(dirImageRoot + championKey + "_0" + dirImageEnd).resize(616,1120).into(imageView);
////        Picasso.with(this).load("http://ddragon.leagueoflegends.com/cdn/6.16.2/img/champion/Amumu.png").into(imageView);
//
//
//
//        TextView titleChampionSubtitle = (TextView) view.findViewById(R.id.titleChampionSubtitle);
//        titleChampionSubtitle.setText(champion.getTitle());


        TextView titleChampionSkins = (TextView) view.findViewById(R.id.titleChampionSkins);
        titleChampionSkins.setText(champion.getName() + " Skins");

        LinearLayout innerLayout = (LinearLayout) view.findViewById(R.id.mainInnerLayout);


        int skinNum = 0;
        for(Integer i = 0; i < champion.getSkins().size(); i++) {

            if(!champion.getSkins().containsKey(i)) {
                skinNum++;
                while(!champion.getSkins().containsKey(skinNum)) {
                    skinNum++;
                }
            }
            else {
                skinNum = i;
            }
//            System.out.println("???: " + i + " skin num: " + skinNum);


            ImageView tempIV = new ImageView(getContext());
            tempIV.setMinimumHeight(570);
            LinearLayout.LayoutParams lpImage = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
            lpImage.gravity = Gravity.CENTER_HORIZONTAL;
            tempIV.setLayoutParams(lpImage);
            Picasso.with(tempIV.getContext()).load(dirImageRoot + championKey + "_" + skinNum + dirImageEnd).into(tempIV);
            innerLayout.addView(tempIV);

            TextView tempTV = new TextView(getContext());
//            String num = (String) i;
            tempTV.setText(champion.getSkins().get(skinNum));
//            System.out.println(i + ": " + champion.getSkins().get(i));
            tempTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 32);
            LinearLayout.LayoutParams lpSubtitle = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
            lpSubtitle.gravity = Gravity.CENTER_HORIZONTAL;
            tempTV.setLayoutParams(lpSubtitle);
            innerLayout.addView(tempTV);

            if(i !=  (champion.getSkins().size() - 1)) {
                View space = new View(getContext());
                space.setBackgroundColor(getResources().getColor(R.color.white));
                LinearLayout.LayoutParams lpSpace = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
                lpSpace.height = 20;
                lpSpace.setMargins(0, 30, 0, 30);
                space.setLayoutParams(lpSpace);

                innerLayout.addView(space);
            }
        }



        return view;
    }

}
