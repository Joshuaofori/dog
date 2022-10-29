package com.example.dog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dog.entity.Dog;

public interface DogRepository extends CrudRepository<Dog,Long> {
	@Query("Select d.id, d.breed from Dog d where d.id=:id")
	String findBreedByID(Long id);
	
	@Query("Select d.id, d.breed from Dog d")
	List<String> findAllBreed();
	
	@Query("Select d.id, d.name from Dog d")
	List<String> findAllName();
	

}
