package Model;

import Model.Courses.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student extends User{
    private final String firstName;
    private final String lastName;
    private boolean[][][] timetable;
    private ArrayList<Time> exams;
    private ArrayList<Course> takenCourses;
    private Map<String, Course> addedCourses;
    public Student(String username, String password, String firstName, String lastName) {
        this.setUsername(username);
        this.setPassword(password);
        this.takenCourses = new ArrayList<>();
        this.timetable = new boolean[8][25][60];
        this.exams = new ArrayList<>();
        this.addedCourses = new HashMap<>();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean[][][] getTimetable() {
        return timetable;
    }

    public ArrayList<Course> getTakenCourses() {
        return takenCourses;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Time> getExams() {
        return exams;
    }

    public Map<String, Course> getAddedCourses() {
        return addedCourses;
    }
}