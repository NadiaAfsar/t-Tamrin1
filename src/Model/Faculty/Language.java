package Model.Faculty;

import Model.Courses.Course;
import Model.Courses.GeneralCourse;
import Model.Time;

import java.util.ArrayList;
import java.util.HashMap;

public class Language extends Faculty{
    public Language() {
        this.setName("Language");
        this.setCourses(new ArrayList<>());
        this.setMapOfCourses(new HashMap<>());
        this.addEnglish();
        this.addPersian();
        this.addGerman();
    }
    private void addEnglish() {
        Time start = new Time(14,30);
        Time end = new Time(18, 0);
        Time t = new Time(new int[]{2, 4}, start, end);
        Time exam = new Time("02/03/26", new Time(11, 0));
        Course course = new GeneralCourse("English","Jafari", t, exam,3, "31", 30);
        this.getCourses().add(course);
        this.getMapOfCourses().put("31", course);
    }
    private void addPersian() {
        Time start = new Time(13,0);
        Time end = new Time(15, 0);
        Time t = new Time(new int[]{1, 3}, start, end);
        Time exam = new Time("02/03/22", new Time(9, 0));
        Course course = new GeneralCourse("Persian","Gheidi", t, exam,3,"32", 30);
        this.getCourses().add(course);
        this.getMapOfCourses().put("32", course);
    }
    private void addGerman() {
        Time start = new Time(9,0);
        Time end = new Time(10, 30);
        Time t = new Time(new int[]{1, 3}, start, end);
        Time exam = new Time("02/04/02", new Time(10, 0));
        Course course = new GeneralCourse("German","Haghighi", t, exam,3,"33", 30);
        this.getCourses().add(course);
        this.getMapOfCourses().put("33", course);
    }
}