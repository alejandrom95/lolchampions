package com.example.alex.lolchampions;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity  {

    private String region;
//    private String[] arraySpinner;
//
//    private HashMap<String,String[]> spinnerRegionKeys = new HashMap<String, String[]>();

    private ArrayList<String> championList = new ArrayList<String>();
    private HashMap<String, String> correctKeys = new HashMap<String, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SET UP MENUBAR

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_menubar);
        setSupportActionBar(myToolbar);
        //END MENUBAR

        //ADD CHAMPIONS TO LIST
        championList.add("Aatrox");
        championList.add("Ahri");
        championList.add("Akali");
        championList.add("Alistar");
        championList.add("Amumu");
        championList.add("Anivia");
        championList.add("Annie");
        championList.add("Ashe");
        championList.add("Aurelion Sol");
        championList.add("Azir");
        championList.add("Bard");
        championList.add("Blitzcrank");
        championList.add("Brand");
        championList.add("Braum");
        championList.add("Caitlyn");
        championList.add("Cassiopeia");
        championList.add("Cho'Gath");
        championList.add("Corki");
        championList.add("Darius");
        championList.add("Diana");
        championList.add("Dr. Mundo");
        championList.add("Draven");
        championList.add("Ekko");
        championList.add("Elise");
        championList.add("Evelynn");
        championList.add("Ezreal");
        championList.add("Fiddlesticks");
        championList.add("Fiora");
        championList.add("Fizz");
        championList.add("Galio");
        championList.add("Gangplank");
        championList.add("Garen");
        championList.add("Gnar");
        championList.add("Gragas");
        championList.add("Graves");
        championList.add("Hecarim");
        championList.add("Heimerdinger");
        championList.add("Illaoi");
        championList.add("Irelia");
        championList.add("Janna");
        championList.add("Jarvan IV");
        championList.add("Jax");
        championList.add("Jayce");
        championList.add("Jhin");
        championList.add("Jinx");
        championList.add("Kalista");
        championList.add("Karma");
        championList.add("Karthus");
        championList.add("Kassadin");
        championList.add("Katarina");
        championList.add("Kayle");
        championList.add("Kennen");
        championList.add("Kha'Zix");
        championList.add("Kindred");
        championList.add("Kled");
        championList.add("Kog'Maw");
        championList.add("LeBlanc");
        championList.add("Lee Sin");
        championList.add("Leona");
        championList.add("Lissandra");
        championList.add("Lucian");
        championList.add("Lulu");
        championList.add("Lux");
        championList.add("Malphite");
        championList.add("Malzahar");
        championList.add("Maokai");
        championList.add("Master Yi");
        championList.add("Miss Fortune");
        championList.add("Mordekaiser");
        championList.add("Morgana");
        championList.add("Nami");
        championList.add("Nasus");
        championList.add("Nautilus");
        championList.add("Nidalee");
        championList.add("Nocturne");
        championList.add("Nunu");
        championList.add("Olaf");
        championList.add("Orianna");
        championList.add("Pantheon");
        championList.add("Poppy");
        championList.add("Quinn");
        championList.add("Rammus");
        championList.add("Rek'Sai");
        championList.add("Renekton");
        championList.add("Rengar");
        championList.add("Riven");
        championList.add("Rumble");
        championList.add("Ryze");
        championList.add("Sejuani");
        championList.add("Shaco");
        championList.add("Shen");
        championList.add("Shyvana");
        championList.add("Singed");
        championList.add("Sion");
        championList.add("Sivir");
        championList.add("Skarner");
        championList.add("Sona");
        championList.add("Soraka");
        championList.add("Swain");
        championList.add("Syndra");
        championList.add("Tahm Kench");
        championList.add("Taliyah");
        championList.add("Talon");
        championList.add("Taric");
        championList.add("Teemo");
        championList.add("Thresh");
        championList.add("Tristana");
        championList.add("Trundle");
        championList.add("Tryndamere");
        championList.add("Twisted Fate");
        championList.add("Twitch");
        championList.add("Udyr");
        championList.add("Urgot");
        championList.add("Varus");
        championList.add("Vayne");
        championList.add("Veigar");
        championList.add("Vel'Koz");
        championList.add("Vi");
        championList.add("Viktor");
        championList.add("Vladimir");
        championList.add("Volibear");
        championList.add("Warwick");
        championList.add("Wukong");
        championList.add("Xerath");
        championList.add("Xin Zhao");
        championList.add("Yasuo");
        championList.add("Yorick");
        championList.add("Zac");
        championList.add("Zed");
        championList.add("Ziggs");
        championList.add("Zilean");
        championList.add("Zyra");


        //END ADD CHAMPIONS TO LIST

        //SET UP HASH MAP WITH CORRECT KEYS FOR CHAMPION NAMES
        correctKeys.put("Cho'Gath", "Chogath");
        correctKeys.put("Dr. Mundo", "DrMundo");
        correctKeys.put("Fiddlesticks", "FiddleSticks");
        correctKeys.put("Kha'Zix", "Khazix");
        correctKeys.put("Kog'Maw", "KogMaw");
        correctKeys.put("LeBlanc", "Leblanc");
        correctKeys.put("Wukong", "MonkeyKing");
        correctKeys.put("Rek'Sai", "RekSai");
        correctKeys.put("Vel'Koz", "Velkoz");

        //END HASHMAP SET UP


