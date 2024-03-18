package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;

public class GridView  extends View {

    private CellView cellViews[][];

    public GridView(Model model) {
        super(model);
        /*
        Cell cell = new CellView(((Grid)model).getCell(row, col)
                cellViews[row][col] = cell
                set cell.row and cell.col here
        */
        int dim = ((Grid) model).getDim();
        cellViews = new CellView[dim][dim];
        setLayout(new GridLayout(dim, dim));

        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                Cell cell = ((Grid) model).getCell(row, col);
                CellView cellView = new CellView(cell);
                cellViews[row][col] = cellView;
                add(cellView);
            }
        }
    }

    public void update() {
        // call update method of each CellView
        for (int row = 0; row < cellViews.length; row++) {
            for (int col = 0; col < cellViews[row].length; col++) {
                cellViews[row][col].update();
            }
        }
    }

}