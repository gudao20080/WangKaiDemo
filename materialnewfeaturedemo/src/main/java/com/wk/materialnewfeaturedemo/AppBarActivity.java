package com.wk.materialnewfeaturedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AppBarActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar);
        ButterKnife.inject(this);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
//        actionBar.setDisplayShowHomeEnabled(true);
        toolbar.setLogo(R.drawable.vv57);
        toolbar.setLogoDescription("这是一个TooBar");
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setTitle("ToolBar");
        toolbar.setContentInsetsAbsolute(10, 108);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AppBarActivity.this, "OnClicked", Toast.LENGTH_SHORT).show();
            }
        });
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_app_bar, menu);
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
