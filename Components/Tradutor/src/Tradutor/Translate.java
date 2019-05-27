package Tradutor;

public class Translate {
	
	public static void main(String args[]) {
		System.out.println(Translate.translate("Eu nao sei o que escrever aqui"));
	}
	
	/*
	 * Metodo que da um wrap no Translator para deixa-lo como static
	 */
	public static String translate(String text) {
		Translator t = new Translator();
		String resultado = t.translation(text);
		return resultado;
	}
	
}
