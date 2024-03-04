package Model.Faculty;

import Model.Courses.Course;
import Model.Courses.ElectricalEngineering.BasicProgramming;
import Model.Courses.MathematicalSciences.Math1;
import Model.Time;

import java.util.ArrayList;

public class ElectricalEngineering extends Faculty{
    public ElectricalEngineering() {
        this.setName("ElectricalEngineering");
        this.setCourses(new ArrayList<>());
        this.addBasicProgramming();
        this.addElectricalCircuits();
        this.addElectronic1Lab();
    }
    private void addBasicProgramming() {
        Time start = new Time(10,30);
        Time end = new Time(12, 30);
        Time t = new Time(new int[]{2, 4}, start, end);
        Time exam = new Time("22 Khordad", new Time(9, 30));
        Course course = new BasicProgramming("Arasteh", t, exam, 100);
        this.getCourses().add(course);
    }
    private void addElectricalCircuits() {
        Time start = new Time(13,0);
        Time end = new Time(15, 0);
        Time t = new Time(new int[]{1, 3}, start, end);
        Time exam = new Time("29 Khordad", new Time(10, 30));
        Course course = new BasicProgramming("Hadi", t, exam, 40);
        this.getCourses().add(course);
    }
    private void addElectronic1Lab() {
        Time start = new Time(9,0);
        Time end = new Time(12, 0);
        Time t = new Time(new int[]{1, 3}, start, end);
        Time exam = new Time("3 Tir", new Time(9, 30));
        Course course = new BasicProgramming("Rezapour", t, exam, 30);
        this.getCourses().add(course);
    }

}
