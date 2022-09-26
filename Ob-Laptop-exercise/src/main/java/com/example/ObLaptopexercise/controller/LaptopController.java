package com.example.ObLaptopexercise.controller;

import com.example.ObLaptopexercise.entities.Laptop;
import com.example.ObLaptopexercise.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;


@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {

        this.laptopRepository = laptopRepository;
    }

    // CRUD over Laptop entity.
      // Search all Laptop.

    @GetMapping("/api/laptops")
    @ApiOperation("Find all Laptop in Database")
    public List<Laptop> findAll(){
        // Retrieve Laptops from Database
        return laptopRepository.findAll();
    }

    // search for a single Laptop by ist id.
    @GetMapping("/api/laptops/{id}")
    @ApiOperation("search for a single Laptop by ist id.")
    public ResponseEntity <Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        if (laptopOpt.isPresent()){
            return ResponseEntity.ok(laptopOpt.get());

        }else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new Laptop in the Database.

    @PostMapping("/api/laptops")
    @ApiOperation("Create a new Laptop in Database.")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));

        if (laptop.getId() != null){
            log.warn("trying to create a new Laptop with id");
            return ResponseEntity.badRequest().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    // Update an existing Laptop in Database.
    @PutMapping("/api/laptops")
    @ApiOperation("Update an existing Laptop in Database.")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if (laptop.getId() == null) {
            log.warn("Trying to update a non existing laptop");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())){
            log.warn("Trying to update a non existing laptop");
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    // Delete an existing Laptop in Database.
    @DeleteMapping("/api/laptops/{id}")
    @ApiOperation("Delete an existing Laptop in Database.")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if (!laptopRepository.existsById(id)){
            log.warn("Trying to delete a non existing laptop");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Delete all existing Laptops in Database.
    @ApiIgnore
    @DeleteMapping("/api/laptops")
    @ApiOperation("Delete all existing Laptops in Database.")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
