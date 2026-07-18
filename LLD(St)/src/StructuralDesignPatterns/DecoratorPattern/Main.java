package StructuralDesignPatterns.DecoratorPattern;
interface Pizza {
    String getDescription();
    double getCost();
}
class MargharitaPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Margharita Pizza";
    }
    @Override
    public double getCost() {
        return 200.0;
    }
}
class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }
    @Override
    public double getCost() {
        return 100.0;
    }
}
//Decorator Class
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;
    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}
//Concrete Decorators
class ExtraCheese extends PizzaDecorator {
    public ExtraCheese(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese";
    }
    @Override
    public double getCost() {
        return pizza.getCost() + 50.0;
    }
}
class Olives extends PizzaDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }
    @Override
    public double getCost() {
        return pizza.getCost() + 30.0;
    }
}
class Stuffed extends PizzaDecorator {
    public Stuffed(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Stuffed";
    }
    @Override
    public double getCost() {
        return pizza.getCost() + 50.0;
    }
}
public class Main {
    public static void main(String[] args) {
        Pizza pizza = new ExtraCheese(new MargharitaPizza());
        System.out.println(pizza.getDescription() + " costs " + pizza.getCost());
        Pizza pizza2 = new ExtraCheese(new PlainPizza());
        System.out.println(pizza2.getDescription() + " costs " + pizza2.getCost());
        Pizza OliveCheesePizza = new Olives(new ExtraCheese(new MargharitaPizza()));
        System.out.println(OliveCheesePizza.getDescription() + " costs " + OliveCheesePizza.getCost());
        Pizza StuffedCheesePizza = new Stuffed(new Olives(new ExtraCheese(new MargharitaPizza())));
        System.out.println(StuffedCheesePizza.getDescription() + " costs " + StuffedCheesePizza.getCost());
    }
}
