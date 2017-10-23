package io.github.robertovillarejo.sexualslang.service;

import java.util.List;

import io.github.robertovillarejo.sexualslang.dto.WordDTO;


public interface SemanticDBAnalyzer {
	
	public void analyze(List<List<WordDTO>> listSentence);

}
