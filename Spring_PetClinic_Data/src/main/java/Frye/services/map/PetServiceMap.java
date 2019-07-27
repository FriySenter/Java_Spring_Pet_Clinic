package Frye.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import Frye.models.Pet;
import Frye.services.CrudServices;
import Frye.services.PetServices;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetServices {

	@Override
	public Pet save(Pet object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public Set<Pet> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

//	@Override
//	public Pet save(Long id, Pet object) {
//		// TODO Auto-generated method stub
//		return super.save(id, object);
//	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Pet object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

}
