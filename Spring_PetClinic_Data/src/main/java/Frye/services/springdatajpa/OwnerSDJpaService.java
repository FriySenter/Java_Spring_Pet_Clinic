package Frye.services.springdatajpa;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import Frye.models.Owner;
import Frye.repositories.OwnerRepository;
import Frye.repositories.PetRepository;
import Frye.repositories.PetTypeRepository;
import Frye.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

	private final OwnerRepository or;
	private final PetRepository pr;
	private final PetTypeRepository ptr;

	public OwnerSDJpaService(OwnerRepository or, PetRepository pr, PetTypeRepository ptr) {
		super();
		this.or = or;
		this.pr = pr;
		this.ptr = ptr;
	}

	@Override
	public Set<Owner> findAll() {
		// TODO Auto-generated method stub

		Set<Owner> owners = new HashSet<>();
		or.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Owner> optionalOwner = or.findById(id);

		if (optionalOwner.isPresent()) {
			return optionalOwner.get();
		}
		return null;
	}

	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub
		return or.save(object);
	}

	@Override
	public void delete(Owner object) {
		// TODO Auto-generated method stub

		or.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

		or.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return or.findByLastName(lastName);
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		return or.findAllByLastNameLike(lastName);
	}

}
