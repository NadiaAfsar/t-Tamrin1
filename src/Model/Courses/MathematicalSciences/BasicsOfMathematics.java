package Model.Courses.MathematicalSciences;

import Model.Courses.SpecializedCourse;
import Model.Time;

import java.util.ArrayList;

public class BasicsOfMathematics extends SpecializedCourse {
    public BasicsOfMathematics(String professor, Time classTime, Time examTime, int capacity) {
        super(professor, classTime, examTime, capacity);
        this.setStudents(new ArrayList<>());
        this.setTitle("Basics Of Mathematics");
        this.setCode(14);
        this.setCredit(4);
    }
}
