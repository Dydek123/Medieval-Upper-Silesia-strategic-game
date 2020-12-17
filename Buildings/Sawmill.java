package Buildings;

import javax.swing.*;

public class Sawmill extends Building{
    public Sawmill() {
        this.cost = 3000;
        this.income = 500;
        this.type = "Zegewerk";
        this.symbol =  "ZGW";
        this.icon = new ImageIcon(System.getProperty("user.dir") + "/src/buildingIcons/Sawmill.png");
    }
}
