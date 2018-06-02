package com.example.sravyanaguboyina.eventbuzz;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.bumptech.glide.Glide;

import java.util.List;
/**
 * Created by sravya naguboyina on 26-03-2018.
 */

class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.ViewHolder>{
    private Context context;
    private LayoutInflater inflater;
    private List<MyData2> my_data;

    public CustomAdapter2(Context context, List<MyData2> my_data) {
        //Log.d("LOG_TAG","const");
        this.context = context;
        inflater=LayoutInflater.from(context);
        this.my_data = my_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card2,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.empid.setText(my_data.get(position).getempid());
        holder.descr.setText(my_data.get(position).getdescr());
        holder.date.setText(my_data.get(position).getdate());
        holder.time.setText(my_data.get(position).gettime());
        holder.semester.setText(my_data.get(position).getsem());
        holder.branch.setText(my_data.get(position).getbranch());

        Log.d("LOG_TAG","From adapter2"+my_data.get(position).getempid()+my_data.get(position).getdescr()+my_data.get(position).getdate()+my_data.get(position).gettime()+my_data.get(position).getsem()+my_data.get(position).getbranch());
        //Glide.with(context).load(my_data.get(position).getImage_link()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return my_data.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView descr,date,time,semester,branch,empid;
        // public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            empid=(TextView)itemView.findViewById(R.id.name1);
            descr = (TextView) itemView.findViewById(R.id.description1);
            date = (TextView) itemView.findViewById(R.id.d);
            time = (TextView) itemView.findViewById(R.id.t);
            semester = (TextView) itemView.findViewById(R.id.s);
            branch= (TextView) itemView.findViewById(R.id.b);

        }
    }
}
