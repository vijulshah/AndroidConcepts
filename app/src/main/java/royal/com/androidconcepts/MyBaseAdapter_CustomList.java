package royal.com.androidconcepts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyBaseAdapter_CustomList extends BaseAdapter {

    Context context;
    ArrayList<DataModel> dataModelArrayList;

    public MyBaseAdapter_CustomList(Context context, ArrayList<DataModel> dataModelArrayList)
    {
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
        convertView = layoutInflater.inflate(R.layout.raw_custom_list_view,null);

        TextView tvdata = (TextView)convertView.findViewById(R.id.tv_custom_list_data);
        ImageView imgdata = (ImageView)convertView.findViewById(R.id.imgview_custom_list_data);

        tvdata.setText(dataModelArrayList.get(position).getStrData());
        imgdata.setImageResource(dataModelArrayList.get(position).getImgData());

        return convertView;
    }
}
