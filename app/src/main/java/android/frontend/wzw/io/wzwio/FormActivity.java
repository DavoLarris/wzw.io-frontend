package android.frontend.wzw.io.wzwio;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class FormActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String URL = "http://bizgen.co/web/app_dev.php/admin/api/form/meetup/create";
    private EditText title, description, latitude, longuitude, time, date;
    private ToggleButton open;
    private DatePickerDialog DatePickerDialog;
    private TimePickerDialog TimePickerDialog;
    private SimpleDateFormat dateFormatter, timerFormater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        findId();
        setListeners();

    }

    private void findId(){
        title = (EditText) findViewById(R.id.title);
        description = (EditText) findViewById(R.id.description);
        latitude = (EditText) findViewById(R.id.latitude);
        longuitude = (EditText) findViewById(R.id.longuitude);
        open = (ToggleButton) findViewById(R.id.open);
        date = (EditText) findViewById(R.id.date);
        date.setInputType(InputType.TYPE_NULL);
        date.requestFocus();
        time = (EditText) findViewById(R.id.time);
        time.setInputType(InputType.TYPE_NULL);
        time.requestFocus();
    }

    private void setListeners(){
        date.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();

        DatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                date.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        time.setOnClickListener(this);
        TimePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener(){
            public void onTimeSet(TimePicker view, int hour, int min) {
                Calendar newDate = Calendar.getInstance();
                Date dat = new Date();
                dat.setHours(hour);
                dat.setMinutes(min);

                newDate.setTime(dat);
                timerFormater = new SimpleDateFormat("HH:mm", Locale.getDefault());
                time.setText(timerFormater.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.HOUR_OF_DAY), newCalendar.get(Calendar.MINUTE), true);
    }
    @Override
    public void onClick(View view) {
        if(view == date) {
            DatePickerDialog.show();
        } else if (view ==time){
            TimePickerDialog.show();
        }
    }

    public void createEvent(View view){
        int num = open.isChecked()  ? 1 : 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//falta tz
        Date meetup_date = null;
        try {
             meetup_date = format.parse(date.getText().toString()+ "T"+ time.getText().toString()+":00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String json = "{\"meetup\":{\"id\":1,\"name\":\"" + title.getText() + "\",\"description\":\"" + description.getText() + "\",\"latitude\":" + latitude.getText() + ",\"longitude\":" + longuitude.getText() + ",\"open\":"+ num +"}}";
        new Uploader(this).execute(URL, json);

    }

    public void goToMenu() {
        Intent intent = new Intent(FormActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
