package Model.Faculty;

import Model.Courses.Course;
import Model.Courses.Language.English;
import Model.Courses.Language.German;
import Model.Courses.Language.Persian;
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
        Time t = new Time(new int[]{2, 4}, start, end);
        Time exam = new Time("26 Khordad", new Time(11, 0));
        Course course = new English("Jafari", t, exam, 0);
        this.getCourses().add(course);
    }
    private void addPersian() {
        Time start = new Time(13,0);
        Time end = new Time(15, 0);
        Time t = new Time(new int[]{1, 3}, start, end);
        Time exam = new Time("22 Khordad", new Time(9, 0));
        Course course = new Persian("Gheidi", t, exam, 30);
        this.getCourses().add(course);
    }
    private void addGerman() {
        Time start = new Time(9,0);
        Time end = new Time(10, 30);
        Time t = new Time(new int[]{1, 3}, start, end);
        Time exam = new Time("2 Tir", new Time(10, 0));
        Course course = new German("Haghighi", t, exam, 30);
        this.getCourses().add(course);
    }
}