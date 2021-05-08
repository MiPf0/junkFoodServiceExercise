package org.lecture.hotdog;

import org.lecture.Healthiness;

/**
 * Concrete HotDog Class inherited from 'HotDog' which inherited from 'JunkFood'
 */
public class PickleDog extends HotDog {

    int numberOfPickles;

    public PickleDog(int numberOfPickles) {
        this.price = 3.5;
        this.minutesToPrep = 3;
        this.healthiness = Healthiness.MEDIUM_HEALTHY;

        this.numberOfSausages = 1;
        this.sesameBread = true;
        this.hotDogVersion = HotDogVersion.PICKLE_DOG;

        this.numberOfPickles = numberOfPickles;
    }
}
