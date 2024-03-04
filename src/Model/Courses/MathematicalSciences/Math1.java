package Model.Courses.MathematicalSciences;

import Model.Courses.GeneralCourse;
import Model.Time;

public class Math1 extends GeneralCourse {
    public Math1(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setTitle("Math1");
        this.setCode(11);
        this.setCredit(4);
    }
}
