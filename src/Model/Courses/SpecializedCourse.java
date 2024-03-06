package Model.Courses;

import Model.Time;

import java.util.ArrayList;
import java.util.HashMap;

public class SpecializedCourse extends Course{
    public SpecializedCourse(String title, String professor, Time classTime, Time examTime, int credit, String code, int capacity) {
        this.setTitle(title);
        this.setInstructor(professor);
        this.setClassTime(classTime);
        this.setExamTime(examTime);
        this.setCredit(credit);
        this.setCode(code);
        this.setCapacity(capacity);
        this.setStudents(new ArrayList<>());
        this.setMapOfStudents(new HashMap<>());
    }

}
