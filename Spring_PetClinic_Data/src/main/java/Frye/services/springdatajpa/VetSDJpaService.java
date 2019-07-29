package Frye.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import Frye.models.Vet;
import Frye.repositories.VetRepository;
import Frye.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

	private final VetRepository vr;

	public VetSDJpaService(VetRepository vr) {
		super();
		this.vr = vr;
	}

	@Override
	public Set<Vet> findAll() {
		// TODO Auto-generated method stub

		Set<Vet> vets = new HashSet<>();

		vr.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		// TODO Auto-generated method stub
		return vr.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		return vr.save(object);
	}

	@Override
	public void delete(Vet object) {
		// TODO Auto-generated method stub

		vr.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

		vr.deleteById(id);

	}

}
