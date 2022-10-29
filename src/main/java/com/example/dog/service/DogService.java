package com.example.dog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dog.entity.Dog;

public interface DogService {
	List<String> retrieveDogBreed();
	String retrieveDogBreedByID(Long id);
	List<String> retrieveDogNames();
	List<Dog> retrieveDogs();
}
