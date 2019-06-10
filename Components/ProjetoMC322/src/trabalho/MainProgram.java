package trabalho;


public class MainProgram {
	public static void main(String[] args) {
		IDoctor doc = new Doctor("Asdrubal");
		IResponder pat = new Patient("Bastiao");
		DataSetComponent tab = new DataSetComponent();	
		String dir = "/home/debora/Música/teste.csv";//Local onde esta a matriz de instancias na sua maquina
	    tab.setDataSource(dir);
		
	    doc.connect(tab);
		doc.connect(pat);
		
		doc.startInterview();
		
	}
}
