package componenteServidor;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import com.sun.net.httpserver.*;

public class Servidor implements IServidor{

	private HttpServer server;
	
	Servidor() throws IOException{
		server = HttpServer.create(new InetSocketAddress(8500),0);
	}
	
	
	Servidor(int PORT) throws IOException{
		server = HttpServer.create(new InetSocketAddress(PORT),0);
	}
	
	public void initialize() {
		server.start();
		
	}

	public void addContext(String path, HttpHandler h) {
		HttpContext context = server.createContext(path);
		context.setHandler(h);
	}

	public void sendResponse(HttpExchange exchange, String response) throws IOException {
		exchange.sendResponseHeaders(200, response.getBytes().length);
		OutputStream os = exchange.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
	
	public String getQuery(HttpExchange exchange) {
		URI requestURI = exchange.getRequestURI();
		String query = requestURI.getQuery();
		return query;
	}
	
	
	public void simpleHandler(HttpExchange exchange) throws IOException{
		String response = getQuery(exchange);
		sendResponse(exchange, response);			
	}
	
	
}