package android.frontend.wzw.io.wzwio;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    //private Meetup meetup
    private TextView txtNombre, txtDesc, txtCoord;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        createActionBar();

        txtNombre = (TextView)findViewById(R.id.idNombre);
        txtDesc = (TextView)findViewById(R.id.idDesc);
        txtCoord = (TextView)findViewById(R.id.idCoord);
        image = (ImageView) findViewById(R.id.foto);


        //Person == Meetup
        //Meetup = (Meetup) getIntent().getExtras().getSerializable("Meetup"); //getIntent().getSerializableExtra("Meetup")


        //if (Meetup != null) {
        //    txtNombre.setText(Meetup.getName());
        //    txtNombre.setText(Meetup.getDesc());
        //    txtNombre.setText(Meetup.getCoord());
       //     image.setImageResource(Meetup.getFoto());
       // }


    }

    private void createActionBar(){
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
