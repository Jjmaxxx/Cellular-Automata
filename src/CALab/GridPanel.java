package CALab;

import mvc.*;
import javax.swing.*;
import java.awt.*;

public class GridPanel extends AppPanel {

    public GridPanel(AppFactory factory) {
        super(factory);
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        JPanel firstRowPanel = new JPanel();
        firstRowPanel.setLayout(new BoxLayout(firstRowPanel, BoxLayout.X_AXIS));

        JButton run1 = new JButton("Run1");
        run1.addActionListener(this);
        firstRowPanel.add(run1);

        firstRowPanel.add(Box.createHorizontalStrut(100));

        JButton run50 = new JButton("Run50");
        run50.addActionListener(this);
        firstRowPanel.add(run50);

        JPanel secondRowPanel = new JPanel();
        secondRowPanel.setLayout(new BoxLayout(secondRowPanel, BoxLayout.X_AXIS));

        JButton populateButton = new JButton("Populate");
        populateButton.addActionListener(this);
        secondRowPanel.add(populateButton);

        secondRowPanel.add(Box.createHorizontalStrut(100));

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        secondRowPanel.add(clearButton);

        controlPanel.add(firstRowPanel);
        controlPanel.add(Box.createVerticalStrut(100));
        controlPanel.add(secondRowPanel);

    }
}