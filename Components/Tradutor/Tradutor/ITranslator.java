package Tradutor;

import com.ibm.watson.language_translator.v3.LanguageTranslator;

public interface ITranslator {
	
	public LanguageTranslator setCredentials();
	
	public String identifyLanguage(String text, LanguageTranslator lang_t);
	
	public String translation(String text);
	
	public String translation(String text, String toLang);
}
