package Model.Faculty;

import Model.Courses.Course;
import Model.Courses.GeneralCourse;
import Model.Courses.SpecializedCourse;
import Model.Time;

import java.util.ArrayList;
import java.util.HashMap;

public class Physics extends Faculty{
    public Physics() {
        this.setName("Physics");
        this.setCourses(new ArrayList<>());
        this.setMapOfCourses(new HashMap<>());
        this.addPhysic1();
        this.addPhysic1Lab();
        this.addElectromagnetism();
    }
    private void addPhysic1() {
        Time start = new Time(10,0);
        Time end = new Time(12, 0);
        Time t = new Time(new int[]{1, 3}, start, end);
        Time exam = new Time("02/04/01", new Time(9, 0));
        Course course = new GeneralCourse("Physic 1","Baghram", t, exam,3,"21", 150);
        this.getCourses().add(course);
        this.getMapOfCourses().put("21", course);
    }

    private void addPhysic1Lab() {
        Time start = new Time(8,0);
        Time end = new Time(10, 0);
        Time t = new Time(new int[]{1}, start, end);
        Time exam = new Time("02/03/10", new Time(9, 0));
        Course course = new GeneralCourse("Physoc 1 Lab","Moghimi", t, exam,1,"22", 150);
        this.getCourses().add(course);
        this.getMapOfCourses().put("22", course);
    }

    private void addElectromagnetism() {
        Time start = new Time(13,0);
        Time end = new Time(15, 0);
        Time t = new Time(new int[]{2, 4}, start, end);
        Time exam = new Time("02/03/20", new Time(9, 0));
        Course course = new SpecializedCourse("Electromagnetism","Mirkamali", t, exam,3,"23", 150);
        this.getCourses().add(course);
        this.getMapOfCourses().put("23", course);
    }
}
