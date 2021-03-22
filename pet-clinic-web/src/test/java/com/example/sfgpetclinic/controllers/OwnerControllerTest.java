package com.example.sfgpetclinic.controllers;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.springdatajpa.OwnerSDJpaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
@Mock
    OwnerService ownerService;
@InjectMocks
OwnerController ownerController;
Set<Owner> owners;
MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        owners=new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
mockMvc= MockMvcBuilders
        .standaloneSetup(ownerController)
        .build();
    }

    @Test
    void listOwners() {
        when(ownerService.findAll()).thenReturn(owners);
      //  mockMvc.perform(get("/"))
               // .andExpect(status().is(200));
    }


    @Test
    void findOwners() {
    }
}