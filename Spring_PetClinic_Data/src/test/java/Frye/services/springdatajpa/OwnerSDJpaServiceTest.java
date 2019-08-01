package Frye.services.springdatajpa;

import Frye.models.Owner;
import Frye.repositories.OwnerRepository;
import Frye.repositories.PetRepository;
import Frye.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository or;

    @Mock
    PetRepository pr;

    @Mock
    PetTypeRepository ptr;

    @InjectMocks
    OwnerSDJpaService service;

    private final String LAST_NAME = "Smith";
    Owner returnedOwner;

    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();

    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1l).build());
        returnOwnerSet.add(Owner.builder().id(2l).build());

        when(or.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());

    }

    @Test
    void findById() {

        when(or.findById(anyLong())).thenReturn(Optional.of(returnedOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void save() {

        Owner ownerToSave = Owner.builder().id(1L).build();

        when(or.save(any())).thenReturn(returnedOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void delete() {

        service.delete(returnedOwner);

        verify(or).delete(any());
    }

    @Test
    void deleteById() {

        service.deleteById(1L);

        verify(or).deleteById(anyLong());
    }

    @Test
    void findByLastName() {

//        Owner returnedOwner = Owner.builder().id(1L).lastName(Last_Name).build();

        when(or.findByLastName(any())).thenReturn(returnedOwner);

        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());
    }
}