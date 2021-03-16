package com.example.myapplication.ui;

import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import com.example.myapplication.ui.phare.PhareContent.PhareItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PhareItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPhareRecyclerViewAdapter extends RecyclerView.Adapter<MyPhareRecyclerViewAdapter.ViewHolder> {

    private final List<PhareItem> mValues;

    public MyPhareRecyclerViewAdapter(List<PhareItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_phare, parent, false);
        return new ViewHolder(view);
    }

    final static String TAG = "MainActivity";

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNomView.setText(mValues.get(position).nom);
        holder.mRegionView.setText(mValues.get(position).region);
        holder.mConstructionView.setText(String.valueOf(mValues.get(position).construction));
        holder.mView.setOnClickListener (new View.OnClickListener() {
        @Override
        public void onClick (View v) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
            alertDialogBuilder.setTitle(mValues.get(position).getNom());
            alertDialogBuilder.setMessage("Region : " + mValues.get(position).getRegion() + "\n"
                    + "Construction : " + mValues.get(position).getConstruction() + "\n"
                    + "Hauteur : " + mValues.get(position).getHauteur() + "\n"
                    + "Eclat : " + mValues.get(position).getEclat() + "\n"
                    + "Période : " + mValues.get(position).getPeriode() + "\n"
                    + "Portée : " + mValues.get(position).getPortee() + "\n"
                    + "Caractère : " + mValues.get(position).getCaractere() + "\n"
                    + "Date d'automatisation : " + mValues.get(position).getAutomatisation() + "\n"
                    + "Source : " + mValues.get(position).getAuteur() + "\n");
            alertDialogBuilder.setCancelable(true);
            alertDialogBuilder.show();

            Log.d(TAG , "Clicked " + position);
            }
        });
    }





    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNomView;
        public final TextView mRegionView;
        public final TextView mConstructionView;

        public PhareItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNomView = (TextView) view.findViewById(R.id.nom);
            mRegionView = (TextView) view.findViewById(R.id.region);
            mConstructionView = (TextView) view.findViewById(R.id.construction);

        }
    }
}