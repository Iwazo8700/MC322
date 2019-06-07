package speak;

public class Speak {
	
	static ITextToSpeechService t = new TextToSpeechService();

	//metodo que da um wrap na funcao do TextToSpeechService para deixa-lo static
	public static void speak(String text) {
		try {
			t.execute(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
