package com.sixletterwords.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sixletterwords.model.Word;
import com.sixletterwords.util.WordUtilities;

@Service
public class WordService {

	private static final Logger logger = LoggerFactory.getLogger(WordService.class);

	List<Word> allWords = new ArrayList<Word>();
	List<Word> completeWords = new ArrayList<Word>();
	List<Word> incompleteWords = new ArrayList<Word>();
	public List<Word> foundWords = new ArrayList<Word>();

	public WordService(List<Word> words) {
		allWords = words;
		getAllCompleteWords();
		getAllIncompleteWords();
	}

	public List<Word> getCompletedWords() {
		for (Word word : incompleteWords) {
			handleIncompleteWord(word);
		}
		return foundWords;
	}

	private void handleIncompleteWord(Word word) {
		if (word.getLength() < WordUtilities.MAXIMUM_LETTERS) {
			List<Word> wordsbyMatchingLength = getWordsByLength(WordUtilities.MAXIMUM_LETTERS - word.getLength());
			for (Word MatchingLengthword : wordsbyMatchingLength) {
				String possibleWord = word.getWord() + MatchingLengthword.getWord();
				Word completedword = getCompleteWordByName(possibleWord);

				if (completedword != null) {
					logger.info(word.getWord() + "+" + MatchingLengthword.getWord() + "=" + possibleWord);
					foundWords.add(completedword);
				}
			}
		}
	}

	public void getAllCompleteWords() {
		for (Word word : allWords) {
			if (word.getLength() == WordUtilities.MAXIMUM_LETTERS) {
				completeWords.add(word);
			}
		}
	}

	public void getAllIncompleteWords() {
		for (Word word : allWords) {
			if (word.getLength() < WordUtilities.MAXIMUM_LETTERS) {
				incompleteWords.add(word);
			}
		}
	}

	public List<Word> getWordsByLength(int wordLength) {
		List<Word> wordsByLength = new ArrayList<>();
		for (Word word : incompleteWords) {
			if (word.getLength() == wordLength) {
				wordsByLength.add(word);
			}
		}
		return wordsByLength;
	}

	public Word getCompleteWordByName(String newWord) {
		for (Word word : completeWords) {
			if (newWord.equals(word.getWord())) {
				return word;
			}
		}
		return null;
	}
}
