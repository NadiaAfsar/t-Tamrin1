package Model.Courses.MathematicalSciences;

import Model.Courses.SpecializedCourse;
import Model.Time;

public class BasicsOfMathematics extends SpecializedCourse {
    public BasicsOfMathematics(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setTitle("BasicsOfMathematics");
        this.setCode(14);
        this.setCredit(4);
    }
}
