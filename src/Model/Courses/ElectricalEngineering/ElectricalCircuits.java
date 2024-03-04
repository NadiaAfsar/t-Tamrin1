package Model.Courses.ElectricalEngineering;

import Model.Courses.SpecializedCourse;
import Model.Time;

public class ElectricalCircuits extends SpecializedCourse {
    public ElectricalCircuits(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setTitle("ElectricalCircuits");
        this.setCode(42);
        this.setCredit(3);
    }
}
