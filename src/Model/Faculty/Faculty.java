package Model.Faculty;

import Model.Courses.Course;

import java.util.ArrayList;
import java.util.Map;

public abstract class Faculty {
    private String name;
    private ArrayList<Course> courses;
    private Map<String, Course> mapOfCourses;

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public Map<String, Course> getMapOfCourses() {
        return mapOfCourses;
    }

    public void setMapOfCourses(Map<String, Course> mapOfCourses) {
        this.mapOfCourses = mapOfCourses;
    }
}