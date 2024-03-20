package LifeLab;

import CALab.GridFactory;
import mvc.Model;

public class LifeFactory extends GridFactory {
    @Override
    public Model makeModel() {
        return new Society();
    }
    public String[] getHelp() {
        return new String[] {"Populate: Populates Cells either alive or dead.\nRun1: Simulates 1 cycle of life.\nRun50: Simulates 50 cycles of life.\nClear: Kills all Cells\nNew:Creates new Board\nSave:Saves Board\nOpen:Opens Board"};
    }
    public String about() {
        return "Life Lab Simulator 2024";
    }
}
