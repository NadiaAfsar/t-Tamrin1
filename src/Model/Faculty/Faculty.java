package Model.Faculty;

import Model.Courses.Course;

import java.util.ArrayList;

public abstract class Faculty {
    private String name;
    private ArrayList<Course> courses;

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}
