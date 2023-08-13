package com.sixletterwords.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sixletterwords.util.WordUtilities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Word {

	private static final Logger logger = LoggerFactory.getLogger(Word.class);

	private @Id @GeneratedValue Long id;
	private int length;
	private String word;

	public Word(String word) throws IndexOutOfBoundsException {
		this.word = word;
		setLength();
	}

	public Word() {
	}

	public Long getId() {
		return this.id;
	}

	public int getLength() {
		return length;
	}

	public String getWord() {
		return word;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLength() {
		if (word.length() <= WordUtilities.MAXIMUM_LETTERS) {
			this.length = word.length();
		} else {
			logger.warn(word + " has too many letters! There is only a maximum of " + WordUtilities.MAXIMUM_LETTERS
					+ " letters allowed!");
		}
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return this.word;
	}
}
