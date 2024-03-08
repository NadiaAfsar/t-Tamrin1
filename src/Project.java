import Model.Admin;
import Model.Faculty.*;
import Model.Student;
import Model.User;
import Site.AdminCli;
import Site.Cli;
import Site.SaveLoad;
import Site.StudentCli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Project {
    private Cli cli;
    public Project () throws FileNotFoundException, IOException {
        cli = new Cli(new MathematicalSciences(), new Language(), new Physics(), new ElectricalEngineering());
        cli.setMapOfUsers(new HashMap<>());
        cli.getMapOfUsers().put("Admin", new Admin());
        cli.loadData();
        cli.init();

    }
}
