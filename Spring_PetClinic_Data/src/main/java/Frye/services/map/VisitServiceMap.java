package Frye.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import Frye.models.Visit;
import Frye.services.VisitService;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Set<Visit> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Visit save(Visit object) {
		// TODO Auto-generated method stub

		if (object.getPet() == null || object.getPet().getOwner() == null || object.getPet().getId() == null
				|| object.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid Visit!");
		}

		return super.save(object); 
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Visit object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

}
