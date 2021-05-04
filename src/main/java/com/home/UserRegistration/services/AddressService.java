package com.home.UserRegistration.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.UserRegistration.entities.Address;
import com.home.UserRegistration.repositories.AddressRepository;
import com.home.UserRegistration.services.exceptions.PropertyValueException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;
	
	@Transactional
	public Address insert(Address address) throws RuntimeException{
		try {
			return repository.save(address);
			
		} catch(RuntimeException e) {
			throw new PropertyValueException();
		}
	}
}
