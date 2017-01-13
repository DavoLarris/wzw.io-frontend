package android.frontend.wzw.io.wzwio;


import android.os.AsyncTask;

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

    }

    @Override
    protected void onProgressUpdate(Void... unused) {
    }
}
