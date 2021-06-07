package com.example.wgumobileappcapstoneericrees.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.wgumobileappcapstoneericrees.DAO.AssessmentDAO;
import com.example.wgumobileappcapstoneericrees.DAO.CourseDAO;
import com.example.wgumobileappcapstoneericrees.DAO.MentorDAO;
import com.example.wgumobileappcapstoneericrees.DAO.TermDAO;
import com.example.wgumobileappcapstoneericrees.Entity.Assessment;
import com.example.wgumobileappcapstoneericrees.Entity.Course;
import com.example.wgumobileappcapstoneericrees.Entity.Mentor;
import com.example.wgumobileappcapstoneericrees.Entity.Term;
import com.example.wgumobileappcapstoneericrees.Utility.DateConverter;

// Add database entities
@Database(entities = {Term.class, Course.class, Assessment.class, Mentor.class}, version = 1, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class WGUMobileAppCapstoneDB extends RoomDatabase {
    // Create database instance
    private static WGUMobileAppCapstoneDB instance;
    // Define database name
    private static final String DATABASE_NAME = "WGUMobileAppCapstoneDB.db";
    // Set instance for database
    public synchronized static WGUMobileAppCapstoneDB getInstance(Context context) {
        if (instance == null) {
            // When database is null initialize database
            instance = Room.databaseBuilder(context.getApplicationContext(), WGUMobileAppCapstoneDB.class, DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    // Create DAOs
    public abstract TermDAO termDAO();
    public abstract CourseDAO courseDAO();
    public abstract AssessmentDAO assessmentDAO();
    public abstract MentorDAO mentorDAO();
}
