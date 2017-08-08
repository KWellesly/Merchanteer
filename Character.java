
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Character {

    private String name;
    private String startIsland;
    private double money = 1000.0;
    private ArrayList<String> cargo = new ArrayList<String>();
    private double upgradeCost = 1000.0;

    public Character(String name, String startIsland) {
        this.name = name;
        this.startIsland = startIsland;
        for (int i = 0; i < 5; i++) {
            this.cargo.add(null);
        }

    }

    public int getSpaceLeft() {
        int counter = 0;
        for (String eachItem : cargo) {
            if (eachItem == null) {
                counter++;
            }
        }
        return counter;
    }

    public void upgradeCargo() {
        this.cargo.add(null);
        int cargoSpace = cargo.size();
        double price = (cargoSpace * cargoSpace) * 100;
        setMoney(price);
    }

    public String getName() {
        return this.name;
    }

    public String getStartIsland() {
        return this.startIsland;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartIsland(String startIsland) {
        this.startIsland = startIsland;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double cost) {
        money = money + cost;
    }

    public ArrayList<String> getCargo() {
        return cargo;
    }


    public void addCargo(String cargoItem, int quantity) {
        int counter = 0;
        int cargoSpace = cargo.size();
        for (int i = 0; i < cargoSpace; i++) {
            while (cargo.get(i) == null && quantity > 0) {
                cargo.set(i, cargoItem);
                quantity--;
            }
        }
    }
}