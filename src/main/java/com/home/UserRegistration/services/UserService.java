package com.home.UserRegistration.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.UserRegistration.entities.User;
import com.home.UserRegistration.repositories.UserRepository;
import com.home.UserRegistration.services.exceptions.BadRequestExceptions;
import com.home.UserRegistration.services.exceptions.PropertyValueException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User insert(User user) throws RuntimeException {
		User obj = repository.findByCpf(user.getCpf());
		User obj2 = repository.findByEmail(user.getEmail());
			if(obj != null || obj2 != null ) {
				throw new PropertyValueException();
			}
			return repository.save(user);
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new BadRequestExceptions());
	}
}
