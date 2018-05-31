package com.example.demo.domain;

/*
 * 젤 처음에 test로 사용해봤던 member domain
 */
public class PreviousMember {

	private long idx;
	private String email;
	private String name;
	
	public PreviousMember() {
	}
	
	public PreviousMember(long idx, String email, String name) {
		this.email = email;
		this.name = name;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
