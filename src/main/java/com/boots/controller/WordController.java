package com.boots.controller;

import com.boots.model.Word;
import com.boots.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;

@Controller
public class WordController {

	@Autowired
	private WordService wordService;

	@RequestMapping(value = "/list-words", method = RequestMethod.GET)
	public String showWords(ModelMap model) {
		String user = getLoggedInUser(model);
		model.put("word", wordService.getWordsByUser(user));
		return "list-words";
	}

	private String getLoggedInUser(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@RequestMapping(value = "/add-word", method = RequestMethod.GET)
	public String showAddWordPage(ModelMap model) {
		model.addAttribute("word", new Word());
		return "word";
	}

	@RequestMapping(value = "/delete-word", method = RequestMethod.GET)
	public String deleteWord(@RequestParam long id) {
		wordService.deleteWord(id);
		return "redirect:/list-words";
	}

	@RequestMapping(value = "/update-word", method = RequestMethod.GET)
	public String showUpdateWordPage(@RequestParam long id, ModelMap model) {
		Word word = wordService.getWordsById(id).get();
		model.put("word", word);
		return "word";
	}

	@RequestMapping(value = "/update-word", method = RequestMethod.POST)
	public String updateWord(ModelMap model, @Valid Word word, BindingResult result) {

		if (result.hasErrors()) {
			return "word";
		}

		word.setUser(getLoggedInUser(model));
		wordService.updateWord(word);
		return "redirect:/list-words";
	}

	@RequestMapping(value = "/add-word", method = RequestMethod.POST)
	public String addWord(ModelMap model, @Valid Word word, BindingResult result) {

		if (result.hasErrors()) {
			return "word";
		}

		word.setUser(getLoggedInUser(model));
		wordService.saveWord(word);
		return "redirect:/list-words";
	}
}
