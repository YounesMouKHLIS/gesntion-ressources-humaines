package com.example.demo.team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.model.Service;;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "Libelle")
	private String libelle;
	@Column(name = "Description")
	private String description;
	@OneToMany
	/*
	 * @ElementCollection private Collection<Employee> employees = new
	 * ArrayList<Employee>();
	 */
	@ManyToOne
	private Service service;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * public Collection<Employee> getEmployees() { return employees; }
	 * 
	 * public void setEmployees(Collection<Employee> employees) { this.employees =
	 * employees; }
	 */

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

}
