package com.example.wgumobileappcapstoneericrees.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wgumobileappcapstoneericrees.Database.WGUMobileAppCapstoneDB;
import com.example.wgumobileappcapstoneericrees.Entity.Mentor;
import com.example.wgumobileappcapstoneericrees.R;

public class AddMentorActivity extends AppCompatActivity {
    WGUMobileAppCapstoneDB db;
    boolean addedMentor;
    int termId;
    int courseId;
    Intent intent;
    String mName;
    String mPhone;
    String mEmail;
    Button btnAddMentor;
    EditText mentorName;
    EditText mentorPhone;
    EditText mentorEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mentor);
        db = WGUMobileAppCapstoneDB.getInstance(getApplicationContext());
        intent = getIntent();
        termId = intent.getIntExtra("termId", -1);
        courseId = intent.getIntExtra("courseId", -1);
        btnAddMentor = findViewById(R.id.btn_updateMentor);
        mentorName = findViewById(R.id.eTxt_addMentorName);
        mentorPhone = findViewById(R.id.ePhone_addMentorPhone);
        mentorEmail = findViewById(R.id.eEmail_addMentorEmail);

        // Set add mentor button
        btnAddMentor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMentor();
                if (addedMentor == true) {
                    Intent intent = new Intent(AddMentorActivity.this, CourseDetailsActivity.class);
                    intent.putExtra("termId", termId);
                    intent.putExtra("courseId", courseId);
                    startActivity(intent);
                }
            }
        });
    }

    // Method to add new mentor
    private void addMentor() {
        mName = mentorName.getText().toString();
        mPhone = mentorPhone.getText().toString();
        mEmail = mentorEmail.getText().toString();

        if (mName.trim().isEmpty() || (mPhone.trim().isEmpty() || (mEmail.trim().isEmpty()))) {
            Toast.makeText(getApplicationContext(), "All fields are required, can't be empty!", Toast.LENGTH_SHORT).show();
            return;
        }

        Mentor m = new Mentor();
        m.setMCourseId(courseId);
        m.setMentorName(mName);
        m.setMentorPhone(mPhone);
        m.setMentorEmail(mEmail);
        db.mentorDAO().insert(m);
        Toast.makeText(getApplicationContext(), mName + " was added!", Toast.LENGTH_LONG).show();
        addedMentor = true;
    }

    // Menu setup
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // WGU icon to send to home screen
        if (id == R.id.home) {
            Intent intent = new Intent(AddMentorActivity.this, HomeActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}