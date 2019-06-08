package componenteServidor;


import java.io.IOException;

public class FabricaServidor {
	public static IServidor create() throws IOException {
		return new Servidor();
	}
	public static IServidor create(int port) throws IOException {
		return new Servidor(port);
	}
}
