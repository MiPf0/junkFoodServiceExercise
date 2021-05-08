package org.lecture;

import org.lecture.burger.*;
import org.lecture.hotdog.*;
import org.lecture.pizza.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Class containing all configuration
 */
public class JunkFoodConfiguration {

    /**
     * asks user to select respective destination for junkfood delivery
     * @return Destination; selected destination by user
     */
    //no scanner over parameters as testing would become more difficult
    public static Destination destinationSelection() {
        Scanner sc = new Scanner(System.in);
        Destination selectedDestination = null;
        System.out.println("Where do you live? Please choose from the following and input the respective number: \n" +
                "(1) " + Destination.GREENWICH_VILLAGE.getName() + "\n" +
                "(2) "+ Destination.SOHO.getName() + "\n" +
                "(3) "+ Destination.LOWER_EAST_SIDE.getName() + "\n" +
                "(4) "+ Destination.LENOX_HILL.getName() + "\n" +
                "(5) " + Destination.UPPER_WEST_SIDE.getName());
        String selection = sc.nextLine();
        switch (selection) {
                case "1" -> selectedDestination = Destination.GREENWICH_VILLAGE;
                case "2" -> selectedDestination = Destination.SOHO;
                case "3" -> selectedDestination = Destination.LOWER_EAST_SIDE;
                case "4" -> selectedDestination = Destination.LENOX_HILL;
                case "5" -> selectedDestination = Destination.UPPER_WEST_SIDE;
            default -> {
                System.out.println("Not possible, program exits.");
                System.exit(0);
            }
        }
        return selectedDestination;
    }

    /**
     * gets order from user
     * @param d user's destination
     * @return order from user in form of array list (type interface orderable)
     */
    //no scanner over parameters as testing would become more difficult
    public static ArrayList<Orderable> getUserOrder(Destination d) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Orderable> orderList = new ArrayList<>();

        ConcreteBurgerFactory bf = new ConcreteBurgerFactory();
        ConcreteHotDogFactory hf = new ConcreteHotDogFactory();
        ConcretePizzaFactory pf = new ConcretePizzaFactory();

        Orderable orderable;

        boolean continueSelection = false;
        boolean continueWholeOrderProcess = false;

