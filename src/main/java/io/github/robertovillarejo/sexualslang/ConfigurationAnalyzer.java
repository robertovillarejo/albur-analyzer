package io.github.robertovillarejo.sexualslang;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.upc.freeling.Dictionary;
import edu.upc.freeling.HmmTagger;
import edu.upc.freeling.Maco;
import edu.upc.freeling.MacoOptions;
import edu.upc.freeling.SemanticDB;
import edu.upc.freeling.Senses;
import edu.upc.freeling.Splitter;
import edu.upc.freeling.Tokenizer;

@Configuration
public class ConfigurationAnalyzer {
	
	private final String data;
	private final String lang;
	
	public ConfigurationAnalyzer(Freeling freeling) {
		data = freeling.data;
		lang = freeling.lang;
	}
	
	@Bean
	public SemanticDB propertySemanticDB() {
		return new SemanticDB(data + lang + "/semdb.dat");
	}
	
	@Bean(name="dict")
	public Dictionary propertyDictionary() {
		return new Dictionary(lang, data + lang + "/dicc.src", data + lang + "/afixos.dat", data + lang + "/compounds.dat", false, true);
	}
	
	@Bean(name="dictSlang")
	public Dictionary propertyDictionarySlang() {
		return new Dictionary(lang, data + lang + "/albur/dicc.src", data + lang + "/afixos.dat", data + lang + "/compounds.dat", false, true);
	}
	
	@Bean(name="senses")
	public Senses propertySenses() {
		return new Senses(data + lang + "/senses.dat");
	}
	
	@Bean(name="sensesSlang")
	public Senses propertySensesSlang() {
		return new Senses(data + lang + "/albur/senses.dat");
	}
	
	@Bean
	public Tokenizer propertyTokenizer() {
		return new Tokenizer(data + lang + "/tokenizer.dat");
	}
	
	@Bean
	public Splitter propertySplitter() {
		return new Splitter(data + lang + "/splitter.dat");
	}
	
	@Bean
	public Maco propertyMaco() {
		MacoOptions op = new MacoOptions( lang );

	    op.setDataFiles( "", 
	                     data + "common/punct.dat",
	                     data + lang + "/dicc.src",
	                     data + lang + "/afixos.dat",
	                     "",
	                     data + lang + "/locucions.dat", 
	                     data + lang + "/np.dat",
	                     data + lang + "/quantities.dat",
	                     data + lang + "/probabilitats.dat");
	    
	    Maco mf = new Maco( op );
	    mf.setActiveOptions(false, true, true, true,
	                        true, true, false, true, 
	                        true, true, true, true);
	    
	    return mf;
	}
	
	@Bean
	public HmmTagger propertyHmmTagger() {
		return new HmmTagger( data + lang + "/tagger.dat", true, 2 );
	}

}
