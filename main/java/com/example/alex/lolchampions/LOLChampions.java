package com.example.alex.lolchampions;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



/**
 * Created by Alex on 8/15/16.
 */
/*
Get
 */
public class LOLChampions implements Parcelable {




    private String key;

    private String name;
    private String title;

    private int attackPower;
    private int defensePower;
    private int abilityPower;
    private int difficulty;

    private HashMap<Integer,String> skins = new HashMap<Integer, String>();

    private ArrayList<String> tags = new ArrayList<String>();

    private double hp;
    private double hpPerLevel;
    private double mp;
    private double mpPerLevel;
    private double moveSpeed;
    private double armor;
    private double armorPerLevel;
    private double spellBlock;
    private double spellBlockPerLevel;
    private double attackRange;
    private double hpRegen;
    private double hpRegenPerLevel;
    private double mpRegen;
    private double mpRegenPerLevel;
    private double crit;
    private double critPerLevel;
    private double attackDamage;
    private double attackDamagePerLevel;
    private double attackSpeedOffset;
    private double attackSpeedPerLevel;
    private String statsText;

    private String loreString;

    private ArrayList<String> allyTips = new ArrayList<String>();
    private ArrayList<String> enemyTips = new ArrayList<String>();



    private String url;// = "http://ddragon.leagueoflegends.com/cdn/6.16.2/data/en_US/champion/" + key + ".json";

    public LOLChampions(String n) {
        key = n;
        url = "http://ddragon.leagueoflegends.com/cdn/6.16.2/data/en_US/champion/" + key + ".json";
        getChampionData(url);
    }

    //METHODS USED FOR PARCELABLE
    protected LOLChampions(Parcel in) {
        key = in.readString();
        name = in.readString();
        title = in.readString();
        url = in.readString();

        skins = in.readHashMap(String.class.getClassLoader());

        attackPower = in.readInt();
        defensePower = in.readInt();
        abilityPower = in.readInt();
        difficulty = in.readInt();

        tags = in.readArrayList(String.class.getClassLoader());

        hp = in.readDouble();
        hpPerLevel = in.readDouble();
        mp = in.readDouble();
        mpPerLevel = in.readDouble();
        moveSpeed = in.readDouble();
        armor = in.readDouble();
        armorPerLevel = in.readDouble();
        spellBlock = in.readDouble();
        spellBlockPerLevel = in.readDouble();
        attackRange = in.readDouble();
        hpRegen = in.readDouble();
        hpRegenPerLevel = in.readDouble();
        mpRegen = in.readDouble();
        mpRegenPerLevel = in.readDouble();
        crit = in.readDouble();
        critPerLevel = in.readDouble();
        attackDamage = in.readDouble();
        attackDamagePerLevel = in.readDouble();
        attackSpeedOffset = in.readDouble();
        attackSpeedPerLevel = in.readDouble();
        statsText = in.readString();

        loreString = in.readString();

        allyTips = in.readArrayList(String.class.getClassLoader());
        enemyTips = in.readArrayList(String.class.getClassLoader());


    }



    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(key);
        parcel.writeString(name);
        parcel.writeString(title);
        parcel.writeString(url);

        parcel.writeMap(skins);

        parcel.writeInt(attackPower);
        parcel.writeInt(defensePower);
        parcel.writeInt(abilityPower);
        parcel.writeInt(difficulty);

        parcel.writeList(tags);

        parcel.writeDouble(hp);
        parcel.writeDouble(hpPerLevel);
        parcel.writeDouble(mp);
        parcel.writeDouble(mpPerLevel);
        parcel.writeDouble(moveSpeed);
        parcel.writeDouble(armor);
        parcel.writeDouble(armorPerLevel);
        parcel.writeDouble(spellBlock);
        parcel.writeDouble(spellBlockPerLevel);
        parcel.writeDouble(attackRange);
        parcel.writeDouble(hpRegen);
        parcel.writeDouble(hpRegenPerLevel);
        parcel.writeDouble(mpRegen);
        parcel.writeDouble(mpRegenPerLevel);
        parcel.writeDouble(crit);
        parcel.writeDouble(critPerLevel);
        parcel.writeDouble(attackDamage);
        parcel.writeDouble(attackDamagePerLevel);
        parcel.writeDouble(attackSpeedOffset);
        parcel.writeDouble(attackSpeedPerLevel);
        parcel.writeString(statsText);

