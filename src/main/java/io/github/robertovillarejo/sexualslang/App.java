package io.github.robertovillarejo.sexualslang;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.upc.freeling.Util;


/**
 *
 */
@SpringBootApplication
public class App{
	
	public static void main(String[] args) {		
		System.loadLibrary( "freeling_javaAPI" );
	    Util.initLocale( "default" );
	    SpringApplication.run(App.class, args);
	}
	
}
