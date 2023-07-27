package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.ArrayList;

public class DogHandler {

    private DogsRepository itsDogRepo;
    public DogHandler(DogsRepository repo) {
        itsDogRepo = repo;
    }

    public long addDog(Dog theDog) {
        return itsDogRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogRepo.count();
    }
    public Dog getDogByName(String name){
        Dog fluffy = new Dog();
        fluffy.setName(name);
        ArrayList arr = new ArrayList(itsDogRepo.findByName(fluffy));
        if(arr.size() == 1){
            return (Dog) arr.get(0);
        }
        else{
            return null;
        }
    }

}
