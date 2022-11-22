package sample.test;


public class SumOfArray {
	public static void main(String[] args) {
		GaugeCalculator gc = new GaugeCalculator(30);
		System.out.println("gc Average " + gc.getLossAverage());
		for (int i = 0; i < 50; i++) {
			gc.addLoss(i);
		}
		System.out.println("gc Average " + gc.getLossAverage());
	}
}
