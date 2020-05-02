package royal.com.androidconcepts;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationService extends AppCompatActivity {

    private static final String CHANNEL_ID = "My_channel";
    private Button btn_notify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_service);

        btn_notify = (Button)findViewById(R.id.btn_notify);
        btn_notify.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //issueNotification();
                customNotification();
            }
        });
    }

    private void customNotification() {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            String CHANNEL_ID = "my_channel_007";// The id of the channel.
            CharSequence name = "my_channel";// The user-visible name of the channel.
            int importance = NotificationManager.IMPORTANCE_HIGH;
            Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.messageicon)
                    .setContentTitle("New Message")
                    .setContentText("Hello World!")
                    .setAutoCancel(true)
                    .setSound(soundUri)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);;

            // Creating an Audio Attribute
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();

            // Creating Channel
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,name,importance);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setSound(soundUri,audioAttributes);

            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.createNotificationChannel(notificationChannel);
            mNotificationManager.notify(0, notificationBuilder.build());

        }
    }

    void issueNotification() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            int notifyID = 1;
            String CHANNEL_ID = "my_channel_007";// The id of the channel.
            CharSequence name = "my_channel";// The user-visible name of the channel.
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);

            Notification notification = new Notification.Builder(NotificationService.this)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setSmallIcon(R.drawable.messageicon)
                    .setWhen(System.currentTimeMillis())
                    .setContentTitle("New Message")
                    .setContentText("Hello World!")
                    .setDefaults(Notification.DEFAULT_LIGHTS| Notification.DEFAULT_SOUND)
                    .setContentText("You've received new messages.")
                    .setSmallIcon(R.drawable.messageicon)
                    .setChannelId(CHANNEL_ID)
                    .build();

            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.createNotificationChannel(mChannel);

            mNotificationManager.notify(notifyID , notification);
        }
    }
}
