package Model.Faculty;

import Model.Courses.Course;
import Model.Courses.MathematicalSciences.Math1;
import Model.Time;

import java.util.ArrayList;

public class Language extends Faculty{
    public Language() {
        this.setName("Language");
        this.setCourses(new ArrayList<>());
        this.addEnglish();
        this.addPersian();
        this.addGerman();
    }
    private void addEnglish() {
        Time start = new Time(14,30);
        Time end = new Time(18, 0);
        Time t = new Time(new String[]{"Sunday", "Tuesday"}, start, end);
        Time exam = new Time("26 Khordad", new Time(11, 0));
        Course course = new Math1("Jafari", t, exam, 30);
        this.getCourses().add(course);
    }
    private void addPersian() {
        Time start = new Time(13,0);
        Time end = new Time(15, 0);
        Time t = new Time(new String[]{"Saturday", "Monday"}, start, end);
        Time exam = new Time("22 Khordad", new Time(9, 0));
        Course course = new Math1("Gheidi", t, exam, 30);
        this.getCourses().add(course);
    }
    private void addGerman() {
        Time start = new Time(9,0);
        Time end = new Time(10, 30);
        Time t = new Time(new String[]{"Saturday", "Monday"}, start, end);
        Time exam = new Time("2 Tir", new Time(10, 0));
        Course course = new Math1("Haghighi", t, exam, 30);
        this.getCourses().add(course);
    }
}
