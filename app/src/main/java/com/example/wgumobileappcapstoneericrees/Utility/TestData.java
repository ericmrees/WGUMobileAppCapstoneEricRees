package com.example.wgumobileappcapstoneericrees.Utility;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wgumobileappcapstoneericrees.Database.WGUMobileAppCapstoneDB;
import com.example.wgumobileappcapstoneericrees.Entity.Assessment;
import com.example.wgumobileappcapstoneericrees.Entity.Course;
import com.example.wgumobileappcapstoneericrees.Entity.Mentor;
import com.example.wgumobileappcapstoneericrees.Entity.Term;

import java.util.Calendar;
import java.util.List;

public class TestData extends AppCompatActivity {
    Term testTerm1 = new Term();
    Term testTerm2 = new Term();
    Term testTerm3 = new Term();
    Term testTerm4 = new Term();
    Course testCourse1 = new Course();
    Course testCourse2 = new Course();
    Course testCourse3 = new Course();
    Course testCourse4 = new Course();
    Course testCourse5 = new Course();
    Course testCourse6 = new Course();
    Course testCourse7 = new Course();
    Course testCourse8 = new Course();
    Course testCourse9 = new Course();
    Course testCourse10 = new Course();
    Course testCourse11 = new Course();
    Course testCourse12 = new Course();
    Course testCourse13 = new Course();
    Course testCourse14 = new Course();
    Course testCourse15 = new Course();
    Course testCourse16 = new Course();
    Assessment testAssessment1 = new Assessment();
    Assessment testAssessment2 = new Assessment();
    Assessment testAssessment3 = new Assessment();
    Assessment testAssessment4 = new Assessment();
    Assessment testAssessment5 = new Assessment();
    Assessment testAssessment6 = new Assessment();
    Assessment testAssessment7 = new Assessment();
    Assessment testAssessment8 = new Assessment();
    Assessment testAssessment9 = new Assessment();
    Assessment testAssessment10 = new Assessment();
    Assessment testAssessment11 = new Assessment();
    Assessment testAssessment12 = new Assessment();
    Assessment testAssessment13 = new Assessment();
    Assessment testAssessment14 = new Assessment();
    Assessment testAssessment15 = new Assessment();
    Assessment testAssessment16 = new Assessment();
    Mentor testMentor1 = new Mentor();
    Mentor testMentor2 = new Mentor();
    Mentor testMentor3 = new Mentor();
    Mentor testMentor4 = new Mentor();
    Mentor testMentor5 = new Mentor();
    Mentor testMentor6 = new Mentor();
    Mentor testMentor7 = new Mentor();
    Mentor testMentor8 = new Mentor();
    Mentor testMentor9 = new Mentor();
    Mentor testMentor10 = new Mentor();
    Mentor testMentor11 = new Mentor();
    Mentor testMentor12 = new Mentor();
    Mentor testMentor13 = new Mentor();
    Mentor testMentor14 = new Mentor();
    Mentor testMentor15 = new Mentor();
    Mentor testMentor16 = new Mentor();

    WGUMobileAppCapstoneDB db;

    // Method to add all test data (terms, courses, assessments, and mentors)
    public void addTestData(Context context) {
        db = WGUMobileAppCapstoneDB.getInstance(context);
        try {
            insertTerms();
            insertCourses();
            insertAssessments();
            insertMentors();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to add all test terms
    private void insertTerms() {
        Calendar start;
        Calendar end;

        // Set up test term 1
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -10);
        end.add(Calendar.MONTH, -5);
        testTerm1.setTermName("Term 1");
        testTerm1.setTermStart(start.getTime());
        testTerm1.setTermEnd(end.getTime());

        // Set up test term 2
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -5);
        end.add(Calendar.MONTH, 0);
        testTerm2.setTermName("Term 2");
        testTerm2.setTermStart(start.getTime());
        testTerm2.setTermEnd(end.getTime());

        // Set up test term 3
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 0);
        end.add(Calendar.MONTH, 5);
        testTerm3.setTermName("Term 3");
        testTerm3.setTermStart(start.getTime());
        testTerm3.setTermEnd(end.getTime());

