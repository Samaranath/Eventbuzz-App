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

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    private Context context;
    private LayoutInflater inflater;
    private List<MyData> my_data;

    public CustomAdapter(Context context, List<MyData> my_data) {
        //Log.d("LOG_TAG","const");
        this.context = context;
        inflater=LayoutInflater.from(context);
        this.my_data = my_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.description.setText(my_data.get(position).getDescription());
        holder.name.setText(my_data.get(position).getName());
        holder.venue.setText(my_data.get(position).getVenue());
        holder.starttime.setText(my_data.get(position).getStarttime());
        holder.startdate.setText(my_data.get(position).getStartdate());
        holder.endtime.setText(my_data.get(position).getEndtime());
        holder.enddate.setText(my_data.get(position).getEnddate());

        Log.d("LOG_TAG","From adapter"+my_data.get(position).getDescription()+my_data.get(position).getName()+my_data.get(position).getVenue());
        //Glide.with(context).load(my_data.get(position).getImage_link()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return my_data.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView description,name,venue,startdate,enddate,starttime,endtime;
       // public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            description = (TextView) itemView.findViewById(R.id.description);
            name = (TextView) itemView.findViewById(R.id.name);
            venue = (TextView) itemView.findViewById(R.id.venue);
            startdate = (TextView) itemView.findViewById(R.id.startdate);
            starttime= (TextView) itemView.findViewById(R.id.starttime);
            enddate = (TextView) itemView.findViewById(R.id.enddate);
            endtime = (TextView) itemView.findViewById(R.id.endtime);
        }
    }
}
