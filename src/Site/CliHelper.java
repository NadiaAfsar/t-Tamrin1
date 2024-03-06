package Site;

import Model.Courses.Course;
import Model.Student;
import Model.Time;

public interface CliHelper {
    static void showCourseData (Course course) {
        System.out.println("code: "+course.getCode());
        System.out.println("credit: "+course.getCredit());
        System.out.println("title: "+course.getTitle());
        System.out.println("professor: "+course.getInstructor());
        System.out.println("class time: "+course.getClassTime());
        System.out.println("exam time: "+course.getExamTime());
        System.out.println("taken capacity: "+course.getTaken()+"/"+course.getCapacity());
    }
    static void setClassTime (Time time, boolean addOrDel, Student student) {
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
    static boolean hasConflict(Course course, Student student) {
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
    static void addCourseStudent (Course course, Student student) {
        course.addStudent(student);
        setClassTime(course.getClassTime(), true, student);
        student.getExams().add(course.getExamTime());
        student.getTakenCourses().add(course);
        student.getMapOfCourses().put(course.getTitle(), course);
        student.getMapOfCourses().put(course.getCode(), course);
        course.getMapOfStudents().put(student.getUsername(), student);
    }
    static void deleteCourseStudent (Course course, Student student) {
        setClassTime(course.getClassTime(), false, student);
        student.getExams().remove(course.getExamTime());
        student.getTakenCourses().remove(course);
        student.getMapOfCourses().remove(course.getTitle());
        student.getMapOfCourses().put(course.getCode(), null);
        course.getMapOfStudents().put(student.getUsername(), null);
        course.removeStudent(student);
    }
    static boolean isAlphabetic (String string) {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isAlphabetic(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    static boolean isDigit (String string) {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
