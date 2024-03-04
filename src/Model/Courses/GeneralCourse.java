package Model.Courses;

import Model.Time;

public class GeneralCourse extends Course{
    public GeneralCourse(String title, String professor, Time classTime, Time examTime, int credit, int code, int capacity) {
        this.setTitle(title);
        this.setProfessor(professor);
        this.setClassTime(classTime);
        this.setExamTime(examTime);
        this.setCredit(credit);
        this.setCode(code);
        this.setCapacity(capacity);
    }

    public GeneralCourse(String professor, Time classTime, Time examTime, int capacity) {
        this.setProfessor(professor);
        this.setClassTime(classTime);
        this.setExamTime(examTime);
        this.setCapacity(capacity);
    }
}