        do {
            do {
                printMenuToUser();
                String selection = sc.nextLine();

                switch (selection) {
                    case "1.1" -> {
                        orderable = bf.createBurger("VEGAN_DREAM");
                        orderList.add(orderable);
                    }
                    case "1.2" -> {
                        orderable = bf.createBurger("GREEK_ADVENTURE");
                        orderList.add(orderable);
                    }
                    case "1.3" -> {
                        orderable = bf.createBurger("CLASSIC_STAR");
                        orderList.add(orderable);
                    }
                    case "2.1" -> {
                        orderable = hf.createHotDog("GARLIC_DOG");
                        orderList.add(orderable);
                    }
                    case "2.2" -> {
                        orderable = hf.createHotDog("PICKLE_DOG");
                        orderList.add(orderable);
                    }
                    case "2.3" -> {
                        orderable = hf.createHotDog("MUSTARD_DOG");
                        orderList.add(orderable);
                    }
                    case "3.1" -> {
                        orderable = pf.createPizza("CAPRICCIOSA");
                        orderList.add(orderable);
                    }
                    case "3.2" -> {
                        orderable = pf.createPizza("QUATTRO_FORMAGGI");
                        orderList.add(orderable);
                    }
                    case "3.3" -> {
                        orderable = pf.createPizza("INSALATA");
                        orderList.add(orderable);
                    }
                    default -> {
                        System.out.println("Wrong input. Program exits.");
                        System.exit(0);
                    }

                }

                System.out.println("Do you want to take another order? Please type (y) or (n).");

                String userContinuation = sc.nextLine();

                switch (userContinuation) {
                    case "y" -> continueSelection = true;
                    case "n" -> continueSelection = false;
                    default -> {
                        System.out.println("Wrong input. Program exits.");
                        System.exit(0);
                    }
                }

            } while (continueSelection);

            System.out.println("This is your order:\n");
            HashMap<String, Integer> orderHashmap = getNumberOfEachOrderedJunkFood(orderList);
            printOrder(orderHashmap);
            printBill(orderList,d);
            System.out.println("\n(a) Confirm order | (b) Do not confirm and add something | (c) Cancel order and quit process");

            String input = sc.nextLine();

            switch (input) {
                case "a" -> {
                    System.out.println("Thank you!");
                    continueWholeOrderProcess = false;
                }
                case "b" -> {
                    continueWholeOrderProcess = true;
                }
                case "c" -> {
                    System.exit(0);
                }
                default -> System.exit(0);
            }
        } while (continueWholeOrderProcess);
        return orderList;
    }

    /**
     * prints Menu to user
     */
    public static void printMenuToUser() {
        GreekAdventure gaDummy = new GreekAdventure(true);
        VeganDream vdDummy = new VeganDream(true);
        ClassicStar csDummy = new ClassicStar("pork");

        GarlicDog gdDummy = new GarlicDog(true);
        PickleDog pdDummy = new PickleDog(3);
        MustardDog mdDummy = new MustardDog(true);

        Capricciosa ccDummy = new Capricciosa(5);
        QuattroFormaggi qfDummy = new QuattroFormaggi("a","b","c","d");
        Insalata isDummy = new Insalata("x");

        DecimalFormat df = new DecimalFormat("#.00#");

        System.out.println("What do you want to order? Please choose from the menu: \n" +
                "BURGERS: (1.1) " + BurgerVersion.VEGAN_DREAM.getName() + " " + df.format(vdDummy.getPrice()) + "$ || " +
                "(1.2) " + BurgerVersion.GREEK_ADVENTURE.getName() + " " + df.format(gaDummy.getPrice()) + "$ || " +
                "(1.3) " + BurgerVersion.CLASSIC_STAR.getName() + " " + df.format(csDummy.getPrice()) + "$\n" +
                "HOTDOGS: (2.1) " + HotDogVersion.GARLIC_DOG.getName() + " " + df.format(gdDummy.getPrice()) + "$ || " +
                "(2.2) " + HotDogVersion.PICKLE_DOG.getName() + " " + df.format(pdDummy.getPrice()) + "$ || " +
                "(2.3) " + HotDogVersion.MUSTARD_DOG.getName() + " " + df.format(mdDummy.getPrice()) + "$\n" +
                "PIZZAS: (3.1) " + PizzaVersion.CAPRICCIOSA.getName() + " " + df.format(ccDummy.getPrice()) + "$ || " +
                "(3.2) " + PizzaVersion.QUATTRO_FORMAGGI.getName() + " " + df.format(qfDummy.getPrice()) + "$ || " +
                "(3.3) " + PizzaVersion.INSALATA.getName() + " " + df.format(isDummy.getPrice()) + "$");
    }

    /**
     * prints bill to user
     * @param al ordered list
     * @param d destination
     */
    public static void printBill(ArrayList<Orderable> al, Destination d) {
        double sumPriceOfOrders = getSumPriceOfOrders(al);
        double deliveryCost = getDeliveryCost(d);
        DecimalFormat df = new DecimalFormat("#.00#");
        System.out.println("\nYour bill:\nFood - " + df.format(sumPriceOfOrders) + "$\n" +
                "Delivery - " + df.format(deliveryCost) + "$\n" +
                "Whole price to pay - " + df.format(sumPriceOfOrders+deliveryCost) + "$\n");
        System.out.println("Delivery will take " + getDeliveryTime(d) + " minutes.");
    }

    /**
     * summarizes number of each junkfood and also number of each group of junkfood (burger, hotdog, pizza)
     * @param orderable in form of an array list (order from user)
     * @return hashmap with key value pair for each junkfood/group of junkfood
     */
    public static HashMap<String, Integer> getNumberOfEachOrderedJunkFood(ArrayList<Orderable> orderable) {

        HashMap<String, Integer> hmap = new HashMap<>();

        int veDrCounter = 0;
        int grAdCounter = 0;
        int clStCounter = 0;
        int gaHdCounter = 0;
        int piHdCounter = 0;
        int muHdCounter = 0;
        int caPiCounter = 0;
        int qfPiCounter = 0;
        int inPiCounter = 0;

        int burgerCounter = 0;
        int hotdogCounter = 0;
        int pizzaCounter = 0;

        for(Orderable od : orderable) {
            if (od instanceof VeganDream) {
                veDrCounter++;
                burgerCounter++;
            } else if (od instanceof GreekAdventure) {
                grAdCounter++;
                burgerCounter++;
            } else if (od instanceof ClassicStar) {
                clStCounter++;
                burgerCounter++;
            } else if (od instanceof GarlicDog) {
                gaHdCounter++;
                hotdogCounter++;
            } else if (od instanceof PickleDog) {
                piHdCounter++;
                hotdogCounter++;
            } else if (od instanceof MustardDog) {
                muHdCounter++;
                hotdogCounter++;
            } else if (od instanceof Capricciosa) {
                caPiCounter++;
                pizzaCounter++;
            } else if (od instanceof QuattroFormaggi) {
                qfPiCounter++;
                pizzaCounter++;
            } else if (od instanceof Insalata) {
                inPiCounter++;
                pizzaCounter++;
            }
        }

        hmap.put(BurgerVersion.VEGAN_DREAM.getName(),veDrCounter);
        hmap.put(BurgerVersion.GREEK_ADVENTURE.getName(),grAdCounter);
        hmap.put(BurgerVersion.CLASSIC_STAR.getName(),clStCounter);
        hmap.put(HotDogVersion.GARLIC_DOG.getName(),gaHdCounter);
        hmap.put(HotDogVersion.PICKLE_DOG.getName(), piHdCounter);
        hmap.put(HotDogVersion.MUSTARD_DOG.getName(), muHdCounter);
        hmap.put(PizzaVersion.CAPRICCIOSA.getName(),caPiCounter);
        hmap.put(PizzaVersion.QUATTRO_FORMAGGI.getName(), qfPiCounter);
        hmap.put(PizzaVersion.INSALATA.getName(), inPiCounter);
        hmap.put("Burger", burgerCounter);
        hmap.put("Hot Dog", hotdogCounter);
        hmap.put("Pizza", pizzaCounter);

        return hmap;
    }

    /**
     * prints order to the console with data from hashmap
     * @param hmap
     */
    public static void printOrder(HashMap<String, Integer> hmap) {

        if(hmap.get("Burger")>0) {
            System.out.println("Burgers: ");
            if(hmap.get(BurgerVersion.CLASSIC_STAR.getName())>0) {
                System.out.println(hmap.get(BurgerVersion.CLASSIC_STAR.getName()) + " x " + BurgerVersion.CLASSIC_STAR.getName());
            }
            if(hmap.get(BurgerVersion.GREEK_ADVENTURE.getName())>0) {
                System.out.println(hmap.get(BurgerVersion.GREEK_ADVENTURE.getName()) + " x " + BurgerVersion.GREEK_ADVENTURE.getName());
            }
            if(hmap.get(BurgerVersion.VEGAN_DREAM.getName())>0) {
                System.out.println(hmap.get(BurgerVersion.VEGAN_DREAM.getName()) + " x " + BurgerVersion.VEGAN_DREAM.getName());
            }
        }

        if(hmap.get("Hot Dog")>0) {
            System.out.println("Hot Dogs: ");
            if(hmap.get(HotDogVersion.GARLIC_DOG.getName())>0) {
                System.out.println(hmap.get(HotDogVersion.GARLIC_DOG.getName()) + " x " + HotDogVersion.GARLIC_DOG.getName());
            }
            if(hmap.get(HotDogVersion.MUSTARD_DOG.getName())>0) {
                System.out.println(hmap.get(HotDogVersion.MUSTARD_DOG.getName()) + " x " + HotDogVersion.MUSTARD_DOG.getName());
            }
            if(hmap.get(HotDogVersion.PICKLE_DOG.getName())>0) {
                System.out.println(hmap.get(HotDogVersion.PICKLE_DOG.getName()) + " x " + HotDogVersion.PICKLE_DOG.getName());
            }
        }

        if(hmap.get("Pizza")>0) {
            System.out.println("Pizzas: ");
            if(hmap.get(PizzaVersion.CAPRICCIOSA.getName())>0) {
                System.out.println(hmap.get(PizzaVersion.CAPRICCIOSA.getName()) + " x " + PizzaVersion.CAPRICCIOSA.getName());
            }
            if(hmap.get(PizzaVersion.INSALATA.getName())>0) {
                System.out.println(hmap.get(PizzaVersion.INSALATA.getName()) + " x " + PizzaVersion.INSALATA.getName());
            }
            if(hmap.get(PizzaVersion.QUATTRO_FORMAGGI.getName())>0) {
                System.out.println(hmap.get(PizzaVersion.QUATTRO_FORMAGGI.getName()) + " x " + PizzaVersion.QUATTRO_FORMAGGI.getName());
            }
        }
    }

    /**
     * gets the longest prep time of a junkfood group (burger, hotdog or pizza, depending on how many of them will be produced)
     * @param al arraylist (order by user)
     * @return int longest prep time
     */
    public static int getLongestPrepTime(ArrayList<Orderable> al) {

        int burgerTime = 0;
        int hotDogTime = 0;
        int pizzaTime = 0;

        for(Orderable o : al) {
            if(o instanceof Burger) {
                burgerTime += o.getMinutesToPrep();
            } else if(o instanceof HotDog) {
                hotDogTime += o.getMinutesToPrep();
            } else if(o instanceof Pizza) {
                pizzaTime += o.getMinutesToPrep();
            }
        }
        return Math.max(burgerTime,Math.max(hotDogTime,pizzaTime));
    }

    /**
     * calculates the sum of whole order
     * @param al array list user order
     * @return double, sum of whole order
     */
    public static double getSumPriceOfOrders(ArrayList<Orderable> al) {
        double finalPrice = 0;
        for(Orderable o : al) {
            double price = o.getPrice();
            finalPrice += price;
        }
        return finalPrice;
    }

    /**
     * calculates delivery time in minutes
     * @param d destination
     * @return int
     */
    public static int getDeliveryTime(Destination d) {
        double calc = d.getDistance()*10;
        return (int) calc;
    }

    /**
     * calculates delivery cost in $
     * @param d destination
     * @return double
     */
    public static double getDeliveryCost(Destination d) {
        double cost = d.getDistance()*3;
        cost *= 10;
        cost = Math.round(cost);
        cost /= 10;
        return cost;
    }

    /**
     * simulates time passing by in the CLI
     * @param minutesToPrep
     * @param minutesToDeliver
     */
    public static void simulateTime(int minutesToPrep,int minutesToDeliver) {

        long simulatedMinutesToPrep = (long) (minutesToPrep*0.25);
        long simulatedMinutesToDeliver = (long) (minutesToDeliver*0.25);

        TimeUnit time = TimeUnit.MILLISECONDS;

        System.out.println("Started preparing food...");

        try {
            time.sleep(simulatedMinutesToPrep);
            System.out.println("Preparation finished.");
        } catch (InterruptedException e) {
            System.out.println("Interrupted while preparing.");
        }

        try {
            time.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting after preparation.");
        }

        System.out.println("Delivery started...");

        try {
            time.sleep(simulatedMinutesToDeliver);
            System.out.println("Food delivered!\nPlease come to the door and look after a handsome guy. Bring some cash!");
        } catch (InterruptedException e) {
            System.out.println("Interrupted while trying to deliver.");
        }
    }
}