package Model.Faculty;

import Model.Courses.Course;
import Model.Courses.MathematicalSciences.AdvancedProgramming;
import Model.Courses.MathematicalSciences.BasicsOfMathematics;
import Model.Courses.MathematicalSciences.Math1;
import Model.Courses.MathematicalSciences.Math2;
import Model.Time;

import java.util.ArrayList;

public class MathematicalSciences extends Faculty{
    public MathematicalSciences() {
        this.setName("MathematicalSciences");
        this.setCourses(new ArrayList<>());
        this.addMath1();
        this.addMath2();
        this.addAdvancedProgramming();
        this.addBasicsOfMathematics();
    }
    private void addMath1() {
        Time start = new Time(10,30);
        Time end = new Time(12, 30);
        Time t = new Time(new int[]{2, 4}, start, end);
        Time exam = new Time("20 Khordad", new Time(9, 0));
        Course course = new Math1("Moghaddasi", t, exam, 150);
        this.getCourses().add(course);
    }
    private void addMath2() {
        Time start = new Time(10,30);
        Time end = new Time(12, 30);
        Time t = new Time(new int[]{1, 3}, start, end);
        Time exam = new Time("22 Khordad", new Time(9, 0));
        Course course = new Math2("Poornaki", t, exam, 250);
        this.getCourses().add(course);
    }
    private void addAdvancedProgramming() {
        Time start = new Time(9,0);
        Time end = new Time(11, 0);
        Time t = new Time(new int[]{2, 4}, start, end);
        Time exam = new Time("28 Khordad", new Time(9, 0));
        Course course = new AdvancedProgramming("Boomari", t, exam, 200);
        this.getCourses().add(course);
    }
    private void addBasicsOfMathematics() {
        Time start = new Time(8,0);
        Time end = new Time(10, 0);
        Time t = new Time(new int[]{1, 3}, start, end);
        Time exam = new Time("25 Khordad", new Time(10, 0));
        Course course = new BasicsOfMathematics("Ardeshir", t, exam, 80);
        this.getCourses().add(course);
    }
}
