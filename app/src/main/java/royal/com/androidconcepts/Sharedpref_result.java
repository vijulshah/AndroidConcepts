package royal.com.androidconcepts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Sharedpref_result extends AppCompatActivity {

    TextView tv_sharefpref_result;
    Button btn_del_sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpref_result);

        tv_sharefpref_result = (TextView)findViewById(R.id.tv_sharefpref_result);
        btn_del_sharedpref = (Button)findViewById(R.id.btn_del_sharedpref);

        final SharedPreferences sharedPreferences = getSharedPreferences("MY_DATA",MODE_PRIVATE);

        String txt = sharedPreferences.getString("DATA","");

        tv_sharefpref_result.setText(txt);

        btn_del_sharedpref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences.edit().clear().commit();
                Toast.makeText(Sharedpref_result.this,"Data Deleted",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Sharedpref_result.this,SharedPref.class);
                startActivity(i);
                finish();
            }
        });
    }
}
