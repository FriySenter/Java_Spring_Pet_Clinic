package Frye.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import Frye.models.Pet;
import Frye.repositories.PetRepository;
import Frye.services.PetServices;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetServices {

	private final PetRepository pr;

	public PetSDJpaService(PetRepository pr) {
		super();
		this.pr = pr;
	}

	@Override
	public Set<Pet> findAll() {
		// TODO Auto-generated method stub

		Set<Pet> pets = new HashSet<>();
		pr.findAll().forEach(pets::add);

		return pets;
	}

	@Override
	public Pet findById(Long id) {
		// TODO Auto-generated method stub
		return pr.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		// TODO Auto-generated method stub
		return pr.save(object);
	}

	@Override
	public void delete(Pet object) {
		// TODO Auto-generated method stub

		pr.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

		pr.deleteById(id);
		;
	}

}
