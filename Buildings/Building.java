package Buildings;

import java.util.ArrayList;
import java.util.List;

public abstract class Building {
    protected Integer cost;
    protected String type;
    protected String symbol; //TODO Change to icon
    protected Integer income;
    protected List<String> requirements = new ArrayList<>();

    public Integer getCost() {
        return cost;
    }
    public String getType() {
        return type;
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
