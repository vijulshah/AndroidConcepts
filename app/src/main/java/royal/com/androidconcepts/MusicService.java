package royal.com.androidconcepts;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MusicService extends AppCompatActivity implements View.OnClickListener,SeekBar.OnSeekBarChangeListener {

    private ImageView iv_music_img;
    private ImageButton btn_previous;
    private ImageButton btn_play;
    private ImageButton btn_next;
    private SeekBar seekbar_music;
    private boolean paused=true;
    MyMusicPlayer mp3;
    private int click = 1;

    private boolean playPause;
    private boolean initialStage = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_service);

        init();


    }

    private void init() {
        mp3 = new MyMusicPlayer();
        iv_music_img = (ImageView)findViewById(R.id.iv_music_img);
        btn_previous = (ImageButton)findViewById(R.id.btn_previous);
        btn_play = (ImageButton)findViewById(R.id.btn_play);
        btn_next = (ImageButton)findViewById(R.id.btn_next);
        seekbar_music = (SeekBar)findViewById(R.id.seekbar_music);
        btn_previous.setOnClickListener(this);
        btn_play.setOnClickListener(this);
        btn_next.setOnClickListener(this);
        seekbar_music.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_previous :
            {

            }
            break;

            case R.id.btn_play : {

                if (paused) {
                    if (click == 1) {
                        Intent i = new Intent(this, MyMusicPlayer.class);
                        startService(i);
                        click++;
                        paused = false;
                        btn_play.setImageResource(R.drawable.ic_pause);
                    } else {

                        mp3.mediaPlayer.start();
                        paused = false;
                        btn_play.setImageResource(R.drawable.ic_pause);
                    }
                } else {
                    mp3.mediaPlayer.pause();
                    paused = true;
                    btn_play.setImageResource(R.drawable.ic_play);
                }
            }

            break;

            case R.id.btn_next :
            {

            }
            break;

            default :
            {

            }
            break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }




}
