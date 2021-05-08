package org.lecture.pizza;

import org.lecture.Healthiness;

/**
 * Concrete Pizza Class inherited from 'Pizza' which inherited from 'JunkFood'
 */
public class Capricciosa extends Pizza {

    int numberOfOlives;

    public Capricciosa(int numberOfOlives) {
        this.price = 6.5;
        this.minutesToPrep = 22;
        this.healthiness = Healthiness.MEDIUM_HEALTHY;

        this.diameterInInches = 14;
        this.folded = true;
        this.blanche = false;
        this.pizzaVersion = PizzaVersion.CAPRICCIOSA;

        this.numberOfOlives = numberOfOlives;
    }
}
