package com.example.spring02.part1_ch05;

public class ProductVO {
	private String name;
	private double price;
	
	// 생성자, getter/setter, toString()
	public ProductVO() {
		// TODO Auto-generated constructor stub
	}

	public ProductVO(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + "]";
	} 
	
	
	
	
	
}
