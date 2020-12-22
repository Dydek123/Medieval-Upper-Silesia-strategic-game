import Buildings.Building;

import javax.swing.*;

public class Memento {
    private double budget;
    private Building building;
    private JButton buildingPlace;

    public Memento(double budget, Building building, JButton buildingPlace) {
        this.budget = budget;
        this.building = building;
        this.buildingPlace = buildingPlace;
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
}
