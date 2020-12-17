import Buildings.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class City  implements ActionListener{
    JFrame jFrame = new JFrame();

    JPanel scorePanel = new JPanel();
    JPanel cityBuildings = new JPanel();
    JPanel description = new JPanel();

    JLabel budgetLabel = new JLabel();
    JLabel incomeLabel = new JLabel();

    JButton[] buttons = new JButton[25];

    JPopupMenu popupMenu = new JPopupMenu("Wybierz budynek");
    JMenuItem[] buildingsMenu = new JMenuItem[5];

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            budget += income;
            budgetLabel.setText("Kwota: " + budget);
        }
    });

    private double budget = 2000; //Initial budget
    private double income = 0; // Initial income per second
    private List<String> currentBuildings = new ArrayList<>();

    City(){
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1920,1080);
        jFrame.getContentPane().setBackground(new Color(50,50,50));
        jFrame.setLayout(new BorderLayout());
        jFrame.setVisible(true);

        setScorePanel(budgetLabel,JLabel.LEFT,"Kwota: " + budget);
        setScorePanel(incomeLabel,JLabel.RIGHT,"Przychód: "+income);

        scorePanel.setLayout(new GridLayout(1,2));
        scorePanel.setBounds(0,0,1920,100);

        scorePanel.add(budgetLabel);
        scorePanel.add(incomeLabel);
        jFrame.add(scorePanel,BorderLayout.NORTH);

        cityBuildings .setLayout(new GridLayout(5,5));
        cityBuildings.setBounds(0,100,1920,680);
        cityBuildings.setBackground(new Color(150,150,150));
        for (int i = 0 ; i < 25 ; i++){
            buttons[i] = new JButton();
            cityBuildings.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        jFrame.add(cityBuildings);
        description.setLayout(new GridLayout(6,4));
        description.setBounds(0,0,1920,300);
        setDescriptionPanel();
        jFrame.add(description,BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO
        timer.start();
        for (int i = 0 ; i <25 ; i++){
            if (e.getSource() == buttons[i]){
                if (buttons[i].getText()==""){
                    buttons[i].setForeground(new Color(255,0,0));
//                    buttons[i].setText("X");
//                    budget -= 500;
//                    budgetLabel.setText("Kwota: " + budget);
//                    popup.show(buttons[i],190,136 );
                    showMenu(buttons[i]);
                }
            }
        }
    }

    public void build(Building building, JButton button){
        //TODO
        if (building.getCost() < budget) {
//            button.setText(building.getSymbol());
            button.setIcon(building.getIcon());
            budget -= building.getCost();
            income += building.getIncome();
            budgetLabel.setText("Kwota: " + budget);
            incomeLabel.setText("Przychód: " + income);
        }
    }

    public void showMenu(JButton button){
        final JPopupMenu popup = new JPopupMenu();
        Building[] buildingType = {new Quarry(), new WoodcuttersHut(), new Sawmill(), new GoldMine(), new Mint()};

        for (int i = 0 ; i < 5 ; i++) {
            int finalI = i;
            JMenuItem jMenuItem = new JMenuItem(new AbstractAction(buildingType[finalI].getType() + " " +buildingType[finalI].getCost()) {
                public void actionPerformed(ActionEvent e) {
                    build(buildingType[finalI], button);
                }
            });
            if (buildingType[i].getCost() > budget) {
                jMenuItem.setForeground(Color.RED);
            }
            popup.add(jMenuItem);
        }
        popup.show(button,190,136);
    }

    private void setScorePanel(JLabel label, int direction, String text){
        label.setBackground(new Color(25,25,25));
        label.setForeground(new Color(25,255,0));
        label.setFont(new Font("Ink Free", Font.BOLD, 75));
        label.setHorizontalAlignment(direction);
        label.setText(text);
        label.setOpaque(true);
    }
    private void setDescriptionPanel(){
        int textType;

        List<String> desciptionList = new ArrayList<>(4);
        desciptionList.add("");
        desciptionList.add("Cena");
        desciptionList.add("Przychód");
        desciptionList.add("Wymagania");

        Building building = new Quarry();
        for (int i = 0 ; i < 24 ; i++){
            JLabel label = new JLabel();
            label.setBackground(new Color(25,25,25));
            label.setForeground(new Color(255,255,255));
            label.setFont(new Font("Ink Free", Font.PLAIN, 30));
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


            description.add(label);
        }
    }
}
