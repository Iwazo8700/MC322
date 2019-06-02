
public class Speak {
	
	//metodo que da um wrap na funcao do TextToSpeechService para deixa-lo static
	public static void speak(String text) {
		TextToSpeechService t = new TextToSpeechService();
		try {
			t.execute(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
