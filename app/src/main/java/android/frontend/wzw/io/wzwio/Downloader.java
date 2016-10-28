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

    public void attach(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    public void dettach(){
        this.mainActivity = null;
    }

    @Override
    protected String doInBackground(String... params) {
        JSONArray meetups;
        ArrayList<Meetup> meetupsList = new ArrayList<Meetup>();

        if (params.length > 0) {
            String url = params[0];

            WebRequest web = new WebRequest();

            if (web.get(url)) {
                try{
                    meetups = new JSONArray(web.getResponseString());
                    for (int i = 0; i < meetups.length(); i++) {
                        JSONObject meetupObj = meetups.getJSONObject(i);
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); //IGUAL ESTO NO VA BIEN, REVISAAR SI FALLAN LAS FECHAS

                        Date meetup_date = format.parse(meetupObj.getString("meetup_date"));
                        Date since = format.parse(meetupObj.getString("since"));

                        meetupsList.add(i, new Meetup(meetupObj.getLong("id"),meetupObj.getString("name"), meetupObj.getString("description"), meetup_date, since, 0f, 0f));

                        this.publishProgress(meetupsList);
                    }

                } catch (JSONException ex){
                    ex.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }




        } else {
            return "";
        }

    }
}
