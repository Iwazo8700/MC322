package Tradutor;

import java.util.List;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.RequestTooLargeException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.language_translator.v3.LanguageTranslator;
import com.ibm.watson.language_translator.v3.model.IdentifiedLanguage;
import com.ibm.watson.language_translator.v3.model.IdentifiedLanguages;
import com.ibm.watson.language_translator.v3.model.IdentifyOptions;
import com.ibm.watson.language_translator.v3.model.TranslateOptions;
import com.ibm.watson.language_translator.v3.model.TranslationResult;
import com.ibm.watson.language_translator.v3.util.Language;

public class Translator implements ITranslator {
	
	/*
	 * Metodo que cria e retorna um novo objeto tradutor ja configurando as verificacoes 
	 * necessarias para utilizar a API watson
	 */
	
	public LanguageTranslator setCredentials() {
		
		
		//Cria um objeto LanguageTranslator 
		//(O argumento eh a data, para o programa nao quebrar com atualizacoe da api)

		
		LanguageTranslator novo = new LanguageTranslator("2019-05-23");
		
		// Configura as credenciais necessarias (obtidas criando uma conta no cloud da ibm)
		
		IamOptions iamOptions = new IamOptions.Builder()
				  .apiKey("7kVlzDd6_MXKtaMB_67IfDm_iVnHFI3LAmcBH-S8QrB3")
				  .build();	
		novo.setIamCredentials(iamOptions);
		
		return novo;
	}
	
	/*
	 * Metodo que recebe um texto e retorna a lingua mais provavel em que ele foi escrito 
	 */
	
	public String identifyLanguage(String text, LanguageTranslator lang_t) {
		
		
		//Cria objeto IdentifyOptions onde o texto ficara guardado
		// (necessario pois a funcao identify recebe como parametro um objeto desse tipo)
		 
		IdentifyOptions t = new IdentifyOptions.Builder().text(text).build();

		/*
		 *  Cria um objeto ServiceCall, que faz uma request http quando chamado o metodo execute().
		 *  A funcao getResult retorna o resultado do request executado, que nesse caso sera uma objeto
		 *  IndentifiedLanguages
		 *  O metodo getLanguages vai retornar uma lista de IdentifiedLanguage, onde cada objeto
		 *  IdentifiedLanguage contem o nome da lingua e a probabilidade de ser ela
		 */
		
		ServiceCall<IdentifiedLanguages> l = lang_t.identify(t);
		List<IdentifiedLanguage> f = l.execute().getResult().getLanguages();
		
		//Percorre a lista de linguas possiveis e salva em lang a lingua com maior confianca
		
		String lang = "";
		double certeza = -1;
		for(int i = 0; i < f.size(); i++) {
			if(f.get(i).getConfidence() > certeza) {
				certeza = f.get(i).getConfidence();
				lang = f.get(i).getLanguage();
			}
		}
		
		return lang;
	}
	
	
	/*
	 * Metodo que recebe um texto e retorna ele traduzido para o ingles
	 */
	
	public String translation(String text) {
		String retorno = null;
		
		// Cria o conversor (LanguageTranslator)
		LanguageTranslator service = setCredentials();

		// Encontra a lingua do texto a ser convertido
		String lang = identifyLanguage(text, service);
		
		//Cria um objeto TranslateOptions que guarda o texto, a lingua para converter e 
		// a lingua do texto a ser convertido
		// Caso o texto ja esteja em ingles, o retorno vira o proprio texto recebido
		// Caso o texto seja longo demais ou ocorra outro erro, retorna null
		try {	
			TranslateOptions translateOptions = new TranslateOptions.Builder()
				  .addText(text)
				  .source(lang)
				  .target(Language.ENGLISH)
				  .build();

			//O metodo translate faz uma request com https ao ser executado e o getResult retorna o 
			// resultado do request em um TranslationResult
			TranslationResult translationResult = service.translate(translateOptions).execute().getResult();
		
			retorno = translationResult.getTranslations().get(0).getTranslationOutput();
			
		}catch(NotFoundException e) { //Erro por nao haver modelo ou lingua de destino = lingua de entrada
			
			retorno = text;
			
		} catch (RequestTooLargeException e) { //Erro por excesso de caracteres
			
			retorno = null;
			
		} catch (ServiceResponseException e) { // Classe de erro geral

		   retorno = null;
		}
		
		//Pega a String resultante do translationResult e retorna ela
		return retorno;


	}
	
	/*
	 * Metodo que recebe um texto e retorna ele traduzido para uma lingua escolhida
	 */
	
	public String translation(String text, String toLang) {
		String retorno = null;
		// Cria o conversor (LanguageTranslator)
		LanguageTranslator service = setCredentials();

		// Converte o texto para ingles, pois eh a lingua com maior suporte de conversoes
		String eng = Translate.translate(text);
			
		//Cria um objeto TranslateOptions que guarda o texto, a lingua para converter e 
		// a lingua do texto a ser convertido
		if(eng != null) {
			TranslateOptions translateOptions = new TranslateOptions.Builder()
					.addText(eng)
					.source(Language.ENGLISH)
					.target(toLang)
					.build();

			//O metodo translate faz uma request com https ao ser executado e o getResult retorna o 
			// resultado do request em um TranslationResult
			TranslationResult translationResult = service.translate(translateOptions).execute().getResult();
		
			//Pega a String resultante do translationResult
			retorno = translationResult.getTranslations().get(0).getTranslationOutput();
		}
		return retorno;
	}
}
