package core;

public class Student {
	private String studname;
	private int studmarks;
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getStudname() {
		return studname;
	}
	public void setStudname(String studname) {
		this.studname = studname;
	}
	public int getStudmarks() {
		return studmarks;
	}
	public void setStudmarks(int studmarks) {
		this.studmarks = studmarks;
	}
	
}
