import Buildings.Building;

import javax.swing.*;

public class Originator {
    private double budget;
    private Building building;
    private JButton buildingPlace;

    public void setState(double budget, Building building, JButton button){
        this.budget = budget;
        this.building = building;
        this.buildingPlace = button;
    }

    public double getBudget() {
        return budget;
    }

    public Building getBuilding() {
        return building;
    }

    public JButton getBuildingPlace() {
        return buildingPlace;
    }

    public Memento saveStateToMemento(){
        return new Memento(this.budget, this.building, this.buildingPlace);
    }

    public void getStateFromMemento(Memento memento){
        budget = memento.getBudget();
        building = memento.getBuilding();
        buildingPlace = memento.getBuildingPlace();
    }

    public void print(){
        System.out.println(budget + " " + building.getType() + " " + buildingPlace);
    }
}
