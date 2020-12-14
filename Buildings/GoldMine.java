package Buildings;

public class GoldMine extends Building{
    public GoldMine() {
        this.cost = 5000;
        this.income = 1000;
        this.type = "Kopalnia Złota";
        this.symbol =  "KZ";
        this.requirements.add("KAM");
        this.requirements.add("TAR");
        this.requirements.add("CD");
    }
}
