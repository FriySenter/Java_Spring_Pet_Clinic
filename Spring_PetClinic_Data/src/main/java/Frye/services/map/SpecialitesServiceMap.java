package Frye.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import Frye.models.Speciality;
import Frye.services.SpecialtyService;

@Service
public class SpecialitesServiceMap extends AbstractMapService<Speciality, Long> implements SpecialtyService {

	@Override
	public Set<Speciality> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Speciality findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Speciality object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

}
