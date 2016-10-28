package android.frontend.wzw.io.wzwio;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewMeets;
    private ArrayList<Meetup> meetups;
    private static final String URL = "http://wzw.io/web/admin/api/meetup";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metodoAparte();

        Toolbar toolbar = (Toolbar) findViewById(R.id.myToolbar);
        toolbar.setTitle("WZW");
        setSupportActionBar(toolbar);

        setupData();
        setupCustomList();

    }

    private void metodoAparte(){
        new Downloader(this).execute(URL);
    }

    private void setupData () {
        meetups = new ArrayList<Meetup>();
        meetups.add(new Meetup());
    }

    private void setupCustomList() {
        CustomListAdapter customizedListAdapter = new CustomListAdapter(this, meetups);

        listViewMeets = (ListView) findViewById(R.id.idListView);

        listViewMeets.setAdapter(customizedListAdapter);


        listViewMeets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent myIntent = new Intent(MainActivity.this, DetailActivity.class);
                myIntent.putExtra("Meetup", meetups.get(position));
                startActivity(myIntent);
            }
        });

    }

    public ArrayList<Meetup> getMeetups () {
        return this.meetups;
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
                myIntent = new Intent(MainActivity.this, PreferencesActivity.class);
                startActivity(myIntent);

            case R.id.action_about:
                myIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(myIntent);
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
