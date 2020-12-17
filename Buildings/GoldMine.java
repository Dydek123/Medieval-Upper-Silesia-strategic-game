package Buildings;

import javax.swing.*;

public class GoldMine extends Building{
    public GoldMine() {
        this.cost = 5000;
        this.income = 1000;
        this.type = "Gruba złotŏ";
        this.symbol =  "GZ";
        this.requirements.add(new Quarry().getSymbol());
        this.requirements.add(new WoodcuttersHut().getSymbol());
        this.requirements.add(new Sawmill().getSymbol());
        this.icon = new ImageIcon(System.getProperty("user.dir") + "/src/buildingIcons/GoldMine.png");
    }
}
