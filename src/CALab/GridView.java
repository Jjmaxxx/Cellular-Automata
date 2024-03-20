package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;

public class GridView extends View {

    private CellView cellViews[][];

    public GridView(Model model) {

        super(model);

        /*
        Cell cell = new CellView(((Grid)model).getCell(row, col)
                cellViews[row][col] = cell
                set cell.row and cell.col here
        */
        createCells();
    }

    public void update() {
//        System.out.println("updating view");
        // call update method of each CellView
        for (int row = 0; row < cellViews.length; row++) {
            for (int col = 0; col < cellViews[row].length; col++) {
                cellViews[row][col].update();
            }
        }
        updateUI();
    }
    public void setModel(Model newModel){

        model.unsubscribe(this); //me
        model=newModel;
        model.subscribe(this);//me
        removeAll();
        createCells();
    }
    public void createCells(){
        int dim = ((Grid) model).getDim();
        cellViews = new CellView[dim][dim];
        setLayout(new GridLayout(dim, dim));

        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                Cell cell = ((Grid) model).getCell(row, col);
                CellView cellView = new CellView(cell);
                cellView.update();
                cellViews[row][col] = cellView;
                add(cellView);
            }
        }
    }
}