package mvc;

public interface AppFactory {

    public Model makeModel();

    public View makeView();

    // source added 3/15 to support text fields
    Command makeEditCommand(Model model, String type, Object source);

    public String getTitle();
    public String[] getHelp();
    public String about();
    public String[] getEditCommands();
    public Command makeEditCommand(String name);

}
