package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

public class DogHandler {
    private DogsRepository itsDogsRepo;
    public DogHandler(DogsRepository repo) {
        itsDogsRepo = repo;
    }

    public long addDog(Dog theDog) {
        return itsDogsRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogsRepo.count();
    }

    public Dog getDogByName(String name) {
        int count = 0;
        for (dog d : itsDogsRepo) {
            if(!d.getName().equals(name))
                return null;
            else
                count++;
                if (count > 1)
                    return null;
                else
                    return d;
        }
    }

}
