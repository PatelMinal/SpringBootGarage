package com.minal.springboot.database.hello.mySpringBootDatabaseGarage.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vehicle")
@EntityListeners(AuditingEntityListener.class)

public class mySpringBootGarageDataModel implements Serializable{ 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotBlank
	private String type;
	
	@NotBlank
	private String colour;
	
	private Integer model;
	
	public mySpringBootGarageDataModel() {}
	public mySpringBootGarageDataModel(String type, String colour, int model) {
		this.type = type;
		this.colour = colour;
		this.model = model;
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}
}
