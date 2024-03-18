package CALab;

import mvc.*;

public class PopulateCommand extends Command {
    private boolean randomly;
    Model model;

    public PopulateCommand(Model m, boolean randomly) {
        super(m);
        this.randomly = randomly;
        this.model = m;
    }

    @Override
    public void execute() {
        Grid grid = (Grid) model ;
        grid.repopulate(randomly);
    }
}