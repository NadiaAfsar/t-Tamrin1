package Model.Courses.ElectricalEngineering;

import Model.Courses.SpecializedCourse;
import Model.Time;

public class BasicProgramming extends SpecializedCourse {
    public BasicProgramming(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setTitle("BasicProgramming");
        this.setCode(41);
        this.setCredit(3);
    }
}
