package Site;

import Model.Courses.Course;
import Model.Courses.GeneralCourse;
import Model.Courses.SpecializedCourse;
import Model.Faculty.Faculty;
import Model.Student;
import Model.Time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AdminCli {
    private final Faculty MathematicalSciences;
    private final Faculty Language;
    private final Faculty Physics;
    private final Faculty ElectricalEngineering;
    private Cli cli;
    private Scanner sc;
    private String pick;
    private Faculty chosenFaculty;
    private String type;
    private String title;
    private String code;
    private int credit;
    private String instructor;
    private Time ClassTime;
    private Time ExamTime;
    private int capacity;
    private String date;
    private ArrayList<Integer> days;
    private int[] arrayOfDays;
    private int hour;
    private int minute;
    private Time start;
    private Time end;
    private Course course;

    public AdminCli (Faculty f1, Faculty f2, Faculty f3, Faculty f4) {
        this.MathematicalSciences = f1;
        this.Language = f2;
        this.Physics = f3;
        this.ElectricalEngineering = f4;
        sc = new Scanner(System.in);
        cli = new Cli(f1, f2, f3, f4, new HashMap<>());
    }
    public void init () {
        System.out.println("Welcome!");
        System.out.println("*-Back\n1-Show list of faculties\n**-Sign out");
        pick = sc.next();
        if (pick.equals("*")) {
            cli.init();
        }
        else if (pick.equals("1")) {
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
    private void showFaculties () {
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
    private void showCourses (Faculty faculty) {
        System.out.println("*-Back\nEnter the code of a course for more info:");
        int numberOfCourses = faculty.getCourses().size();
        for (int i = 1; i <= numberOfCourses; i++) {
            System.out.println(faculty.getCourses().get(i-1).getCode()+"-"+faculty.getCourses().get(i-1).getTitle());
        }
        System.out.println("1-Add a course\n**-Sign out");
        pick = sc.next();
        if (pick.equals("*")) {
            showFaculties();
        }
        else if (pick.equals("1")) {
            addCourse(faculty);
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else if (faculty.getMapOfCourses().get(pick) != null) {
            showCourse(faculty.getMapOfCourses().get(pick));
        }
        else {
            System.out.println("Invalid request!");
            showCourses(faculty);
        }
    }
    private void showCourse (Course course) {
        CliHelper.showCourseData(course);
        System.out.println("*-Back\n1-Show students\n2-Delete the course\n**-Sign out");
        pick = sc.next();
        if (pick.equals("*")) {
            showCourses(chosenFaculty);
        }
        else if (pick.equals("1")) {
            showStudents(course);
        }
        else if (pick.equals("2")) {
            deleteCourse(course);
            showCourses(chosenFaculty);
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else {
            System.out.println("Invalid request!");
            showCourse(course);
        }
    }
    private void deleteCourse(Course course) {
        chosenFaculty.getCourses().remove(course);
        chosenFaculty.getMapOfCourses().put(course.getCode(), null);
        for (int i = 0; i < course.getStudents().size(); i++) {
            CliHelper.deleteCourseStudent(course, course.getStudents().get(i));
        }
    }
    private void showStudents (Course course) {
        ArrayList<Student> students = course.getStudents();
        System.out.println("*-Back\nChoose a student to delete!");
        for (int i = 1; i <= students.size(); i++) {
            System.out.println(students.get(i-1).getUsername());
        }
        System.out.println("1-Add student\n**-Sign out");
        pick = sc.next();
        if (pick.equals("*")) {
            showCourse(course);
        }
        else if (course.getMapOfStudents().get(pick) != null) {
            showStudent(course.getMapOfStudents().get(pick), course);
        }
        else if (pick.equals("1")) {
            addStudent(course);
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else {
            System.out.println("Invalid input!");
            showStudents(course);
        }
    }
    private void showStudent (Student student, Course course) {
        System.out.println("Student ID: "+student.getUsername());
        System.out.println("Name: "+student.getFirstName()+" "+student.getLastName());
        System.out.println("*-Back\n1-Delete the student\n**-Sign out");
        pick = sc.next();
        if (pick.equals("*")) {
            showCourse(course);
        }
        else if (pick.equals("1")) {
            CliHelper.deleteCourseStudent(course, student);
            System.out.println("Student is deleted!");
            showCourse(course);
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else {
            System.out.println("Invalid input!");
            showStudent(student, course);
        }
    }
    private void addStudent(Course course) {
        System.out.println("*-Back\n**-Sign out\nEnter the student ID:");
        pick = sc.next();
        if (pick.equals("*")) {
            showStudents(course);
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else if (cli.getUsers().get(pick) != null) {
            if (!CliHelper.hasConflict(course, (Student)cli.getUsers().get(pick))) {
                CliHelper.addCourseStudent(course, (Student) cli.getUsers().get(pick));
                System.out.println("Student is added.");
            }
            else {
                System.out.println("This course has time conflict with the student's classes!");
            }
            showStudents(course);
        }
        else {
            System.out.println("This student doesn't exist!");
            showStudents(course);
        }
    }
    private void addCourse(Faculty faculty) {
        System.out.println("*-Back\nEnter type of the course:\n1-General Course\n2-Specialized Course\n**-Sign out");
        type = sc.next();
        if (type.equals("*")) {
            showCourses(faculty);
        }
        else if (type.equals("**")) {
            cli.init();
        }
        else if (!type.equals("1") && !type.equals("2")) {
            System.out.println("Invalid input!");
            addCourse(faculty);
        }
        else {
            getTitle(faculty);
        }
    }
    private void getTitle (Faculty faculty) {
        System.out.println("*-Back\n**-Sign out\nEnter title of the course:");
        title = sc.next();
        if (title.equals("*")) {
            addCourse(faculty);
        }
        else if (title.equals("**")) {
            cli.init();
        } else {
            getCode(faculty);
        }
    }
    private void getCode (Faculty faculty) {
        System.out.println("*-Back\n**-Sign out\nEnter the code of the course:");
        code = sc.next();
        if (code.equals("*")) {
            getTitle(faculty);
        }
        else if (code.equals("**")) {
            cli.init();
        }
        else if (codeExists(code)) {
            System.out.println("This code exists.");
            getCode(faculty);
        }
        else {
            getCredit(faculty);
        }
    }
    public void getCredit(Faculty faculty) {
        System.out.println("*-Back\n**-Sign out\nEnter the credit of the course:");
        pick = sc.next();
        if (code.equals("*")) {
            getTitle(faculty);
        }
        else if (code.equals("**")) {
            cli.init();
        }
        else if (CliHelper.isDigit(pick)) {
            credit = Integer.parseInt(pick);
            getInstructor(faculty);
        }
        else {
            System.out.println("Invalid number!");
            getCredit(faculty);
        }
    }
    public void getInstructor (Faculty faculty) {
        System.out.println("*-Back\n**-Sign out\nEnter the name of the instructor:");
        instructor = sc.next();
        if (instructor.equals("*")) {
            getCredit(faculty);
        }
        else if (instructor.equals("**")) {
            cli.init();
        }
        else {
            getClassDay(faculty);
        }
    }
    public void getClassDay (Faculty faculty) {
        days = new ArrayList<>();
        System.out.println("*-Back\nChoose the days of the course(Enter 8 when you are done):");
        System.out.println("1-Saturday\n2-Sunday\n3-Monday\n4-Tuesday\n5-Wednesday\n6-Thursday\n7-Friday\n8-Done\n**-Sign out");
        while (sc.hasNext()) {
            pick = sc.next();
            if (pick.equals("*")) {
                getInstructor(faculty);
            }
            else if (pick.equals("**")) {
                cli.init();
            }
            else if (pick.equals("8")) {
                getStartTime(faculty);
            }
            else if (CliHelper.isDigit(pick)) {
                int day = Integer.parseInt(pick);
                if (day >= 1 && day <= 7) {
                    days.add(day);
                }
                else {
                    System.out.println("Invalid input!");
                }
            }
            else {
                System.out.println("Invalid input!");
            }
        }
    }
    private void getStartTime (Faculty faculty) {
        System.out.println("*-Back\n**-Sign out\nEnter the class start time:");
        getHour();
        if (pick.equals("*")) {
            getClassDay(faculty);
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else if (CliHelper.isDigit(pick)) {
            hour = Integer.parseInt(pick);
            getStartMinute(faculty);
        }
        else {
            System.out.println("Invalid input!");
            getStartTime(faculty);
        }
    }
    private void getStartMinute (Faculty faculty) {
        getMinute();
        if (pick.equals("*")) {
            getClassDay(faculty);
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else if (CliHelper.isDigit(pick)) {
            minute = Integer.parseInt(pick);
            start = new Time(hour, minute);
            getEndTime(faculty);
        }
        else {
            System.out.println("Invalid input!");
            getStartMinute(faculty);
        }
    }
    public void getHour() {
        System.out.println("hour:");
        pick = sc.next();
    }
    public void getMinute() {
        System.out.println("minute:");
        pick = sc.next();
    }

    private void getEndTime (Faculty faculty) {
        System.out.println("*-Back\n**-Sign out\nEnter the class end time:");
        getHour();
        if (pick.equals("*")) {
            getStartTime(faculty);
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else if (CliHelper.isDigit(pick)) {
            hour = Integer.parseInt(pick);
            getEndMinute(faculty);
        }
        else {
            System.out.println("Invalid input!");
            getEndTime(faculty);
        }
    }
    private void getEndMinute (Faculty faculty) {
        getMinute();
        if (pick.equals("*")) {
            getClassDay(faculty);
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else if (CliHelper.isDigit(pick)) {
            minute = Integer.parseInt(pick);
            end = new Time(hour, minute);
            arrayListToArray(days);
            ClassTime = new Time (arrayOfDays, start, end);
            getExamTime(faculty);
        }
        else {
            System.out.println("Invalid input!");
            getEndMinute(faculty);
        }
    }
    public void getExamTime(Faculty faculty) {
        System.out.println("*-Back\n**-Sign out\nEnter the date of the exam(YY/MM//DD):");
        date = sc.next();
        if (date.equals("*")) {
            getEndTime(faculty);
        }
        else if (date.equals("**")) {
            cli.init();
        }
        else {
            getExamHour(faculty);
        }
    }
    private void getExamHour(Faculty faculty) {
        System.out.println("*-Back\n**-Sign out\nEnter the time of the exam:");
        getHour();
        if (pick.equals("*")) {
            getExamTime(faculty);
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else if (CliHelper.isDigit(pick)) {
            hour = Integer.parseInt(pick);
            getExamMinute(faculty);
        }
        else {
            System.out.println("Invalid input!");
            getExamHour(faculty);
        }
    }
    private void getExamMinute (Faculty faculty) {
        getMinute();
        if (pick.equals("*")) {
            getExamHour(faculty);
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else if (CliHelper.isDigit(pick)) {
            minute = Integer.parseInt(pick);
            start = new Time(hour, minute);
            ExamTime = new Time (date, start);
            getCapacity(faculty);
        }
        else {
            System.out.println("Invalid input!");
            getEndMinute(faculty);
        }
    }
    private void getCapacity(Faculty faculty) {
        System.out.println("*-Back\n**-Sign out\nEnter the capacity of the course:");
        pick = sc.next();
        if (pick.equals("*")) {
            getExamHour(faculty);
        }
        else if (pick.equals("**")) {
            cli.init();
        }
        else if (CliHelper.isDigit(pick)) {
            capacity = Integer.parseInt(pick);
            if (type.equals("1")) {
                course = new GeneralCourse(title, instructor, ClassTime, ExamTime, credit, code, capacity);
            }
            else {
                course = new SpecializedCourse(title, instructor, ClassTime, ExamTime, credit, code, capacity);
            }
            faculty.getCourses().add(course);
            faculty.getMapOfCourses().put(course.getCode(), course);
            showCourses(faculty);
        }
    }
    private void arrayListToArray (ArrayList<Integer> days) {
        arrayOfDays = new int[days.size()];
        for (int i = 0; i < days.size(); i++) {
            arrayOfDays[i] = days.get(i);
        }
    }

    private boolean codeExists (String code) {
        if (MathematicalSciences.getMapOfCourses().get(code) != null) {
            return true;
        }
        if (Language.getMapOfCourses().get(code) != null) {
            return true;
        }
        if (Physics.getMapOfCourses().get(code) != null) {
            return true;
        }
        if (ElectricalEngineering.getMapOfCourses().get(code) != null) {
            return true;
        }
        return false;
    }

    public Cli getCli() {
        return cli;
    }
}
