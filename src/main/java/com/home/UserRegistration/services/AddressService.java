package com.home.UserRegistration.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.UserRegistration.entities.Address;
import com.home.UserRegistration.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;
	
	@Transactional
	public Address insert(Address address) {
			return repository.save(address);
	}
	

}
