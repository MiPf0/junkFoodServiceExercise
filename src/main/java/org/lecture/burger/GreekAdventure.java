package org.lecture.burger;

import org.lecture.Healthiness;

/**
 * Concrete Burger Class inherited from 'Burger' which inherited from 'JunkFood'
 */
public class GreekAdventure extends Burger {

    boolean lowFatHalloumi;

    public GreekAdventure(boolean lowFatHalloumi) {
        this.price = 9;
        this.minutesToPrep = 14;
        this.healthiness = Healthiness.MEDIUM_HEALTHY;

        this.numberOfPatties = 1;
        this.vegetarian = true;
        this.vegan = false;
        this.fullGrainBun = false;
        this.burgerVersion = BurgerVersion.GREEK_ADVENTURE;

        this.lowFatHalloumi = lowFatHalloumi;
    }
}
