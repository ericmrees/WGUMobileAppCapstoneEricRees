package com.example.wgumobileappcapstoneericrees.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wgumobileappcapstoneericrees.Entity.Course;
import com.example.wgumobileappcapstoneericrees.R;

import java.util.ArrayList;
import java.util.List;

public class DroppedAdapter extends RecyclerView.Adapter<DroppedAdapter.DroppedViewHolder> {
    class DroppedViewHolder extends RecyclerView.ViewHolder {
        private final TextView dropped;

        private DroppedViewHolder(View itemView) {
            super(itemView);
            dropped = itemView.findViewById(R.id.col_dropped);
        }
    }

    //private final LayoutInflater mInflater;
    private final Context context;
    private List<Course> mCourses;

    public DroppedAdapter(List<Course> courseList, Context context) {
        mCourses = courseList;
        this.context = context;
    }

    @Override
    public DroppedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_dropped, parent, false);
        return new DroppedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DroppedViewHolder holder, int position) {
        if (mCourses != null) {
            /*final*/ Course currentCourse = mCourses.get(position);
            if (currentCourse.getStatus().equals("Dropped")) {
                holder.dropped.setText(currentCourse.getCourseName());
            }
        } else {
            holder.dropped.setText("No Word");
        }
    }

    public void setWords(List<Course> words) {
        mCourses = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mCourses != null)
            return mCourses.size();
        else return 0;
    }

    public void filterList(ArrayList<Course> filteredList) {
        mCourses = filteredList;
        notifyDataSetChanged();
    }
}