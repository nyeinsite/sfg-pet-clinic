package com.example.sfgpetclinic.services.map;

import com.example.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {
OwnerServiceMap ownerServiceMap;
final Long ownerId=1L;
final String lastName="Tun";
    @BeforeEach
    void setUp() {
        ownerServiceMap=new OwnerServiceMap(new PetTypeMapService(),new PetServiceMap());
   ownerServiceMap.save(Owner.builder().id(1L).build());
    }

    @Test
    void findAll() {
        Set<Owner>ownersSet=ownerServiceMap.findAll();
        assertEquals(1,ownersSet.size());
    }

    @Test
    void findById() {
        Owner owner=ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id=2L;
        Owner owner2=Owner.builder().id(2L).build();
        Owner savedOwner=ownerServiceMap.save(owner2);
        assertEquals(id,savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner=ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void findbByLastName() {
        Owner nyein=ownerServiceMap.findbByLastName(null);
       assertNull(nyein);
    }
}