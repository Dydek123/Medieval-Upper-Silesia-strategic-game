package Buildings;

import javax.swing.*;
import java.io.File;

public class GoldMine extends Building{
    public GoldMine() {
        this.cost = 5000;
        this.income = 1000;
        this.type = "Gold Mine";
        this.symbol =  "GM";
        this.requirements.add(new Quarry().getSymbol());
        this.requirements.add(new WoodcuttersHut().getSymbol());
        this.requirements.add(new Sawmill().getSymbol());
        this.icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "buildingIcons" + File.separator + "GoldMine.png");
    }
}
