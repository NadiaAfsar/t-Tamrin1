package Model.Courses.MathematicalSciences;

import Model.Courses.SpecializedCourse;
import Model.Time;

public class AdvancedProgramming extends SpecializedCourse {
    public AdvancedProgramming(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setTitle("AdvancedProgramming");
        this.setCode(13);
        this.setCredit(4);
    }
}
