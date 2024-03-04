package Model.Courses.MathematicalSciences;

import Model.Courses.GeneralCourse;
import Model.Time;

public class Math2 extends GeneralCourse {
    public Math2(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setTitle("Math2");
        this.setCode(12);
        this.setCredit(4);
    }
}
