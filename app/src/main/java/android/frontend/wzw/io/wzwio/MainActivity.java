package android.frontend.wzw.io.wzwio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewMeets;
    private ArrayList<Meetup> meetups;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupData();
        setupCustomList();
    }

    private void setupData () {
        meetups = new ArrayList<Meetup>();
        meetups.add(new Meetup());
        meetups.add(new Meetup());
        meetups.add(new Meetup());
    }


    private void setupCustomList() {
        CustomListAdapter customizedListAdapter = new CustomListAdapter(this, meetups);

        listViewMeets = (ListView) findViewById(R.id.idListView);

        listViewMeets.setAdapter(customizedListAdapter);


        listViewPeople.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent myIntent = new Intent(MainActivity.this, DetailActivity.class);
                myIntent.putExtra("Meetup", meetups.get(position));
                startActivity(myIntent);
            }
        });

    }
}