        parcel.writeString(loreString);

        parcel.writeList(allyTips);
        parcel.writeList(enemyTips);

    }

    private void getChampionData(String url) {

        JSONObject json = getJson(url);
        try {
            JSONObject data = json.getJSONObject("data");
            JSONObject nameObject = data.getJSONObject(key);
            name = nameObject.getString("name");
            title = nameObject.getString("title");

            //GET INFO
            JSONObject info = nameObject.getJSONObject("info");
            attackPower = info.getInt("attack");
            defensePower = info.getInt("defense");
            abilityPower = info.getInt("magic");
            difficulty = info.getInt("difficulty");
            //END GET INFO

            //GET TAGS
            if(name.equals("Teemo")) {
                tags.add("Marksman");
                tags.add("AssasSIN");
            }
            else {
                JSONArray tagsArray = nameObject.getJSONArray("tags");
                for (int i = 0; i < tagsArray.length(); i++) {
                    tags.add(tagsArray.getString(i));
                }
            }
            //END GET TAGS

            //GET BLURB
//            blurb = nameObject.getString("blurb");
//            boolean cont = true;
//            while (cont) {
//                if(blurb.contains("<")) {
//                    int start = blurb.indexOf("<");
//                    int end = blurb.indexOf(">");
//                    String replace = blurb.substring(start, (end + 1));
//                    blurb.replace(replace, "");
//                }
//                else {
//                    cont = false;
//                }
//            }
            //END GET BLURB

            //GET STATS
            JSONObject stats = nameObject.getJSONObject("stats");
            hp = stats.getDouble("hp");
            hpPerLevel = stats.getDouble("hpperlevel");
            mp = stats.getDouble("mp");
            mpPerLevel = stats.getDouble("mpperlevel");
            moveSpeed = stats.getDouble("movespeed");
            armor = stats.getDouble("armor");
            armorPerLevel = stats.getDouble("armorperlevel");
            spellBlock = stats.getDouble("spellblock");
            spellBlockPerLevel = stats.getDouble("spellblockperlevel");
            attackRange = stats.getDouble("attackrange");
            hpRegen = stats.getDouble("hpregen");
            hpRegenPerLevel = stats.getDouble("hpregenperlevel");
            mpRegen = stats.getDouble("mpregen");
            mpRegenPerLevel = stats.getDouble("mpregenperlevel");
            crit = stats.getDouble("crit");
            critPerLevel = stats.getDouble("critperlevel");
            attackDamage = stats.getDouble("attackdamage");
            attackDamagePerLevel = stats.getDouble("attackdamageperlevel");
            attackSpeedOffset = stats.getDouble("attackspeedoffset");
            attackSpeedPerLevel = stats.getDouble("attackspeedperlevel");

            statsText =
                    "HP: " + hp + "\n" +
                    "HP per Level: " + hpPerLevel + "\n" +
                    "Mana: " + mp + "\n" +
                    "Mana per Level: " + mpPerLevel + "\n" +
                    "Movement Speed: " + moveSpeed + "\n" +
                    "Armor: " + armor + "\n" +
                    "Armor per Level: " + armorPerLevel + "\n" +
                    "Magic Resistance: " + spellBlock + "\n" +
                    "Magic Resistance per Level: " + spellBlockPerLevel + "\n" +
                    "Attack Range: " + attackRange + "\n" +
                    "HP Regen: " + hpRegen + "\n" +
                    "HP Regen Per Level: " + hpRegenPerLevel + "\n" +
                    "Mana Regen: " + mpRegen + "\n" +
                    "Mana Regen per Level: " + mpRegenPerLevel + "\n" +
//                    "Crit: " + crit + "\n" +
//                    "Crit per Level: " + critPerLevel  + "\n" +
                    "Attack Damage: " + attackDamage  + "\n" +
                    "Attack Damage per Level: " + attackDamagePerLevel  + "\n" +
                    "Attack Speed Offset: " + attackSpeedOffset  + "\n" +
                    "Attack Speed per Level: " + attackSpeedPerLevel;

            //END GET STATS

            //GET LORE

            loreString = nameObject.getString("lore");
            loreString = Html.fromHtml(loreString).toString();
//            loreString.replaceAll("<br>", "");
//            boolean cont = true;
//            while (cont) {
//                if(loreString.contains("<")) {
//                    int start = loreString.indexOf("<");
//                    int end = loreString.indexOf(">");
//                    String replace = loreString.substring(start, (end + 1));
//                    loreString.replace(replace, "\n");
//                }
//                else {
//                    cont = false;
//                }
//                System.out.println("-");
//            }
            //END GET LORE

            //GET ALLY AND ENEMY TIPS
            JSONArray allyTipsJson = nameObject.getJSONArray("allytips");
            for (int i = 0; i < allyTipsJson.length(); i++) {
                allyTips.add("-" + allyTipsJson.getString(i) + "\n");
            }
            JSONArray enemyTipsJson = nameObject.getJSONArray("enemytips");
            for (int i = 0; i < enemyTipsJson.length(); i++) {
                enemyTips.add("-" + enemyTipsJson.getString(i) + "\n");
            }
            //END GET ALLY AND ENEMY TIPS

            //GET SKINS
            JSONArray skinsArray = nameObject.getJSONArray("skins");

            for(int i = 0; i < skinsArray.length(); i++) {
                //get json object of current skin
                JSONObject temp = skinsArray.getJSONObject(i);
                //get skin number
                Integer skinNum = temp.getInt("num");
                //get skin name
                String skinName = temp.getString("name");
                skins.put(skinNum, skinName);
//                System.out.println("num: " + skinNum + " name: " + skinName);
            }
            //END GET SKINS




        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private JSONObject getJson(String url) {

        JSONObject jsonO = null;

        String jsonString = null;
        try {
            jsonString = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();//readUrl(url);

            jsonO = new JSONObject(jsonString);
            return jsonO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
//        catch (NullPointerException e) {
//
//        }
    }






    //GETTERS
    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
    public String getTitle() {
        return title;
    }

    public HashMap<Integer, String> getSkins() {
        return skins;
    }

    public int getAttackPower() {
        return attackPower;
    }
    public int getDefensePower() {
        return defensePower;
    }
    public int getAbilityPower() {
        return abilityPower;
    }
    public int getDifficulty() {
        return difficulty;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public double getHp() {
        return hp;
    }
    public double getHpPerLevel() {
        return hpPerLevel;
    }
    public double getMp() {
        return mp;
    }
    public double getMpPerLevel() {
        return mpPerLevel;
    }
    public double getMoveSpeed() {
        return moveSpeed;
    }
    public double getArmor() {
        return armor;
    }
    public double getArmorPerLevel() {
        return armorPerLevel;
    }
    public double getSpellBlock() {
        return spellBlock;
    }
    public double getSpellBlockPerLevel() {
        return spellBlockPerLevel;
    }
    public double getAttackRange() {
        return attackRange;
    }
    public double getHpRegen() {
        return hpRegen;
    }
    public double getHpRegenPerLevel() {
        return hpRegenPerLevel;
    }
    public double getMpRegen() {
        return mpRegen;
    }
    public double getMpRegenPerLevel() {
        return mpRegenPerLevel;
    }
    public double getCrit() {
        return crit;
    }
    public double getCritPerLevel() {
        return critPerLevel;
    }
    public double getAttackDamage() {
        return attackDamage;
    }
    public double getAttackDamagePerLevel() {
        return attackDamagePerLevel;
    }
    public double getAttackSpeedOffset() {
        return attackSpeedOffset;
    }
    public double getAttackSpeedPerLevel() {
        return attackSpeedPerLevel;
    }
    public String getStatsText() {
        return statsText;
    }

    public String getLoreString() {
        return loreString;
    }

    public ArrayList<String> getEnemyTips() {
        return enemyTips;
    }
    public ArrayList<String> getAllyTips() {
        return allyTips;
    }
    //END GETTERS




    @Override
    public int describeContents() {
        return 0;
    }
    //END PARCELABLE METHODS

    public static final Creator<LOLChampions> CREATOR = new Creator<LOLChampions>() {
        @Override
        public LOLChampions createFromParcel(Parcel in) {
            return new LOLChampions(in);
        }

        @Override
        public LOLChampions[] newArray(int size) {
            return new LOLChampions[size];
        }
    };

}
