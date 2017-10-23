package io.github.robertovillarejo.sexualslang.dto;

import java.util.ArrayList;
import java.util.List;

import edu.upc.freeling.ListSentence;
import edu.upc.freeling.ListSentenceIterator;
import edu.upc.freeling.ListWordIterator;
import edu.upc.freeling.Sentence;
import edu.upc.freeling.Word;

public class SentenceMapper {
	
	public static List<WordDTO> toDTO(Sentence s) {
		List<WordDTO> sentence = new ArrayList<>();
		ListWordIterator lwIt = new ListWordIterator(s);
		while (lwIt.hasNext()) {
			Word w = lwIt.next();
			sentence.add(WordMapper.toDTO(w));
		}
		return sentence;
	}
	
	public static List<List<WordDTO>> toListSentenceDTO(ListSentence ls) {
		List<List<WordDTO>> listSentence = new ArrayList<>();
		ListSentenceIterator lsIt = new ListSentenceIterator(ls);
		while (lsIt.hasNext()) {
			Sentence s = lsIt.next();
			listSentence.add(toDTO(s));
		}
		return listSentence;
	}

}
