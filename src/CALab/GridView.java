package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;

public class GridView extends View {

    private CellView cellViews[][];

    public GridView(Model model) {
        super(model);
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
    public void setModel(Model newModel) {
        super.setModel(newModel);
        Grid grid = (Grid) model;
        for (int row = 0; row < grid.getDim(); row++) {
            for (int col = 0; col < grid.getDim(); col++) {
                cellViews[row][col].setCell(grid.getCell(row, col));
            }
        }
        update();
    }

    public void update() {
        for (int row = 0; row < cellViews.length; row++) {
            for (int col = 0; col < cellViews[row].length; col++) {
                cellViews[row][col].update();
            }
        }
    }
}