        // Set up test term 4
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 5);
        end.add(Calendar.MONTH, 10);
        testTerm4.setTermName("Term 4");
        testTerm4.setTermStart(start.getTime());
        testTerm4.setTermEnd(end.getTime());

        db.termDAO().insertAll(testTerm1, testTerm2, testTerm3, testTerm4);
    }

    // Method to add all test courses
    private void insertCourses() {
        Calendar start;
        Calendar end;
        List<Term> tList = db.termDAO().getTermList();
        if (tList == null) return;

        // Set up test course 1
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -10);
        end.add(Calendar.MONTH, -9);
        testCourse1.setCourseName("UI Design");
        testCourse1.setCourseStart(start.getTime());
        testCourse1.setCourseEnd(end.getTime());
        testCourse1.setStatus("Completed");
        testCourse1.setCourseNote("Completed user interface design!");
        testCourse1.setCTermId(tList.get(0).getTermId());

        // Set up test course 2
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -9);
        end.add(Calendar.MONTH, -8);
        testCourse2.setCourseName("Data Management");
        testCourse2.setCourseStart(start.getTime());
        testCourse2.setCourseEnd(end.getTime());
        testCourse2.setStatus("Completed");
        testCourse2.setCourseNote("Completed data management!");
        testCourse2.setCTermId(tList.get(0).getTermId());

        // Set up test course 3
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -8);
        end.add(Calendar.MONTH, -7);
        testCourse3.setCourseName("IT Project Management");
        testCourse3.setCourseStart(start.getTime());
        testCourse3.setCourseEnd(end.getTime());
        testCourse3.setStatus("Completed");
        testCourse3.setCourseNote("Completed IT project management");
        testCourse3.setCTermId(tList.get(0).getTermId());

        // Set up test course 4
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -7);
        end.add(Calendar.MONTH, -6);
        testCourse4.setCourseName("Web Development");
        testCourse4.setCourseStart(start.getTime());
        testCourse4.setCourseEnd(end.getTime());
        testCourse4.setStatus("Completed");
        testCourse4.setCourseNote("Completed web development!");
        testCourse4.setCTermId(tList.get(0).getTermId());

        // Set up test course 5
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -5);
        end.add(Calendar.MONTH, -4);
        testCourse5.setCourseName("Technical Communication");
        testCourse5.setCourseStart(start.getTime());
        testCourse5.setCourseEnd(end.getTime());
        testCourse5.setStatus("Completed");
        testCourse5.setCourseNote("Completed technical communication!");
        testCourse5.setCTermId(tList.get(1).getTermId());

        // Set up test course 6
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -4);
        end.add(Calendar.MONTH, -3);
        testCourse6.setCourseName("Scripting and Programming");
        testCourse6.setCourseStart(start.getTime());
        testCourse6.setCourseEnd(end.getTime());
        testCourse6.setStatus("Completed");
        testCourse6.setCourseNote("Completed scripting and programming!");
        testCourse6.setCTermId(tList.get(1).getTermId());

        // Set up test course 7
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -3);
        end.add(Calendar.MONTH, -2);
        testCourse7.setCourseName("Network and Security");
        testCourse7.setCourseStart(start.getTime());
        testCourse7.setCourseEnd(end.getTime());
        testCourse7.setStatus("Completed");
        testCourse7.setCourseNote("Completed network and security");
        testCourse7.setCTermId(tList.get(1).getTermId());

        // Set up test course 8
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -2);
        end.add(Calendar.MONTH, -1);
        testCourse8.setCourseName("Software Engineering");
        testCourse8.setCourseStart(start.getTime());
        testCourse8.setCourseEnd(end.getTime());
        testCourse8.setStatus("Completed");
        testCourse8.setCourseNote("Completed software engineering!");
        testCourse8.setCTermId(tList.get(1).getTermId());

        // Set up test course 9
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 0);
        end.add(Calendar.MONTH, 1);
        testCourse9.setCourseName("Software I");
        testCourse9.setCourseStart(start.getTime());
        testCourse9.setCourseEnd(end.getTime());
        testCourse9.setStatus("In Progress");
        testCourse9.setCourseNote("Taking software 1!");
        testCourse9.setCTermId(tList.get(2).getTermId());

        // Set up test course 10
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 1);
        end.add(Calendar.MONTH, 2);
        testCourse10.setCourseName("Business of IT");
        testCourse10.setCourseStart(start.getTime());
        testCourse10.setCourseEnd(end.getTime());
        testCourse10.setStatus("Plan to Take");
        testCourse10.setCourseNote("Excited to take business of IT!");
        testCourse10.setCTermId(tList.get(2).getTermId());

        // Set up test course 11
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 2);
        end.add(Calendar.MONTH, 3);
        testCourse11.setCourseName("OSs for Programmers");
        testCourse11.setCourseStart(start.getTime());
        testCourse11.setCourseEnd(end.getTime());
        testCourse11.setStatus("Plan to Take");
        testCourse11.setCourseNote("Excited to take OSs for programmers");
        testCourse11.setCTermId(tList.get(2).getTermId());

        // Set up test course 12
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 3);
        end.add(Calendar.MONTH, 4);
        testCourse12.setCourseName("Software II");
        testCourse12.setCourseStart(start.getTime());
        testCourse12.setCourseEnd(end.getTime());
        testCourse12.setStatus("Plan to Take");
        testCourse12.setCourseNote("Excited to take software 2!");
        testCourse12.setCTermId(tList.get(2).getTermId());

        // Set up test course 13
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 5);
        end.add(Calendar.MONTH, 6);
        testCourse13.setCourseName("Mobile App Development");
        testCourse13.setCourseStart(start.getTime());
        testCourse13.setCourseEnd(end.getTime());
        testCourse13.setStatus("Plan to Take");
        testCourse13.setCourseNote("Excited to take mobile app development!");
        testCourse13.setCTermId(tList.get(3).getTermId());

        // Set up test course 14
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 6);
        end.add(Calendar.MONTH, 7);
        testCourse14.setCourseName("Software QA");
        testCourse14.setCourseStart(start.getTime());
        testCourse14.setCourseEnd(end.getTime());
        testCourse14.setStatus("Plan to Take");
        testCourse14.setCourseNote("Excited to take software QA!");
        testCourse14.setCTermId(tList.get(3).getTermId());

        // Set up test course 15
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 7);
        end.add(Calendar.MONTH, 8);
        testCourse15.setCourseName("Advanced SQL");
        testCourse15.setCourseStart(start.getTime());
        testCourse15.setCourseEnd(end.getTime());
        testCourse15.setStatus("Plan to Take");
        testCourse15.setCourseNote("Excited to take advanced SQL!");
        testCourse15.setCTermId(tList.get(3).getTermId());

        // Set up test course 16
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 8);
        end.add(Calendar.MONTH, 9);
        testCourse16.setCourseName("Software Development Capstone");
        testCourse16.setCourseStart(start.getTime());
        testCourse16.setCourseEnd(end.getTime());
        testCourse16.setStatus("Plan to Take");
        testCourse16.setCourseNote("Excited to take software development capstone!");
        testCourse16.setCTermId(tList.get(3).getTermId());

        db.courseDAO().insertAll(testCourse1, testCourse2, testCourse3, testCourse4, testCourse5, testCourse6, testCourse7, testCourse8,
                testCourse9, testCourse10, testCourse11, testCourse12, testCourse13, testCourse14, testCourse15, testCourse16);
    }

    // Method to add all test assessments
    private void insertAssessments() {
        Calendar start;
        Calendar end;
        List<Course> cList = db.courseDAO().getAllCourses();
        if (cList == null) return;

        // Set up test assessment 1
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -10);
        end.add(Calendar.MONTH, -9);
        testAssessment1.setAssessmentName("UI Design Project");
        testAssessment1.setAssessmentStart(start.getTime());
        testAssessment1.setAssessmentEnd(end.getTime());
        testAssessment1.setType("Performance");
        testAssessment1.setACourseId(cList.get(0).getCourseId());

        // Set up test assessment 2
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -9);
        end.add(Calendar.MONTH, -8);
        testAssessment2.setAssessmentName("Data Mgmt Exam");
        testAssessment2.setAssessmentStart(start.getTime());
        testAssessment2.setAssessmentEnd(end.getTime());
        testAssessment2.setType("Objective");
        testAssessment2.setACourseId(cList.get(1).getCourseId());

        // Set up test assessment 3
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -8);
        end.add(Calendar.MONTH, -7);
        testAssessment3.setAssessmentName("Project Mgmt Exam");
        testAssessment3.setAssessmentStart(start.getTime());
        testAssessment3.setAssessmentEnd(end.getTime());
        testAssessment3.setType("Objective");
        testAssessment3.setACourseId(cList.get(2).getCourseId());

        // Set up test assessment 4
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -7);
        end.add(Calendar.MONTH, -6);
        testAssessment4.setAssessmentName("Web Design Project");
        testAssessment4.setAssessmentStart(start.getTime());
        testAssessment4.setAssessmentEnd(end.getTime());
        testAssessment4.setType("Performance");
        testAssessment4.setACourseId(cList.get(3).getCourseId());

        // Set up test assessment 5
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -5);
        end.add(Calendar.MONTH, -4);
        testAssessment5.setAssessmentName("Tech Comm Proposal");
        testAssessment5.setAssessmentStart(start.getTime());
        testAssessment5.setAssessmentEnd(end.getTime());
        testAssessment5.setType("Performance");
        testAssessment5.setACourseId(cList.get(4).getCourseId());

        // Set up test assessment 6
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -4);
        end.add(Calendar.MONTH, -3);
        testAssessment6.setAssessmentName("Script and Program Exam");
        testAssessment6.setAssessmentStart(start.getTime());
        testAssessment6.setAssessmentEnd(end.getTime());
        testAssessment6.setType("Objective");
        testAssessment6.setACourseId(cList.get(5).getCourseId());

        // Set up test assessment 7
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -3);
        end.add(Calendar.MONTH, -2);
        testAssessment7.setAssessmentName("Network and Security Exam");
        testAssessment7.setAssessmentStart(start.getTime());
        testAssessment7.setAssessmentEnd(end.getTime());
        testAssessment7.setType("Objective");
        testAssessment7.setACourseId(cList.get(6).getCourseId());

        // Set up test assessment 8
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -2);
        end.add(Calendar.MONTH, -1);
        testAssessment8.setAssessmentName("Software Engineering Exam");
        testAssessment8.setAssessmentStart(start.getTime());
        testAssessment8.setAssessmentEnd(end.getTime());
        testAssessment8.setType("Objective");
        testAssessment8.setACourseId(cList.get(7).getCourseId());

        // Set up test assessment 9
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 0);
        end.add(Calendar.MONTH, 1);
        testAssessment9.setAssessmentName("Inventory App");
        testAssessment9.setAssessmentStart(start.getTime());
        testAssessment9.setAssessmentEnd(end.getTime());
        testAssessment9.setType("Performance");
        testAssessment9.setACourseId(cList.get(8).getCourseId());

        // Set up test assessment 10
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 1);
        end.add(Calendar.MONTH, 2);
        testAssessment10.setAssessmentName("IT Business Exam");
        testAssessment10.setAssessmentStart(start.getTime());
        testAssessment10.setAssessmentEnd(end.getTime());
        testAssessment10.setType("Objective");
        testAssessment10.setACourseId(cList.get(9).getCourseId());

        // Set up test assessment 11
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 2);
        end.add(Calendar.MONTH, 3);
        testAssessment11.setAssessmentName("OS Exam");
        testAssessment11.setAssessmentStart(start.getTime());
        testAssessment11.setAssessmentEnd(end.getTime());
        testAssessment11.setType("Objective");
        testAssessment11.setACourseId(cList.get(10).getCourseId());

        // Set up test assessment 12
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 3);
        end.add(Calendar.MONTH, 4);
        testAssessment12.setAssessmentName("Appointment App");
        testAssessment12.setAssessmentStart(start.getTime());
        testAssessment12.setAssessmentEnd(end.getTime());
        testAssessment12.setType("Performance");
        testAssessment12.setACourseId(cList.get(11).getCourseId());

        // Set up test assessment 13
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 5);
        end.add(Calendar.MONTH, 6);
        testAssessment13.setAssessmentName("Mobile App");
        testAssessment13.setAssessmentStart(start.getTime());
        testAssessment13.setAssessmentEnd(end.getTime());
        testAssessment13.setType("Performance");
        testAssessment13.setACourseId(cList.get(12).getCourseId());

        // Set up test assessment 14
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 6);
        end.add(Calendar.MONTH, 7);
        testAssessment14.setAssessmentName("Software QA Exam");
        testAssessment14.setAssessmentStart(start.getTime());
        testAssessment14.setAssessmentEnd(end.getTime());
        testAssessment14.setType("Objective");
        testAssessment14.setACourseId(cList.get(13).getCourseId());

        // Set up test assessment 15
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 7);
        end.add(Calendar.MONTH, 8);
        testAssessment15.setAssessmentName("SQL Exam");
        testAssessment15.setAssessmentStart(start.getTime());
        testAssessment15.setAssessmentEnd(end.getTime());
        testAssessment15.setType("Objective");
        testAssessment15.setACourseId(cList.get(14).getCourseId());

        // Set up test assessment 16
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 8);
        end.add(Calendar.MONTH, 9);
        testAssessment16.setAssessmentName("Capstone Project");
        testAssessment16.setAssessmentStart(start.getTime());
        testAssessment16.setAssessmentEnd(end.getTime());
        testAssessment16.setType("Performance");
        testAssessment16.setACourseId(cList.get(15).getCourseId());

        db.assessmentDAO().insertAll(testAssessment1, testAssessment2, testAssessment3, testAssessment4, testAssessment5, testAssessment6, testAssessment7, testAssessment8,
                testAssessment9, testAssessment10, testAssessment11, testAssessment12, testAssessment13, testAssessment14, testAssessment15, testAssessment16);
    }

    // Method to add all test mentors
    private void insertMentors() {
        List<Course> cList = db.courseDAO().getAllCourses();
        if (cList == null) return;

        // Set up test mentor 1
        testMentor1.setMentorName("Eric Rees");
        testMentor1.setMentorPhone("8015461148");
        testMentor1.setMentorEmail("eric@wgu.edu");
        testMentor1.setMCourseId(cList.get(0).getCourseId());

        // Set up test mentor 2
        testMentor2.setMentorName("Adam Fischer");
        testMentor2.setMentorPhone("8017674455");
        testMentor2.setMentorEmail("adamf@wgu.edu");
        testMentor2.setMCourseId(cList.get(1).getCourseId());

        // Set up test mentor 3
        testMentor3.setMentorName("Jeremy Roenick");
        testMentor3.setMentorPhone("3973272797");
        testMentor3.setMentorEmail("jr@wgu.edu");
        testMentor3.setMCourseId(cList.get(2).getCourseId());

        // Set up test mentor 4
        testMentor4.setMentorName("Calvin Rees");
        testMentor4.setMentorPhone("8012727270");
        testMentor4.setMentorEmail("calvin@wgu.edu");
        testMentor4.setMCourseId(cList.get(3).getCourseId());

        // Set up test mentor 5
        testMentor5.setMentorName("Melissa Rees");
        testMentor5.setMentorPhone("8012272727");
        testMentor5.setMentorEmail("mel@wgu.edu");
        testMentor5.setMCourseId(cList.get(4).getCourseId());

        // Set up test mentor 6
        testMentor6.setMentorName("Macho Man");
        testMentor6.setMentorPhone("8001234567");
        testMentor6.setMentorEmail("machoman@wgu.edu");
        testMentor6.setMCourseId(cList.get(5).getCourseId());

        // Set up test mentor 7
        testMentor7.setMentorName("Ironman");
        testMentor7.setMentorPhone("1111111111");
        testMentor7.setMentorEmail("ironman@wgu.edu");
        testMentor7.setMCourseId(cList.get(6).getCourseId());

        // Set up test mentor 8
        testMentor8.setMentorName("Captain America");
        testMentor8.setMentorPhone("5555555555");
        testMentor8.setMentorEmail("cap@wgu.edu");
        testMentor8.setMCourseId(cList.get(7).getCourseId());

        // Set up test mentor 9
        testMentor9.setMentorName("Spiderman");
        testMentor9.setMentorPhone("9999999999");
        testMentor9.setMentorEmail("spidey@wgu.edu");
        testMentor9.setMCourseId(cList.get(8).getCourseId());

        // Set up test mentor 10
        testMentor10.setMentorName("Thor");
        testMentor10.setMentorPhone("7777777777");
        testMentor10.setMentorEmail("godofthunder@wgu.edu");
        testMentor10.setMCourseId(cList.get(9).getCourseId());

        // Set up test mentor 11
        testMentor11.setMentorName("Hulk");
        testMentor11.setMentorPhone("3334445555");
        testMentor11.setMentorEmail("hulk@wgu.edu");
        testMentor11.setMCourseId(cList.get(10).getCourseId());

        // Set up test mentor 12
        testMentor12.setMentorName("Black Widow");
        testMentor12.setMentorPhone("7778889999");
        testMentor12.setMentorEmail("blackwidow@wgu.edu");
        testMentor12.setMCourseId(cList.get(11).getCourseId());

        // Set up test mentor 13
        testMentor13.setMentorName("Hawkeye");
        testMentor13.setMentorPhone("7774443333");
        testMentor13.setMentorEmail("hawkeye@wgu.edu");
        testMentor13.setMCourseId(cList.get(12).getCourseId());

        // Set up test mentor 14
        testMentor14.setMentorName("Thanos");
        testMentor14.setMentorPhone("0000000000");
        testMentor14.setMentorEmail("thanos@wgu.edu");
        testMentor14.setMCourseId(cList.get(13).getCourseId());

        // Set up test mentor 15
        testMentor15.setMentorName("Scarlet Witch");
        testMentor15.setMentorPhone("6666666666");
        testMentor15.setMentorEmail("wanda@wgu.edu");
        testMentor15.setMCourseId(cList.get(14).getCourseId());

        // Set up test mentor 16
        testMentor16.setMentorName("Vision");
        testMentor16.setMentorPhone("1112223333");
        testMentor16.setMentorEmail("vision@wgu.edu");
        testMentor16.setMCourseId(cList.get(15).getCourseId());

        db.mentorDAO().insertAll(testMentor1, testMentor2, testMentor3, testMentor4, testMentor5, testMentor6, testMentor7, testMentor8,
                testMentor9, testMentor10, testMentor11, testMentor12, testMentor13, testMentor14, testMentor15, testMentor16);
    }
}