package Model.Courses.Language;

import Model.Courses.GeneralCourse;
import Model.Time;

public class English extends GeneralCourse {
    public English(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setTitle("English");
        this.setCode(31);
        this.setCredit(3);
    }
}
