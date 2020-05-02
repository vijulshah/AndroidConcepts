package royal.com.androidconcepts;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class BroadcastService extends AppCompatActivity implements View.OnClickListener {

    TimePicker alarm_time;
    ToggleButton btn_toggle;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_service);

        init();
        btn_toggle.setOnClickListener(this);
    }

    private void init() {

        alarm_time = (TimePicker)findViewById(R.id.alarm_time);
        btn_toggle = (ToggleButton)findViewById(R.id.btn_toggle);
        alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
    }

    @Override
    public void onClick(View v) {

        if (btn_toggle.isChecked()==true)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY,alarm_time.getCurrentHour());
            calendar.set(Calendar.MINUTE,alarm_time.getCurrentMinute());

            Intent intent = new Intent(BroadcastService.this,DoBroaadcast.class);
            pendingIntent = PendingIntent.getBroadcast(this,123,intent,PendingIntent.FLAG_ONE_SHOT);

            alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

            Toast.makeText(BroadcastService.this,"Alarm set",Toast.LENGTH_SHORT).show();
        }
        else
        {
            alarmManager.cancel(pendingIntent);
            Toast.makeText(BroadcastService.this,"Alarm cancelled",Toast.LENGTH_SHORT).show();
        }
    }
}
