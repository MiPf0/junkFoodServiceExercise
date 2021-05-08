package org.lecture.burger;

import org.lecture.Healthiness;

/**
 * Concrete Burger Class inherited from 'Burger' which inherited from 'JunkFood'
 */
public class VeganDream extends Burger {

    boolean veganMayo;
    public VeganDream(boolean veganMayo) {
        this.price = 7.5;
        this.minutesToPrep = 16;
        this.healthiness = Healthiness.SUPER_HEALTHY;

        this.numberOfPatties = 1;
        this.vegetarian = true;
        this.vegan = true;
        this.fullGrainBun = true;
        this.burgerVersion = BurgerVersion.VEGAN_DREAM;

        this.veganMayo = veganMayo;
    }


}
