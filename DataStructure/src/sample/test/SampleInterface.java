package sample.test;

public class SampleInterface implements ISampleInterface {

	@Override
	public void getDetail() {	
		System.out.println("Detail 1");
	}
	
	
	@Override
	public void getName() {
		System.out.println("Name 1");
	}
}
