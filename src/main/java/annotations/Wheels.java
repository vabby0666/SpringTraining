package annotations;

public interface Wheels {
 void rotate(String str);

default void material() {
	System.out.println("Material used for Wheels are rubber");
}
}
