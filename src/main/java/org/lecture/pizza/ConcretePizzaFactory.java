package org.lecture.pizza;

/**
 * Class for factory method implementation
 */
public class ConcretePizzaFactory implements PizzaFactory {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        switch (type) {
            case "CAPRICCIOSA" -> pizza = new Capricciosa(10);
            case "QUATTRO_FORMAGGI" -> pizza = new QuattroFormaggi("Mozzarella","Gorgonzola","Parmesan","Emmental");
            case "INSALATA" -> pizza = new Insalata("bird salad");
        }
        return pizza;
    }
}