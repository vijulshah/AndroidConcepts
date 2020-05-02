package royal.com.androidconcepts;

import android.content.ContentResolver;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

public class CustomSeekBar extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar custom_seekBar;
    TextView custom_seekbar_tv;

    ContentResolver contentResolver;
    Window window;
    int brightness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_seek_bar);

        init();
        custom_seekBar.setOnSeekBarChangeListener(this);
    }

    private void init() {

        custom_seekBar = (SeekBar)findViewById(R.id.custom_seekbar);
        custom_seekbar_tv = (TextView)findViewById(R.id.custom_seekbar_tv);

        contentResolver = getContentResolver();
        window = getWindow();

        try {

            brightness = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS);
            custom_seekBar.setProgress(brightness);
            custom_seekbar_tv.setText("current brightness: "+String.valueOf(brightness));

        }catch (Settings.SettingNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        this.brightness = progress;
        Settings.System.putInt(contentResolver,Settings.System.SCREEN_BRIGHTNESS,brightness);

        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.screenBrightness = brightness/(float)255;
        window.setAttributes(layoutParams);

        custom_seekbar_tv.setText("current brightness: "+String.valueOf(brightness));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {


    }
}
