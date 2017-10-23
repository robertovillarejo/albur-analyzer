package io.github.robertovillarejo.sexualslang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.upc.freeling.Analysis;
import edu.upc.freeling.Dictionary;
import edu.upc.freeling.ListAnalysis;
import edu.upc.freeling.ListSentence;
import edu.upc.freeling.ListSentenceIterator;
import edu.upc.freeling.ListWordIterator;
import edu.upc.freeling.Senses;
import edu.upc.freeling.Sentence;
import edu.upc.freeling.Word;
import io.github.robertovillarejo.sexualslang.Analyzer;

@Component("slangAnalyzer")
public class SlangAnalyzer implements Analyzer{
	
	@Autowired
	@Qualifier("dictSlang")
	private Dictionary dictSlang;
	
	@Autowired
	@Qualifier("sensesSlang")
	private Senses sensesSlang;

	@Override
	public void analyze(ListSentence ls) {
		dictionarySearch(ls);
		sensesSlang.analyze(ls);
	}
	
	private void dictionarySearch(Word w) {
        ListAnalysis lsAn;
        lsAn = new ListAnalysis();
        dictSlang.searchForm(w.getLcForm(), lsAn);
        addAnalysis(w, lsAn);
    }
	
	private void addAnalysis(Word w, ListAnalysis lsAn) {
        
        while (!lsAn.empty()) {
        	Analysis analysis;
            analysis = lsAn.front();
            w.getAnalysis().pushBack(analysis);
            lsAn.popFront();
        }

    }
	
	private void dictionarySearch(Sentence s) {
        ListWordIterator lwIt;
        lwIt = new ListWordIterator(s);

        while (lwIt.hasNext()) {
            Word w = lwIt.next();
            dictionarySearch(w);
        }
    }
	
	private void dictionarySearch(ListSentence ls) {
        ListSentenceIterator lsIt;
        lsIt = new ListSentenceIterator(ls);

        while (lsIt.hasNext()) {
            Sentence s = lsIt.next();
            dictionarySearch(s);
        }
    }

}
