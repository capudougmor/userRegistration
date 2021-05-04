package com.home.UserRegistration.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.home.UserRegistration.entities.Address;
import com.home.UserRegistration.entities.User;
import com.home.UserRegistration.repositories.AddressRepository;
import com.home.UserRegistration.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", Instant.parse("2019-06-20T19:53:07Z"));
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", Instant.parse("2019-06-20T19:53:07Z"));
		
		Address a1 = new Address(null, "Dr Lima", "256", " ", "Pampulha", "Uberlandia", "MG", "38408045", u1);
		Address a2 = new Address(null, "Segismundo", "4856", " ", "Finote", "Uberlandia", "MG", "384106755", u2);
		Address a3 = new Address(null, "Dos Perreira", "78", " ", "Centro", "Uberlandia", "MG", "38403712", u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		addressRepository.saveAll(Arrays.asList(a1, a2, a3));
	}

}
