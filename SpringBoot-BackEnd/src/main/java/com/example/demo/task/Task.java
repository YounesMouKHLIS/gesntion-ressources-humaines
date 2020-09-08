package com.example.demo.task;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "Desciptrion")
	private String description;
	@Column(name = "Day_Start")
	private Date day_start;
	@Column(name = "Day_End")
	private Date day_end;
	@Column(name = "State")
	private String Statee;

	/*
	 * @ManyToOne private Employee employee;
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDay_start() {
		return day_start;
	}

	public void setDay_start(Date day_Start) {
		this.day_start = day_Start;
	}

	public Date getDay_end() {
		return day_end;
	}

	public void setDay_end(Date day_end) {
		this.day_end = day_end;
	}

	public String getStatee() {
		return Statee;
	}

	public void setStatee(String statee) {
		Statee = statee;
	}

	/*
	 * public Employee getEmployee() { return employee; }
	 * 
	 * public void setEmployee(Employee employee) { this.employee = employee; }
	 */

}
