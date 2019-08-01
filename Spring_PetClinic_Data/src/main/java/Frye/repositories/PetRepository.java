package Frye.repositories;

import org.springframework.data.repository.CrudRepository;

import Frye.models.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
