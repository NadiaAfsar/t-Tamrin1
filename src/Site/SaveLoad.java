package Site;

import Model.Courses.Course;
import Model.Courses.GeneralCourse;
import Model.Courses.SpecializedCourse;
import Model.Faculty.Faculty;
import Model.Student;
import Model.Time;
import Model.User;
import Site.CliHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public interface SaveLoad {
    static void saveUsers (ArrayList<User> users) throws IOException {
        File file = new File("users");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < users.size(); i++) {
            fileWriter.append(users.get(i).getUsername()+"\n");
            saveStudent((Student)users.get(i));
        }
        fileWriter.close();
    }
    static void loadUsers (ArrayList<User> users, Map<String, User> mapOfUsers) throws FileNotFoundException {
        File file = new File("users");
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            Student student = loadStudent(sc.nextLine());
            users.add(student);
            mapOfUsers.put(student.getUsername(), student);
        }
    }
    static void saveStudent(Student student)  throws IOException {
        File directory = new File("students");
        directory.mkdir();
        File file = new File("students/"+student.getUsername());
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.append(student.getUsername()+"\n");
        fileWriter.append(student.getPassword()+"\n");
        fileWriter.append(student.getFirstName()+"\n");
        fileWriter.append(student.getLastName()+"\n");
        fileWriter.close();
    }
    static Student loadStudent(String user) throws FileNotFoundException {
        File file = new File("students/"+user);
        Scanner sc = new Scanner(file);
        String username = sc.nextLine();
        String password = sc.nextLine();
        String firstName = sc.nextLine();
        String lastName = sc.nextLine();
        return new Student(username, password, firstName, lastName);
    }
    static void saveCourse (Course course) throws IOException {
        File directory = new File("courses");
        directory.mkdir();
        File file = new File("courses/"+course.getCode());
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        if (course instanceof GeneralCourse) {
            fileWriter.append("1\n");
        }
        else {
            fileWriter.append("2\n");
        }
        fileWriter.append(course.getTitle()+"\n");
        fileWriter.append(course.getInstructor()+"\n");
        fileWriter.append(course.getCredit()+"\n");
        fileWriter.append(course.getCapacity()+"\n");
        int days = course.getClassTime().getDates().length;
        fileWriter.append(days+"\n");
        for (int i = 0; i < days; i++) {
            fileWriter.append(course.getClassTime().getDates()[i]+"\n");
        }
        fileWriter.append(course.getClassTime().getStart().getHour()+"\n");
        fileWriter.append(course.getClassTime().getStart().getMinute()+"\n");
        fileWriter.append(course.getClassTime().getEnd().getHour()+"\n");
        fileWriter.append(course.getClassTime().getEnd().getMinute()+"\n");
        fileWriter.append(course.getExamTime().getDate()+"\n");
        fileWriter.append(course.getExamTime().getStart().getHour()+"\n");
        fileWriter.append(course.getExamTime().getStart().getMinute()+"\n");
        for (Student student: course.getStudents()) {
            fileWriter.append(student.getUsername()+"\n");
        }
        fileWriter.close();
    }
    static Course loadCourse (String code, Map<String, User> students) throws FileNotFoundException{
        File file = new File("courses/"+code);
        Scanner sc = new Scanner(file);
        Course course;
        String type = sc.nextLine();
        String title = sc.nextLine();
        String instructor = sc.nextLine();
        int credit = Integer.parseInt(sc.nextLine());
        int capacity = Integer.parseInt(sc.nextLine());
        int days = Integer.parseInt(sc.nextLine());
        int[] dates = new int[days];
        for (int i = 0; i < days; i++){
            dates[i] = Integer.parseInt(sc.nextLine());
        }
        int hour = Integer.parseInt(sc.nextLine());
        int minute = Integer.parseInt(sc.nextLine());
        Time start = new Time(hour, minute);
        hour = Integer.parseInt(sc.nextLine());
        minute = Integer.parseInt(sc.nextLine());
        Time end = new Time(hour, minute);
        Time classTime = new Time(dates, start, end);
        String examDate = sc.nextLine();
        hour = Integer.parseInt(sc.nextLine());
        minute = Integer.parseInt(sc.nextLine());
        start = new Time(hour, minute);
        Time exam = new Time(examDate, start);
        if (type.equals("1")) {
            course = new GeneralCourse(title, instructor, classTime, exam, credit, code, capacity);
        }
        else {
            course = new SpecializedCourse(title, instructor, classTime, exam, credit, code, capacity);
        }
        while (sc.hasNext()) {
            String username = sc.next();
            CliHelper.addCourseStudent(course, (Student)students.get(username));
        }
        return course;
    }
    static void saveCourses (Faculty faculty) throws IOException {
        File directory = new File("faculties");
        directory.mkdir();
        File file = new File("faculties/"+faculty.getName());
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        for (Course course: faculty.getCourses()) {
            fileWriter.append(course.getCode()+"\n");
            saveCourse(course);
        }
        fileWriter.close();
    }
    static void loadCourses (Faculty faculty, Map<String, User> students) throws FileNotFoundException {
        File file = new File("faculties/"+faculty.getName());
        Scanner sc = new Scanner(file);
        faculty.setCourses(new ArrayList<>());
        faculty.setMapOfCourses(new HashMap<>());
        while (sc.hasNext()) {
            Course course = loadCourse(sc.next(), students);
            faculty.getCourses().add(course);
            faculty.getMapOfCourses().put(course.getCode(), course);
        }
    }
}
