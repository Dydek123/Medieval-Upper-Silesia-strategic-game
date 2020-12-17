package Buildings;

import javax.swing.*;

public class Quarry extends Building{
    public Quarry() {
        this.cost = 500;
        this.income = 200;
        this.type = "Kamieniołom";
        this.symbol =  "KAM";
        this.icon = new ImageIcon(System.getProperty("user.dir") + "/src/buildingIcons/quarry.png");
    }
}
