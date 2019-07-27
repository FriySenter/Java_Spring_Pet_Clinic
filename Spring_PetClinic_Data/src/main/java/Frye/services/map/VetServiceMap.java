package Frye.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import Frye.models.Speciality;
import Frye.models.Vet;
import Frye.services.CrudServices;
import Frye.services.SpecialtyService;
import Frye.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialtyService ss;

	public VetServiceMap(SpecialtyService ss) {
		super();
		this.ss = ss;
	}

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub

		if (object.getSpecialities().size() > 0) {
			object.getSpecialities().forEach(spe -> {
				if (spe.getId() == null) {
					Speciality savedSpeciality = ss.save(spe);
					spe.setId(savedSpeciality.getId());
				}
			});
		}
		return super.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

//	@Override
//	Vet save(Long id, Vet object) {
//		// TODO Auto-generated method stub
//		return super.save(id, object);
//	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

}
