package Frye.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import Frye.models.PetType;
import Frye.repositories.PetTypeRepository;
import Frye.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

	private final PetTypeRepository ptr;

	public PetTypeSDJpaService(PetTypeRepository ptr) {
		super();
		this.ptr = ptr;
	}

	@Override
	public Set<PetType> findAll() {
		// TODO Auto-generated method stub

		Set<PetType> petTypes = new HashSet<>();
		ptr.findAll().forEach(petTypes::add);

		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		// TODO Auto-generated method stub
		return ptr.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		// TODO Auto-generated method stub
		return ptr.save(object);
	}

	@Override
	public void delete(PetType object) {
		// TODO Auto-generated method stub

		ptr.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

		ptr.deleteById(id);
	}

}
