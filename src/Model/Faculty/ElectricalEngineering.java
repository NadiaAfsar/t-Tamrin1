package Model.Faculty;

import Model.Courses.Course;
import Model.Courses.GeneralCourse;
import Model.Courses.SpecializedCourse;
import Model.Time;

import java.util.ArrayList;
import java.util.HashMap;

public class ElectricalEngineering extends Faculty{
    public ElectricalEngineering() {
        this.setName("ElectricalEngineering");
        this.setCourses(new ArrayList<>());
        this.setMapOfCourses(new HashMap<>());
        this.addBasicProgramming();
        this.addElectricalCircuits();
        this.addElectronic1Lab();
    }
    private void addBasicProgramming() {
        Time start = new Time(10,30);
        Time end = new Time(12, 30);
        Time t = new Time(new int[]{2, 4}, start, end);
        Time exam = new Time("22 Khordad", new Time(9, 30));
        Course course = new SpecializedCourse("Basic Programming","Arasteh", t, exam,3, "41", 100);
        this.getCourses().add(course);
        this.getMapOfCourses().put("41", course);
    }
    private void addElectricalCircuits() {
        Time start = new Time(13,0);
        Time end = new Time(15, 0);
        Time t = new Time(new int[]{1, 3}, start, end);
        Time exam = new Time("29 Khordad", new Time(10, 30));
        Course course = new SpecializedCourse("Electrical Circuits", "Hadi", t, exam,3, "42", 40);
        this.getCourses().add(course);
        this.getMapOfCourses().put("42", course);
    }
    private void addElectronic1Lab() {
        Time start = new Time(9,0);
        Time end = new Time(12, 0);
        Time t = new Time(new int[]{1, 3}, start, end);
        Time exam = new Time("3 Tir", new Time(9, 30));
        Course course = new GeneralCourse("Electronic 1 Lab","Rezapour", t, exam,1, "43", 30);
        this.getCourses().add(course);
        this.getMapOfCourses().put("43", course);
    }

}