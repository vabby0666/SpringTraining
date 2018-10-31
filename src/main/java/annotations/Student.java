package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Value("511")
	private int stdcode;
	@Value("Vabby")
	private String stdname;
	@Value("67.03")
	private Double stdavg;
	@Autowired
	Marks marks;
	
	
	public Marks getMarks() {
		return marks;
	}
	public void setMarks(Marks marks) {
		this.marks = marks;
	}
	public int getStdcode() {
		return stdcode;
	}
	public void setStdcode(int stdcode) {
		this.stdcode = stdcode;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public Double getStdavg() {
		return stdavg;
	}
	public void setStdavg(Double stdavg) {
		this.stdavg = stdavg;
	}
	
	
}
