package Model.Courses.ElectricalEngineering;

import Model.Courses.GeneralCourse;
import Model.Time;

import java.util.ArrayList;

public class Electronic1Lab extends GeneralCourse {
    public Electronic1Lab(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setStudents(new ArrayList<>());
        this.setTitle("Electronic 1 Lab");
        this.setCode(43);
        this.setCredit(1);
    }
}