package LifeLab;

import CALab.Cell;
import CALab.Grid;

public class LifeGrid extends Grid{
    public LifeGrid(){
        super();
    }
    @Override
    public Cell makeCell(boolean uniform){
        return new LifeCell(uniform);
    }
}

