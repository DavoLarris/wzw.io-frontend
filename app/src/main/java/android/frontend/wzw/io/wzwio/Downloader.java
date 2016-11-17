package android.frontend.wzw.io.wzwio;

import android.os.AsyncTask;

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
public class Downloader extends AsyncTask<String, ArrayList<Meetup>, String> {

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
    protected String doInBackground(String... params) {

        JSONArray meetups;
        ArrayList<Meetup> meetupsList = new ArrayList<Meetup>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

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

                        boolean open = meetupObj.getInt("open") == 0 ? false : true;

                        meetupsList.add(i, new Meetup(meetupObj.getLong("id"), meetupObj.getString("name"), meetupObj.getString("description"), meetup_date, since,(float) meetupObj.getLong("latitude"), (float) meetupObj.getLong("longitude"), open));

                    }
                    this.publishProgress(meetupsList);
                    return "ok";
                } catch (JSONException ex) {
                    ex.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                meetupsList.add(0, new Meetup(1l, "Error get", "Empty JSON: Error found", new Date(), new Date(), 0f, 0f, false));
                return "get error";
            }
        } else {
            meetupsList.add(0, new Meetup(1l, "Error params", "Empty JSON: Error found", new Date(), new Date(), 0f, 0f, false));
            return "params error";
        }

        return "";
    }

    @Override
    protected void onPostExecute(String unused) {
        mainActivity.setupCustomList();
    }

    @Override
    protected void onProgressUpdate(ArrayList<Meetup>... meetups) {
        this.mainActivity.setMeetups(meetups[0]);
    }
}

