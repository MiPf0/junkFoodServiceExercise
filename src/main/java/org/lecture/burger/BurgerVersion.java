package org.lecture.burger;

/**
 * Enum Burger types
 */
public enum BurgerVersion {
    VEGAN_DREAM("Vegan dream"),
    GREEK_ADVENTURE("Greek adventure"),
    CLASSIC_STAR("Classic star");

    String name;

    BurgerVersion(String version) {
        this.name = version;
    }

    public String getName() {
        return name;
    }
}