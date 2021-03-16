package com.example.sfgpetclinic.services;

import com.example.sfgpetclinic.model.Owner;



public interface OwnerService  extends CrudService<Owner,Long>{
public Owner findbByLastName(String lastName);
}
