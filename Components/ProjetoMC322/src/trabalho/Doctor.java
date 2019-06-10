package trabalho;


import java.util.List;

import speak.Speak;
import Temperamental.*;
import pt.clubedohardware.dataorganizer.DataOrganizer;
import pt.clubedohardware.node.Tree;

public class Doctor implements IDoctor {
	private ITableProducer dataset;
	private IResponder responder;
	private Tree tree;
	private String[][] instances;
	private List<String> diseases;
	private int[][] symptomFrequency;
	private IFabricaStress unico;
	private Estresse medico_unico;
	private IDoctor eu = this;
	private String name;
	
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
		
	}
		
	public void connect(IResponder responder) {
		this.responder = responder;
		medico_unico = unico.FabricaEstresse();
	}
        
	public void startInterview() {
	    
	    String answer;
	    
	    while(tree.getRoot().getDiseases() == null) {
	    	System.out.println("Do you have " + dataset.requestAttributes()[tree.getRoot().getSymptom()] + "?");
	    	answer = responder.ask("Do you have " + dataset.requestAttributes()[tree.getRoot().getSymptom()] + "?");
	    	medico_unico.novaPergunta();
	    	if(getAnswer(answer))
	    		tree.setRoot(tree.getRoot().getDireito());
	    	else
	    		tree.setRoot(tree.getRoot().getEsquerdo());
	    }
	    System.out.println("You have" + tree.getRoot().getDiseases().toString());
	    Speak.speak("You have" + tree.getRoot().getDiseases().toString());

	}
	
	private boolean getAnswer(String answer) {
		boolean retorno = false;
		
		if(answer.contains("sim"))
			retorno = true;
		
		return retorno;
	}
    
}

