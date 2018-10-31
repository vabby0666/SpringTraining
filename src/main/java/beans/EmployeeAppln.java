package beans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"beans"})
public class EmployeeAppln {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppln.class, args);
	}
}//http://localhost:1234/springbootmvc/