package android.frontend.wzw.io.wzwio;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by DavoLarris on 28/10/2016.
 */
public class Downloader extends AsyncTask<String, String, ArrayList<Meetup>> {

    private MainActivity mainActivity;


    public Downloader(MainActivity mainActivity) {
        attach(mainActivity);
    }

    public void attach(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void dettach() {
        this.mainActivity = null;
    }

    @Override
    protected ArrayList<Meetup> doInBackground(String... params) {
        /*
        JSONArray meetups;
        ArrayList<Meetup> meetupsList = new ArrayList<Meetup>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        try {
            meetups = new JSONArray("[{\"id\":1,\"name\":\"Caza de Pokemon\",\"description\":\"Quedada para pillar pokemons\",\"since\":\"2016-10-09T00:00:00+0200\",\"meetup_date\":\"2016-10-25T00:00:00+0200\",\"open\":1,\"latitude\":0,\"longitude\":0},{\"id\":2,\"name\":\"Estudiar Android\",\"description\":\"Quedada para estudiar Android\",\"since\":\"2016-10-10T00:00:00+0200\",\"meetup_date\":\"2016-10-24T00:00:00+0200\",\"open\":1,\"latitude\":0,\"longitude\":0}]");
            for (int i = 0; i < meetups.length(); i++) {
                JSONObject meetupObj = meetups.getJSONObject(i);

                Date meetup_date = format.parse(meetupObj.getString("meetup_date"));
                Date since = format.parse(meetupObj.getString("since"));

                meetupsList.add(i, new Meetup(meetupObj.getLong("id"), meetupObj.getString("name"), meetupObj.getString("description"), meetup_date, since,(float) meetupObj.getLong("latitude"), (float) meetupObj.getLong("longitude")));

            }
            this.publishProgress(meetupsList);
            return "ok";
        } catch (JSONException ex) {
            ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        -----------------------------------------------
        if (params.length > 0) {
            String url = params[0];

            WebRequest web = new WebRequest();

            if (web.get(url)) {
                try {
                    meetups = new JSONArray(web.getResponseString());
                    for (int i = 0; i < meetups.length(); i++) {
                        JSONObject meetupObj = meetups.getJSONObject(i);

                        Date meetup_date = format.parse(meetupObj.getString("meetup_date"));
                        Date since = format.parse(meetupObj.getString("since"));

                        meetupsList.add(i, new Meetup(meetupObj.getLong("id"), meetupObj.getString("name"), meetupObj.getString("description"), meetup_date, since,(float) meetupObj.getLong("latitude"), (float) meetupObj.getLong("longitude")));

                    }
                    this.publishProgress(meetupsList);
                    return "ok";
                } catch (JSONException ex) {
                    ex.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                meetupsList.add(0, new Meetup(1l, "Grror get", "Empty JSON: Error found", new Date(), new Date(), 0f, 0f));
                return "get error";
            }
        } else {
            meetupsList.add(0, new Meetup(1l, "Prror params", "Empty JSON: Error found", new Date(), new Date(), 0f, 0f));
            return "params error";
        }
        */
        //meetupsList.add(0, new Meetup(1l, "Prror params", "Empty JSON: Error found", new Date(), new Date(), 0f, 0f));
        ArrayList<Meetup> meetupsList = new ArrayList<Meetup>();
        meetupsList.add(0, new Meetup(1l, "Grror get", "Empty JSON: Error found", new Date(), new Date(), 0f, 0f));
        //this.publishProgress(meetupsList);
        return meetupsList;

    }

    @Override
    protected void onPostExecute(ArrayList<Meetup> meetups) {
        this.mainActivity.setMeetups(meetups);
        //Log.d("DEBUGGINGWZW", meetupsList.get(0).getTitle());
        //this.mainActivity.setMeetups(meetupsList);
    }

    @Override
    protected void onProgressUpdate(String... meetups) {
        //this.mainActivity.setMeetups(meetups[0]);
    }
}

