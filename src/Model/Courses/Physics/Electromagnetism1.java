package Model.Courses.Physics;

import Model.Courses.SpecializedCourse;
import Model.Time;

public class Electromagnetism1 extends SpecializedCourse {
    public Electromagnetism1(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setTitle("Electromagnetism1");
        this.setCode(23);
        this.setCredit(3);
    }
}
