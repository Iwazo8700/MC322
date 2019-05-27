package Tradutor;

public class Translate {
	
	/*
	 * Metodos que dao um wrap no Translator para deixa-los como static
	 */
	public static String translate(String text) {
		Translator t = new Translator();
		String resultado = t.translation(text);
		return resultado;
	}
	
	public static String translate(String text, String toLan) {
		Translator t = new Translator();
		String resultado = t.translation(text, toLan);
		return resultado;
	}
	
}
