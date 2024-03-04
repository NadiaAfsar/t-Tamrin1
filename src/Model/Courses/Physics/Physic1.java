package Model.Courses.Physics;

import Model.Courses.GeneralCourse;
import Model.Time;

public class Physic1 extends GeneralCourse {
    public Physic1(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setTitle("Physic1");
        this.setCode(21);
        this.setCredit(3);
    }
}
