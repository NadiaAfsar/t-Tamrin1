package Model.Courses.Language;

import Model.Courses.GeneralCourse;
import Model.Time;

public class German extends GeneralCourse {
    public German(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setTitle("German");
        this.setCode(33);
        this.setCredit(3);
    }
}
