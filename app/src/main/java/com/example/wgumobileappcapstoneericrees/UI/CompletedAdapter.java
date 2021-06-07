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

public class CompletedAdapter extends RecyclerView.Adapter<CompletedAdapter.CompletedViewHolder> {
    class CompletedViewHolder extends RecyclerView.ViewHolder {
        private final TextView completed;

        private CompletedViewHolder(View itemView) {
            super(itemView);
            completed = itemView.findViewById(R.id.col_completed);
        }
    }

    //private final LayoutInflater mInflater;
    private final Context context;
    private List<Course> mCourses;

    public CompletedAdapter(List<Course> courseList, Context context) {
        mCourses = courseList;
        this.context = context;
    }

    @Override
    public CompletedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_completed, parent, false);
        return new CompletedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CompletedViewHolder holder, int position) {
        if (mCourses != null) {
            /*final*/ Course currentCourse = mCourses.get(position);
            if (currentCourse.getStatus().equals("Completed")) {
                holder.completed.setText(currentCourse.getCourseName());
            }
        } else {
            holder.completed.setText("No Word");
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