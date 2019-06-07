package componenteServidor;

import java.io.IOException;
import com.sun.net.httpserver.*;


public class Testador {
	
	final static String link1 = "/oi/";
	public static void main(String args[]) throws IOException{
		Servidor teste = new Servidor();
		
		
		teste.addContext("/emanuel/", new HttpHandler() {
			@Override
			public void handle(HttpExchange exchange) throws IOException{
				int a =  Integer.parseInt(teste.getQuery(exchange))+ 10;
				teste.sendResponse(exchange, Integer.toString(a));			
			}
		});
		teste.addContext("/bah/", new HttpHandler() {
			@Override
			public void handle(HttpExchange exchange) throws IOException{
				String response = "We are connected [Bah] : " + teste.getQuery(exchange);			
				teste.sendResponse(exchange, response);			
			}
		});
		teste.initialize();
		
	}
	
	
	public String tratar(String tratar) {return ".";}
	

}
