package royal.com.androidconcepts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

public class SimpleRatingBar extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener {

    RatingBar simple_ratingbar;
    TextView simple_ratingbar_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_rating_bar);

        init();
        simple_ratingbar.setOnRatingBarChangeListener(this);
    }

    private void init() {

        simple_ratingbar = (RatingBar)findViewById(R.id.simple_ratingbar);
        simple_ratingbar_tv = (TextView)findViewById(R.id.simple_ratingbar_tv);

    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

        simple_ratingbar_tv.setText(String.valueOf(rating));
    }
}