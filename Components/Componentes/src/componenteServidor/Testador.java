package componenteServidor;

import java.io.IOException;
import com.sun.net.httpserver.*;
import java.util.Map;
public class Testador {
	
	
	public static void main(String args[]) throws IOException{
		
		IServidor teste = FabricaServidor.create();
		
		teste.addContext("/somador/", new HttpHandler() {
			public void handle(HttpExchange exchange) throws IOException{
			    Servidor.addHeaders(exchange);
				Map<String, String> query = Servidor.splitQuery(Servidor.getQuery(exchange));
				
				
				int a, b;
				a = Integer.parseInt(query.get("a"));
				b = Integer.parseInt(query.get("b"));
				String response = Integer.toString(a+b);
				
				
				Servidor.sendResponse(exchange, response);
				System.out.println("Sum: "+response);
			}
		});
		teste.initialize();	
	}
	
	
	
}
