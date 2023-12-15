package com.example.demo;
public class person
{
	@Override
	public String toString() {
		return "person [Name=" + Name + ", age=" + age + ", Address=" + address + "]";
	}
		// TODO Auto-generated method stub
		

	private int age;
	private String address;
	private String Name;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
}
