package Model.Courses.Language;

import Model.Courses.GeneralCourse;
import Model.Time;

import java.util.ArrayList;

public class Persian extends GeneralCourse {
    public Persian(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setStudents(new ArrayList<>());
        this.setTitle("Persian");
        this.setCode(32);
        this.setCredit(3);
    }
}
