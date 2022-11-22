package sample.test;

public class HelloWorld {

	public HelloWorld() {
		System.out.println(this.getClass());
	}
	public static void main(String[] args) {
		new HelloWorld();
		System.out.println("Hello World");
	}
	
}