package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() { return dim; }
    public int getTime() { return time; }
    public Cell getCell(int row, int col) { return cells[row][col]; }
    public abstract Cell makeCell(boolean uniform);


    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }
    public Grid() {this(20); }

    protected void populate() {
        // 1. use makeCell to fill in cells
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {

                cells[row][col]= makeCell(false);
                cells[row][col].col = col;
                cells[row][col].row = row;
            }
        }
        // 2. use getNeighbors to set the neighbors field of each cell
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].neighbors =  getNeighbors(cells[row][col], 1);
            }
        }
    }

    // called when Populate button is clicked
    public void repopulate(boolean randomly) {
        if (randomly) {
            // randomly set the status of each cell
            for (int row = 0; row < dim; row++) {
                for (int col = 0; col < dim; col++) {
                    cells[row][col].reset(true); // Reset cell states randomly
                }
            }
        }
        else {
            // set the status of each cell to 0 (dead)
            for (int row = 0; row < dim; row++) {
                for (int col = 0; col < dim; col++) {
                    cells[row][col].reset(false); // Reset cell states to 0 (dead)
                }
            }
        }
        // Notify subscribers about the changes
        notifySubscribers();
    }


    public Set<Cell> getNeighbors(Cell asker, int radius) {
        /*
        return the set of all cells that can be reached from the asker in radius steps.
        If radius = 1 this is just the 8 cells touching the asker.
        Tricky part: cells in row/col 0 or dim - 1.
        The asker is not a neighbor of itself.
        */

        Set<Cell> neighbors = new HashSet<>();
        int row = asker.row;
        int col = asker.col;
        int minRow = Math.max(0, row - radius); // Handle edge cases
        int maxRow = Math.min(dim - 1, row + radius);
        int minCol = Math.max(0, col - radius);
        int maxCol = Math.min(dim - 1, col + radius);

        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                if (i != row || j != col) { // Exclude asker as a neighbour
                    neighbors.add(cells[i][j]);
                }
            }
        }
        return neighbors;
    }

    // overide these
    public int getStatus() { return 0; }
    public Color getColor() { return Color.GREEN; }

    // cell phases:

    public void observe() {
        // call each cell's observe method and notify subscribers
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].observe();
            }
        }
        notifySubscribers();
    }

    public void interact() {
        // ???
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].interact();
            }
        }
        notifySubscribers();
    }

    public void update() {
        // ???
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].update();

            }
        }
        notifySubscribers();
    }

    public void updateLoop(int cycles) {
        observe();
        for(int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
    }
    public void clear(){
        // ? maybe
        repopulate(false);
    }
}

class MakeGrid extends Grid{
    public MakeGrid(){
        super();
    }
    @Override
    public Cell makeCell(boolean uniform) {
        return new MakeCell(uniform);
    }
}