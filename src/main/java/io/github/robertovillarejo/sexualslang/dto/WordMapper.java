package io.github.robertovillarejo.sexualslang.dto;

import java.util.ArrayList;
import java.util.List;

import edu.upc.freeling.ListPairStringDouble;
import edu.upc.freeling.PairStringDouble;
import edu.upc.freeling.Word;
import io.github.robertovillarejo.sexualslang.SenseDTO;

public class WordMapper {
	
	public static WordDTO toDTO(Word w) {
		WordDTO dto = new WordDTO();
		dto.setForm(w.getForm());
		dto.setLemma(w.getLemma());
		dto.setSensesString(w.getSensesString());
		List<SenseDTO> senses = sensesToDTO(w.getSenses());
		dto.setSenses(senses);
		return dto;
	}
	
	public static List<SenseDTO> sensesToDTO(ListPairStringDouble senses) {
		List<SenseDTO> results = new ArrayList<>();
		while (!senses.empty()) {
			SenseDTO sense = new SenseDTO();
			PairStringDouble pairStringDouble = senses.front();
			sense.setSense(pairStringDouble.getFirst());
			sense.setProbability(pairStringDouble.getSecond());
			senses.popFront();
			results.add(sense);
		}
		return results;
	}

}
