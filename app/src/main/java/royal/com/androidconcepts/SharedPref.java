package royal.com.androidconcepts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPref extends AppCompatActivity implements View.OnClickListener {

    EditText edt_sharedpref_data;
    Button btn_edt_sharedpref_save,btn_next_page;
    TextView tvname_sharedpref,tv_show_sharedpref_data;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        init();
        btn_edt_sharedpref_save.setOnClickListener(this);
        btn_next_page.setOnClickListener(this);
    }

    private void init() {

        edt_sharedpref_data = (EditText)findViewById(R.id.edt_sharedpref_data);
        btn_edt_sharedpref_save = (Button)findViewById(R.id.btn_edt_sharedpref_save);
        tvname_sharedpref = (TextView)findViewById(R.id.tvname_sharedpref);
        btn_next_page = (Button)findViewById(R.id.btn_next_page);
        tv_show_sharedpref_data = (TextView) findViewById(R.id.tv_show_sharedpref_data);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_edt_sharedpref_save: {

                String txt = edt_sharedpref_data.getText().toString();

                sharedPreferences = getSharedPreferences("MY_DATA",MODE_PRIVATE);
                SharedPreferences.Editor editor =  sharedPreferences.edit();
                editor.putString("DATA",txt);
                editor.commit();
                edt_sharedpref_data.setText("");

                Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.btn_next_page: {

                Intent i =new Intent(this,Sharedpref_result.class);
                startActivity(i);
                finish();
            }
            break;

            default: {

            }
        }
    }
}
