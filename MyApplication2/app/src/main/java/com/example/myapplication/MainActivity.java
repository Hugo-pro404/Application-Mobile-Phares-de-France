package com.example.myapplication;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.myapplication.ui.MapsFragment;
import com.example.myapplication.ui.phare.PhareContent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;

    static Context context; //1) définition var statique


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getApplicationContext(); //2) Initialisation context
        PhareContent.loadPhareJSON();


        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_liste, R.id.nav_map, R.id.nav_propos)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


//            // Listview Data
//        List<PhareContent.PhareItem> Phares = PhareContent.ITEMS;
//        for (PhareContent.PhareItem Item : Phares ){
//
//        lv = (ListView) findViewById(R.id.list);
//        inputSearch = (EditText) findViewById(R.id.menu_activity_main_search);
//
//        // Adding items to listview
//        adapter = new ArrayAdapter<String>(this, R.layout.fragment_phare, R.id.nom);
//        lv.setTextFilterEnabled(true);
//    }
//
//            /**
//             * Enabling Search Filter
//             * */
//            inputSearch.addTextChangedListener(new TextWatcher() {
//
//                @Override
//                public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
//                    // When user changed the Text
//                    MainActivity.this.adapter.getFilter().filter(cs);
//                }
//
//                @Override
//                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
//                                              int arg3) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void afterTextChanged(Editable arg0) {
//                    // TODO Auto-generated method stub
//                }
//            });


        }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_activity_main_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    //Action sur le bouton recherche
    if(item.getItemId() == R.id.menu_activity_main_search) {
        Toast.makeText(this, "Recherche indisponible, demandez plutôt l'avis de Google, c'est mieux et plus rapide.", Toast.LENGTH_LONG).show();
        return true;
    }
    else
            return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public static Context getContext(){
        return context;
    }

}