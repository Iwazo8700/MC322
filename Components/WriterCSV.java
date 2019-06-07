import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriterCSV {
	private String arquivo_nome;
	FileWriter arquivo;
	PrintWriter formatado;
	
	public WriterCSV(String arquivo_nome) {
		this.arquivo_nome = arquivo_nome;
	}
	public void Writer(String array) {
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