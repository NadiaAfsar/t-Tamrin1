package Model.Courses.Language;

import Model.Courses.GeneralCourse;
import Model.Time;

public class Persian extends GeneralCourse {
    public Persian(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setTitle("Persian");
        this.setCode(32);
        this.setCredit(3);
    }
}
