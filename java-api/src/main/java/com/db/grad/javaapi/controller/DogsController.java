package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DogsController {

    @Autowired
    DogsService dogsService;

    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return dogsService.getAllDogs();
    }

    @PostMapping("/dogs")
    public ResponseEntity<Dog> addNewDog(Dog dog) {
        return ResponseEntity.ok().body(dogsService.addDog(dog));
    }
    @PutMapping("/dog")
    public ResponseEntity<Dog> modifyDog (@RequestBody Dog dog) {
        return ResponseEntity.ok().body(dogsService.addDog(dog));
    }

    @GetMapping("/dog")
    public ResponseEntity<Dog> getDogById(@RequestParam(value = "id", defaultValue = "-1") Long id,
                          @RequestParam(value = "name", defaultValue = "false") String name)
                            throws ResourceNotFoundException {
        if (id != -1)
            return ResponseEntity.ok().body(dogsService.getDogById(id));
        if (!name.equals("false"))
            return ResponseEntity.ok().body(dogsService.getDogByName(name));
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/dogs/number")
    public long getNumberOfDogs() {
        return dogsService.getNoOfDogs();
    }

    @DeleteMapping("/dogs")
    public ResponseEntity<Map<String, Boolean>> deleteDog(@RequestBody Long id) {
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", dogsService.removeDog(id));
        return ResponseEntity.ok().body(response);
    }
}
