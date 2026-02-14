package com.capgemini.OneToOneUnidirectional;

import jakarta.persistence.*;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long employeeId;
	private String name;
	private String department;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Locker locker;
	public Employee() {
		
	}

	public Employee(String name, String department,Locker locker) {
		this.name = name;
		this.department = department;
		this.locker=locker;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + employeeId + ", name=" + name + ", department=" + department + "]";
	}
}
