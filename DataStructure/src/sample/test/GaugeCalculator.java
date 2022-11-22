package sample.test;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class GaugeCalculator {

	public Queue<Double> loss;
	private int limit = 30;

	public GaugeCalculator(int limit) {
		this.limit = limit;
		this.loss = new LinkedBlockingQueue<>(this.limit);
	}

	public GaugeCalculator(int limit, Queue<Double> loss) {
		this.limit = limit;
		if (loss == null) {
			this.loss = new LinkedBlockingQueue<>(this.limit);
		} else {
			this.loss = loss;
		}
	}

	public double getLossAverage() {
		double returnValue = 0.0;
		if (this.loss != null) {
			Iterator<Double> lossItr = loss.iterator();
			while (lossItr.hasNext()) {
				returnValue += lossItr.next();
			}
			// System.out.println("returnValue = " + returnValue);
			returnValue = returnValue / this.limit;
		}
		return returnValue;
	}

	public void addLoss(double loss) {
		if (this.loss != null) {
			// System.out.println("size = " +this.loss.size());
			if (this.loss.size() == this.limit)
				this.loss.poll();
			this.loss.add(loss);

		}
	}

}
