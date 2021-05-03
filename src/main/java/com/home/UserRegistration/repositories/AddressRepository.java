package com.home.UserRegistration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.UserRegistration.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
