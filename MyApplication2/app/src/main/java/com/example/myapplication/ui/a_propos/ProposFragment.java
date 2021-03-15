package com.example.myapplication.ui.a_propos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;

public class ProposFragment extends Fragment {

    private ProposViewModel proposViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        proposViewModel =
                new ViewModelProvider(this).get(ProposViewModel.class);
        View root = inflater.inflate(R.layout.fragment_propos, container, false);
        final TextView textView = root.findViewById(R.id.text_propos);
        proposViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}