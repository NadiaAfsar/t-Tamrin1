package Model.Courses.Physics;

import Model.Courses.GeneralCourse;
import Model.Time;

import java.util.ArrayList;

public class Physic1 extends GeneralCourse {
    public Physic1(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setStudents(new ArrayList<>());
        this.setTitle("Physic 1");
        this.setCode(21);
        this.setCredit(3);
    }
}
