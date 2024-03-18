package LifeLab;

import CALab.*;
import mvc.AppFactory;

public class LifePanel extends GridPanel{
    public LifePanel(AppFactory factory) {
        super(factory);
    }

    public static void main(String[] args){
        GridFactory f = new LifeFactory();
        GridPanel p = new GridPanel(f);
        p.display();
    }
//    public static void main(String[] args) {
//        AppFactory factory = new GridFactory();
//        AppPanel panel = new GridPanel(factory);
//        panel.display();
//    }
}
