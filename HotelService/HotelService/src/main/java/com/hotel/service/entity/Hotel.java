package com.hotel.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="hotel")
public class Hotel {
	
	@Id
	@Column(name="Id")
	private String id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="Contact")
	private Long contact;
}