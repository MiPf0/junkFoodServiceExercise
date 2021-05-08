package org.lecture.hotdog;

import org.lecture.Healthiness;

/**
 * Concrete HotDog Class inherited from 'HotDog' which inherited from 'JunkFood'
 */
public class GarlicDog extends HotDog {

    boolean artificialGarlicPowder;

    public GarlicDog(boolean artificialGarlicPowder) {
        this.price = 4;
        this.minutesToPrep = 4;
        this.healthiness = Healthiness.MEDIUM_HEALTHY;

        this.numberOfSausages = 2;
        this.sesameBread = true;
        this.hotDogVersion = HotDogVersion.GARLIC_DOG;

        this.artificialGarlicPowder = artificialGarlicPowder;
    }

}