package LifeLab;

import CALab.Cell;
import CALab.Grid;

public class Society extends Grid{
    public Society(){
        super();
    }
    @Override
    public Cell makeCell(boolean uniform){
        return new Agent(uniform);
    }
}

