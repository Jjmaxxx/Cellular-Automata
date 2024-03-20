package LifeLab;

import CALab.Cell;
import CALab.Grid;

import java.util.HashSet;
import java.util.Set;

public class Society extends Grid{
    public static Set<Integer> rebirth = new HashSet<Integer>();
    public static Set<Integer> death = new HashSet<Integer>();
    public static int percentAlive = 50;
//    public static int gridAlive = (int)(400* ((double) percentAlive /100));

    static {
        // Set rebirth rules
        rebirth.add(3);
        // Set death rules
        death.add(0);
        death.add(1);
        death.add(4);
        death.add(5);
        death.add(6);
        death.add(7);
        death.add(8);
    }
    public Society(){
        super();
    }
    @Override
    public Cell makeCell(boolean uniform){
        return new Agent(uniform);
    }

}