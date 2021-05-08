package org.lecture.pizza;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.lecture.JunkFood;

/**
 * abstract class 'Pizza', inherited from abstract class 'JunkFood'
 */
@Getter
@Setter
// '@ToString' without '(callSuper = true)' because of unit tests where objects are compared in 'assertequals'
@ToString
public abstract class Pizza extends JunkFood {

    protected int diameterInInches;
    protected boolean folded;
    protected boolean blanche;
    protected PizzaVersion pizzaVersion;

}
