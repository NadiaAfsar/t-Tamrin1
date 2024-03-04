package Model.Courses.Physics;

import Model.Courses.GeneralCourse;
import Model.Time;

public class Physic1Lab extends GeneralCourse {
    public Physic1Lab(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setTitle("Physic1Lab");
        this.setCode(22);
        this.setCredit(1);
    }
}
