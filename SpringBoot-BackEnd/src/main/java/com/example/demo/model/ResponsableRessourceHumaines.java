package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.employee.Employee;

@Entity
@Table(name = "Responsable_RH")
public class ResponsableRessourceHumaines extends Employee {

	@OneToMany
	private Collection<Payment> payments = new ArrayList<Payment>();

	public Collection<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Collection<Payment> payments) {
		this.payments = payments;
	}

}
