package mvc;

import javax.swing.*;

public class View extends JPanel implements Subscriber {

    public Model model;

    @Override
    public void update() {

    }
    public void setModel(Model newModel){
        model=newModel;
    }
}
