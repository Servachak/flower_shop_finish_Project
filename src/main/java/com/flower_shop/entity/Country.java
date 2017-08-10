package com.flower_shop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToMany(cascade=CascadeType.REMOVE)
	@JoinTable(name = "flower_country", joinColumns = @JoinColumn(name = "flower_id"), inverseJoinColumns = @JoinColumn(name = "id_country"))
	private List<Flower> flowers;

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + "]";
	}

	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Flower> getFlovers() {
		return flowers;
	}

	public void setFlovers(List<Flower> flowers) {
		this.flowers = flowers;
	}
	
	
}
