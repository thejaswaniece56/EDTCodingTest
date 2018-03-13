package com.practice;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * This program compares the Employee objects saved in the TreeSet
 * and the results displayed to the standard output.
 * 
 * Compare by last name and age are implemented.
 *
 * @author  Thejaswani
 * @version 1.0
 * @since   2018-03-13 
 */
public class MyComparatorImpl {

	public static void main(String[] args) {
		// Defining the TreeSet with name comparator and age comparator
		TreeSet<Employee> nameTreeSet = new TreeSet<Employee>(new MyNameComp());
		nameTreeSet.add(new Employee("John", "Smith", 25));
		nameTreeSet.add(new Employee("Adam", "Jones", 36));
		nameTreeSet.add(new Employee("Jonathan", "Davis", 40));
		for (Employee emp : nameTreeSet) {
			System.out.println("Name Comparator : "+emp.getLastName());
		}

		TreeSet<Employee> ageTreeSet = new TreeSet<Employee>(new MyAgeComp());
		ageTreeSet.add(new Employee("Adam", "Jones", 36));
		ageTreeSet.add(new Employee("John", "Smith", 25));
		ageTreeSet.add(new Employee("Jonathan", "Davis", 40));
		for (Employee emp : ageTreeSet) {
			System.out.println("Age Comparator : "+emp.getAge());
		}
	}

}

/*
 * Defining the name comparator class
 */
class MyNameComp implements Comparator<Employee>{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getLastName().compareTo(emp2.getLastName());
	}

}

/*
 * Defining the age comparator class
 */
class MyAgeComp implements Comparator<Employee>{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		if (emp1.getAge() > emp2.getAge()) 
			return 1;
		else
			return -1;
	}

}

/*
 * Defining the Employee object class
 */
class Employee {

	private String firstName;
	private String lastName;
	private int age;

	public Employee(String fName, String lName, int age) {
		this.firstName = fName;
		this.lastName = lName;
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fName) {
		this.firstName = fName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lName) {
		this.lastName = lName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}