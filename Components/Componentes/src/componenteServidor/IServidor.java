package componenteServidor;


import java.io.IOException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public interface IServidor {
	public void initialize();
	public void addContext(String path, HttpHandler h);
	public void simpleHandler(HttpExchange exchange) throws IOException;
}
