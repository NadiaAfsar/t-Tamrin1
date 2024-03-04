package Model.Faculty;

import Model.Courses.Course;
import Model.Courses.MathematicalSciences.Math1;
import Model.Courses.Physics.Physic1;
import Model.Courses.Physics.Physic1Lab;
import Model.Time;

import java.util.ArrayList;

public class Physics extends Faculty{
    public Physics() {
        this.setCourses(new ArrayList<>());
        this.addPhysic1();
        this.addPhysic1Lab();
        this.addElectromagnetism();
    }
    private void addPhysic1() {
        Time start = new Time(10,0);
        Time end = new Time(12, 0);
        Time t = new Time(new String[]{"Saturday", "Monday"}, start, end);
        Time exam = new Time("1 Tir", new Time(9, 0));
        Course course = new Physic1("Baghram", t, exam, 150);
        this.getCourses().add(course);
    }

    private void addPhysic1Lab() {
        Time start = new Time(8,0);
        Time end = new Time(10, 0);
        Time t = new Time(new String[]{"Saturday"}, start, end);
        Time exam = new Time("10 Khordad", new Time(9, 0));
        Course course = new Physic1Lab("Moghimi", t, exam, 150);
        this.getCourses().add(course);
    }

    private void addElectromagnetism() {
        Time start = new Time(13,0);
        Time end = new Time(15, 0);
        Time t = new Time(new String[]{"Sunday", "Tuesday"}, start, end);
        Time exam = new Time("20 Khordad", new Time(9, 0));
        Course course = new Physic1Lab("Mirkamali", t, exam, 150);
        this.getCourses().add(course);
    }
}
