package royal.com.androidconcepts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class GridViewClass extends AppCompatActivity {

    GridView gridView;
    String strData[] = {"Android","JAVA","PHP","C",".net","C++"};
    int imgData[] = {R.drawable.android,R.drawable.java,R.drawable.php,R.drawable.c_language,R.drawable.dotnetone,R.drawable.c_plus};

    ArrayList<DataModel> dataModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_class);

        gridView = (GridView)findViewById(R.id.grid_view);

        dataModelArrayList = new ArrayList<DataModel>();

        for(int i=0; i<strData.length;i++)
        {
            DataModel dataModel = new DataModel(strData[i],imgData[i]);
            dataModelArrayList.add(dataModel);
        }

        MyBaseAdapter_GridView myBaseAdapter = new MyBaseAdapter_GridView(this,dataModelArrayList);
        gridView.setAdapter(myBaseAdapter);
    }

}
