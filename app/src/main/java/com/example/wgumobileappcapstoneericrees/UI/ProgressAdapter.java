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

public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.ProgressViewHolder> {
    class ProgressViewHolder extends RecyclerView.ViewHolder {
        private final TextView inProgress;

        private ProgressViewHolder(View itemView) {
            super(itemView);
            inProgress = itemView.findViewById(R.id.col_inProgress);
        }
    }

    //private final LayoutInflater mInflater;
    private final Context context;
    private List<Course> mCourses;

    public ProgressAdapter(List<Course> courseList, Context context) {
        mCourses = courseList;
        this.context = context;
    }

    @Override
    public ProgressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_progress, parent, false);
        return new ProgressViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProgressViewHolder holder, int position) {
        if (mCourses != null) {
            /*final*/ Course currentCourse = mCourses.get(position);
            if (currentCourse.getStatus().equals("In Progress")) {
                holder.inProgress.setText(currentCourse.getCourseName());
            }
        } else {
            holder.inProgress.setText("No Word");
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