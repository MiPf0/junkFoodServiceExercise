package org.lecture.burger;

/**
 * Class for factory method implementation
 */
public class ConcreteBurgerFactory implements BurgerFactory {

    @Override
    public Burger createBurger(String type) {
        Burger burger = null;

        switch (type) {
            case "VEGAN_DREAM" -> burger = new VeganDream(false);
            case "GREEK_ADVENTURE" -> burger = new GreekAdventure(false);
            case "CLASSIC_STAR" -> burger = new ClassicStar("pork");
        }
        return burger;
    }

}