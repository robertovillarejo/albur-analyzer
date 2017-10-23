package io.github.robertovillarejo.sexualslang.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.robertovillarejo.sexualslang.dto.WordDTO;
import io.github.robertovillarejo.sexualslang.service.AnalyzerService;

@RestController
@RequestMapping("/api")
public class AnalyzerController {
	
	private AnalyzerService analyzer;
		
	public AnalyzerController(AnalyzerService analyzer) {
		this.analyzer = analyzer;
	}
	
	@GetMapping("/analyze")
	public List<List<WordDTO>> analyze(@RequestBody String text) {
		return analyzer.analyze(text);
	}

}
