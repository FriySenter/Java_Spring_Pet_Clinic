package Frye.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Frye.services.map.*;
import Frye.models.Owner;
import Frye.models.Pet;
import Frye.models.PetType;
import Frye.models.Speciality;
import Frye.models.Vet;
import Frye.models.Visit;
import Frye.services.OwnerService;
import Frye.services.PetTypeService;
import Frye.services.SpecialtyService;
import Frye.services.VetService;
import Frye.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService os;
	private final VetService vs;
	private final PetTypeService pts;
	private final SpecialtyService sps;
	private final VisitService vis;

	public DataLoader(OwnerService os, VetService vs, PetTypeService pts, SpecialtyService sps, VisitService vis) {
		super();
		this.os = os;
		this.vs = vs;
		this.pts = pts;
		this.sps = sps;
		this.vis = vis;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		int count = pts.findAll().size();

		if (count == 0) {
			loadData();
		}

	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = pts.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = pts.save(cat);

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = sps.save(radiology);

		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = sps.save(surgery);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = sps.save(dentistry);

		Owner o1 = new Owner();
		o1.setFirstName("Mike");
		o1.setLastName("Frye");
		o1.setAddress("8E 9th street");
		o1.setCity("Chicago");
		o1.setTele("123456789");

		Pet mikespet = new Pet();
		mikespet.setName("norri");
		mikespet.setOwner(o1);
		mikespet.setPetType(savedDogPetType);
		mikespet.setBirthday(LocalDate.now());
		o1.getPets().add(mikespet);

		os.save(o1);

		Owner o2 = new Owner();
		o2.setFirstName("Kaven");
		o2.setLastName("WU");
		o2.setAddress("8E 19th street");
		o2.setCity("Chicago");
		o2.setTele("123456789");

		Pet wuspet = new Pet();
		wuspet.setName("Koti");
		wuspet.setOwner(o2);
		wuspet.setPetType(savedCatPetType);
		wuspet.setBirthday(LocalDate.now());
		o2.getPets().add(wuspet);

		os.save(o2);

		Visit vs1 = new Visit();
		vs1.setPet(wuspet);
		vs1.setDate(LocalDate.now());
		vs1.setDescription("wu's visit pet");

		vis.save(vs1);

		System.out.println("Loading Owners...");

		Vet v1 = new Vet();
		v1.setFirstName("Harry");
		v1.setLastName("Potter");
		v1.getSpecialities().add(savedRadiology);
		v1.getSpecialities().add(savedDentistry);

		vs.save(v1);

		System.out.println("Loading Vets...");
	}

}
