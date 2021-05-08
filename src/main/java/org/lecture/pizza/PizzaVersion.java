package org.lecture.pizza;

/**
 * Enum Pizza types
 */
public enum PizzaVersion {
    CAPRICCIOSA("Capricciosa"),
    QUATTRO_FORMAGGI("Quattro Formaggi"),
    INSALATA("Insalata");

    String name;

    PizzaVersion(String version) {
        this.name = version;
    }

    public String getName() {
        return name;
    }
}