package org.lecture.burger;

/**
 * interface for creating Burgers with factory method
 */
public interface BurgerFactory {
    Burger createBurger(String type);
}
