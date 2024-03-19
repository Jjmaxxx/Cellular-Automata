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

        Cell[] arr = new Cell[neighbors.size()];
        arr= neighbors.toArray(arr);
        int aliveNeighbors = 0;
        for (Cell cell : arr) {
            if (cell.status == 1) {
                aliveNeighbors += 1;
            }
        }
        ambience = aliveNeighbors;
        notifySubscribers();
    }

    @Override
    public void interact() {

    }

    @Override
    public void update() {
        if(ambience<2 || ambience>3){
            status =0;
        }else if(ambience ==3 && status ==0){
            status =1;
        }

//        notifySubscribers();
    }

    @Override
    public void nextState() {
        if(this.status == 0){
            this.status = 1;
        }else {
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
        notifySubscribers();
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