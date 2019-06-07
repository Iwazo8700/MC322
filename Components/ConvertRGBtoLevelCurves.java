
import java.util.ArrayList;

public class ConvertRGBtoLevelCurves implements ICreateArray{
	int vetor[][];
	private String sintomas[] = null;
    private String diagnostico[][] = null;
	
	public ConvertRGBtoLevelCurves(DataSetComponent data) {
		String atributos[] = data.requestAttributes();
        this.sintomas = atributos;
        String instancias[][] = data.requestInstances();
        this.diagnostico = instancias;
        this.vetor = new int[(diagnostico.length + 1)*50 + (diagnostico.length)][((sintomas.length + 1)+1)*50 + (sintomas.length + 1)];
	}
	public String reader() {
		for(int i = 0; i < diagnostico.length - 1; i++) {
			for(int j = 0; j < sintomas.length; j++) {
				createArray(i , j, Integer.parseInt(diagnostico[i][j]), Integer.parseInt(diagnostico[i][j+1]), Integer.parseInt(diagnostico[i+1][j]),Integer.parseInt(diagnostico[i+1][j+1]));
			}			
		}
		preenche();
		return imprimeArray();
	}
	public void createArray(String diagnostico[]){}
	
	public void createArray(int x, int y, int ij, int ij1, int i1j, int i1j1) {
		this.vetor[x*51][y*51] = ij;
		
		float dy = (((float)i1j - (float)ij)/50);
		for(int j = 0; j < 51; j++) {
			this.vetor[x*51 + j][y*51] = (int)(ij + dy*j);
		}
	}
	public void preenche() {
		for(int i = 0; i < this.vetor.length; i++) {
			for(int j = 0; j < this.vetor[i].length; j++) {
				int a = (j/51)*51;
				int b = ((j/51)+1)*51;
				if(b == 459) {
					b = 457;
				}
				float dx = ((float)vetor[i][b] - (float)vetor[i][a])/50;
				vetor[i][j] = (int)(vetor[i][a] + dx*(j/51));
				
			}
		}
	}
	public String imprimeArray() {
		String resultado = "";
		for(int i = 0; i < vetor.length; i++) {
			for(int j = 0; j < vetor[i].length; j++) {
				resultado += vetor[i][j]+",";
			}
			resultado += "\n";
		}
		return resultado;
	}
}