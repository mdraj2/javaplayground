package com.fdm.relationships.manyToMany;

import java.util.ArrayList;
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
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	// persists all associated products
	@ManyToMany(cascade = CascadeType.ALL)
	//@JoinTable(name = "STORE_PRODUCT_JOIN", joinColumns = @JoinColumn(name = "STORE_ID_FK"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID_FK)"))
	private List<Product> product = new ArrayList<Product>();

	public Store() {
		super();
	}

	public Store(String name) {
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

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public void add(Product product) {
		this.product.add(product);

	}

}
