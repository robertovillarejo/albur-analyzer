package io.github.robertovillarejo.sexualslang.service;

import java.util.List;

import io.github.robertovillarejo.sexualslang.dto.WordDTO;

public interface AnalyzerService {

	public List<List<WordDTO>> analyze(String text);
	
}
