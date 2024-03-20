package LifeLab;

import CALab.Cell;

import java.awt.*;

public class Agent extends Cell {
    private int status = 0;
    private int ambience = 0;

    public Agent(boolean uniform) {
        super(uniform);
    }

    @Override
    public void observe() {
        ambience = 0;
        for (Cell neighbor : neighbors) {
            if (neighbor != null && neighbor.getStatus() == 1) {
                ambience++;
            }
        }
        notifySubscribers();
    }

    @Override
    public void interact() {

    }

    @Override
    public void update() {
        if (status == 0) {
            if (Society.rebirth.contains(ambience)) {
                status = 1;
            }
        } else {
            if (Society.death.contains(ambience)) {
                status = 0;
            }
        }
        notifySubscribers();
    }

    @Override
    public void nextState() {
        if(this.status == 0){
            this.status = 1;
        }else {
            this.status = 0;
        }
        notifySubscribers();
    }

    @Override
    public void reset(boolean randomly) {
        if (randomly) {
            if (Math.random() < Society.percentAlive / 100.0) {
                status = 1;
            }else{
                status = 0;
            }
        } else {
            status = 0;
        }
        ambience = 0;
        notifySubscribers();
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public Color getColor() {
        if (status == 1) {
            return Color.GREEN;
        }
        return Color.RED;
    }
}