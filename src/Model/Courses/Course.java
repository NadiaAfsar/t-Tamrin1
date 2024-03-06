package Model.Courses;

import Model.Student;
import Model.Time;

import java.util.ArrayList;
import java.util.Map;

public abstract class Course {
    private String title;
    private String instructor;
    private Time ClassTime;
    private Time ExamTime;
    private int credit;
    private String code;
    private int capacity;
    private int taken;
    private ArrayList<Student> students;
    private Map<String, Student> mapOfStudents;


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

    public String getCode() {
        return code;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setClassTime(Time classTime) {
        ClassTime = classTime;
    }

    public void setExamTime(Time examTime) {
        ExamTime = examTime;
    }

    public int getTaken() {
        return taken;
    }

    public void addStudent(Student student) {
        this.taken ++;
        this.students.add(student);
    }
    public void removeStudent(Student student) {
        this.taken -= 1;
        this.students.remove(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Map<String, Student> getMapOfStudents() {
        return mapOfStudents;
    }

    public void setMapOfStudents(Map<String, Student> mapOfStudents) {
        this.mapOfStudents = mapOfStudents;
    }
}
