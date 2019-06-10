package componenteServidor;


import com.sun.net.httpserver.HttpHandler;

public interface IServidor {
	public void initialize();
	public void addContext(String path, HttpHandler h);
	
}
