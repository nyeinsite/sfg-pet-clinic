package com.example.sfgpetclinic.services;

import com.example.sfgpetclinic.model.Owner;

import java.util.List;


public interface OwnerService  extends CrudService<Owner,Long>{
public Owner findbByLastName(String lastName);
List<Owner> findAllByLastNameLike(String lastName);
}
