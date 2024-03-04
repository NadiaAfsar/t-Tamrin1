package Site;

import Model.Courses.Course;
import Model.Faculty.*;
import Model.Student;
import Model.Time;

import java.util.HashMap;
import java.util.Scanner;

public class StudentCli {
    private final Student student;
    private String pick;
    Scanner sc;
    private Cli cli;
    private Faculty chosenFaculty;
    private final Faculty MathematicalSciences;
    private final Faculty Language;
    private final Faculty Physics;
    private final Faculty ElectricalEngineering;
    public StudentCli (Student student, Faculty f1, Faculty f2, Faculty f3, Faculty f4) {
        this.student = student;
        this.MathematicalSciences = f1;
        this.Language = f2;
        this.Physics = f3;
        this.ElectricalEngineering = f4;
        sc = new Scanner(System.in);
        cli = new Cli(f1, f2, f3, f4, new HashMap<>());
    }
    public void init () {
        System.out.println("Welcome "+student.getFirstName()+" "+student.getLastName()+"!");
        System.out.println("0-Back\n1-Show taken courses\n2-Show list of faculties");
        pick = sc.next();
        if (pick.equals("0")) {
            cli.init();
        }
        else if (pick.equals("1")) {
            showTakenCourses();
        }
        else if (pick.equals("2")) {
            showFaculties();
        }
    }
    public void showFaculties () {
        System.out.println("0-Back\n1-Mathematical Sciences\n2-Language\n3-Physics\n4-Electrical Engineering");
        pick = sc.next();
        if (pick.equals("0")) {
            init();
        }
        else if (pick.equals("1")) {
            chosenFaculty = MathematicalSciences;
            showCourses(MathematicalSciences);
        }
        else if (pick.equals("2")) {
            chosenFaculty = Language;
            showCourses(Language);
        }
        else if (pick.equals("3")) {
            chosenFaculty = Physics;
            showCourses(Physics);
        }
        else if (pick.equals("4")) {
            chosenFaculty = ElectricalEngineering;
            showCourses(ElectricalEngineering);
        }
    }
    public void showTakenCourses () {
        System.out.println("0-Back");
        int numberOfCourses = student.getTakenCourses().size();
        for (int i = 1; i <= numberOfCourses; i++) {
            System.out.println(i+"-"+student.getTakenCourses().get(i-1).getTitle());
        }
        int p = sc.nextInt();
        if (p == 0) {
            init();
        }
        else if (p >= 1 && p <= numberOfCourses) {
            showTakenCourse(student.getTakenCourses().get(p-1), 0);
        }

    }
    public void showTakenCourse (Course course, int lastPage) {
        System.out.println("code: "+course.getCode());
        System.out.println("credit: "+course.getCredit());
        System.out.println("title: "+course.getTitle());
        System.out.println("professor: "+course.getProfessor());
        System.out.println("class time: "+course.getClassTime());
        System.out.println("exam time: "+course.getExamTime());
        System.out.println("taken capacity: "+course.getTaken()+"/"+course.getCapacity());
        System.out.println("0-Back\n1-delete the course");
        pick = sc.next();
        if (pick.equals("0")) {
            if (lastPage == 0) {
                showTakenCourses();
            }
            else {
                showCourses(chosenFaculty);
            }
        }
        else if (pick.equals("1")) {
            deleteCourse(course);
            System.out.println("The course is deleted!");
            if (lastPage == 0) {
                showTakenCourses();
            }
            else {
                showCourses(chosenFaculty);
            }
        }
    }
    private void showCourses (Faculty faculty) {
        System.out.println("0-Back");
        int numberOfCourses = faculty.getCourses().size();
        for (int i = 1; i <= numberOfCourses; i++) {
            System.out.println(i+"-"+faculty.getCourses().get(i-1).getTitle());
        }
        int p = sc.nextInt();
        if (p == 0) {
            showFaculties();
        }
        else if (p >= 1 && p <= numberOfCourses) {
            if (student.getAddedCourses().get(faculty.getCourses().get(p-1).getTitle()) != null) {
                showTakenCourse(faculty.getCourses().get(p-1), 1);
            }
            else {
                showCourse(p);
            }
        }
    }
    public void showCourse (int n) {
        Course course = chosenFaculty.getCourses().get(n-1);
        System.out.println("code: "+course.getCode());
        System.out.println("credit: "+course.getCredit());
        System.out.println("title: "+course.getTitle());
        System.out.println("professor: "+course.getProfessor());
        System.out.println("class time: "+course.getClassTime());
        System.out.println("exam time: "+course.getExamTime());
        System.out.println("taken capacity: "+course.getTaken()+"/"+course.getCapacity());
        System.out.println("0-Back\n1-add the course");
        pick = sc.next();
        if (pick.equals("0")) {
            showCourses(chosenFaculty);
        }
        else if (pick.equals("1")) {
            if (course.getTaken() != course.getCapacity()) {
                if (!hasConflict(course)) {
                    addCourse(course);
                    System.out.println("Course added!");
                    showCourses(chosenFaculty);
                }
                else {
                    System.out.println("This class has time conflict with your classes!");
                    showCourses(chosenFaculty);
                }
            }
            else {
                System.out.println("This class is full!");
                showCourses(chosenFaculty);
            }
        }
    }
    public void setClassTime (Time time, boolean addOrDel) {
        for (int day: time.getDates()) {
            for (int hour = time.getStart().getHour(); hour <= time.getEnd().getHour(); hour++) {
                if (hour == time.getStart().getHour()) {
                    for (int minute = time.getStart().getMinute(); minute < 60; minute++) {
                        student.getTimetable()[day][hour][minute] = addOrDel;
                    }
                }
                else if (hour == time.getEnd().getHour()) {
                    for (int minute = 0; minute < time.getEnd().getMinute(); minute++) {
                        student.getTimetable()[day][hour][minute] = addOrDel;
                    }
                }
                else {
                    for (int minute = 0; minute < 60; minute++) {
                        student.getTimetable()[day][hour][minute] = addOrDel;
                    }
                }
            }
        }
    }
    public boolean hasConflict(Course course) {
        Time t = course.getExamTime();
        for (Time exam: student.getExams()) {
            if (t.getDate().equals(exam.getDate()) && t.getHour() == exam.getHour() && t.getMinute() == exam.getMinute()) {
                return true;
            }
        }
        t = course.getClassTime();
        for (int day: t.getDates()) {
            for (int hour = t.getStart().getHour(); hour <= t.getEnd().getHour(); hour++) {
                if (hour == t.getStart().getHour()) {
                    for (int minute = t.getStart().getMinute(); minute < 60; minute++) {
                        if (student.getTimetable()[day][hour][minute] == true)
                        {
                            return true;
                        }
                    }
                }
                else if (hour == t.getEnd().getHour()) {
                    for (int minute = 0; minute < t.getEnd().getMinute(); minute++) {
                        if (student.getTimetable()[day][hour][minute] == true) {
                            return true;
                        }
                    }
                }
                else {
                    for (int minute = 0; minute < 60; minute++) {
                        if (student.getTimetable()[day][hour][minute] == true) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public void addCourse (Course course) {
        course.addStudent(student);
        setClassTime(course.getClassTime(), true);
        student.getExams().add(course.getExamTime());
        student.getTakenCourses().add(course);
        student.getAddedCourses().put(course.getTitle(), course);
    }
    public void deleteCourse (Course course) {
        setClassTime(course.getClassTime(), false);
        student.getExams().remove(course.getExamTime());
        student.getTakenCourses().remove(course);
        student.getAddedCourses().remove(course.getTitle());
        course.removeStudent(student);
    }

    public Student getStudent() {
        return student;
    }

    public Cli getCli() {
        return cli;
    }

    public void setCli(Cli cli) {
        this.cli = cli;
    }
}