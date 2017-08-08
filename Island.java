import java.util.Random;

public class Island {


    private int woodCount = 0;
    private int foodCount = 0;
    private int sugarCount = 0;
    private int jewelCount = 0;
    private double woodCost = 0.0;
    private double foodCost = 0.0;
    private double sugarCost = 0.0;
    private double jewelCost = 0.0;
    private String islandName = "";
    private int woodPriceFac = 250;
    private int foodPriceFac = 350;
    private int sugarPriceFac = 500;
    private int jewelPriceFac = 1000;

    public Island(String islandName, int woodBoost, int foodBoost, int sugarBoost, int jewelBoost) {
        this.islandName = islandName;
        Random rand = new Random();
        woodCount = rand.nextInt(50) + woodBoost;
        foodCount = rand.nextInt(50) + foodBoost;
        sugarCount = rand.nextInt(50) + sugarBoost;
        jewelCount = rand.nextInt(50) + jewelBoost;

        woodCost = ((100 / woodCount) + 1) * woodPriceFac;
        foodCost = ((100 / foodCount) + 1) * foodPriceFac;
        sugarCost = ((100 / sugarCount) + 1) * sugarPriceFac;
        jewelCost = ((100 / jewelCount) + 1) * jewelPriceFac;
    }

    public void updatePrices() {
        woodCost = ((100 / woodCount) + 1) * woodPriceFac;
        foodCost = ((100 / foodCount) + 1) * foodPriceFac;
        sugarCost = ((100 / sugarCount) + 1) * sugarPriceFac;
        jewelCost = ((100 / jewelCount) + 1) * jewelPriceFac;
    }

    public double getWoodCost() {
        return woodCost;
    }

    public double getFoodCost() {
        return foodCost;
    }

    public double getSugarCost() {
        return sugarCost;
    }

    public double getJewelCost() {
        return jewelCost;
    }

    public String getName() {
        return this.islandName;
    }

    public int getWoodCount() {
        return woodCount;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public int getSugarCount() {
        return sugarCount;
    }

    public int getJewelCount() {
        return jewelCount;
    }

    public void setWoodCount(int increment) {
        woodCount = woodCount + increment;
    }

    public void setFoodCount(int increment) {
        foodCount = foodCount + increment;
    }

    public void setSugarCount(int increment) {
        sugarCount = sugarCount + increment;
    }

    public void setJewelCount(int increment) {
        jewelCount = jewelCount + increment;
    }
}