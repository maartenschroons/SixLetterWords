package com.sixletterwords.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.sixletterwords.model.Word;

public class TestWordservice {

	@Test
	void testWordSetLength() throws IndexOutOfBoundsException {
		Word word = new Word("test");
		assertTrue(word.getLength() == 4);
	}

	@Test
	void testGetCompletedWord() {
		List<Word> words = new ArrayList<Word>();
		words.add(new Word("harl"));
		words.add(new Word("ey"));
		words.add(new Word("harley"));

		words.add(new Word("tig"));
		words.add(new Word("ger"));
		words.add(new Word("tigger"));

		words.add(new Word("p"));
		words.add(new Word("resto"));
		words.add(new Word("presto"));

		WordService service = new WordService(words);
		service.getCompletedWords();

		assertEquals(service.foundWords.get(0).getWord(), "harley");
		assertEquals(service.foundWords.get(1).getWord(), "tigger");
		assertEquals(service.foundWords.get(2).getWord(), "presto");
	}

	@Test
	void testNoCompletedWordsFound() {
		List<Word> words = new ArrayList<Word>();
		words.add(new Word("harl"));
		words.add(new Word("ey"));
		words.add(new Word("presto"));

		WordService service = new WordService(words);
		service.getCompletedWords();

		assertEquals(service.foundWords.size(), 0);
	}

	@Test
	void testReadFromGivenFile() {
		List<Word> words = new ArrayList<Word>();

		try {
			Scanner s;
			s = new Scanner(new File("testFiles/input.txt"));
			while (s.hasNext()) {
				words.add(new Word(s.next()));

			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		WordService service = new WordService(words);
		service.getCompletedWords();

		assertEquals(service.foundWords.size(), 43664);
	}

	@Test
	void testReadFromNewFile() {
		List<Word> words = new ArrayList<Word>();

		try {
			Scanner s;
			s = new Scanner(new File("testFiles/input2.txt"));
			while (s.hasNext()) {
				words.add(new Word(s.next()));

			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		WordService service = new WordService(words);
		service.getCompletedWords();

		assertEquals(service.foundWords.size(), 2);
	}

}
