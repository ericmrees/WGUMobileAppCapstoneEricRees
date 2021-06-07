package com.example.wgumobileappcapstoneericrees.UI;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wgumobileappcapstoneericrees.Database.WGUMobileAppCapstoneDB;
import com.example.wgumobileappcapstoneericrees.Entity.Course;
import com.example.wgumobileappcapstoneericrees.Entity.Term;
import com.example.wgumobileappcapstoneericrees.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TermDetailsActivity extends AppCompatActivity {
    WGUMobileAppCapstoneDB db;
    LinearLayoutManager linearLayoutManager;
    CourseAdapter adapter;
    FloatingActionButton FABAddCourse;
    Intent intent;
    boolean deletedTerm;
    public static int numCourses;
    int termId;
    List<Course> courseList;
    RecyclerView rvCourse;
    TextView txtTermName;
    TextView txtTermStart;
    TextView txtTermEnd;
    EditText searchCourse;
    String tName;
    String tStart;
    String tEnd;
    Term currentTerm;
    private List<Course> mCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_details);
        db = WGUMobileAppCapstoneDB.getInstance(getApplicationContext());
        intent = getIntent();
        termId = intent.getIntExtra("termId", -1);
        tName = intent.getStringExtra("termName");
        tStart = intent.getStringExtra("termStart");
        tEnd = intent.getStringExtra("termEnd");
        txtTermName = findViewById(R.id.eTxt_termNameDetails);
        txtTermStart = findViewById(R.id.eTxt_termStartDetails);
        txtTermEnd = findViewById(R.id.eTxt_termEndDetails);
        rvCourse = findViewById(R.id.rv_courses);
        FABAddCourse = findViewById(R.id.FAB_addCourse);
        courseList = db.courseDAO().getCourseList(termId);
        searchCourse = findViewById(R.id.searchCourse);
        mCourses = db.courseDAO().getCourseList(termId);

        // Set term values
        List<Term> allTerms = db.termDAO().getAllTerms();
        for (Term t:allTerms) {
            if (t.getTermId() == termId) currentTerm = t;
        }
        if (currentTerm != null) {
            tName = currentTerm.getTermName();
            tStart = DateFormat.format("MM/dd/yyyy", currentTerm.getTermStart()).toString();
            tEnd = DateFormat.format("MM/dd/yyyy", currentTerm.getTermEnd()).toString();
        }
        if (termId != -1) {
            txtTermName.setText(tName);
            txtTermStart.setText(tStart);
            txtTermEnd.setText(tEnd);
        }

        setCourseAdapter();

        // Set add course floating action button
        FABAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TermDetailsActivity.this, AddCourseActivity.class);
                intent.putExtra("termId", termId);
                startActivity(intent);
            }
        });

        // Set search course
        searchCourse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    // Set course adapter for recycler view
    private void setCourseAdapter() {
        // Initialize linear layout manager
        linearLayoutManager = new LinearLayoutManager(this);
        // Set layout manager
        rvCourse.setLayoutManager(linearLayoutManager);
        // Initialize adapter
        adapter = new CourseAdapter(mCourses, this);
        // Set adapter
        rvCourse.setAdapter(adapter);
        // Filter courses by term
        List<Course> filteredCourses = new ArrayList<>();
        for (Course c: db.courseDAO().getAllCourses()) {
            if (c.getCTermId() == termId) filteredCourses.add(c);
        }
        numCourses = filteredCourses.size();
        adapter.setWords(filteredCourses);
    }

    // Method to delete term
    private void deleteTerm() {
        if (numCourses == 0) {
            Term t = new Term();
            t = db.termDAO().getTerm(termId);
            db.termDAO().delete(t);
            Intent intent = new Intent(TermDetailsActivity.this, TermActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), tName + " has been deleted!", Toast.LENGTH_LONG).show();
            deletedTerm = true;
        } else {
            Toast.makeText(getApplicationContext(), tName + " can't be deleted, it has associated courses!", Toast.LENGTH_LONG).show();
            return;
        }
    }

    // Method to filter search courses text
    private void filter(String text) {
        ArrayList<Course> filteredList = new ArrayList<>();
        for (Course course : mCourses) {
            if (course.getCourseName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(course);
            }
        }
        adapter.filterList(filteredList);
    }

    // Menu setup
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_term_details, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // WGU icon to send to home screen
        if (id == R.id.home) {
            Intent intent = new Intent(TermDetailsActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        // Delete icon to delete course
        if (id == R.id.delete_term) {
            deleteTerm();
        }

        // Edit icon to send to edit course screen
        if (id == R.id.edit_term) {
            Intent intent = new Intent(getApplicationContext(), EditTermActivity.class);
            intent.putExtra("termId", termId);
            intent.putExtra("courseList", courseList.size());
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}