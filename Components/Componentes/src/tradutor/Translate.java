package tradutor;

import com.ibm.cloud.sdk.core.service.exception.RequestTooLargeException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

public class Translate {
	private static ITradutorService service = new TranslateService();
	/*
	 * Metodos que dao um wrap no Translator para deixa-los como static
	 */
	public static String translate(String text) throws RequestTooLargeException, ServiceResponseException{
		if (service == null)
				service = new TranslateService();
		String resultado = service.translation(text);
		return resultado;
	}
	
	public static String translate(String text, String toLan) throws RequestTooLargeException, ServiceResponseException{
		String resultado = service.translation(text, toLan);
		return resultado;
	}
	
}
