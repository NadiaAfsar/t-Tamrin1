package Model.Courses.MathematicalSciences;

import Model.Courses.GeneralCourse;
import Model.Time;

import java.util.ArrayList;

public class Math1 extends GeneralCourse {
    public Math1(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setStudents(new ArrayList<>());
        this.setTitle("Math 1");
        this.setCode(11);
        this.setCredit(4);
    }
}
