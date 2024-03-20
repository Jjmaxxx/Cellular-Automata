package conway;

import CALab.GridFactory;
import CALab.GridPanel;
import mvc.AppFactory;

public class MyGridPanel extends GridPanel{
    public MyGridPanel(AppFactory factory) {
        super(factory);
    }

    public static void main(String[] args){
        GridFactory f = new MyGridFactory();
        GridPanel p = new GridPanel(f);
        p.display();
    }
//    public static void main(String[] args) {
//        AppFactory factory = new GridFactory();
//        AppPanel panel = new GridPanel(factory);
//        panel.display();
//    }
}
