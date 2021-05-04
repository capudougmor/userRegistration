package com.home.UserRegistration.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.home.UserRegistration.entities.Address;
import com.home.UserRegistration.entities.User;
import com.home.UserRegistration.services.AddressService;
import com.home.UserRegistration.services.UserService;

@RestController
@RequestMapping(value = "/addresses")
public class AddressResource {
	
	@Autowired
	private AddressService service;
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Address> insert(@PathVariable Long id, @Valid @RequestBody Address obj)  {
		User user = userService.findById(id);
		obj.setUser(user);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}
