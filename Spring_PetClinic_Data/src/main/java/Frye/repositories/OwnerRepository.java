package Frye.repositories;

import org.springframework.data.repository.CrudRepository;

import Frye.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByLastName(String lastName); 

}
