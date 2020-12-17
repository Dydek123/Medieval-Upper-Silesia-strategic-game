package Buildings;

import javax.swing.*;

public class GoldMine extends Building{
    public GoldMine() {
        this.cost = 5000;
        this.income = 1000;
        this.type = "Kopalnia Złota";
        this.symbol =  "KZ";
        this.requirements.add("KAM");
        this.requirements.add("TAR");
        this.requirements.add("CD");
        this.icon = new ImageIcon(System.getProperty("user.dir") + "/src/buildingIcons/GoldMine.png");
    }
}