//        for(int i = 0; i < championList.size(); i++) {
//            FetchChampionsTask summonerTask = new FetchChampionsTask();
//
//            String keyValue = championList.get(i);
//            if(correctKeys.containsKey(keyValue)) {
//                keyValue = correctKeys.get(keyValue);
//            }
//            summonerTask.execute(keyValue);
//            System.out.println("???");
//        }

        //ADD CHAMPION BUTTONS
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.mainInnerLayout);
        addChampionButtons(linearLayout, championList);

        //END ADD CHAMPION BUTTONS



    }




    public class FetchChampionsTask extends AsyncTask<String, Void, LOLChampions> {

        @Override
        protected LOLChampions doInBackground(String... params) {

            LOLChampions champion = null;//-----------------------------------------------------------------
            try {
                //make sure params are lowercase and have no spaces
                champion = new LOLChampions(params[0].replaceAll("\\s+", ""));
            }
            catch (RuntimeException e) {
                System.out.println("invalid search");
            }

            return champion;
        }

        @Override
        protected void onPostExecute(LOLChampions champion) {
            super.onPostExecute(champion);
            if(champion == null) {
                //DISPLAY MESSAGE TELLING USER IT'S A WRONG INPUT
                Toast.makeText(MainActivity.this, "INVALID CHAMPION NAME", Toast.LENGTH_LONG).show();
            } else {
                //SEND CHAMPION TO NEW ACTIVITY
                Intent i = new Intent(MainActivity.this, ChampionDisplayActivity.class);
                Bundle b = new Bundle();
                b.putParcelable("Champion", champion);
                i.putExtras(b);
                startActivity(i);

            }


//            if(result != null) {
//                TextView dis = (TextView) findViewById(R.id.textView1);
//                dis.setText(String.valueOf((result.getSummonerLevel())));
//            }
        }
    }

    private void addChampionButtons(LinearLayout linLayout, ArrayList<String> championList) {
        for(String i : championList) {
            final Button button = new Button(this);
            button.setText(i);
            button.setTextColor(getApplication().getResources().getColor(R.color.black));

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //call task that gets champion info
                    FetchChampionsTask summonerTask = new FetchChampionsTask();
                    String keyValue = button.getText().toString();
                    if(correctKeys.containsKey(keyValue)) {
                        keyValue = correctKeys.get(keyValue);
                    }
                    summonerTask.execute(keyValue);


                }
            });
//            String buttonName = "button" + i;
//            button.setId(Integer.parseInt(buttonName));
//            button.setGravity(Integer.parseInt("center_vertical"));

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);

            linLayout.addView(button, lp);
        }
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


//    //LISTEN FOR BUTTON SELECTIONS
//    @Override
//    public void onClick(View view) {
//
//
//        view.getId()
//    }

}








/*

        //SET UP REGION SPINNER IN MAIN ACTIVITY
        this.arraySpinner = new String[] {
                "Brazil", "Europe Nordic & East", "Europe West",
                "Latin America North", "Latin America South",
                "North America", "Oceania", "Russia", "Turkey",
                "Japan", "South East Asia", "Republic of Korea",
                "Public Beta Environment"
        };
        final Spinner sRegions = (Spinner) findViewById(R.id.spinnerRegions);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        sRegions.setAdapter(adapter);
        //END REGION SPINNER

        //SET UP HASHMAP

        spinnerRegionKeys.put("Brazil","br");
        spinnerRegionKeys.put("Europe Nordic & East","eune");
        spinnerRegionKeys.put("Europe West","euw");
        spinnerRegionKeys.put("Latin America North","lan");
        spinnerRegionKeys.put("Latin America South","las");
        spinnerRegionKeys.put("North America","na");
        spinnerRegionKeys.put("Oceania","oce");
        spinnerRegionKeys.put("Russia","ru");
        spinnerRegionKeys.put("Turkey","tr");
        spinnerRegionKeys.put("Japan","jp");
        spinnerRegionKeys.put("South East Asia","sea");
        spinnerRegionKeys.put("Republic of Korea","kr");
        spinnerRegionKeys.put("Public Beta Environment","pbe");

        //END HASHMAP


        //when region is changed, change region value
        sRegions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                region = sRegions.getSelectedItem().toString();
                region = spinnerRegionKeys.get(sRegions.getSelectedItem().toString());
            }
            //does nothing
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {}

        });
 */