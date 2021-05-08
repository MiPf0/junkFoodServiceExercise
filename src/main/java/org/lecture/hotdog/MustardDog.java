package org.lecture.hotdog;

import org.lecture.Healthiness;

/**
 * Concrete HotDog Class inherited from 'HotDog' which inherited from 'JunkFood'
 */
public class MustardDog extends HotDog {

    boolean spicyMustard;

    public MustardDog(boolean spicyMustard) {
        this.price = 3;
        this.minutesToPrep = 2;
        this.healthiness = Healthiness.NOT_HEALTHY;

        this.numberOfSausages = 1;
        this.sesameBread = false;
        this.hotDogVersion = HotDogVersion.MUSTARD_DOG;

        this.spicyMustard = spicyMustard;
    }
}
