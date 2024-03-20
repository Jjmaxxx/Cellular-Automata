package CALab;

import mvc.*;

public class RunCommand extends Command {
    Model model;
    private int cycles;

    public RunCommand(Model model, int cycles) {
        super(model);
        this.model = model;
        this.cycles = cycles;
    }

    @Override
    public void execute() {
        Grid grid = (Grid) model;
        grid.updateLoop(cycles); // Run the simulation for the specified number of cycles
    }
}