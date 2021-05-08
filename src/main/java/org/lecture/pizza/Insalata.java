package org.lecture.pizza;

import org.lecture.Healthiness;

/**
 * Concrete Pizza Class inherited from 'Pizza' which inherited from 'JunkFood'
 */
public class Insalata extends Pizza {

    String typeOfSalad;

    public Insalata(String typeOfSalad) {
        this.price = 8;
        this.minutesToPrep = 12;
        this.healthiness = Healthiness.SUPER_HEALTHY;

        this.diameterInInches = 12;
        this.folded = true;
        this.blanche = true;
        this.pizzaVersion = PizzaVersion.INSALATA;

        this.typeOfSalad = typeOfSalad;
    }
}
