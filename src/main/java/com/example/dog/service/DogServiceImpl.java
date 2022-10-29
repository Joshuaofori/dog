package com.example.dog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.dog.entity.Dog;
import com.example.dog.repository.DogRepository;

@Service
public class DogServiceImpl implements DogService {
	@Autowired
	DogRepository dogRepository;

	@Override
	public List<String> retrieveDogBreed() {
		return dogRepository.findAllBreed();
	}

	@Override
	public String retrieveDogBreedByID(Long id) {
		Optional<String> optionalDog = Optional.ofNullable(dogRepository.findBreedByID(id));
		String dog = optionalDog.orElseThrow(DogNotFoundException::new);
		return dog;
	}

	@Override
	public List<String> retrieveDogNames() {
		return dogRepository.findAllName();
	}

	@Override
	public List<Dog> retrieveDogs() {
		return  (List<Dog>) dogRepository.findAll();
	}

}
