import Model.Admin;
import Model.Faculty.*;
import Model.Student;
import Model.User;
import Site.Cli;

import java.util.HashMap;
import java.util.Map;

public class Project {
    private final Faculty MathematicalSciences;
    private final Faculty Language;
    private final Faculty Physics;
    private final Faculty ElectricalEngineering;
    private Cli cli;
    public Project () {
        MathematicalSciences = new MathematicalSciences();
        Language = new Language();
        Physics = new Physics();
        ElectricalEngineering = new ElectricalEngineering();
        Map<String, User> users = new HashMap<>();
        users.put("Admin", new Admin());
        users.put("402100356", new Student("402100356", "402100356", "nadia", "afsar"));
        cli = new Cli(MathematicalSciences, Language, Physics, ElectricalEngineering, users);
        cli.init();
    }
}
