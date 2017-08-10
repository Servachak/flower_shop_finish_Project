package com.flower_shop.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Flower {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String color;
	private int price;
	
	@ManyToMany
	@JoinTable(name = "flower_country", joinColumns = @JoinColumn(name = "id_country"), inverseJoinColumns = @JoinColumn(name = "flower_id"))
	private List<Country> countrys = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "user_flower", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_Flower"))
	private List<User> users = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "orders_flower", joinColumns = @JoinColumn(name = "id_orders"), inverseJoinColumns = @JoinColumn(name = "id_flower"))
	private List<Orders> orders = new ArrayList<>();
	
	public Flower() {
		
	}

	public Flower(String name, String color, int price) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Country> getCountrys() {
		return countrys;
	}

	public void setCountrys(List<Country> countrys) {
		this.countrys = countrys;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Flower [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + "]";
	}
	
	
}
