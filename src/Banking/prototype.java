package Banking;

public class prototype {
	int AcNo;
	String Name;
	double Bal;
	

	public prototype() {
		super();
		// TODO Auto-generated constructor stub
	}

	public prototype(int AcNo,String name,double Bal) {
		super();
		this.AcNo = AcNo;
		this.Name = name;
		this.Bal = Bal;
	}

	public int getAcNo() {
		return AcNo;
	}

	public void setAcNo(int acNo) {
		AcNo = acNo;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getBal() {
		return Bal;
	}

	public void setBal(double bal) {
		Bal = bal;
	}

}
