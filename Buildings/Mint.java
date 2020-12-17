package Buildings;

import javax.swing.*;

public class Mint extends Building{
    public Mint(){
        this.cost = 10000;
        this.income = 3000;
        this.type = "Mennica";
        this.symbol =  "MNN";
        this.requirements.add("KAM");
        this.requirements.add("TAR");
        this.requirements.add("CD");
        this.requirements.add("KZ");
        this.icon = new ImageIcon(System.getProperty("user.dir") + "/src/buildingIcons/Mint.png");
    }
}
