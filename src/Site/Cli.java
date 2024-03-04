package Site;

import Model.Admin;
import Model.Faculty.Faculty;
import Model.Student;
import Model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cli {
    private User user;
    private Map<String, User> users;
    private String username;
    private String password;
    private String pick;
    Scanner sc = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private StudentCli studentCli;
    private AdminCli adminCli;
    private final Faculty MathematicalSciences;
    private final Faculty Language;
    private final Faculty Physics;
    private final Faculty ElectricalEngineering;
    public Cli(Faculty f1, Faculty f2, Faculty f3, Faculty f4, Map<String, User> users) {
        this.MathematicalSciences = f1;
        this.Language = f2;
        this.Physics = f3;
        this.ElectricalEngineering = f4;
        this.users = users;

    }
    public void init() {
        System.out.println("Welcome!\n1-Log in\n2-Sign up");
        pick = sc.next();
        if (pick.equals("1")) {
            this.LogIn();
        }
        else if (pick.equals("2")) {
            SignUp();
        }
    }
    private void LogIn() {
        System.out.println("0-Back\nEnter your username:");
        username = sc.next();
        if (username.equals("0")) {
            init();
        }
        else if (users.get(username) != null) {
            getPassword();
        }
        else {
            System.out.println("This username doesn't exist.");
            this.LogIn();
        }
    }
    private void getPassword() {
        System.out.println("0-Back\nEnter your password:");
        password = sc.next();
        if (password.equals("0")) {
            LogIn();
        }
        else if (password.equals(users.get(username).getPassword())){
            user = users.get(username);
            studentCli = new StudentCli((Student)user, MathematicalSciences, Language, Physics, ElectricalEngineering);
            studentCli.getCli().setUsers(this.getUsers());
            studentCli.init();
        }
        else {
            System.out.println("Wrong password!");
            this.getPassword();
        }
    }
    private void SignUp() {
        System.out.println("0-Back\nEnter your first name:");
        firstName = sc.next();
        if (firstName.equals("0")) {
            init();
        }
        else if (isAlphabetic(firstName)){
            getLastName();
        }
        else {
            System.out.println("Invalid first name!");
            SignUp();
        }
    }
    private void setPassword() {
        System.out.println("0-Back\nEnter your password (Your password needs to be 9 characters):");
        password = sc.next();
        if (password.equals("0")) {
            SignUp();
        }
        else if (password.length() == 9) {
            repeatPassword();
        }
        else {
            System.out.println("Invalid password!");
        }
    }
    private void repeatPassword() {
        System.out.println("0-Back\nEnter your password again:");
        String pass = sc.next();
        if (pass.equals("0")) {
            setPassword();
        }
        else if (pass.equals(password)) {
            user = new Student(username, password, firstName, lastName);
            users.put(username, user);
            studentCli = new StudentCli((Student)user, MathematicalSciences, Language, Physics, ElectricalEngineering);
            studentCli.getCli().setUsers(this.getUsers());
            studentCli.init();
        }
        else {
            System.out.println("Passwords don't match!");
            repeatPassword();
        }
    }
    private void setUsername () {
        System.out.println("0-Back\nEnter your username:");
        username = sc.next();
        if (username.equals("0")) {
            getLastName();
        }
        else if (users.get(username) == null){
            setPassword();
        }
        else {
            System.out.println("This username is taken.");
            setUsername();
        }
    }
    private void getLastName () {
        System.out.println("0-Back\nEnter your last name:");
        lastName = sc.next();
        if (firstName.equals("0")) {
            SignUp();
        }
        else if (isAlphabetic(lastName)) {
            setUsername();
        }
        else {
            System.out.println("Invalid last name!");
            getLastName();
        }
    }
    private boolean isAlphabetic (String string) {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isAlphabetic(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }
}