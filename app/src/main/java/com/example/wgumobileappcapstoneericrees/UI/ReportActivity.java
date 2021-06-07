package com.example.wgumobileappcapstoneericrees.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wgumobileappcapstoneericrees.Database.WGUMobileAppCapstoneDB;
import com.example.wgumobileappcapstoneericrees.Entity.Course;
import com.example.wgumobileappcapstoneericrees.Entity.Term;
import com.example.wgumobileappcapstoneericrees.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ReportActivity extends AppCompatActivity {
    private WGUMobileAppCapstoneDB db;
    TextView termData;
    TextView courseData;
    TextView coursesInProgress;
    TextView coursesCompleted;
    TextView coursesDropped;
    TextView coursesPlanToTake;
    TextView reportDateTimeStamp;
    RecyclerView rvProgress;
    RecyclerView rvCompleted;
    RecyclerView rvDropped;
    RecyclerView rvPlan;
    LinearLayoutManager linearLayoutManager;
    ProgressAdapter progressAdapter;
    CompletedAdapter completedAdapter;
    DroppedAdapter droppedAdapter;
    PlanAdapter planAdapter;
    public static int numCourses;
    private List<Course> mCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        db = WGUMobileAppCapstoneDB.getInstance(getApplicationContext());
        termData = findViewById(R.id.eTxt_termsReport);
        courseData = findViewById(R.id.eTxt_coursesReport);
        coursesInProgress = findViewById(R.id.eTxt_coursesInProgressReport);
        coursesCompleted = findViewById(R.id.eTxt_coursesCompletedReport);
        coursesDropped = findViewById(R.id.eTxt_coursesDroppedReport);
        coursesPlanToTake = findViewById(R.id.eTxt_coursesPlanToTakeReport);
        reportDateTimeStamp = findViewById(R.id.eTxt_timestamp);
        rvProgress = findViewById(R.id.rv_progress);
        rvCompleted = findViewById(R.id.rv_completed);
        rvDropped = findViewById(R.id.rv_dropped);
        rvPlan = findViewById(R.id.rv_plan);

        updateReport();
        setProgressAdapter();
        setCompletedAdapter();
        setDroppedAdapter();
        setPlanAdapter();
        dateTimeStamp();
    }

    // Method to set the report with term and course data
    private void updateReport() {
        int term = 0;
        int course = 0;
        int courseInProgress = 0;
        int courseCompleted = 0;
        int courseDropped = 0;
        int coursePlanToTake = 0;

        List<Term> termList = db.termDAO().getAllTerms();
        List<Course> courseList = db.courseDAO().getAllCourses();
        for (int i = 0; i < termList.size(); i++) {
            term = termList.size();
        }
        for (int i = 0; i < courseList.size(); i++) {
            course = courseList.size();
            if (courseList.get(i).getStatus().contains("In Progress")) courseInProgress++;
            if (courseList.get(i).getStatus().contains("Completed")) courseCompleted++;
            if (courseList.get(i).getStatus().contains("Dropped")) courseDropped++;
            if (courseList.get(i).getStatus().contains("Plan to Take")) coursePlanToTake++;
        }
        termData.setText(String.valueOf(term));
        courseData.setText(String.valueOf(course));
        coursesInProgress.setText(String.valueOf(courseInProgress));
        coursesCompleted.setText(String.valueOf(courseCompleted));
        coursesDropped.setText(String.valueOf(courseDropped));
        coursesPlanToTake.setText(String.valueOf(coursePlanToTake));
    }

    // Set progress adapter for recycler view
    private void setProgressAdapter() {
        // Initialize linear layout manager
        linearLayoutManager = new LinearLayoutManager(this);
        // Set layout manager
        rvProgress.setLayoutManager(linearLayoutManager);
        // Initialize adapter
        progressAdapter = new ProgressAdapter(mCourses, this);
        // Set adapter
        rvProgress.setAdapter(progressAdapter);
        // Filter courses by in progress status
        List<Course> filteredCourses = new ArrayList<>();
        for (Course c: db.courseDAO().getAllCourses()) {
            if (c.getStatus().equals("In Progress")) {
                filteredCourses.add(c);
            }
        }
        numCourses = filteredCourses.size();
        progressAdapter.setWords(filteredCourses);
    }

    // Set complete adapter for recycler view
    private void setCompletedAdapter() {
        // Initialize linear layout manager
        linearLayoutManager = new LinearLayoutManager(this);
        // Set layout manager
        rvCompleted.setLayoutManager(linearLayoutManager);
        // Initialize adapter
        completedAdapter = new CompletedAdapter(mCourses, this);
        // Set adapter
        rvCompleted.setAdapter(completedAdapter);
        // Filter courses by in progress status
        List<Course> filteredCourses = new ArrayList<>();
        for (Course c: db.courseDAO().getAllCourses()) {
            if (c.getStatus().equals("Completed")) {
                filteredCourses.add(c);
            }
        }
        numCourses = filteredCourses.size();
        completedAdapter.setWords(filteredCourses);
    }

    // Set dropped adapter for recycler view
    private void setDroppedAdapter() {
        // Initialize linear layout manager
        linearLayoutManager = new LinearLayoutManager(this);
        // Set layout manager
        rvDropped.setLayoutManager(linearLayoutManager);
        // Initialize adapter
        droppedAdapter = new DroppedAdapter(mCourses, this);
        // Set adapter
        rvDropped.setAdapter(droppedAdapter);
        // Filter courses by in progress status
        List<Course> filteredCourses = new ArrayList<>();
        for (Course c: db.courseDAO().getAllCourses()) {
            if (c.getStatus().equals("Dropped")) {
                filteredCourses.add(c);
            }
        }
        numCourses = filteredCourses.size();
        droppedAdapter.setWords(filteredCourses);
    }

    // Set plan adapter for recycler view
    private void setPlanAdapter() {
        // Initialize linear layout manager
        linearLayoutManager = new LinearLayoutManager(this);
        // Set layout manager
        rvPlan.setLayoutManager(linearLayoutManager);
        // Initialize adapter
        planAdapter = new PlanAdapter(mCourses, this);
        // Set adapter
        rvPlan.setAdapter(planAdapter);
        // Filter courses by in progress status
        List<Course> filteredCourses = new ArrayList<>();
        for (Course c: db.courseDAO().getAllCourses()) {
            if (c.getStatus().equals("Plan to Take")) {
                filteredCourses.add(c);
            }
        }
        numCourses = filteredCourses.size();
        planAdapter.setWords(filteredCourses);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateReport();
    }

    // Method to set the current date and time
    private void dateTimeStamp() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy   HH:mm:ss", Locale.getDefault());
        String dateTime = dateFormat.format(calendar.getTime());
        reportDateTimeStamp.setText(dateTime);
    }

    // Menu setup
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // WGU icon sends to home screen
        if (id == R.id.home) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}