package org.lecture.hotdog;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.lecture.JunkFood;

/**
 * abstract class 'HotDog', inherited from abstract class 'JunkFood'
 */
@Getter
@Setter
// '@ToString' without '(callSuper = true)' because of unit tests where objects are compared in 'assertequals'
@ToString
public abstract class HotDog extends JunkFood {

    protected int numberOfSausages;
    protected boolean sesameBread;
    protected boolean mustard;
    protected boolean ketchup;
    protected HotDogVersion hotDogVersion;

}
