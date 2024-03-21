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
    public int status = 0;

    public Cell(boolean uniform) {
        if(uniform){
            status=1;
        }else{
            status =0;
        }
    }
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
