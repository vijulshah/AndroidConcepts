package royal.com.androidconcepts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleListView extends AppCompatActivity {

    ListView simple_listview;
    String strData[] = {"Android","IOS","JAVA","PHP",".net","C","C++"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);

        simple_listview = (ListView)findViewById(R.id.simple_listview);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.raw_simple_list_view,R.id.tv_simple_list_view_data,strData);
        simple_listview.setAdapter(arrayAdapter);
    }
}