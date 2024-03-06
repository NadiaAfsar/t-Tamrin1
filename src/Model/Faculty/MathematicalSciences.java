package Model.Faculty;

import Model.Courses.Course;
import Model.Courses.GeneralCourse;
import Model.Courses.SpecializedCourse;
import Model.Time;

import java.util.ArrayList;
import java.util.HashMap;

public class MathematicalSciences extends Faculty{
    public MathematicalSciences() {
        this.setName("MathematicalSciences");
        this.setCourses(new ArrayList<>());
        this.setMapOfCourses(new HashMap<>());
        this.addMath1();
        this.addMath2();
        this.addAdvancedProgramming();
        this.addBasicOfMathematics();
    }
    private void addMath1() {
        Time start = new Time(10,30);
        Time end = new Time(12, 30);
        Time t = new Time(new int[]{2, 4}, start, end);
        Time exam = new Time("20 Khordad", new Time(9, 0));
        Course course = new GeneralCourse("Math 1", "Moghaddasi", t, exam,4, "11", 150);
        this.getCourses().add(course);
        this.getMapOfCourses().put("11", course);
    }
    private void addMath2() {
        Time start = new Time(10,30);
        Time end = new Time(12, 30);
        Time t = new Time(new int[]{1, 3}, start, end);
        Time exam = new Time("22 Khordad", new Time(9, 0));
        Course course = new GeneralCourse("Math 2","Poornaki", t, exam,4,"12", 250);
        this.getCourses().add(course);
        this.getMapOfCourses().put("12", course);
    }
    private void addAdvancedProgramming() {
        Time start = new Time(9,0);
        Time end = new Time(11, 0);
        Time t = new Time(new int[]{2, 4}, start, end);
        Time exam = new Time("28 Khordad", new Time(9, 0));
        Course course = new SpecializedCourse("Advanced Programming","Boomari", t, exam,4,"13", 200);
        this.getCourses().add(course);
        this.getMapOfCourses().put("13", course);
    }
    private void addBasicOfMathematics() {
        Time start = new Time(8,0);
        Time end = new Time(10, 0);
        Time t = new Time(new int[]{1, 3}, start, end);
        Time exam = new Time("25 Khordad", new Time(10, 0));
        Course course = new SpecializedCourse("Basic Of Mathematics","Ardeshir", t, exam,4,"14", 80);
        this.getCourses().add(course);
        this.getMapOfCourses().put("14", course);
    }
}
