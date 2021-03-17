package com.example.myapplication.ui.phare;


import android.graphics.Color;

import com.example.myapplication.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PhareContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<PhareItem> ITEMS = new ArrayList<PhareItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, PhareItem> ITEM_MAP = new HashMap<String, PhareItem>();

    private static final int COUNT = 25;

    public PhareContent() {
    }

    /*
    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }
     */

    private static void addItem(PhareItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

//    private static PhareItem createPhareItem(int position) {
//        return new PhareItem(String.valueOf(position), "Phare " + position);
//    }


    /**
     * fabrique les data
     */
    public static void loadPhareJSON() {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(MainActivity.getContext().getAssets().open("phares_all.json")));
            StringBuilder sb = new StringBuilder();

            String line = null;
            while ((line = br.readLine()) != null)
            {
                sb.append(line + "\n");
            }


            String str = sb.toString();
            JSONObject jObjConnection = new JSONObject(str);
            JSONObject jsonBix = jObjConnection.getJSONObject("phares");
            JSONArray jsonA = jsonBix.getJSONArray("liste");

            for(int i=0 ; i< jsonA.length() ; i++)
            {

                JSONObject obj = (JSONObject)jsonA.get(i);

                String id = "";
                String nom = "";
                String region = "";
                String auteur = "";
                int construction = 0;
                int hauteur = 0;
                int eclat = 0;
                int periode = 0;
                int portee = 0;
                int automatisation = 0;
                String caractere = "";
                double lat = 0;
                double lon = 0;

                if (!obj.isNull("id")) {
                    id = obj.getString("id");
                }
                if (!obj.isNull("name")) {
                    nom = obj.getString("name");
                }
                if (!obj.isNull("region")) {
                    region = obj.getString("region");
                }
                if (!obj.isNull("auteur")) {
                    auteur = obj.getString("auteur");
                }
                if (!obj.isNull("construction")) {
                    construction = obj.getInt("construction");
                }
                if (!obj.isNull("hauteur")) {
                    hauteur = obj.getInt("hauteur");
                }
                if (!obj.isNull("eclat")) {
                    eclat = obj.getInt("eclat");
                }
                if (!obj.isNull("periode")) {
                    periode = obj.getInt("periode");
                }
                if (!obj.isNull("portee")) {
                    portee = obj.getInt("portee");
                }
                if (!obj.isNull("automatisation")) {
                    automatisation = obj.getInt("automatisation");
                }
                if (!obj.isNull("caractere")) {
                    caractere = obj.getString("caractere");
                }
                if (!obj.isNull("lat")) {
                    lat = obj.getDouble("lat");
                }
                if (!obj.isNull("lon")) {
                    lon = obj.getDouble("lon");
                }

                ITEMS.add(new PhareItem(id, nom, region, auteur, construction, hauteur, eclat, periode, portee, automatisation, caractere, lat, lon));



            }

        }
        catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }


//    private static String makeDetails(int position) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Details about Item: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore details information here.");
//        }
//        return builder.toString();
//    }

    /**
     * A Phara item representing a piece of content.
     */
    public static class PhareItem {
        public final String id;
        public final String nom;
        public final String region;
        public final String auteur;
        public final int construction;
        public final int hauteur;
        public final int eclat;
        public final int periode;
        public final int portee;
        public final int automatisation;
        public final String caractere;
        public final Double lat;
        public final Double lon;

        public String getId() {
            return id;
        }

        public String getNom() {
            return nom;
        }

        public String getRegion() {
            return region;
        }

        public String getAuteur() {
            return auteur;
        }

        public int getConstruction() {
            return construction;
        }

        public int getHauteur() {
            return hauteur;
        }

        public int getEclat() {
            return eclat;
        }

        public int getPeriode() {
            return periode;
        }

        public int getPortee() {
            return portee;
        }

        public int getAutomatisation() {
            return automatisation;
        }

        public String getCaractere() {
            return caractere;
        }

        public Double getLat() {
            return lat;
        }

        public Double getLon() {
            return lon;
        }



        public PhareItem(String id, String nom, String region, String auteur, Integer construction, Integer hauteur, Integer eclat, Integer periode, Integer portee, Integer automatisation, String caractere, Double lat, Double lon) {
            this.id = id;
            this.nom = nom;
            this.region = region;
            this.auteur = auteur;
            this.construction = construction;
            this.hauteur = hauteur;
            this.eclat = eclat;
            this.periode = periode;
            this.portee = portee;
            this.automatisation = automatisation;
            this.caractere = caractere;
            this.lat = lat;
            this.lon = lon;
        }



//        @Override
//        public String toString() {
//            return id;
//        }
    }
}