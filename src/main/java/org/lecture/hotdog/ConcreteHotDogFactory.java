package org.lecture.hotdog;

/**
 * Class for factory method implementation
 */
public class ConcreteHotDogFactory implements HotDogFactory {

    @Override
    public HotDog createHotDog(String type) {
        HotDog hotDog = null;

        switch (type) {
            case "GARLIC_DOG" -> hotDog = new GarlicDog(false);
            case "PICKLE_DOG" -> hotDog = new PickleDog(2);
            case "MUSTARD_DOG" -> hotDog = new MustardDog(true);
        }
        return hotDog;
    }
}
