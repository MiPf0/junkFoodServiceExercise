package org.lecture.pizza;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lecture.burger.*;

public class ConcretePizzaFactoryTest {

    @Test
    public void PizzafactoryTest() {

        Pizza testPizzaCapricciosa = new Capricciosa(10);
        Pizza testPizzaInsalata = new Insalata("bird salad");
        Pizza testPizzaQuattroFormaggi = new QuattroFormaggi("Mozzarella","Gorgonzola","Parmesan","Emmental");

        ConcretePizzaFactory pf = new ConcretePizzaFactory();

        Assertions.assertEquals(testPizzaCapricciosa.toString(),pf.createPizza("CAPRICCIOSA").toString());
        Assertions.assertEquals(testPizzaInsalata.toString(),pf.createPizza("INSALATA").toString());
        Assertions.assertEquals(testPizzaQuattroFormaggi.toString(),pf.createPizza("QUATTRO_FORMAGGI").toString());
    }

}
