package com.shakticonsultant.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.shakticonsultant.JobDescriptionActivity;
import com.shakticonsultant.R;
import com.shakticonsultant.responsemodel.JobAppliedListDatumResponse;
import com.shakticonsultant.responsemodel.ScheduleInterviewDatumResponse;

import java.util.List;

public class ScheduleInterviewAdapter extends RecyclerView.Adapter<ScheduleInterviewAdapter.ViewHolder> {

    List<ScheduleInterviewDatumResponse> list;
    Context context;

    public ScheduleInterviewAdapter(Context context) {

        this.context = context;
        this.list = list;
    }

    public ScheduleInterviewAdapter(Context context, List<ScheduleInterviewDatumResponse> list) {

        this.context = context;
        this.list = list;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_scheduled_interviews_layout, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {


        viewHolder.tvTitle.setText(list.get(position).getTitle());
        viewHolder.tvTime.setText("Time: "+list.get(position).getSchedule_time());
        viewHolder.tvday.setText(list.get(position).getSchedule_day());
        String currentdate = list.get(position).getSchedule_date();
        String[] separated = currentdate.split("-");
        String number=separated[0]; // this will contain "Fruit"
        String month=separated[1]; // this will contain " they taste good"

        viewHolder.tvdate.setText(number);
        viewHolder.tvmonth.setText(month);



        viewHolder.btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            /*    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(position).getGoogle_meet_link()));
                context.startActivity(intent);
*/
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+list.get(position).getGoogle_meet_link())));

            }
        });
      //  viewHolder.tvDate.setText(list.get(position).getIcon());

/*
viewHolder.lJobCategory.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

Intent i=new Intent(context,SpecificFacultyJobActivity.class);
i.putExtra("skill_id",list.get(position).getId());
i.putExtra("skill_name",list.get(position).getTitle());
context.startActivity(i);
    }
});*/
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle,tvdate,tvday,tvTime,tvmonth;
        ImageView imgIcon;
        Button btnJoin;
     //   LinearLayout lJobCategory;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            tvTitle = (TextView) itemLayoutView.findViewById(R.id.textView79);
            tvdate = (TextView) itemLayoutView.findViewById(R.id.textView76);
            tvday = (TextView) itemLayoutView.findViewById(R.id.textView78);
            tvTime = (TextView) itemLayoutView.findViewById(R.id.textView80);
            tvmonth = (TextView) itemLayoutView.findViewById(R.id.textView77);

            btnJoin = (Button) itemLayoutView.findViewById(R.id.btnJoin);

        }


    }

    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return list.size();
    }

    public  void clear(){
        int size = list.size();
        list.clear();

        notifyItemRangeRemoved(0, size);
    }

}
