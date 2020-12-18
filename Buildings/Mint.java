package Buildings;

import javax.swing.*;
import java.io.File;

public class Mint extends Building{
    public Mint(){
        this.cost = 10000;
        this.income = 3000;
        this.type = "Wytwōrnia mōnet";
        this.symbol =  "WM";
        this.requirements.add(new Quarry().getSymbol());
        this.requirements.add(new WoodcuttersHut().getSymbol());
        this.requirements.add(new Sawmill().getSymbol());
        this.requirements.add(new GoldMine().getSymbol());
        this.icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "buildingIcons" + File.separator + "Mint.png");
    }
}
