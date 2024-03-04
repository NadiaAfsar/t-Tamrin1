package Model.Courses.ElectricalEngineering;

import Model.Courses.SpecializedCourse;
import Model.Time;

import java.util.ArrayList;

public class BasicProgramming extends SpecializedCourse {
    public BasicProgramming(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setStudents(new ArrayList<>());
        this.setTitle("Basic Programming");
        this.setCode(41);
        this.setCredit(3);
    }
}
