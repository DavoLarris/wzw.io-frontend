package android.frontend.wzw.io.wzwio;


import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by DavoLarris on 14/11/2016.
 */
public class Uploader  extends AsyncTask<String, Void, Void> {
    private FormActivity formActivity;


    public Uploader(FormActivity formActivity) {
        attach(formActivity);
    }

    public void attach(FormActivity formActivity) {
        this.formActivity = formActivity;
    }

    public void dettach() {
        this.formActivity = null;
    }


    @Override
    protected Void doInBackground(String... params) {
        String url = params[0];
        String json = params[1];
        WebRequest web = new WebRequest();

        web.postJson(url, json);
        return null;
    }


    @Override
    protected void onPostExecute(Void unused) {
        Toast.makeText(formActivity, "Meetup created successfully", Toast.LENGTH_LONG).show();
        formActivity.goToMenu();
    }

    @Override
    protected void onProgressUpdate(Void... unused) {
    }
}
