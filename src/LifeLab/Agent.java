package LifeLab;

import CALab.Cell;

import java.awt.*;
import java.util.Random;

public class Agent extends Cell{
    public Agent(boolean uniform){
        super(uniform);
    }
    @Override
    public void observe() {
//        System.out.println("i am at row:" + row + " col: " + col);
//        for (Cell item : neighbors) {
//            System.out.println(" row: " + item.row + "col: " +item.col);
//        }
//        System.out.println("___");
        Cell[] arr = new Cell[neighbors.size()];
        arr= neighbors.toArray(arr);
        int aliveNeighbors = 0;
        for (Cell cell : arr) {
            if (cell.status == 1) {
                aliveNeighbors += 1;
            }
        }
        ambience = aliveNeighbors;
        update();
    }

    @Override
    public void interact() {
        if(ambience<2 || ambience>4){
            status =0;
        }else if(ambience ==3){
            status =1;
        }
    }

    @Override
    public void update() {
        notifySubscribers();
    }

    @Override
    public void nextState() {
        if(this.status == 0){
            this.status = 1;
        }else{
            this.status = 0;
        }
    }

    @Override
    public void reset(boolean randomly) {
        if(randomly){
            Random random = new Random();
            status = random.nextInt(2);
        }else{
            status = 0;
        }
        ambience=0;
        update();
    }

    @Override
    public Color getColor() {
        if(status == 1){
            return Color.GREEN;
        }
        return Color.RED;
    }

    @Override
    public int getStatus() {
        return ambience;
    }
}