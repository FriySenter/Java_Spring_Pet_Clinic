package Frye.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import Frye.models.Speciality;
import Frye.repositories.SpecialityRepository;
import Frye.services.SpecialtyService;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialtyService {

	private final SpecialityRepository sr;

	public SpecialitySDJpaService(SpecialityRepository sr) {
		super();
		this.sr = sr;
	}

	@Override
	public Set<Speciality> findAll() {
		// TODO Auto-generated method stub

		Set<Speciality> specialities = new HashSet<>();
		sr.findAll().forEach(specialities::add);

		return specialities;
	}

	@Override
	public Speciality findById(Long id) {
		// TODO Auto-generated method stub
		return sr.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {
		// TODO Auto-generated method stub
		return sr.save(object);
	}

	@Override
	public void delete(Speciality object) {
		// TODO Auto-generated method stub

		sr.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

		sr.deleteById(id);
	}

}
