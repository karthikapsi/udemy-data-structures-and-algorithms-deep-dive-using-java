package sample.test;

public class SampleThread extends Thread {
	
	String name;
	
	public SampleThread(String name) {
		this.name = name;
	}
	
	public void run() {		
		System.out.println("New Thread " + this.name + getName());				
	}
	
	public static void main(String[] args) {
		SampleThread st = new SampleThread("Thread 1");
		SampleThread st1 = new SampleThread("Thread 2");
		SampleThread st2 = new SampleThread("Thread 3");
		st.setName("Threads");
		st.start();
		st1.start();
		st2.start();
	}

}
