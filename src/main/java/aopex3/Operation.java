package aopex3;

import org.springframework.stereotype.Component;

@Component
public class Operation {
	public void msg() {
		System.out.println("msg method invoked");
	}
	public int m() {
		System.out.println("m method invoked");
		return 1;
	}
	public void k() {
		System.out.println("k method invoked");
	}
}
