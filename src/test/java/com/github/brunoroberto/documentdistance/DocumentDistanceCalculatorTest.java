package com.github.brunoroberto.documentdistance;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.github.brunoroberto.documentdistance.time.ExecutionTimePrinter;

public class DocumentDistanceCalculatorTest {

	@Test
	public void differentDocumentTest() {
		System.out.println("\ndifferentDocumentTest");

		String text1 = "The roses are red";
		String text2 = "Be or not to be";

		double distance = calculateSimilarity(text1, text2);
		printSimiliarity(distance);

		assertEquals(0.0, distance, 0.0);
	}

	@Test
	public void identicalDocumentTest() {
		System.out.println("\nidenticalDocumentTest");

		String text1 = "The roses are red";
		String text2 = "The roses are red";

		double distance = calculateSimilarity(text1, text2);
		printSimiliarity(distance);

		assertEquals(1.0, distance, 0.0);
	}

	@Test
	public void almostSameDocumentTest() {
		System.out.println("\nalmostSameDocumentTest");

		String text1 = "The roses are red";
		String text2 = "The roses are pink";

		double distance = calculateSimilarity(text1, text2);
		printSimiliarity(distance);

		assertEquals(0.75, distance, 0.0);
	}

	private double calculateSimilarity(String text1, String text2) {
		DocumentDistanceCalculator distanceCalculator = new DocumentDistanceCalculator();
		double distance = distanceCalculator.distance(new Document(text1), new Document(text2));
		ExecutionTimePrinter.print(distanceCalculator.getExecutionTime());
		return distance;
	}

	private void printSimiliarity(double distance) {
		System.out.println(String.format("similar=%.1f%%", distance * 100));
	}

}
