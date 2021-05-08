package org.lecture.burger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConcreteBurgerFactoryTest {

    @Test
    public void BurgerfactoryTest() {

        Burger testBurgerVeganDream = new VeganDream(false);
        Burger testBurgerGreekAdventure = new GreekAdventure(false);
        Burger testBurgerClassicStar = new ClassicStar("pork");

        ConcreteBurgerFactory bf = new ConcreteBurgerFactory();

        Assertions.assertEquals(testBurgerVeganDream.toString(),bf.createBurger("VEGAN_DREAM").toString());
        Assertions.assertEquals(testBurgerGreekAdventure.toString(),bf.createBurger("GREEK_ADVENTURE").toString());
        Assertions.assertEquals(testBurgerClassicStar.toString(),bf.createBurger("CLASSIC_STAR").toString());
    }
}
