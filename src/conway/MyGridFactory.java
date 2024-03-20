package conway;

import CALab.GridFactory;
import mvc.Model;

public class MyGridFactory extends GridFactory {
    @Override
    public Model makeModel() {
        return new MyGrid();
    }
    public String[] getHelp() {
        return new String[] {"Populate: Populates Cells either alive or dead.\nRun1: Simulates 1 cycle of life.\nRun50: Simulates 50 cycles of life.\nClear: Kills all Cells\nNew:Creates new Board\nSave:Saves Board\nOpen:Opens Board"};
    }
    public String about() {
        return "Conway Lab Simulator 2024";
    }
}
