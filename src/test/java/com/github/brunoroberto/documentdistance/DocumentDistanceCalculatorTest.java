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

		System.out.println("Text1 = " + text1);
		System.out.println("Text2 = " + text2);

		double distance = calculateDistance(text1, text2);
		printDistance(distance);

		assertEquals((Math.PI / 2), distance, 0.0);
	}

	@Test
	public void identicalDocumentTest() {
		System.out.println("\nidenticalDocumentTest");

		String text1 = "The roses are red";
		String text2 = "The roses are red";

		System.out.println("Text1 = " + text1);
		System.out.println("Text2 = " + text2);

		double distance = calculateDistance(text1, text2);
		printDistance(distance);

		assertEquals(0.0, distance, 0.0);
	}

	@Test
	public void almostSameDocumentTest() {
		System.out.println("\nalmostSameDocumentTest");

		String text1 = "The roses are red";
		String text2 = "The roses are pink";

		System.out.println("Text1 = " + text1);
		System.out.println("Text2 = " + text2);

		double distance = calculateDistance(text1, text2);
		printDistance(distance);

		assertEquals(0.7227342478134157, distance, 0.0);
	}

	private double calculateDistance(String text1, String text2) {
		DocumentDistanceCalculator distanceCalculator = new DocumentDistanceCalculator();
		double distance = distanceCalculator.distance(new Document(text1), new Document(text2));
		ExecutionTimePrinter.print(distanceCalculator.getExecutionTime());
		return distance;
	}

	private void printDistance(double distance) {
		System.out.println(String.format("distance=%.2f - %s\n", distance, strDistance(distance)));
	}

	private String strDistance(double distance) {
		if (distance == 0.0)
			return "Similar";
		else if (distance >= (Math.PI / 2))
			return "Different";
		return "Almost similar";
	}

}
