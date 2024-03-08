package Site;

import Model.Courses.Course;
import Model.Faculty.*;
import Model.Student;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    public StudentCli (Student student, Faculty f1, Faculty f2, Faculty f3, Faculty f4) throws FileNotFoundException, IOException{
        this.student = student;
        this.MathematicalSciences = f1;
        this.Language = f2;
        this.Physics = f3;
        this.ElectricalEngineering = f4;
        sc = new Scanner(System.in);
        cli = new Cli(f1, f2, f3, f4);
    }
    public void init () throws IOException {
        System.out.println("Welcome "+student.getFirstName()+" "+student.getLastName()+"!");
        System.out.println("*-Back\n1-Show taken courses\n2-Show list of faculties\n**-Sign out");
        pick = sc.next();
        if (pick.equals("*")) {
            cli.init();
        }
        else if (pick.equals("1")) {
            showTakenCourses();
        }
        else if (pick.equals("2")) {
            showFaculties();
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else {
            System.out.println("Invalid request!");
            this.init();
        }
    }
    public void showFaculties () throws IOException{
        System.out.println("*-Back\n1-Mathematical Sciences\n2-Language\n3-Physics\n4-Electrical Engineering\n**-Sign out");
        pick = sc.next();
        if (pick.equals("*")) {
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
        else if (pick.equals("**")) {
            cli.init();
        }
        else {
            System.out.println("Invalid request!");
            showFaculties();
        }
    }
    public void showTakenCourses () throws IOException {
        if (student.getTakenCourses().size() != 0) {
            System.out.println("*-Back\nEnter the code of a course for more info:");
            int numberOfCourses = student.getTakenCourses().size();
            for (int i = 1; i <= numberOfCourses; i++) {
                System.out.println(i + "-" + student.getTakenCourses().get(i - 1).getTitle());
            }
            System.out.println("**-Sign out");
            pick = sc.next();
            if (pick.equals("*")) {
                init();
            } else if (pick.equals("**")) {
                cli.init();
            }
            if (CliHelper.isDigit(pick)) {
                int p = Integer.parseInt(pick);
             if (p >= 1 && p <= numberOfCourses) {
                    showTakenCourse(student.getTakenCourses().get(p - 1), 0);
                } else {
                    System.out.println("Invalid request!");
                    showTakenCourses();
                }
            }
            else {
                System.out.println("Invalid request!");
                showTakenCourses();
            }
        }
        else {
            System.out.println("No course is taken yet!");
            init();
        }
    }
    public void showTakenCourse (Course course, int lastPage) throws IOException{
        CliHelper.showCourseData(course);
        System.out.println("*-Back\n1-delete the course\n**-Sign out");
        pick = sc.next();
        if (pick.equals("*")) {
            if (lastPage == 0) {
                showTakenCourses();
            }
            else {
                showCourses(chosenFaculty);
            }
        }
        else if (pick.equals("1")) {
            CliHelper.deleteCourseStudent(course, student);
            SaveLoad.saveStudent(student);
            SaveLoad.saveCourse(course);
            System.out.println("The course is deleted!");
            if (lastPage == 0) {
                showTakenCourses();
            }
            else {
                showCourses(chosenFaculty);
            }
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else {
            System.out.println("Invalid request!");
            showTakenCourse(course, lastPage);
        }
    }
    private void showCourses (Faculty faculty) throws IOException{
        System.out.println("*-Back\nEnter the code of a course for more info:");
        int numberOfCourses = faculty.getCourses().size();
        for (int i = 1; i <= numberOfCourses; i++) {
            System.out.println(faculty.getCourses().get(i-1).getCode()+"-"+faculty.getCourses().get(i-1).getTitle());
        }
        System.out.println("**-Sign out");
        pick = sc.next();
        if (pick.equals("*")) {
            showFaculties();
        }
        else if (faculty.getMapOfCourses().get(pick) != null) {
            if (student.getMapOfCourses().get(faculty.getMapOfCourses().get(pick).getTitle()) != null) {
                showTakenCourse(faculty.getMapOfCourses().get(pick), 1);
            }
            else {
                showCourse(faculty.getMapOfCourses().get(pick));
            }
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else {
            System.out.println("Invalid request!");
            showCourses(faculty);
        }
    }
    public void showCourse (Course course) throws IOException{
        CliHelper.showCourseData(course);
        System.out.println("*-Back\n1-add the course\n**-Sign out");
        pick = sc.next();
        if (pick.equals("*")) {
            showCourses(chosenFaculty);
        }
        else if (pick.equals("1")) {
            if (course.getTaken() != course.getCapacity()) {
                if (!CliHelper.hasConflict(course, student)) {
                    CliHelper.addCourseStudent(course, student);
                    SaveLoad.saveStudent(student);
                    SaveLoad.saveCourse(course);
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
        else if (pick.equals("**")) {
            cli.init();
        }
        else {
            System.out.println("Invalid request!");
            showCourse(course);
        }
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