package cnu.spendit;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by taylo on 1/31/2018.
 */

public class MoneyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SharedPreferences userData = getApplicationContext().getSharedPreferences("cnu.spendit", Context.MODE_PRIVATE);
        SharedPreferences.Editor dataEditor = userData.edit();
        Bundle dataBundle = intent.getBundleExtra("Info");


        if(userData.getInt("budget", 0)==0){
            dataEditor.putInt("budget",0);
            dataEditor.commit();
        }

        if(userData.getInt("balance", 0)==0){
            dataEditor.putInt("balance",0);
            dataEditor.commit();
        }


        return START_NOT_STICKY;
    }
}
