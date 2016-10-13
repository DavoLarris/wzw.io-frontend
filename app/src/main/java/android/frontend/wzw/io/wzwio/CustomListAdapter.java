package android.frontend.wzw.io.wzwio;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DavoLarris on 13/10/2016.
 */
public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Meetup> meetups;

    public CustomListAdapter(Activity activity, ArrayList<Meetup> meetups){
        super();
        this.activity = activity;
        this.meetups = meetups;
    }

    @Override
    public int getCount() {
        return meetups.size();
    }

    @Override
    public Object getItem(int position) {
        return meetups.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_row, null);

        }

        Meetup meetup = meetups.get(position);

        ImageView imageViewIcon = (ImageView) v.findViewById(R.id.idImage);
        imageViewIcon.setImageResource(meetup.getPicture());

        TextView textViewTitle = (TextView) v.findViewById(R.id.idTitle);
        textViewTitle.setText(meetup.getTitle());

        TextView textViewText = (TextView) v.findViewById(R.id.idDescription);
        textViewText.setText(meetup.getDescription());

        return v;
    }
}
