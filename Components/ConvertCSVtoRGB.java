import java.util.ArrayList;

public class ConvertCSVtoRGB implements ICreateArray{
	private String sintomas[] = null;
    private String diagnostico[][] = null;
	private int maxValue;
	private ArrayList<String[]> array = new ArrayList<String[]>();
	
	public ConvertCSVtoRGB(DataSetComponent data) {
		String atributos[] = data.requestAttributes();
        this.sintomas = atributos;
        String instancias[][] = data.requestInstances();
        this.diagnostico = instancias;
	}
	
	public void foundMaxValue() {
		maxValue = 0;
		for(int i = 0; i < diagnostico.length; i++) {
			for(int j = 0; j < diagnostico[i].length - 1; j++) {
				if(Integer.parseInt(diagnostico[i][j]) > maxValue) {
					maxValue = Integer.parseInt(diagnostico[i][j]);
				}
			}
		}
	}
	public String reader(){
		for(int i = 0; i < diagnostico.length; i++){
			createArray(diagnostico[i]);
		}
		return imprimeArray();
	}
	public void createArray(String diagnostico[]){
		for(int a = 0; a < diagnostico.length - 1; a++) {
			diagnostico[a] = String.valueOf((Integer.parseInt(diagnostico[a])*255)/maxValue);
		}
		array.add(diagnostico);
	}
	public String imprimeArray() {
		String resultado = "";
		for(int i = 0; i < sintomas.length; i++) {
			resultado += sintomas[i];
			if(i != sintomas.length - 1) {
				resultado += ",";
			}
		}
		resultado += "\n";
		for(int a = 0; a < sintomas.length + 2; a++) {
			resultado += "0";
			if(a != sintomas.length + 1) {
				resultado += ",";
			}
		}
		resultado += "\n";
		for(int k = 0; k < array.size(); k++) {
			if(k != array.size() - 1) {
				resultado += "0,";
			}			
			for(int l = 0; l < array.get(k).length; l++) {
				resultado += array.get(k)[l];
				if(l != array.get(k).length - 1) {
					resultado += ",";
				}
				if(l == array.size()) {
					resultado += "0,";
				}
			}
			if(k != array.size() - 1) {
				resultado += "\n";
			}
		}
		for(int b = 0; b < sintomas.length + 2; b++) {
			resultado += "0";
			if(b != sintomas.length + 1) {
				resultado += ",";
			}
		}
		return resultado;
	}
}
