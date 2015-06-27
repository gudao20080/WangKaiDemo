package com.example.administrator.multipackagedemo;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_show_channel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChannelNameInApplication();
            }
        });
    }

//    public void showChannelName() {
//        try {
//            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
//
//            if (null != activityInfo.metaData) {
//                String channel = activityInfo.metaData.getString("UMENG_CHANNEL");
//                Toast.makeText(this, channel, Toast.LENGTH_SHORT).show();
//            }else{
//                Toast.makeText(this, "activityInfo.metaData 是空的", Toast.LENGTH_SHORT).show();
//            }
//
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    public void showChannelNameInApplication() {
        try {
            ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            String channel = applicationInfo.metaData.getString("UMENG_CHANNEL");
            Toast.makeText(this, channel, Toast.LENGTH_SHORT).show();

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
