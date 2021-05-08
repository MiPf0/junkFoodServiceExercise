package org.lecture.hotdog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lecture.burger.*;

public class ConcreteHotDogFactoryTest {

    @Test
    public void HotDogfactoryTest() {

        HotDog testHotDogGarlicDog = new GarlicDog(false);
        HotDog testHotDogPickleDog = new PickleDog(2);
        HotDog testHotDogMustardDog = new MustardDog(true);

        ConcreteHotDogFactory bf = new ConcreteHotDogFactory();

        Assertions.assertEquals(testHotDogGarlicDog.toString(),bf.createHotDog("GARLIC_DOG").toString());
        Assertions.assertEquals(testHotDogPickleDog.toString(),bf.createHotDog("PICKLE_DOG").toString());
        Assertions.assertEquals(testHotDogMustardDog.toString(),bf.createHotDog("MUSTARD_DOG").toString());
    }
}
