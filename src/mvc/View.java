package mvc;

import javax.swing.*;

public class View extends JPanel implements Subscriber {

    public Model model;
    public View(Model newModel){
        model = newModel;
    }
    @Override
    public void update() {
//        repaint();
    }
    public void setModel(Model newModel){
        model.unsubscribe(this); //me
        model=newModel;
        model.subscribe(this);//me
    }
}
