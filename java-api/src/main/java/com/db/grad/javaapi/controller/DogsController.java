package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogsController {

    @Autowired
    DogsService dogsService;

    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return dogsService.getAllDogs();
    }

    @GetMapping("/dog/name/{name}")
    public Dog getDogByName(@PathVariable String name) {
        return dogsService.getDogByName(name);
    }

    @GetMapping("/dog/id/{id}")
    public Dog getDogById(@PathVariable(value="id") Long id) {
        return dogsService.getDogById(id);
    }

    @GetMapping("/dogs/number")
    public long getNumberOfDogs() {
        return dogsService.getNoOfDogs();
    }
}
