package componenteServidor;

import java.io.IOException;
import com.sun.net.httpserver.*;
import java.util.Map;

public class Testador {
	public static void main(String args[]) throws IOException{
		IServidor teste = FabricaServidor.create();
		teste.addContext("/teste/", new HttpHandler() {
			@Override
			public void handle(HttpExchange exchange) throws IOException{
				Map<String,String> query = Servidor.splitQuery(teste.getQuery(exchange));
				
				teste.sendResponse(exchange, "Hello World");			
			}
		});
		teste.initialize();	
	}
}
