package org.lecture.pizza;

import org.lecture.Healthiness;

/**
 * Concrete Pizza Class inherited from 'Pizza' which inherited from 'JunkFood'
 */
public class QuattroFormaggi extends Pizza {

    String cheese1of4;
    String cheese2of4;
    String cheese3of4;
    String cheese4of4;

    public QuattroFormaggi(String cheese1of4,String cheese2of4,String cheese3of4,String cheese4of4) {
        this.price = 6;
        this.minutesToPrep = 15;
        this.healthiness = Healthiness.NOT_HEALTHY;

        this.diameterInInches = 14;
        this.folded = false;
        this.blanche = false;
        this.pizzaVersion = PizzaVersion.QUATTRO_FORMAGGI;

        this.cheese1of4 = cheese1of4;
        this.cheese2of4 = cheese2of4;
        this.cheese3of4 = cheese3of4;
        this.cheese4of4 = cheese4of4;
    }
}
