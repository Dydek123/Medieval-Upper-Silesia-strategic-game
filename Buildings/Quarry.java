package Buildings;

import javax.swing.*;

public class Quarry extends Building{
    public Quarry() {
        this.cost = 500;
        this.income = 200;
        this.type = "Gruba kamynia";
        this.symbol =  "GK";
        this.icon = new ImageIcon(System.getProperty("user.dir") + "/src/buildingIcons/quarry.png");
    }
}
