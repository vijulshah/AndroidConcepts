package royal.com.androidconcepts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleSpinner extends AppCompatActivity {

    Spinner simple_spinner;
    String[] myspinner_list= {"---Select---","Android","JAVA","PHP","C",".net","C++"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_spinner);

        init();
        spinnerFuntion();
    }

    private void spinnerFuntion() {

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SimpleSpinner.this,android.R.layout.simple_list_item_1,myspinner_list)
        {
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                TextView tv = (TextView)super.getDropDownView(position, convertView, parent);
                return tv;
            }
        };
        simple_spinner.setAdapter(arrayAdapter);
        simple_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String data = parent.getItemAtPosition(position).toString();
                if(!data.equals("---Select---"))
                Toast.makeText(SimpleSpinner.this,"You selected : "+data,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void init() {

        simple_spinner = (Spinner)findViewById(R.id.simple_spinner);
    }
}
