package Buildings;

import javax.swing.*;

public class WoodcuttersHut extends Building{
    public WoodcuttersHut() {
        this.cost = 1500;
        this.income = 300;
        this.type = "Chata Drwala";
        this.symbol =  "CD";
        this.icon = new ImageIcon(System.getProperty("user.dir") + "/src/buildingIcons/WoodcuttersHut.png");
    }
}
