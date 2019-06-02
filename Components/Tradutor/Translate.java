import com.ibm.cloud.sdk.core.service.exception.RequestTooLargeException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

public class Translate {
	
	/*
	 * Metodos que dao um wrap no Translator para deixa-los como static
	 */
	public static String translate(String text) throws RequestTooLargeException, ServiceResponseException{
		TranslateService t = new TranslateService();
		String resultado = t.translation(text);
		return resultado;
	}
	
	public static String translate(String text, String toLan) throws RequestTooLargeException, ServiceResponseException{
		TranslateService t = new TranslateService();
		String resultado = t.translation(text, toLan);
		return resultado;
	}
	
}
