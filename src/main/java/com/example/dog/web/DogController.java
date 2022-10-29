package com.example.dog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.dog.entity.Dog;
import com.example.dog.service.DogService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@ApiResponses(value= {
		@ApiResponse(code=400, message="This is a bad Request, follow API documentation"),
		@ApiResponse(code=401, message="Due to security constraintm you request cannot be granted"),
		@ApiResponse(code=500, message="The server is down"),
})
public class DogController {
	private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }
	
	@GetMapping("/dogs")
	public ResponseEntity<List<Dog>> getDogs() {
		List<Dog> dogs = dogService.retrieveDogs();
		return new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
		
	}
	
	@GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getDogBreeds() {
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getBreedByID(@PathVariable Long id) {
        String breed = dogService.retrieveDogBreedByID(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
	

}
