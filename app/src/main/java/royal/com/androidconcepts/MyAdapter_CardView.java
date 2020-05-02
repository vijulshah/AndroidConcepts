package royal.com.androidconcepts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter_CardView extends BaseAdapter {

    Context context;
    ArrayList<DataModel> dataModelArrayList;

    public MyAdapter_CardView(Context context, ArrayList<DataModel> dataModelArrayList) {

        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public int getCount() {
        return dataModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.raw_card_view,null);

        ImageView imageView = (ImageView)convertView.findViewById(R.id.cv_img);
        TextView textView = (TextView)convertView.findViewById(R.id.cv_tv);

        imageView.setImageResource(dataModelArrayList.get(position).getImgData());
        textView.setText(dataModelArrayList.get(position).getStrData());

        return convertView;
    }
}
