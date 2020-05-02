package royal.com.androidconcepts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomSpinner extends AppCompatActivity implements Spinner.OnItemSelectedListener{

    private Spinner custom_spinner;
    private String strData[] = {"---Select---","Android","JAVA","PHP","C",".net","C++"};
    private int imgData[] = {0,R.drawable.android,R.drawable.java,R.drawable.php,R.drawable.c_language,R.drawable.dotnetone,R.drawable.c_plus};
    ArrayList<DataModel> dataModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_spinner);

        custom_spinner = (Spinner)findViewById(R.id.custom_spinner);
        dataModelArrayList = new ArrayList<DataModel>();

        for(int i=0;i<strData.length;i++)
        {
            DataModel dataModel = new DataModel(strData[i],imgData[i]);
            dataModelArrayList.add(dataModel);
        }
        MyBaseAdapter_CustomSpinner myBaseAdapter_customSpinner
                = new MyBaseAdapter_CustomSpinner(this,dataModelArrayList);
        custom_spinner.setAdapter(myBaseAdapter_customSpinner);

        custom_spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String data = ((TextView)view.findViewById(R.id.tv_custom_spinner)).getText().toString();
        if(!data.equals("---Select---"))
        Toast.makeText(this, "You selected : "+data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
