package Model.Courses;

import Model.Time;

public abstract class Course {
    private String title;
    private String professor;
    private Time ClassTime;
    private Time ExamTime;
    private int credit;
    private int code;
    private int capacity;


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTitle() {
        return title;
    }

    public Time getClassTime() {
        return ClassTime;
    }

    public Time getExamTime() {
        return ExamTime;
    }

    public int getCredit() {
        return credit;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCode() {
        return code;
    }

    public String getProfessor() {
        return professor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void setClassTime(Time classTime) {
        ClassTime = classTime;
    }

    public void setExamTime(Time examTime) {
        ExamTime = examTime;
    }
}
