package com.sixletterwords.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sixletterwords.model.Word;
import com.sixletterwords.service.WordService;

@RestController
class Wordcontroller {
	private final WordRepository repository;

	public Wordcontroller(WordRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/words")
	List<Word> all() {
		return repository.findAll();
	}

	@PostMapping("/file")
	List<Word> newWord(@RequestParam("file") File file) {
		List<Word> words = new ArrayList<Word>();
		try {
			Scanner s;
			s = new Scanner(file);
			while (s.hasNext()) {
				words.add(new Word(s.next()));

			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		WordService service = new WordService(words);
		service.getCompletedWords();

		for (Word word : service.foundWords) {
			repository.save(word);
		}

		return service.foundWords;
	}
}
