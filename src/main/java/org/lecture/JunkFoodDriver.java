package org.lecture;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * driver class
 */
@Slf4j
public class JunkFoodDriver {

    /**
     * driver method
     */
    public static void main(String[] args) {

        System.out.println("### Junkie's Food Palace ###\n\n" +
                "Welcome to Junkie's Food Palace for Burgers, Hot Dogs and Pizzas!");

        Destination selectedDestination = JunkFoodConfiguration.destinationSelection();
        log.info("Destination selected.");
        ArrayList<Orderable> orderList = JunkFoodConfiguration.getUserOrder(selectedDestination);
        log.info("User order taken.");

        int longestPrepTime = JunkFoodConfiguration.getLongestPrepTime(orderList);

        System.out.println("Your order will take " + longestPrepTime + " minutes to prepare and " +
                JunkFoodConfiguration.getDeliveryTime(selectedDestination) + " minutes to deliver.");
        log.info("User informed about cost, time and delivery.");

        JunkFoodConfiguration.simulateTime(longestPrepTime,JunkFoodConfiguration.getDeliveryTime(selectedDestination));
        log.info("Order delivered.");
    }
}
