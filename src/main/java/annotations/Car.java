package annotations;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	/*@Autowired
	@Qualifier("ceat")
	Wheels wheels;

	public Wheels getWheels() {
		return wheels;
	}

	public void setWheels(Wheels wheels) {
		this.wheels = wheels;
	}*/
	public void moving(String wheelType) {
		Wheels wh=(str)->{
			System.out.println(str+"ceat wheels are moving");
		};
		
		wh.rotate(wheelType);
		wh.material();
		System.out.println("Car is Moving..");
	}
}
