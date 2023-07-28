package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogsHandlerTest {

    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty(){
        itsDogRepo.deleteAll();

    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one()
    {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        int expectedResult = 1;

        long actualResult = cut.getNoOfDogs();

        assertEquals(expectedResult, actualResult);

    }
    @Test
    public void checkDogByName(){
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
//        Dog obj = cut.getDogByName("Bruno");
        ArrayList<Dog> arr1 = new ArrayList<>();
        arr1.add(theDog);
        assertEquals(arr1.get(0),cut.getDogByName(theDog.getName()));
//        if(theDog instanceof Dog){
//
//        }
//        assertEquals(theDog.getClass(), cut.getDogByName(theDog.getName()));
//        cut.getDogByName("Bruno");

//        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void checkDogById(){
        Dog expectedDog = new Dog();
        expectedDog.setId(1);
        expectedDog.setName("Bruno");
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        theDog = new Dog();
        theDog.setName("Fluffy");
        cut.addDog(theDog);

        Dog actualDog = cut.getDogById(1);

        assertEquals(expectedDog.getId(), actualDog.getId());
        assertEquals(expectedDog.getName(), actualDog.getName());
    }
}
