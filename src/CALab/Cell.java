package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

abstract public class Cell extends Publisher implements Serializable {

    protected int row = 0, col = 0;
    protected Set<Cell> neighbors = new HashSet<Cell>();
    protected Grid myGrid = null;
    protected Cell partner = null;
    protected int ambience = 0;
    protected int status = 0;

    public Cell(boolean uniform) {
        if(uniform){
            status=1;
        }else{
            status =0;
        }
    }


    // choose a random neighbor as a partner
    public void choosePartner() {
        //neighbors = myGrid.getNeighbors(this,1);
        if (partner == null && neighbors != null) {
            Cell[] arr = new Cell[neighbors.size()];
            arr= neighbors.toArray(arr);
            int len = arr.length;
            Random generator = new Random();
            int randomIndex =  generator.nextInt(len);
            int elements = 0;
            while(arr[randomIndex].partner != null && elements < len){
                elements+=1;
                randomIndex+=1;
                if(randomIndex>= len){
                    randomIndex=0;
                }
            }
            if(arr[randomIndex].partner == null){
                partner = arr[randomIndex];
                arr[randomIndex].partner = this;
            }
			/*
			Set partner to null
			Convert neighbors set to a local array
			Starting at a random position in the array search for a neighbor without a partner
			Make the first such neighbor (if any) the partner and set its partner field to this
			*/
        }

    }

    public void unpartner() {
        if (partner != null) {
            if (partner.partner != null) {
                partner.partner = null;
            }
            partner = null;
        }
    }

    // observer neighbors' states
    public abstract void observe();
    // interact with a random neighbor
    public abstract void interact();
    // update my state
    public abstract void update();
    // set status to status + 1 mod whatever
    public abstract void nextState();
    // set status to a random or initial value
    public abstract void reset(boolean randomly);

    public abstract Color getColor();
    //get status should num of alive neighbors
    public abstract int getStatus();

}
class MakeCell extends Cell{

    public MakeCell(boolean uniform){
        super(uniform);
    }
    @Override
    public void observe() {
//        System.out.println("i am at row:" + row + " col: " + col);
//        for (Cell item : neighbors) {
//            System.out.println(" row: " + item.row + "col: " +item.col);
//        }
//        System.out.println("___________________");
        Cell[] arr = new Cell[neighbors.size()];
        arr= neighbors.toArray(arr);
        int aliveNeighbors = 0;
        for (Cell cell : arr) {
            if (cell.status == 1) {
                aliveNeighbors += 1;
            }
        }

        ambience = aliveNeighbors;
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
