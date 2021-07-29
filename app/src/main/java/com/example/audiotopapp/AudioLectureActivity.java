package com.example.audiotopapp;

import androidx.appcompat.app.AppCompatActivity;
import models.Fichier;
import remote.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class AudioLectureActivity extends AppCompatActivity {

    // creating a variable for
    // button and media player
    Button playBtn, pauseBtn;
    TextView titreAudio, dureeAudio;
    ImageView imageView;
    MediaPlayer mediaPlayer;
    String audio_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent mIntent = getIntent();
        audio_name = mIntent.getStringExtra("audio_name");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_lecture);

       // Toast.makeText(getApplicationContext(), "Audio = "+audio_name, Toast.LENGTH_LONG).show();
          /* *****************************************/

        String audioUrl = "http://audioapp.tdigitale.com/public/files/fichiers_audios/"+audio_name+".mp3";

        // initializing media player
        mediaPlayer = new MediaPlayer();
        // below line is use to set the audio
        // stream type for our media player.
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(audioUrl);
            mediaPlayer.prepare();
            dureeAudio = findViewById(R.id.textView7);
            dureeAudio.setText(timerConversion((long) mediaPlayer.getDuration()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        /***********************************************/


        // initializing our buttons
        playBtn = findViewById(R.id.idBtnPlay);
        pauseBtn = findViewById(R.id.idBtnPause);
        imageView = findViewById(R.id.imageView);
        titreAudio = findViewById(R.id.textView5);
        titreAudio.setText(audio_name);

        // setting on click listener for our play and pause buttons.
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling method to play audio.
                playAudio(audio_name);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking the media player
                // if the audio is playing or not.
                if (mediaPlayer.isPlaying()) {
                    // pausing the media player if media player
                    // is playing we are calling below line to
                    // stop our media player.
                    mediaPlayer.stop();
//                    mediaPlayer.pause();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    imageView.clearAnimation();

                    // below line is to display a message
                    // when media player is paused.
                    Toast.makeText(AudioLectureActivity.this, "Audio has been paused", Toast.LENGTH_SHORT).show();
                } else {
                    // this method is called when media
                    // player is not playing.
                    Toast.makeText(AudioLectureActivity.this, "Audio has not played", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //lireAudio();
    }

    //time conversion
    public String timerConversion(long value) {
        String audioTime;
        int dur = (int) value;
        int hrs = (dur / 3600000);
        int mns = (dur / 60000) % 60000;
        int scs = dur % 60000 / 1000;

        if (hrs > 0) {
            audioTime = String.format("%02d:%02d:%02d", hrs, mns, scs);
        } else {
            audioTime = String.format("%02d:%02d", mns, scs);
        }
        return audioTime;
    }
    private void playAudio(String audio_name) {

        String audioUrl = "http://audioapp.tdigitale.com/public/files/fichiers_audios/"+audio_name+".mp3";

        // initializing media player
        mediaPlayer = new MediaPlayer();


        // below line is use to set the audio
        // stream type for our media player.
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        // below line is use to set our
        // url to our media player.
        try {
            mediaPlayer.setDataSource(audioUrl);
            // below line is use to prepare
            // and start our media player.

            mediaPlayer.prepare();
            mediaPlayer.start();
            imageView.animate().rotation(10000).setDuration(mediaPlayer.getDuration());

        } catch (IOException e) {
            e.printStackTrace();
        }
        // below line is use to display a toast message.
        Toast.makeText(this, "Audio started playing..", Toast.LENGTH_SHORT).show();
    }
}


