package CALab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mvc.*;


public class CellView extends JButton implements ActionListener, Subscriber {
    private Cell myCell;

    public CellView(Cell c) {
        myCell = c;
        if (c != null) { c.subscribe(this); }
        this.addActionListener(this);
        update();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        myCell.nextState();
        update();

    }

    public void setCell(Cell c) {
        myCell.unsubscribe(this);
        myCell = c;
        if (c != null) {
            c.subscribe(this);
        }
    }


    @Override
    //String msg, Object oldState, Object newState
    public void update() {
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black)); // needed?
        setText("" + myCell.getStatus());
    }

}