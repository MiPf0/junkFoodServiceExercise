package org.lecture.hotdog;

/**
 * Enum HotDog types
 */
public enum HotDogVersion {
    GARLIC_DOG("Garlic Dog"),
    PICKLE_DOG("Pickle Dog"),
    MUSTARD_DOG("Mustard Dog");

    String name;

    HotDogVersion(String version) {
        this.name = version;
    }

    public String getName() {
        return name;
    }
}
