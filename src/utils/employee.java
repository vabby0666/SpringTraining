package utils;

public class employee {
	String name;
	int code;
	int sal;
	

	public employee(String name, int code, int sal) {
		super();
		this.name = name;
		this.code = code;
		this.sal = sal;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
}
