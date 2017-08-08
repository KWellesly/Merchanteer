import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class Startgame {

    static String name = "";
    static String startIsland = "";
    static boolean fakeIsland = false;
    static boolean fakeAction = false;
    static String action = "";
    static int quantity = 0;
    static String purchaseItem = "";
    static String[] islands = {"Balanchay", "Matiki", "Calay", "Paradine"};
    static String[] actions = {"Buy", "Sell", "Listen for rumors", "Upgrade your ship", "Cast off!"};
    static Island calay;
    static Island balanchay;
    static Island matiki;
    static Island paradine;
    static Character player;
    static ArrayList<Island> islandNames = new ArrayList<Island>();


    public static void main(String[] args) {
        read_Intro_Text();
        while (action.equals("")) {
            newTurn();
            if (action.equals("1")) {
                buy();
                action = "";
            } else if (action.equals("2")) {
                sell();
                action = "";
            } else if (action.equals("3")) {
                rumors();
                action = "";
            } else if (action.equals("4")) {
                upgradeShip();
                action = "";
            } else if (action.equals("5")) {
                castOff();
            }
        }

    }

    public static void read_Intro_Text() {
        Scanner sc = new Scanner(System.in);
        String introText1 = "Welcome to the world of Neville. Before your adventure beings as a trader, let's learn a little bit about yourself! What will you be called by in the world of Neville?";
        System.out.println(introText1);
        name = sc.nextLine();

        while (!(startIsland.equals("Balanchay")) && !(startIsland.equals("Calay")) && !(startIsland.equals("Paradine")) && !(startIsland.equals("Matiki"))) {
            if (fakeIsland) {
                System.out.println("\nCaptain, you must start on one of the starter islands!");
            }
            String introText2 = "\nGreetings, Captain " + name + "! To which island would you like to start your adventure off on? ";
            System.out.println(introText2);
            for (String eachIsland : islands) {
                System.out.println(eachIsland);
            }
            startIsland = sc.nextLine();
            System.out.println("\n" + startIsland);
            fakeIsland = true;
        }

        calay = new Island("Calay", 100, 25, 25, 25);
        balanchay = new Island("Balanchay", 25, 100, 25, 25);
        matiki = new Island("Matiki", 25, 25, 100, 25);
        paradine = new Island("Paradine", 25, 25, 25, 100);
        player = new Character(name, startIsland);
        islandNames.add(calay);
        islandNames.add(balanchay);
        islandNames.add(matiki);
        islandNames.add(paradine);

        System.out.println("Confirm changes (Y/N) \nName=" + player.getName() + "\nStarting in: " + player.getStartIsland());


        System.out.println("Calay: " + "\nWood: " + calay.getWoodCount() + "\nFood: " + calay.getFoodCount() + "\nSugar: " + calay.getSugarCount() + "\nJewels: " + calay.getJewelCount() + "\n");
        System.out.println("Balanchay: " + "\nWood: " + balanchay.getWoodCount() + "\nFood: " + balanchay.getFoodCount() + "\nSugar: " + balanchay.getSugarCount() + "\nJewels: " + balanchay.getJewelCount() + "\n");
        System.out.println("Matiki: " + "\nWood: " + matiki.getWoodCount() + "\nFood: " + matiki.getFoodCount() + "\nSugar: " + matiki.getSugarCount() + "\nJewels: " + matiki.getJewelCount() + "\n");
        System.out.println("Paradine: " + "\nWood: " + paradine.getWoodCount() + "\nFood: " + paradine.getFoodCount() + "\nSugar: " + paradine.getSugarCount() + "\nJewels: " + paradine.getJewelCount() + "\n");
    }

    public static void newTurn() {
        fakeAction = false;
        Scanner actionScanner = new Scanner(System.in);
        while (!(action.equals("1")) && !(action.equals("2")) && !(action.equals("3")) && !(action.equals("4")) && !(action.equals("5"))) {
            if (fakeAction) {
                System.out.println("You cannot do that, Captain!");
            }

            System.out.println("\nWhat would you like to do in " + player.getStartIsland() + ", Captain " + player.getName() + "?");
            int counter = 1;
            for (String eachAction : actions) {
                System.out.println("Press " + counter + " to: "+ eachAction);
                counter++;
            }
            action = actionScanner.nextLine();
            fakeAction = true;
        }
    }

    public static void upgradeShip() {
        double price = (player.getCargo().size() * player.getCargo().size()) * 1000;
        String answer;
        Scanner answerScanner = new Scanner(System.in);
        System.out.println("The master shipwright explains to you that you current ship can hold " + player.getCargo().size() + " cargo. Upgrading your ship will cost you " + price + " coins and give you 1 extra cargo slot."
            + " Do you still want to upgrade? \nY/N");
        answer = answerScanner.nextLine();
        if (answer.equals("Y")) {
            player.upgradeCargo();
            System.out.println("Upgrade was a success! Congratulations, Captain " + player.getName() + ".");
        } else if (answer.equals("N")) {
            System.out.println("Come back again next time when you decide you want an upgrade!");
        } else {

        }

    }

    public static void buy() {
        Scanner buyItem = new Scanner(System.in);
        System.out.println("\nCurrent stock of items available in " + player.getStartIsland());
        for (Island eachIsland : islandNames) {
            if (eachIsland.getName().equals(player.getStartIsland())) {
                System.out.println("(Press 1 to buy) Stock of wood: " + eachIsland.getWoodCount() + " at " + eachIsland.getWoodCost() + " coins each");
                System.out.println("(Press 2 to buy) Stock of food: " + eachIsland.getFoodCount() + " at " + eachIsland.getFoodCost() + " coins each");
                System.out.println("(Press 3 to buy) Stock of sugar: " + eachIsland.getSugarCount() + " at " + eachIsland.getSugarCost() + " coins each");
                System.out.println("(Press 4 to buy) Stock of jewlery: " + eachIsland.getJewelCount() + " at " + eachIsland.getJewelCost() + " coins each");
                System.out.println("(Press 5 to return)");
                System.out.println("\nYour money: " + player.getMoney());

                int itemCode = buyItem.nextInt();
                if (itemCode == 1) {
                    purchaseItem = "Wood";
                    System.out.println("How much wood would you like to purchase? You currently have " + player.getSpaceLeft() + " cargo space left.");
                    quantity = buyItem.nextInt();
                    if (quantity > player.getCargo().size() || (quantity * eachIsland.getWoodCost()) > player.getMoney()) {
                        System.out.println("Captain, you cannot make this purchase! We need a bigger ship or more money!");
                    } else {
                        player.addCargo(purchaseItem, quantity);
                        player.setMoney(-1 * (quantity * eachIsland.getWoodCost()));
                        eachIsland.setWoodCount(quantity);
                        eachIsland.updatePrices();
                        System.out.println("Purchase successful!");
                        System.out.println("\nYour current cargo: " + player.getCargo());
                        System.out.println("Your money: " + player.getMoney());
                    }
                } else if (itemCode == 2) {
                    purchaseItem = "Food";
                    System.out.println("How much food would you like to purchase? You currently have " + player.getSpaceLeft() + " cargo space left.");
                    quantity = buyItem.nextInt();
                    if (quantity > player.getCargo().size() || (quantity * eachIsland.getFoodCost()) > player.getMoney()) {
                        System.out.println("Captain, you cannot make this purchase! We need a bigger ship or more money!");
                    } else {
                        player.addCargo(purchaseItem, quantity);
                        player.setMoney(-1 * (quantity * eachIsland.getFoodCost()));
                        eachIsland.setFoodCount(quantity);
                        eachIsland.updatePrices();
                        System.out.println("Purchase successful!");
                        System.out.println("\nYour current cargo: " + player.getCargo());
                        System.out.println("Your money: " + player.getMoney());
                    }
                } else if (itemCode == 3) {
                    purchaseItem = "Sugar";
                    System.out.println("How much sugar would you like to purchase? You currently have " + player.getSpaceLeft() + " cargo space left.");
                    quantity = buyItem.nextInt();
                    if (quantity > player.getCargo().size() || (quantity * eachIsland.getSugarCost()) > player.getMoney()) {
                        System.out.println("Captain, you cannot make this purchase! We need a bigger ship or more money!");
                    } else {
                        player.addCargo(purchaseItem, quantity);
                        player.setMoney(-1 * (quantity * eachIsland.getSugarCost()));
                        eachIsland.setSugarCount(quantity);
                        eachIsland.updatePrices();
                        System.out.println("Purchase successful!");
                        System.out.println("\nYour current cargo: " + player.getCargo());
                        System.out.println("Your money: " + player.getMoney());
                    }
                } else if (itemCode == 4) {
                    purchaseItem = "Jewlery";
                    System.out.println("How much jewlery would you like to purchase? You currently have " + player.getSpaceLeft() + " cargo space left.");
                    quantity = buyItem.nextInt();
                    if (quantity > player.getCargo().size() || (quantity * eachIsland.getJewelCost()) > player.getMoney()) {
                        System.out.println("Captain, you cannot make this purchase! We need a bigger ship or more money!");
                    } else {
                        player.addCargo(purchaseItem, quantity);
                        player.setMoney(-1 * (quantity * eachIsland.getJewelCost()));
                        eachIsland.setJewelCount(quantity);
                        eachIsland.updatePrices();
                        System.out.println("Purchase successful!");
                        System.out.println("\nYour current cargo: " + player.getCargo());
                        System.out.println("Your money: " + player.getMoney());
                    }
                } else if (itemCode == 5) {
                    newTurn();
                }
            }
        }


    }

    public static void sell() {
        HashMap<String, Integer> cargoMap = new HashMap<>();
        Scanner inputSell = new Scanner(System.in);

        ArrayList<String> currentCargo = player.getCargo();
        for (String eachCargo : currentCargo) {
            if (!(cargoMap.containsKey(eachCargo))) {
                cargoMap.put(eachCargo, 1);
            } else {
                cargoMap.put(eachCargo, cargoMap.get(eachCargo) + 1);
            }
        }
        System.out.println("Your current cargo available for sale:");

        for (String eachTypeCargo : cargoMap.keySet()) {
            if (eachTypeCargo != null) {
                System.out.println(eachTypeCargo + ": " + cargoMap.get(eachTypeCargo));
            }
        }

        System.out.println("What would you like to sell?");

        String sellProduct = inputSell.nextLine();
        while (!(cargoMap.containsKey(sellProduct))) {
            System.out.println("Captain, we do not have " + sellProduct + "!");
            System.out.println("We have: ");
            for (String eachTypeCargo : cargoMap.keySet()) {
                if (eachTypeCargo != null) {
                    System.out.println(eachTypeCargo + ": " + cargoMap.get(eachTypeCargo));
                }
            }
            sellProduct = inputSell.nextLine();
        }

        int numSellProduct = cargoMap.get(sellProduct);
        System.out.println("How many should we sell?");
        Scanner numProduct = new Scanner(System.in);
        int playerNumAnswer = numProduct.nextInt();
        while (playerNumAnswer > numSellProduct) {
            System.out.println("Captain, we do not have that many! We only have a maximum of (" + numSellProduct + ") " + sellProduct);
            playerNumAnswer = numProduct.nextInt();
        }

        //Need to implement: Cost of each product + take sold product out of player cargo + increment island's stock of products + refresh prices on island


    }

    public static void rumors() {

    }

    public static void castOff() {

    }
}