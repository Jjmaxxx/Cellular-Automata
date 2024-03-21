package CALab;

import mvc.*;
import javax.swing.*;

public class GridPanel extends AppPanel {

    public GridPanel(AppFactory factory) {
        super(factory);
        JButton populateButton = new JButton("Populate");
        populateButton.addActionListener(this);
        controlPanel.add(populateButton);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        controlPanel.add(clearButton);

        JButton run1 = new JButton("Run1");
        run1.addActionListener(this);
        controlPanel.add(run1);

        JButton run50 = new JButton("Run50");
        run50.addActionListener(this);
        controlPanel.add(run50);
    }

}
