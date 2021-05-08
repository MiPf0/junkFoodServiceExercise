package org.lecture.burger;

import org.lecture.Healthiness;

/**
 * Concrete Burger Class inherited from 'Burger' which inherited from 'JunkFood'
 */
public class ClassicStar extends Burger {

    String meatSource;

    public ClassicStar(String meatSource) {
        this.price = 15;
        this.minutesToPrep = 18;
        this.healthiness = Healthiness.NOT_HEALTHY;

        this.numberOfPatties = 2;
        this.vegetarian = false;
        this.vegan = false;
        this.fullGrainBun = false;
        this.burgerVersion = BurgerVersion.CLASSIC_STAR;

        this.meatSource = meatSource;
    }
}
