package com.boots.service;

import com.boots.model.Word;
import java.util.List;
import java.util.Optional;

public interface WordService {

	List<Word> getWordsByUser(String user);

	Optional<Word> getWordsById(long id);

	void updateWord(Word word);

	void addWord(String user, String eng, String rus, String description, boolean isDone);

	void deleteWord(long id);
	
	void saveWord(Word word);
}