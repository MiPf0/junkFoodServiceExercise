package org.lecture.pizza;

/**
 * interface for creating Pizzas with factory method
 */
public interface PizzaFactory {
    Pizza createPizza(String type);
}