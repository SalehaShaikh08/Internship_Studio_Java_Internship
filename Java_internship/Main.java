//PizzaMania  
import java.util.Scanner;

 class pizza {
    protected int price;
    private Boolean veg;

    protected int extraCheesePrice = 100;
    protected int extraToppingsPrice = 150;
    protected int backPackPrice = 20;

    protected int basePizzaPrice;

    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingseAdded = false;
    private boolean isOptedForTakeaway = false;

    Scanner in = new Scanner(System.in);

    public pizza(Boolean veg) {
        this.veg = veg;

        if (this.veg) {
            this.price = 300;
        } else {
            this.price = 400;
        }
        basePizzaPrice = this.price;
    }

    public void addExtraCheese() {
        System.out.println("Extra cheese (y/n)? ==>");
        char ch = in.next().charAt(0);
        switch (ch) {
            case ('y'):
                isExtraCheeseAdded = true;
                this.price += extraCheesePrice;
                break;

            case ('n'):
                isExtraCheeseAdded = false;
                break;
        }

    }

    public void addExtraToppings() {
        System.out.println("Want Extra Topping(y/n)? ==>");
        char ch = in.next().charAt(0);
        switch (ch) {
            case ('y'):
                isExtraToppingseAdded = true;
                this.price += extraToppingsPrice;
                break;

            case ('n'):
                isExtraToppingseAdded = false;
                break;
        }
    }

    public void takeAway() {
        System.out.println("Want TakeAway (y/n)? ==>");
        char ch = Character.toLowerCase(in.next().charAt(0));
        switch (ch) {
            case ('y'):
                isOptedForTakeaway = true;
                this.price += backPackPrice;
                break;
            case ('n'):
                isOptedForTakeaway = false;
                break;
        }
    }

    public void getBill() {
        String bill = " ";

        System.out.println("Pizza: " + basePizzaPrice);
        if (isExtraCheeseAdded) {
            bill += "Extra Cheese : " + extraCheesePrice + "\n";
            
        }
        if (isExtraToppingseAdded) {
            bill += "Extra Toppings : " + extraToppingsPrice + "\n";
            
        }
        if (isOptedForTakeaway) {
            bill += "Take away : "+backPackPrice+"\n";
            
        }
        bill += "\nTotal Amount: " + this.price + "\n";
        System.out.println(bill);
        System.out.println("\n\n\nThank You!!! Visit Again.....");
        System.out.println("----------------------------------------------------------------------------");
    }
}

 class DeluxPizza extends pizza {
    public DeluxPizza(Boolean veg) {
        super(veg);
    }

    @Override
    public void addExtraCheese() {
        this.price += extraCheesePrice;
    }

    @Override
    public void addExtraToppings() {
        this.price += extraToppingsPrice;
    }

}

class Main {
    public static void main(String[] args) {
        System.out.println("\n\n------------------------Welcome to Pizzamania------------------");
        System.out.println(
                "Which Pizza:\n 1: Veg Pizza\n 2: Non-Veg Pizza\n 3: Delux Veg Pizza \n 4: Delux Non-Veg Pizza ===>");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                pizza vegPizza = new pizza(true);
                vegPizza.addExtraToppings();
                vegPizza.addExtraCheese();
                vegPizza.takeAway();
                vegPizza.getBill();
                break;

            case 2:
                pizza nonvegPizza = new pizza(false);
                nonvegPizza.addExtraToppings();
                nonvegPizza.addExtraCheese();
                nonvegPizza.takeAway();
                nonvegPizza.getBill();
                break;

            case 3:
                DeluxPizza veg = new DeluxPizza(true);
                veg.basePizzaPrice = 550;
                veg.addExtraToppings();
                veg.addExtraCheese();
                veg.takeAway();
                veg.getBill();
                break;

            case 4:
                DeluxPizza nonveg = new DeluxPizza(false);
                nonveg.basePizzaPrice = 650;
                nonveg.addExtraToppings();
                nonveg.addExtraCheese();
                nonveg.takeAway();
                nonveg.getBill();
                break;

            default:
                System.out.println("Sorry Enter Again!!");
                break;
            
        }
        sc.close();

    }
}