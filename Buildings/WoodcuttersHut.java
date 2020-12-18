package Buildings;

import javax.swing.*;
import java.io.File;

public class WoodcuttersHut extends Building{
    public WoodcuttersHut() {
        this.cost = 1500;
        this.income = 300;
        this.type = "Chałpa siōngŏrza";
        this.symbol =  "CS";
        this.icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "buildingIcons" + File.separator + "WoodcuttersHut.png");
    }
}
