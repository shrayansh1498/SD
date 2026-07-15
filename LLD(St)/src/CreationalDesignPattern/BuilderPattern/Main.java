package CreationalDesignPattern.BuilderPattern;
import java.util.*;

class BurgerMeal {
    private final String bun;
    private final String patty;
    //Optional
    private final List<String> toppings;
    private final boolean hasCheese;
    private final String drink;
    private final String side;


    private BurgerMeal(BurgerBuilder burgerBuilder) {
        this.bun = burgerBuilder.bun;
        this.patty = burgerBuilder.patty;
        this.toppings = burgerBuilder.toppings;
        this.hasCheese = burgerBuilder.hasCheese;
        this.drink = burgerBuilder.drink;
        this.side = burgerBuilder.side;
    }

    public static class BurgerBuilder {
        private String bun;
        private String patty;
        //Optional
        private List<String> toppings;
        private boolean hasCheese;
        private String drink;
        private String side;
        public BurgerBuilder setBun(String bun) {
            this.bun = bun;
            return this;
        }

        public BurgerBuilder setPatty(String patty) {
            this.patty = patty;
            return this;
        }

        public BurgerBuilder addTopping(String topping) {
            if (this.toppings == null) {
                this.toppings = new ArrayList<>();
            }
            this.toppings.add(topping); 
            return this;
        }
        public BurgerBuilder addDrink(String drink) {
            this.drink = drink;
            return this;
        }
        public BurgerBuilder addSide(String side) {
            this.side = side;
            return this;
        }

        public BurgerMeal build() {
            return new BurgerMeal(this);
        }
    }
    public String getBurger() {
        return "BurgerMeal{" +
                "bun='" + bun + '\'' +
                ", patty='" + patty + '\'' +
                ", toppings=" + toppings +
                ", hasCheese=" + hasCheese +
                ", drink='" + drink + '\'' +
                ", side='" + side + '\'' +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        BurgerMeal burgerMeal = new BurgerMeal.BurgerBuilder()
                .setBun("Bun")
                .setPatty("Patty")
                .addTopping("Lettuce")
                .addTopping("Tomato")
                .addDrink("Coke")
                .addSide("Fries")
                .build();

        System.out.println(burgerMeal.getBurger());
    }
}
