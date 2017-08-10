package com.flower_shop.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate date;
	
	
	@ManyToMany
	@JoinTable(name = "orders_flower", joinColumns = @JoinColumn(name = "id_flower"), inverseJoinColumns = @JoinColumn(name = "id_orders"))
	private List<Flower> flowers = new ArrayList<Flower>();
	
	@ManyToOne
	private User user;

	@Override
	public String toString() {
		return "Orders [id=" + id + ", date=" + date + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(List<Flower> flowers) {
		this.flowers = flowers;
	}

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(LocalDate date) {
		super();
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
