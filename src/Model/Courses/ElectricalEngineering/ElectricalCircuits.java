package Model.Courses.ElectricalEngineering;

import Model.Courses.SpecializedCourse;
import Model.Time;

import java.util.ArrayList;

public class ElectricalCircuits extends SpecializedCourse {
    public ElectricalCircuits(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setStudents(new ArrayList<>());
        this.setTitle("Electrical Circuits");
        this.setCode(42);
        this.setCredit(3);
    }
}

