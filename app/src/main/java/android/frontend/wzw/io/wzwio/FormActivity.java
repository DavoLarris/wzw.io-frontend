package android.frontend.wzw.io.wzwio;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class FormActivity extends AppCompatActivity {
    private static final String URL = "http://wzw.io/web/admin/api/meetup";
    //private static final String URL = "http://wzw.io/meetup.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_form);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Toolbar toolbar = (Toolbar) findViewById(R.id.myToolbar);
        toolbar.setTitle("WZW");
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent;

        switch (item.getItemId()) {
            case R.id.action_settings:
                myIntent = new Intent(FormActivity.this, PreferencesActivity.class);
                startActivity(myIntent);

            case R.id.action_about:
                myIntent = new Intent(FormActivity.this, AboutActivity.class);
                startActivity(myIntent);
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
