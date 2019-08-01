package Frye.services.map;

import Frye.models.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap osm;

    final Long ownerId = 1L;
    final String lastName = "Carack";

    @BeforeEach
    void setUp() {
        osm = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());

        osm.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {

        Set<Owner> ownerSet = osm.findAll();

        assertEquals(1, ((Set) ownerSet).size());
    }

    @Test
    void findById() {

        Owner owner = osm.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void deleteById() {
        osm.deleteById(ownerId);

        assertEquals(0, osm.findAll().size());

    }

    @Test
    void delete() {

        osm.delete(osm.findById(ownerId));

        assertEquals(0, osm.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = osm.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {

        Owner savedOwner = osm.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findByLastName() {

        Owner nameTest = osm.findByLastName("foo");

        assertNull(nameTest);

//        assertEquals(ownerId, nameTest.getId());


    }
}