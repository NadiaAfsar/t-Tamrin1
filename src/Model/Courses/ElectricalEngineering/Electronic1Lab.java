package Model.Courses.ElectricalEngineering;

import Model.Courses.GeneralCourse;
import Model.Time;

public class Electronic1Lab extends GeneralCourse {
    public Electronic1Lab(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setTitle("Electronic1Lab");
        this.setCode(43);
        this.setCredit(1);
    }
}
