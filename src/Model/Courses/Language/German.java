package Model.Courses.Language;

import Model.Courses.GeneralCourse;
import Model.Time;

import java.util.ArrayList;

public class German extends GeneralCourse {
    public German(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setStudents(new ArrayList<>());
        this.setTitle("German");
        this.setCode(33);
        this.setCredit(3);
    }
}
