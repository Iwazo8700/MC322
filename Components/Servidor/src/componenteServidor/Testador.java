package componenteServidor;

import java.io.IOException;
import com.sun.net.httpserver.*;

public class Testador {
	
	
	public static void main(String args[]) throws IOException{
		
		IServidor teste = FabricaServidor.create();
		teste.addContext("/teste/", new HttpHandler() {
			public void handle(HttpExchange exchange) throws IOException{
				Servidor.sendResponse(exchange, "Hello World");
			}
		});
		teste.initialize();	
	}
	
}
