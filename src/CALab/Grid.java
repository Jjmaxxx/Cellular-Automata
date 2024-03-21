package CALab;

import java.awt.*;
import java.util.*;
import mvc.*;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() { return dim; }
    public int getTime() { return time; }
    public Cell getCell(int row, int col) { return cells[row][col]; }
    public abstract Cell makeCell(boolean uniform);

    public Grid() {
        cells = new Cell[dim][dim];
        populate();
    }


    protected void populate() {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {

                cells[row][col]= makeCell(false);
                cells[row][col].col = col;
                cells[row][col].row = row;
            }
        }
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].neighbors =  getNeighbors(cells[row][col], 1);
            }
        }
        changed();
    }

    public void repopulate(boolean randomly) {
        if (randomly) {
            for (int row = 0; row < dim; row++) {
                for (int col = 0; col < dim; col++) {
                    cells[row][col].reset(true); // Reset cell states randomly
                }
            }
        }
        else {
            for (int row = 0; row < dim; row++) {
                for (int col = 0; col < dim; col++) {
                    cells[row][col].reset(false); // Reset cell states to 0 (dead)
                }
            }
        }

        changed();
    }


    public Set<Cell> getNeighbors(Cell asker, int radius) {

        Set<Cell> neighbors = new HashSet<>();
        int row = asker.row;
        int col = asker.col;
        for (int i = row - radius; i <= row + radius; i++) {
            for (int j = col - radius; j <= col + radius; j++) {
                int wrappedRow = (i + dim) % dim;
                int wrappedCol = (j + dim) % dim;
                if (!(i == row && j == col)) {
                    neighbors.add(cells[wrappedRow][wrappedCol]);
                }
            }
        }
        return neighbors;
    }

    public int getStatus() { return 0; }
    public Color getColor() { return Color.GREEN; }


    public void observe() {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].observe();
            }
        }
        notifySubscribers();
    }

    public void interact() {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].interact();
            }
        }
        notifySubscribers();
    }

    public void update() {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].update();

            }
        }
        notifySubscribers();
    }

    public void updateLoop(int cycles) {
        for(int cycle = 0; cycle < cycles; cycle++) {
            observe();
            interact();
            update();
            time++;
            System.out.println("time = " + time);
        }
        changed();
    }
    public void clear(){
        repopulate(false);
        changed();
    }
}

