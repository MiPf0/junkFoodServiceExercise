package org.lecture;

/**
 * healthiness enum
 */
public enum Healthiness {
    SUPER_HEALTHY("super healthy"),
    MEDIUM_HEALTHY("medium healthy"),
    NOT_HEALTHY("not healthy");

    String degreeOfHealthiness;

    Healthiness(String degree) {
        this.degreeOfHealthiness = degree;
    }

    public String getDegreeOfHealthiness() {
        return degreeOfHealthiness;
    }
}