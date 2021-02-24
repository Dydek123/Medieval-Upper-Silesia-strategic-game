package Buildings;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Building {
    protected Integer cost;
    protected String type;
    protected String symbol;
    protected Integer income;
    protected List<String> requirements = new ArrayList<>();
    protected Icon icon;


    public Icon getIcon() {
        return icon;
    }
    public Integer getCost() {
        return cost;
    }
    public String getType() {
        return type+" [" + symbol + "]" ;
    }
    public Integer getIncome() {
        return income;
    }
    public List<String> getRequirements() {
        return requirements;
    }

    public String getSymbol() {
        return symbol;
    }
}
