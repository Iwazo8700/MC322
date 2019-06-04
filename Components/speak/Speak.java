package speak;

public class Speak {
	
	static ITextToSpeechService t = null;

	//metodo que da um wrap na funcao do TextToSpeechService para deixa-lo static
	public static void speak(String text) {
		if (t == null)
			t = new TextToSpeechService();
		
		try {
			t.execute(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
