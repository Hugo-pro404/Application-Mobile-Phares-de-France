package com.example.myapplication.ui.a_propos;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;

import java.io.IOException;

public class ProposFragment extends Fragment {

    private ProposViewModel proposViewModel;
    final static String TAG = "Video A Propos";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        proposViewModel =
                new ViewModelProvider(this).get(ProposViewModel.class);
        View root = inflater.inflate(R.layout.fragment_propos, container, false);
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource("Vidéo de Phare");
            mediaPlayer.prepare(); // buffering, etc
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final VideoView videoView = root.findViewById(R.id.videoView);
        Uri uri = Uri.parse("https://i.imgur.com/eKnU8f3.mp4");
                videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        videoView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Log.d(TAG , "Clicked ");
                if (videoView.isPlaying())
                    videoView.pause();
                else
                    videoView.start();
            }
        });
        final TextView textNomView = root.findViewById(R.id.text_mNom);
        proposViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textNomView.setText(s);
            }


        });
        return root;
    }
}