package Buildings;

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
    }
}
