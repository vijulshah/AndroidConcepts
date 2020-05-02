package royal.com.androidconcepts;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityResultClass extends AppCompatActivity {

    TextView txtview_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_class);

        txtview_show = (TextView)findViewById(R.id.txtview_show);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 11)
        {
            String txt = data.getStringExtra("DATA");
            txtview_show.setText(txt);
        }
    }
}
