package curveLevels;
public class ConvertRGBtoLevelCurves implements ICreateFiles{
	int tam = 80;
	int vetor[][];
	private String sintomas[] = null;
    private String diagnostico[][] = null;
	
	public ConvertRGBtoLevelCurves(IDataSetComponent data) {
		String atributos[] = data.requestAttributes();
        this.sintomas = atributos;
        String instancias[][] = data.requestInstances();
        this.diagnostico = instancias;
        this.vetor = new int[(diagnostico.length - 1)*tam + (diagnostico.length)][(sintomas.length)*tam + (sintomas.length + 1)];
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
	public void foundMaxValue(){}
	public void createArray(int x, int y, int ij, int ij1, int i1j, int i1j1) {
		this.vetor[x*(tam + 1)][y*(tam + 1)] = ij;
		
		float dy = (((float)i1j - (float)ij)/tam);
		for(int j = 0; j < (tam + 1); j++) {
			this.vetor[x*(tam + 1) + j][y*(tam + 1)] = (int)(ij + dy*j);
		}
		float dx = (((float)ij1 - (float)ij)/tam);
		for(int i = 0; i < (tam + 1); i++) {
			this.vetor[x*(tam + 1)][y*(tam + 1) + i] = (int)(ij + dx*i);
		}
	}
	public void preenche() {
		for(int i = 0; i < this.vetor.length; i++) {
			for(int j = 0; j < this.vetor[i].length; j++) {
				if(i%(tam + 1) != 0 && j %(tam + 1) != 0) {
					int x1 = (j/(tam + 1))*(tam + 1);
					int x2 = x1 + (tam + 1);
					int y1 = (i/(tam + 1))*(tam + 1);
					int y2 = y1 + (tam + 1);
					
					float dx = ((float)vetor[i][x2] - (float)vetor[i][x1])/tam;
					float dy = ((float)vetor[y2][j] - (float)vetor[y1][j])/tam;
					vetor[i][j] = (int)(vetor[i][x1]+(j%(tam + 1))*dx + vetor[y1][j]+(i%(tam + 1))*dy)/2;	
				}
							
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