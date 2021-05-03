package com.home.UserRegistration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.UserRegistration.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByCpf(String cpf);
	User findByEmail(String email);
}
