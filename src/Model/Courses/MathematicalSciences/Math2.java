package Model.Courses.MathematicalSciences;

import Model.Courses.GeneralCourse;
import Model.Time;

import java.util.ArrayList;

public class Math2 extends GeneralCourse {
    public Math2(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setStudents(new ArrayList<>());
        this.setTitle("Math 2");
        this.setCode(12);
        this.setCredit(4);
    }
}
