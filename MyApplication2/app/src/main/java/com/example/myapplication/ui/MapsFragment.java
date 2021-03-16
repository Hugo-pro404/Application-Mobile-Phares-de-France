package com.example.myapplication.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.phare.PhareContent;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
//        @Override
//        public void onMapReady(GoogleMap googleMap) {
//
//            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//        }
//    };

    @Override
    public void onMapReady(GoogleMap googleMap) {
//        AddMarkerPhareJSON(googleMap);

        //Utilisation du JSON pour créer des markers avec les lat et lon des phares.
        List<PhareContent.PhareItem> Phares = PhareContent.ITEMS;
        for (PhareContent.PhareItem Item : Phares ){
            googleMap.addMarker(new MarkerOptions().position(new LatLng(Item.getLat(), Item.getLon())).title(Item.getNom()).icon(BitmapDescriptorFactory.fromResource(R.drawable.lighthouse_iconpetit)));
        }
        LatLng GARDANNE = new LatLng(43.45, 5.4717363151);

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(GARDANNE, 4));
        if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        } else
            googleMap.setMyLocationEnabled(true);
    }
};


//Première tentative de Création de marker en rechargeant le Json, mais ce n'était pas très propre
//    public static void AddMarkerPhareJSON(GoogleMap googleMap) {
//
//        try {
//
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(MainActivity.getContext().getAssets().open("phares_all.json")));
//            StringBuilder sb = new StringBuilder();
//
//            String line = null;
//            while ((line = br.readLine()) != null)
//            {
//                sb.append(line + "\n");
//            }
//
//
//            String str = sb.toString();
//            JSONObject jObjConnection = new JSONObject(str);
//            JSONObject jsonBix = jObjConnection.getJSONObject("phares");
//            JSONArray jsonA = jsonBix.getJSONArray("liste");
//
//            for(int i = 0 ; i < jsonA.length() ; i++)
//            {
//
//                JSONObject obj = (JSONObject)jsonA.get(i);
//
//                String id = "";
//                String nom = "";
//                String region = "";
//                String auteur = "";
//                int construction = 0;
//                int hauteur = 0;
//                int eclat = 0;
//                int periode = 0;
//                int portee = 0;
//                int automatisation = 0;
//                String caractere = "";
//                double lat = 0;
//                double lon = 0;
//
//                if (!obj.isNull("id")) {
//                    id = obj.getString("id");
//                }
//                if (!obj.isNull("name")) {
//                    nom = obj.getString("name");
//                }
//                if (!obj.isNull("region")) {
//                    region = obj.getString("region");
//                }
//                if (!obj.isNull("auteur")) {
//                    auteur = obj.getString("auteur");
//                }
//                if (!obj.isNull("construction")) {
//                    construction = obj.getInt("construction");
//                }
//                if (!obj.isNull("hauteur")) {
//                    hauteur = obj.getInt("hauteur");
//                }
//                if (!obj.isNull("eclat")) {
//                    eclat = obj.getInt("eclat");
//                }
//                if (!obj.isNull("periode")) {
//                    periode = obj.getInt("periode");
//                }
//                if (!obj.isNull("portee")) {
//                    portee = obj.getInt("portee");
//                }
//                if (!obj.isNull("automatisation")) {
//                    automatisation = obj.getInt("automatisation");
//                }
//                if (!obj.isNull("caractere")) {
//                    caractere = obj.getString("caractere");
//                }
//                if (!obj.isNull("lat")) {
//                    lat = obj.getDouble("lat");
//                }
//                if (!obj.isNull("lon")) {
//                    lon = obj.getDouble("lon");
//                }
//
//                LatLng phare = new LatLng(lat, lon);
//
//                googleMap.addMarker(new MarkerOptions().position(phare).title(nom));
//
//            }
//
//        }
//        catch (IOException | JSONException e) {
//            e.printStackTrace();
//        }
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}