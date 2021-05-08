package org.lecture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lecture.burger.ConcreteBurgerFactory;
import org.lecture.hotdog.ConcreteHotDogFactory;
import org.lecture.pizza.ConcretePizzaFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class JunkFoodConfigurationTest {

    @Test
    public void testDestinationSelection() {

        String input1 = "1";
        System.setIn(new ByteArrayInputStream(input1.getBytes()));
        Destination testOutcome1 = JunkFoodConfiguration.destinationSelection();
        Assertions.assertEquals(Destination.GREENWICH_VILLAGE,testOutcome1);

        String input2 = "2";
        System.setIn(new ByteArrayInputStream(input2.getBytes()));
        Destination testOutcome2 = JunkFoodConfiguration.destinationSelection();
        Assertions.assertEquals(Destination.SOHO,testOutcome2);

        String input3 = "3";
        System.setIn(new ByteArrayInputStream(input3.getBytes()));
        Destination testOutcome3 = JunkFoodConfiguration.destinationSelection();
        Assertions.assertEquals(Destination.LOWER_EAST_SIDE,testOutcome3);

        String input4 = "4";
        System.setIn(new ByteArrayInputStream(input4.getBytes()));
        Destination testOutcome4 = JunkFoodConfiguration.destinationSelection();
        Assertions.assertEquals(Destination.LENOX_HILL,testOutcome4);

        String input5 = "5";
        System.setIn(new ByteArrayInputStream(input5.getBytes()));
        Destination testOutcome5 = JunkFoodConfiguration.destinationSelection();
        Assertions.assertEquals(Destination.UPPER_WEST_SIDE,testOutcome5);
    }

    @Test
    public void testGetUserOrder() {

        String input = "1.1"
                + "\n"
                + "y"
                + "\n"
                + "2.2"
                + "\n"
                + "y"
                + "\n"
                + "3.3"
                + "\n"
                + "n"
                + "\n"
                + "b"
                + "\n"
                + "1.2"
                + "\n"
                + "n"
                + "\n"
                + "a";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ArrayList<Orderable> expected = new ArrayList<>();

        ConcreteBurgerFactory bf = new ConcreteBurgerFactory();
        ConcreteHotDogFactory hf = new ConcreteHotDogFactory();
        ConcretePizzaFactory pf = new ConcretePizzaFactory();

        expected.add(bf.createBurger("VEGAN_DREAM"));
        expected.add(hf.createHotDog("PICKLE_DOG"));
        expected.add(pf.createPizza("INSALATA"));
        expected.add(bf.createBurger("GREEK_ADVENTURE"));

        ArrayList<Orderable> tested = JunkFoodConfiguration.getUserOrder(Destination.SOHO);

        Assertions.assertEquals(expected.toString(),tested.toString());
    }

    @Test
    public void testPrintMenuToUser() {
        String expected = """
                What do you want to order? Please choose from the menu:\s
                BURGERS: (1.1) Vegan dream 7,50$ || (1.2) Greek adventure 9,00$ || (1.3) Classic star 15,00$
                HOTDOGS: (2.1) Garlic Dog 4,00$ || (2.2) Pickle Dog 3,50$ || (2.3) Mustard Dog 3,00$
                PIZZAS: (3.1) Capricciosa 6,50$ || (3.2) Quattro Formaggi 6,00$ || (3.3) Insalata 8,00$
                """;

        //information to get console output to string from StackOverflow
        //https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        PrintStream old = System.out;
        System.setOut(ps);
        JunkFoodConfiguration.printMenuToUser();
        System.out.flush();
        System.setOut(old);

        String tested = output.toString();

        //information to use '.trim().replace("\r","")' from StackOverflow
        //https://stackoverflow.com/questions/36324452/assertequalsstring-string-comparisonfailure-when-contents-are-identical
        Assertions.assertEquals(expected.trim().replace("\r",""),tested.trim().replace("\r",""));
    }

    @Test
    public void testGetOrderNumberOfEachOrderedJunkFood() {

        ArrayList<Orderable> al = new ArrayList<>();

        ConcreteBurgerFactory bf = new ConcreteBurgerFactory();
        ConcreteHotDogFactory hf = new ConcreteHotDogFactory();
        ConcretePizzaFactory pf = new ConcretePizzaFactory();

        al.add(bf.createBurger("VEGAN_DREAM"));
        al.add(bf.createBurger("VEGAN_DREAM"));
        al.add(hf.createHotDog("PICKLE_DOG"));
        al.add(hf.createHotDog("MUSTARD_DOG"));
        al.add(pf.createPizza("INSALATA"));
        al.add(bf.createBurger("GREEK_ADVENTURE"));

        HashMap<String, Integer> expected = new HashMap<>();

        expected.put("Vegan dream",2);
        expected.put("Pickle Dog",1);
        expected.put("Mustard Dog",1);
        expected.put("Insalata",1);
        expected.put("Greek adventure",1);
        expected.put("Burger",3);
        expected.put("Hot Dog",2);
        expected.put("Pizza",1);

        HashMap<String, Integer> tested = JunkFoodConfiguration.getNumberOfEachOrderedJunkFood(al);

        Assertions.assertEquals(expected.get("Vegan dream"),tested.get("Vegan dream"));
        Assertions.assertEquals(expected.get("Pickle Dog"),tested.get("Pickle Dog"));
        Assertions.assertEquals(expected.get("Mustard Dog"),tested.get("Mustard Dog"));
        Assertions.assertEquals(expected.get("Insalata"),tested.get("Insalata"));
        Assertions.assertEquals(expected.get("Greek adventure"),tested.get("Greek adventure"));
        Assertions.assertEquals(expected.get("Burger"),tested.get("Burger"));
        Assertions.assertEquals(expected.get("Hot Dog"),tested.get("Hot Dog"));
        Assertions.assertEquals(expected.get("Pizza"),tested.get("Pizza"));
    }

    @Test
    public void testPrintOrder() {

        String expected = """
                Burgers:\s
                2 x Vegan dream
                Hot Dogs:\s
                1 x Garlic Dog
                Pizzas:\s
                1 x Capricciosa
                """;

        HashMap<String, Integer> hmap = new HashMap<>();

        hmap.put("Vegan dream",2);
        hmap.put("Classic star",0);
        hmap.put("Greek adventure",0);
        hmap.put("Garlic Dog",1);
        hmap.put("Pickle Dog",0);
        hmap.put("Mustard Dog",0);
        hmap.put("Capricciosa",1);
        hmap.put("Insalata",0);
        hmap.put("Quattro Formaggi",0);
        hmap.put("Burger",2);
        hmap.put("Hot Dog",1);
        hmap.put("Pizza",1);


        //information to get console output to string from StackOverflow
        //https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        PrintStream old = System.out;
        System.setOut(ps);
        JunkFoodConfiguration.printOrder(hmap);
        System.out.flush();
        System.setOut(old);

        String tested = output.toString();

        //information to use '.trim().replace("\r","")' from StackOverflow
        //https://stackoverflow.com/questions/36324452/assertequalsstring-string-comparisonfailure-when-contents-are-identical
        Assertions.assertEquals(expected.trim().replace("\r",""),tested.trim().replace("\r",""));
    }

    @Test
    public void testGetLongestPrepTime() {

        ArrayList<Orderable> al = new ArrayList<>();

        ConcreteBurgerFactory bf = new ConcreteBurgerFactory();
        ConcreteHotDogFactory hf = new ConcreteHotDogFactory();
        ConcretePizzaFactory pf = new ConcretePizzaFactory();

        al.add(bf.createBurger("VEGAN_DREAM"));
        al.add(bf.createBurger("VEGAN_DREAM"));
        al.add(hf.createHotDog("PICKLE_DOG"));
        al.add(hf.createHotDog("MUSTARD_DOG"));
        al.add(pf.createPizza("INSALATA"));
        al.add(bf.createBurger("GREEK_ADVENTURE"));

        int tested = JunkFoodConfiguration.getLongestPrepTime(al);

        Assertions.assertEquals(46,tested);
    }

    @Test
    public void testPrintBill() {
        ArrayList<Orderable> al = new ArrayList<>();

        ConcreteBurgerFactory bf = new ConcreteBurgerFactory();
        ConcreteHotDogFactory hf = new ConcreteHotDogFactory();
        ConcretePizzaFactory pf = new ConcretePizzaFactory();

        al.add(bf.createBurger("VEGAN_DREAM"));
        al.add(bf.createBurger("VEGAN_DREAM"));
        al.add(hf.createHotDog("PICKLE_DOG"));
        al.add(hf.createHotDog("MUSTARD_DOG"));
        al.add(pf.createPizza("INSALATA"));
        al.add(bf.createBurger("GREEK_ADVENTURE"));

        Destination d = Destination.UPPER_WEST_SIDE;

        String expected = """
                Your bill:
                Food - 38,50$
                Delivery - 13,20$
                Whole price to pay - 51,70$
                                
                Delivery will take 44 minutes.
                """;

        //information to get console output to string from StackOverflow
        //https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        PrintStream old = System.out;
        System.setOut(ps);
        JunkFoodConfiguration.printBill(al,d);
        System.out.flush();
        System.setOut(old);

        String tested = output.toString();

        //information to use '.trim().replace("\r","")' from StackOverflow
        //https://stackoverflow.com/questions/36324452/assertequalsstring-string-comparisonfailure-when-contents-are-identical
        Assertions.assertEquals(expected.trim().replace("\r",""),tested.trim().replace("\r",""));
    }

    @Test
    public void testGetSumPriceOfOrder() {

        ArrayList<Orderable> al = new ArrayList<>();

        ConcreteBurgerFactory bf = new ConcreteBurgerFactory();
        ConcreteHotDogFactory hf = new ConcreteHotDogFactory();
        ConcretePizzaFactory pf = new ConcretePizzaFactory();

        al.add(bf.createBurger("VEGAN_DREAM"));
        al.add(bf.createBurger("VEGAN_DREAM"));
        al.add(hf.createHotDog("PICKLE_DOG"));
        al.add(hf.createHotDog("MUSTARD_DOG"));
        al.add(pf.createPizza("INSALATA"));
        al.add(bf.createBurger("GREEK_ADVENTURE"));

        double tested = JunkFoodConfiguration.getSumPriceOfOrders(al);

        Assertions.assertEquals(38.5,tested);
    }

    @Test
    public void testGetDeliveryTime() {
        Assertions.assertEquals(10,JunkFoodConfiguration.getDeliveryTime(Destination.GREENWICH_VILLAGE));
        Assertions.assertEquals(14,JunkFoodConfiguration.getDeliveryTime(Destination.SOHO));
        Assertions.assertEquals(25,JunkFoodConfiguration.getDeliveryTime(Destination.LOWER_EAST_SIDE));
        Assertions.assertEquals(38,JunkFoodConfiguration.getDeliveryTime(Destination.LENOX_HILL));
        Assertions.assertEquals(44,JunkFoodConfiguration.getDeliveryTime(Destination.UPPER_WEST_SIDE));
    }

    @Test
    public void testGetDeliveryCost() {
        Assertions.assertEquals(3,JunkFoodConfiguration.getDeliveryCost(Destination.GREENWICH_VILLAGE));
        Assertions.assertEquals(4.2,JunkFoodConfiguration.getDeliveryCost(Destination.SOHO));
        Assertions.assertEquals(7.5,JunkFoodConfiguration.getDeliveryCost(Destination.LOWER_EAST_SIDE));
        Assertions.assertEquals(11.4,JunkFoodConfiguration.getDeliveryCost(Destination.LENOX_HILL));
        Assertions.assertEquals(13.2,JunkFoodConfiguration.getDeliveryCost(Destination.UPPER_WEST_SIDE));
    }

    @Test
    public void testDelivery() {

        String expected = """
                Started preparing food...
                Preparation finished.
                Delivery started...
                Food delivered!
                Please come to the door and look after a handsome guy. Bring some cash!
                """;

        //information to get console output to string from StackOverflow
        //https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        PrintStream old = System.out;
        System.setOut(ps);
        JunkFoodConfiguration.simulateTime(13,5);
        System.out.flush();
        System.setOut(old);

        String tested = output.toString();

        //information to use '.trim().replace("\r","")' from StackOverflow
        //https://stackoverflow.com/questions/36324452/assertequalsstring-string-comparisonfailure-when-contents-are-identical
        Assertions.assertEquals(expected.trim().replace("\r",""),tested.trim().replace("\r",""));
    }
}
