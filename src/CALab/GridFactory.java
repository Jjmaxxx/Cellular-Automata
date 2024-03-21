package CALab;

import mvc.*;

public class GridFactory implements AppFactory {
    public Model makeModel(){
        return null;
    }

    public View makeView(Model m) {
        return new GridView(m);
    }

    public String[] getEditCommands() { return new String[] {"Populate","Clear","Run1","Run50"}; }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type.equals("Run1")){
            return new RunCommand(model,1);
        }
        if(type.equals("Run50")){
            return new RunCommand(model,50);
        }
        if(type.equals("Clear")){
            return new ClearCommand(model);
        }
        if(type.equals("Populate")){
            return new PopulateCommand(model,true);
        }
        return null;
    }


    public String getTitle() {
        return "Cellular Automata Simulator";     }

    public String[] getHelp() {
        return new String[]{"Help"};
    }

    public String about() {
        return "Cellular Automata Simulator";
    }

}