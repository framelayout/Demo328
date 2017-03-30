package com.lm.demo328;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int Shuangjituichu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Shuangjituichu=0;



    }

    public void ShowNotification(View view) {
        NotificationManager manager= (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent=new Intent(MainActivity.this,Main2Activity.class);

        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setContentTitle("title")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("123456")
                .setContentIntent(pendingIntent);

        manager.notify(0,builder.build());


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK)
        {
            if (Shuangjituichu==1)
            {
                this.finish();

            }
            else {
                Shuangjituichu++;
                Toast.makeText(this, "double click to quit!", Toast.LENGTH_SHORT).show();
            }
        }

        return false;
    }



}
