package com.github.brunoroberto.documentdistance;

import java.util.HashMap;
import java.util.Map;

/**
 * Document distance problem: we have two documents D1 and D2 and we want to
 * compute the distance between them.
 * 
 * What is distance?
 * 
 * Distance here means finding out whether the documents are similar or not
 * 
 * Document = Sequence of words (string)
 * 
 * Word = Sequence of alphanumeric characters (separated by spaces)
 * 
 * So the idea in this problem is to find the shared words between documents and
 * use that to define distance.
 * 
 * @author brunoroberto
 *
 */
public class Document {

	private static final String WORD_SEPARATOR = " ";

	private Map<String, Integer> frequencies = new HashMap<>();

	private String[] words;

	public Document(String words) {
		splitWords(words);
		countFrequency();
	}

	private void splitWords(String words) {
		this.words = words.split(WORD_SEPARATOR);
	}

	private void countFrequency() {
		for (String word : this.words) {
			frequencies.putIfAbsent(word, 0);
			frequencies.put(word, frequencies.get(word) + 1);
		}
	}

	public int getFrequency(String word) {
		return this.frequencies.getOrDefault(word, 0);
	}

	public int length() {
		return this.words.length;
	}

	public String[] getWords() {
		return this.words;
	}

}
