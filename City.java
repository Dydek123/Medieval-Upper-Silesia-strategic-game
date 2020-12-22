import Buildings.*;
import Score.Description;
import Score.Scoreboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class City  implements ActionListener{
    private JFrame jFrame = new JFrame();

    private JPanel cityBuildings = new JPanel();

    private JButton[] buttons = new JButton[25];

    //Update budget every second
    private Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            scoreboard.setBudget(scoreboard.getBudget() + scoreboard.getIncome());
        }
    });

    private Scoreboard scoreboard = new Scoreboard();
    private Description descriptionPanel = new Description();
    private final List<String> currentBuildings = new ArrayList<>(); // list of existing buildings
    private final List<Memento> mementoList = new ArrayList<>(); // List of states
    private final Originator originator = new Originator();
    private int stateIndex = 0; //Initial state
    private int maxStateIndex = 0; //Maximum state

    public void play(){
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1920,1080);
        jFrame.getContentPane().setBackground(new Color(50,50,50));
        jFrame.setLayout(new BorderLayout());
        jFrame.setVisible(true);

        //Score & income panel
        scoreboard.setScorePanel(scoreboard.getBudgetLabel(),JLabel.LEFT,"Pijōndze: " + scoreboard.getBudget());
        scoreboard.setScorePanel(scoreboard.getIncomeLabel(),JLabel.RIGHT,"Przichōd: "+ scoreboard.getIncome());
        scoreboard.createPanel();
        jFrame.add(scoreboard.getPanel(),BorderLayout.NORTH);

        //Space for building buildings
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

        // A panel with the name of the available buildings, their costs and requirements
        descriptionPanel.createPanel();
        jFrame.add(descriptionPanel.getPanel(),BorderLayout.SOUTH);

        // Undo and Redo operations
        jFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiersEx() | KeyEvent.CTRL_DOWN_MASK) == KeyEvent.CTRL_DOWN_MASK)) {
                    if (stateIndex>0){
                        originator.getStateFromMemento(mementoList.get(stateIndex-1));

                        scoreboard.setIncome(scoreboard.getIncome()-originator.getBuilding().getIncome());

                        scoreboard.setBudget(originator.getBudget());

                        originator.getBuildingPlace().setIcon(null);

                        currentBuildings.remove(originator.getBuilding().getType());
                        maxStateIndex = stateIndex;
                        stateIndex -= 1;
                    }
                }
                else if ((e.getKeyCode() == KeyEvent.VK_Y) && ((e.getModifiersEx() | KeyEvent.CTRL_DOWN_MASK) == KeyEvent.CTRL_DOWN_MASK)) {
                    if (stateIndex<=maxStateIndex) {
                        originator.getStateFromMemento(mementoList.get(stateIndex));

                        scoreboard.setIncome(scoreboard.getIncome() + originator.getBuilding().getIncome());

                        scoreboard.setBudget(originator.getBudget()-originator.getBuilding().getCost());

                        originator.getBuildingPlace().setIcon(originator.getBuilding().getIcon());

                        currentBuildings.add(originator.getBuilding().getType());
                        stateIndex += 1;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        for (int i = 0 ; i <25 ; i++){
            if (e.getSource() == buttons[i]){
                if (buttons[i].getText().equals("")){
                    showMenu(buttons[i]);
                }
            }
        }
    }

    public void build(Building building, JButton button){
        if (checkRequirements(building) ) {
            //Save state
            originator.setState(scoreboard.getBudget(), building, button);
            this.addMemento(originator.saveStateToMemento());
            stateIndex++;

            //build
            button.setIcon(building.getIcon());
            scoreboard.setBudget(scoreboard.getBudget() - building.getCost());
            scoreboard.setIncome(scoreboard.getIncome() + building.getIncome());
            currentBuildings.add(building.getSymbol());
        }
        else {
            if (building.getCost() > scoreboard.getBudget())
                JOptionPane.showMessageDialog(jFrame, "Niy posiadŏsz za dość dużo pijyndzy");
            else
                JOptionPane.showMessageDialog(jFrame, "Niy posiadŏsz wymŏganych budōnkōw");
        }
    }

    private boolean checkRequirements(Building building) {
        List<String> requirements = new ArrayList<>(building.getRequirements());
        if (building.getCost() > scoreboard.getBudget())
            return false;
        for (String requirement : requirements){
            if (!currentBuildings.contains(requirement))
                return false;
        }
        return true;
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
            if (!checkRequirements(buildingType[i]) ) {
                jMenuItem.setForeground(Color.RED);
            }
            popup.add(jMenuItem);
        }
        popup.show(button,190,136);
    }

    public void addMemento(Memento state){
        mementoList.add(state);
    }

}
