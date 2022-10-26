package com.ey.spr;

public class PersnBean {
	private int id;
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
	private String name;
	public void print() {
		System.out.println(id+"\t"+name);
	}

}
