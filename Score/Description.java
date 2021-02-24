package Score;

import Buildings.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Description extends Panels{
    @Override
    protected void addLabels() {
        int textType;

        List<String> desciptionList = new ArrayList<>(4);
        desciptionList.add("");
        desciptionList.add("Prize");
        desciptionList.add("Income");
        desciptionList.add("Requirements");

        Building building = new Quarry();
        for (int i = 0 ; i < 24 ; i++){
            JLabel label = new JLabel();
            label.setBackground(new Color(25,25,25));
            label.setForeground(new Color(255,255,255));
            label.setFont(new Font("Arial", Font.PLAIN, 30));
            label.setHorizontalAlignment(JLabel.LEFT);
            label.setOpaque(true);
            if (i<4) {
                label.setText(desciptionList.get(i));
            }
            else{
                if (i==8)
                    building = new WoodcuttersHut();
                if (i==12)
                    building = new Sawmill();
                if (i==16)
                    building = new GoldMine();
                if (i==20)
                    building = new Mint();

                textType = i%4;
                switch (textType){
                    case 0:
                        label.setText(building.getType());
                        break;
                    case 1:
                        label.setText(String.valueOf(building.getCost()));
                        break;
                    case 2:
                        label.setText(String.valueOf(building.getIncome()));
                        break;
                    case 3:
                        label.setText(String.valueOf(building.getRequirements()));
                        break;
                }
            }
            getPanel().add(label);
        }
    }

    @Override
    protected void setSize() {
        Panel.setLayout(new GridLayout(6,4));
        Panel.setBounds(0,0,1920,300);
    }
}
