package org.lecture.burger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.lecture.JunkFood;

/**
 * abstract class 'Burger', inherited from abstract class 'JunkFood'
 */
@Getter
@Setter
// '@ToString' without '(callSuper = true)' because of unit tests where objects are compared in 'assertequals'
@ToString
public abstract class Burger extends JunkFood {

    protected int numberOfPatties;
    protected boolean vegetarian;
    protected boolean vegan;
    protected boolean fullGrainBun;
    protected BurgerVersion burgerVersion;

}