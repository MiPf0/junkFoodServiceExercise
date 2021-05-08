package org.lecture.hotdog;

/**
 * interface for creating HotDogs with factory method
 */
public interface HotDogFactory {
    HotDog createHotDog(String type);
}
