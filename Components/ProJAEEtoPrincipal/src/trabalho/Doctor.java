package trabalho;


import java.util.List;
import jsmaiorjava.implementations.ImprimeAtestado;
import jsmaiorjava.implementations.Prontuario;
import jsmaiorjava.implementations.ZumbiTwittero;
import jsmaiorjava.interfaces.IImprimeAtestado;
import jsmaiorjava.interfaces.IProntuario;
import jsmaiorjava.interfaces.IZumbiTwittero;

import Temperamental.*;
import pt.clubedohardware.dataorganizer.DataOrganizer;
import pt.clubedohardware.node.Tree;

public class Doctor implements IDoctor {
	String lang;
	private ITableProducer dataset;
	private IResponder responder;
	private Tree tree;
	private String[][] instances;
	private List<String> diseases;
	private int[][] symptomFrequency;
	private IFabricaStress unico;
	private Estresse medico_unico;
	private String name;
	private IProntuario p;
	private List<String> doencas;
	
	public Doctor(String name) {
		this.name = name;
		 unico = TemperamentoGeral.CriaTemperamento("unico");
	}
	
	public String getNome() {
		return name;
	}
  
	public void connect(ITableProducer producer) {
		dataset = producer;
		instances = dataset.requestInstances();
		createTree();
	}
	
	private void createTree() {
		
		DataOrganizer dataOr = new DataOrganizer();
		diseases = dataOr.diseaseFilter(instances);
		symptomFrequency = dataOr.symptomFilter(instances, diseases);
		tree = dataOr.treeMaker(diseases, symptomFrequency, instances);
		doencas = dataOr.diseaseFilter(instances);
		
	}
		
	public void connect(IResponder responder) {
		this.responder = responder;
		medico_unico = unico.FabricaEstresse();
	}
        
	public String ask() {  
		String a;
	    if(tree.getRoot().getDiseases() == null) {
	    	String r = (medico_unico.novaPergunta()+".\nDo you have " + dataset.requestAttributes()[tree.getRoot().getSymptom()].replace("_", " ") + "?");	    	
	    	return "P: "+r;
	    	
	    	
	    }
	    else
		    a = "";
		    for(int i = 0; i < tree.getRoot().getDiseases().size();i++)
		    	a = a + " " + doencas.get(tree.getRoot().getDiseases().get(i)).replace("_", " ");
		    p = new Prontuario(a, responder.getNome() ,name);
			IZumbiTwittero t = new ZumbiTwittero(p);
			t.twittar();
			return "D: "+a;
	}
	
	public void andarNaArvore(boolean res) {
	    if(res)
	    	tree.setRoot(tree.getRoot().getEsquerdo());
	    else
	    	tree.setRoot(tree.getRoot().getDireito());

	}
	
	
    
	public void getAtestado() {
		IImprimeAtestado i = new ImprimeAtestado(p);
		i.imprime();
	}
}

