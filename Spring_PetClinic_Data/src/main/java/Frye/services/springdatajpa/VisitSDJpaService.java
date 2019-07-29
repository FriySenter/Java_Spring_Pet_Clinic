package Frye.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import Frye.models.Visit;
import Frye.repositories.VisitRepository;
import Frye.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

	private final VisitRepository vr;

	public VisitSDJpaService(VisitRepository vr) {
		super();
		this.vr = vr;
	}

	@Override
	public Set<Visit> findAll() {
		// TODO Auto-generated method stub

		Set<Visit> visits = new HashSet<>();
		vr.findAll().forEach(visits::add);

		return visits;
	}

	@Override
	public Visit findById(Long id) {
		// TODO Auto-generated method stub
		return vr.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		// TODO Auto-generated method stub
		return vr.save(object);
	}

	@Override
	public void delete(Visit object) {
		// TODO Auto-generated method stub

		vr.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

		vr.deleteById(id);

	}

}
