package com.address.model;

public class AddressDTO {//Bean과 DTO는 같은개념
	private int num;
	private String name,addr,zipcode,tell;
	public int getNum() {
		return num;
	}
	public String getName() {
		return name == null ? "" : name.trim();
	}
	public String getAddr() {
		return addr == null ? "" : addr.trim();
	}
	public String getZipcode() {
		return zipcode == null ? "" : zipcode.trim();
	}
	public String getTell() {
		return tell == null ? "" : tell.trim();
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	
}
