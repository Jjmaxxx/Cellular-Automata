package stoplightSim2;

import mvc.*;

public class ChangeCommand extends Command {
    Model model;

    public ChangeCommand(Model model) {
        super(model);
        this.model=model;
    }

    public void execute() {
        Stoplight light = (Stoplight)model;
        light.change();
    }

}
