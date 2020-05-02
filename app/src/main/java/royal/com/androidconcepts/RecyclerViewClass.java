package royal.com.androidconcepts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewClass extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView recyclerViewHorizontal;
    String strData[] = {"Android","JAVA","PHP","C",".net","C++"};
    int imgData[] = {R.drawable.android,R.drawable.java,R.drawable.php,R.drawable.c_language,R.drawable.dotnetone,R.drawable.c_plus};

    ArrayList<DataModel> dataModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerViewHorizontal = (RecyclerView)findViewById(R.id.recyclerViewHorizontal);
        dataModelArrayList = new ArrayList<DataModel>();

        for(int i=0; i<strData.length;i++)
        {
            DataModel dataModel = new DataModel(strData[i],imgData[i]);
            dataModelArrayList.add(dataModel);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        LinearLayoutManager layoutManagerHorizontal = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        recyclerViewHorizontal.setLayoutManager(layoutManagerHorizontal);

        MyAdapter_RecyclerView myAdapter_recyclerView = new MyAdapter_RecyclerView(this,dataModelArrayList);
        recyclerView.setAdapter(myAdapter_recyclerView);
        recyclerViewHorizontal.setAdapter(myAdapter_recyclerView);
    }
}
