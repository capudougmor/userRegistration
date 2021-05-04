package com.home.UserRegistration.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_Address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Street cannot be empty or null")
	private String street;
	@NotEmpty(message = "Number cannot be empty or null")
	private String num;
	@NotEmpty(message = "Complement cannot be empty or null")
	private String complement;
	@NotEmpty(message = "District cannot be empty or null")
	private String district;
	@NotEmpty(message = "City cannot be empty or null")
	private String city;
	@NotEmpty(message = "State cannot be empty or null")
	private String state;
	@NotEmpty(message = "CEP cannot be empty or null")
	private String cep;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Address() {
	}

	public Address(Long id, String street, String num, String complement, String district, String city, String state, String cep,
			User user) {
		super();
		this.id = id;
		this.street = street;
		this.num = num;
		this.complement = complement;
		this.district = district;
		this.city = city;
		this.state = state;
		this.cep = cep;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
