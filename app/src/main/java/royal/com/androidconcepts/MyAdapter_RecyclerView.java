package royal.com.androidconcepts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter_RecyclerView extends RecyclerView.Adapter<MyAdapter_RecyclerView.MyViewHolder> {

    Context context;
    ArrayList<DataModel> dataModelArrayList;

    public MyAdapter_RecyclerView(Context context, ArrayList<DataModel> dataModelArrayList) {

        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }

    @NonNull
    @Override
    public MyAdapter_RecyclerView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        //LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.raw_recycler_view,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter_RecyclerView.MyViewHolder myViewHolder, int i) {

        myViewHolder.imageView.setImageResource(dataModelArrayList.get(i).getImgData());
        myViewHolder.textView.setText(dataModelArrayList.get(i).getStrData());
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = (TextView)itemView.findViewById(R.id.rv_tv);
            imageView = (ImageView)itemView.findViewById(R.id.rv_img);
        }
    }
}
