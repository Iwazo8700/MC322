import java.util.ArrayList;

public class ReaderCSV implements ICreateArray{

	private String sintomas[] = null;
    private String diagnostico[][] = null;
    public ArrayList<String[]> array = new ArrayList<String[]>();
	
	public ReaderCSV(DataSetComponent data) {
		String atributos[] = data.requestAttributes();
        this.sintomas = atributos;
        String instancias[][] = data.requestInstances();
        this.diagnostico = instancias;
	}
	
	public String reader(){
		for(int i = 0; i < diagnostico.length; i++){
			createArray(diagnostico[i]);
		}
		return imprimeArray();
	}
	public void createArray(String diagnostico[]){
		for(int a = 0; a < sintomas.length - 1; a++) {
			if(diagnostico[a].equalsIgnoreCase("t") || diagnostico[a].equalsIgnoreCase("1")) {
				diagnostico[a] = "1";
			}
			else {
				diagnostico[a] = "0";
			}
		}
		if(array.size() == 0) {			
			array.add(diagnostico);
		}
		else {
			boolean flag = true;
			for(int i = 0; i < array.size(); i++) {
				if(array.get(i)[sintomas.length - 1].equals(diagnostico[sintomas.length - 1])) {
					String a[] = array.get(i);					
					for(int b = 0; b < sintomas.length - 1; b++) {
						a[b] = String.valueOf(Integer.parseInt(array.get(i)[b]) + Integer.parseInt(diagnostico[b]));
					}
					array.set(i, a);
					flag = false;
					break;
				}
				else {
					continue;
				}
			}
			if(flag == true) {
				array.add(diagnostico);
			}
		}	
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
		for(int k = 0; k < array.size(); k++) {
			for(int l = 0; l < array.get(k).length; l++) {
				resultado += array.get(k)[l];
				if(l != array.get(k).length - 1) {
					resultado += ",";
				}
			}
			resultado += "\n";
		}
		return resultado;
	}
	
}
