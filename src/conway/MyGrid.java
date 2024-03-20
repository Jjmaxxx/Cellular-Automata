package conway;

import CALab.Cell;
import CALab.Grid;

public class MyGrid extends Grid{
    public MyGrid(){
        super();
    }
    @Override
    public Cell makeCell(boolean uniform){
        return new MyCell(uniform);
    }
}
