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

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.PlanViewHolder> {
    class PlanViewHolder extends RecyclerView.ViewHolder {
        private final TextView planToTake;

        private PlanViewHolder(View itemView) {
            super(itemView);
            planToTake = itemView.findViewById(R.id.col_planToTake);
        }
    }

    //private final LayoutInflater mInflater;
    private final Context context;
    private List<Course> mCourses;

    public PlanAdapter(List<Course> courseList, Context context) {
        mCourses = courseList;
        this.context = context;
    }

    @Override
    public PlanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_plan, parent, false);
        return new PlanViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlanViewHolder holder, int position) {
        if (mCourses != null) {
            /*final*/ Course currentCourse = mCourses.get(position);
            if (currentCourse.getStatus().equals("Plan to Take")) {
                holder.planToTake.setText(currentCourse.getCourseName());
            }
        } else {
            holder.planToTake.setText("No Word");
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