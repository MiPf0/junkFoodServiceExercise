package org.lecture;

import lombok.Getter;
import lombok.Setter;

/**
 * abstract class 'JunkFood'
 */
@Getter
@Setter
public abstract class JunkFood implements Orderable {

    protected double price;
    protected int minutesToPrep;
    protected Healthiness healthiness;

}