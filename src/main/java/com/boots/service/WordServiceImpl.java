package com.boots.service;

import com.boots.model.Word;
import com.boots.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {

	@Autowired
	private WordRepository wordRepository;

	@Override
	public List<Word> getWordsByUser(String user) {
		return wordRepository.findByUser(user);
	}

	@Override
	public Optional<Word> getWordsById(long id) {
		return wordRepository.findById(id);
	}

	@Override
	public void updateWord(Word word) {
		wordRepository.save(word);
	}

	@Override
	public void addWord(String user, String eng, String rus, String description, boolean isDone) {
		wordRepository.save(new Word(user, eng, rus, description, isDone));
	}

	@Override
	public void deleteWord(long id) {
		Optional<Word> word = wordRepository.findById(id);
		if (word.isPresent()) {
			wordRepository.delete(word.get());
		}
	}

	@Override
	public void saveWord(Word word) {
		wordRepository.save(word);
	}
}