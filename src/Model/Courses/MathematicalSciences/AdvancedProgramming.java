package Model.Courses.MathematicalSciences;

import Model.Courses.SpecializedCourse;
import Model.Time;

import java.util.ArrayList;

public class AdvancedProgramming extends SpecializedCourse {
    public AdvancedProgramming(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setStudents(new ArrayList<>());
        this.setTitle("Advanced Programming");
        this.setCode(13);
        this.setCredit(4);
    }
}

