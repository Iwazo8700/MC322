package curveLevels;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer implements IWriter {
	private String arquivo_nome;
	FileWriter arquivo;
	PrintWriter formatado;
	
	public Writer(String arquivo_nome) {
		this.arquivo_nome = arquivo_nome;
	}
	public void write(String array) {
		try {
		    arquivo = new FileWriter(arquivo_nome);
		    formatado = new PrintWriter(arquivo);
		    
		    formatado.println(array);
		
		    arquivo.close();
		
		    //System.out.println("Gravacao concluida com sucesso!");
		} catch (IOException erro) {
		    System.out.println("Nao consegui criar o arquivo =(");
		    erro.printStackTrace();
		}
	}
}