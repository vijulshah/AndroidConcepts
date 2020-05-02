package royal.com.androidconcepts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class CardViewClass extends AppCompatActivity {

    GridView cardView;
    String strData[] = {"Android","JAVA","PHP","C",".net","C++"};
    int imgData[] = {R.drawable.android,R.drawable.java,R.drawable.php,R.drawable.c_language,R.drawable.dotnetone,R.drawable.c_plus};

    ArrayList<DataModel> dataModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_class);

        cardView = (GridView) findViewById(R.id.cardView);

        dataModelArrayList = new ArrayList<DataModel>();

        for(int i=0; i<strData.length;i++)
        {
            DataModel dataModel = new DataModel(strData[i],imgData[i]);
            dataModelArrayList.add(dataModel);
        }

        MyAdapter_CardView myAdapter_cardView = new MyAdapter_CardView(this,dataModelArrayList);
        cardView.setAdapter(myAdapter_cardView);
    }
}
