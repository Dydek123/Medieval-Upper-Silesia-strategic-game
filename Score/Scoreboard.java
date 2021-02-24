package Score;

import javax.swing.*;
import java.awt.*;

public class Scoreboard extends Panels{
    protected double budget;
    protected double income;

    public JLabel getBudgetLabel() {
        return budgetLabel;
    }

    public JLabel getIncomeLabel() {
        return incomeLabel;
    }

    private JLabel budgetLabel = new JLabel();
    private JLabel incomeLabel = new JLabel();

    public Scoreboard(){
        this.budget = 2000;
        this.income = 0;
    }

    public double getBudget() {
        return budget;
    }
    public double getIncome() {
        return income;
    }

    public void setBudget(double budget) {
        this.budget = budget;
        budgetLabel.setText("Budget: " + budget);
    }

    public void setIncome(double income) {
        this.income = income;
        incomeLabel.setText("Income: " + income);
    }

    @Override
    protected void addLabels() {
        Panel.add(budgetLabel);
        Panel.add(incomeLabel);
    }

    @Override
    protected void setSize() {
        Panel.setLayout(new GridLayout(1,2));
        Panel.setBounds(0,0,1920,100);
    }

    public void setScorePanel(JLabel label, int direction, String text){
        label.setBackground(new Color(25,25,25));
        label.setForeground(new Color(25,255,0));
        label.setFont(new Font("Arial", Font.BOLD, 75));
        label.setHorizontalAlignment(direction);
        label.setText(text);
        label.setOpaque(true);
    }
}
