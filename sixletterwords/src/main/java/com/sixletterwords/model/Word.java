package com.sixletterwords.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Word {

	private @Id @GeneratedValue Long id;
	private int length;
	private String word;

	public Word(String word) {
		super();
		this.word = word;
		this.length = word.length();
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

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "id=" + this.id + ", word='" + this.word;
	}
}
