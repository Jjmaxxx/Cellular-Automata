package CALab;

import mvc.*;

public class ClearCommand extends Command {
    Model model;

    public ClearCommand(Model model) {
        super(model);
        this.model = model;
    }

    @Override
    public void execute() {
        Grid grid = (Grid) model;
        grid.clear();
    }
}