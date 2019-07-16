package com.tugbakaya.userrepository.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	private String surname;

	private Date birthDate;

	@CreationTimestamp
	private Date creationDate;

	@Column(nullable = false)
	private boolean oldUser;

	@OneToMany(cascade=CascadeType.ALL)
	List<AdressEntity> adresses;
}
