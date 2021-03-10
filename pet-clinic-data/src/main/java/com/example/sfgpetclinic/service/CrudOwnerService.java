package com.example.sfgpetclinic.service;

import com.example.sfgpetclinic.model.Owner;

import java.util.Set;

public interface CrudOwnerService  <T,ID>{
    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
    T findByLastName(String lastName);

}
