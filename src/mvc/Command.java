package mvc;

public abstract class Command {

    public Model model;

    public Command(Model model) {
        
    }

    public abstract void execute();

}
