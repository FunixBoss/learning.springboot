package com.learning.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.models.Language;
import com.learning.services.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService{

	@Override
	public List<Language> findAll() {
		List<Language> languages = new ArrayList<>();
		languages.add(new Language("lang1", "Japanese"));
		languages.add(new Language("lang2", "Vietnamese"));
		languages.add(new Language("lang3", "English"));
		languages.add(new Language("lang4", "Chinese"));

		return languages;
	}

}
