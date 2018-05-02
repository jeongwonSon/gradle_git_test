package com.example.demo.dao;

public class Car {
	
	public int door;
	public String color;

	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public Car(){
		// default setting
		this.door = 4;
	}
}
