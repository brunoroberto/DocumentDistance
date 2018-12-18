package com.github.brunoroberto.documentdistance;

import com.github.brunoroberto.documentdistance.time.ExecutionTime;

/**
 * 
 * @author brunoroberto
 *
 */
public class DocumentDistanceCalculator {

	private ExecutionTime executionTime = new ExecutionTime();

	public ExecutionTime getExecutionTime() {
		return this.executionTime;
	}

	public double distance(Document d1, Document d2) {
		this.executionTime.start();
		try {
			String[] words = getBiggest(d1, d2).getWords();
			int product = calculateProd(words, d1, d2);
			return Math.acos(product / Math.sqrt(d1.length() * d2.length()));
		} finally {
			this.executionTime.stop();
		}
	}

	private int calculateProd(String[] words, Document d1, Document d2) {
		int sum = 0;
		for (String word : words)
			sum += d1.getFrequency(word) * d2.getFrequency(word);
		return sum;
	}

	private Document getBiggest(Document d1, Document d2) {
		if (d1.length() >= d2.length())
			return d1;
		return d2;
	}

}
