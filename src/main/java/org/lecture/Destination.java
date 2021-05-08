package org.lecture;

import lombok.Getter;

/**
 * destination extended enum
 */
@Getter
public enum Destination {
    GREENWICH_VILLAGE("Greenwich Village", 1.0),
    SOHO("Soho", 1.4),
    LOWER_EAST_SIDE("Lower East Side", 2.5),
    LENOX_HILL("Lenox Hill", 3.8),
    UPPER_WEST_SIDE("Upper West Side", 4.4);

    String name;
    double distance;

    Destination(String name, double milesDistance) {
        this.name = name;
        this.distance = milesDistance;
    }
}