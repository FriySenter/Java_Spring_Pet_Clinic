package Frye.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import Frye.models.Owner;
import Frye.models.Pet;
import Frye.services.CrudServices;
import Frye.services.OwnerService;
import Frye.services.PetServices;
import Frye.services.PetTypeService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService pts;
	private final PetServices ps;

	public OwnerServiceMap(PetTypeService pts, PetServices ps) {
		super();
		this.pts = pts;
		this.ps = ps;
	}

	@Override
	public Set<Owner> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

//	@Override
//	Owner save(Long id, Owner object) {
//		// TODO Auto-generated method stub
//		return super.save(id, object);
//	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Owner object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub

		if (object != null) {

			if (object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if (pet.getPetType() != null) {
						if (pet.getPetType().getId() == null) {
							pet.setPetType(pts.save(pet.getPetType()));
						}
					} else {
						throw new RuntimeException("New PetType is Required!");
					}

					if (pet.getId() == null) {
						Pet savedPet = ps.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			return super.save(object);
		}

		return null;

	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
