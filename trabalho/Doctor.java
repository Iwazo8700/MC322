package trabalho;


import java.util.List;
import jsmaiorjava.implementations.ImprimeAtestado;
import jsmaiorjava.implementations.Prontuario;
import jsmaiorjava.implementations.ZumbiTwittero;
import jsmaiorjava.interfaces.IImprimeAtestado;
import jsmaiorjava.interfaces.IProntuario;
import jsmaiorjava.interfaces.IZumbiTwittero;
import speak.Speak;
import tradutor.Translate;
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
	    
	    boolean answer;
	    
	    while(tree.getRoot().getDiseases() == null) {
	    	System.out.println(Translate.translate("Do you have " + dataset.requestAttributes()[tree.getRoot().getSymptom()].replace("_", " ") + "?", lang));
	    	answer = responder.ask("Do you have " + dataset.requestAttributes()[tree.getRoot().getSymptom()] + "?");
	    	medico_unico.novaPergunta();
	    	if(answer)
	    		tree.setRoot(tree.getRoot().getEsquerdo());
	    	else
	    		tree.setRoot(tree.getRoot().getDireito());
	    }
	    for(int i = 0; i < tree.getRoot().getDiseases().size();i++)
	    	System.out.println("You have " + dataset.requestAttributes()[tree.getRoot().getDiseases().get(i)]);
	    String a = "";
	    for(int i = 0; i < tree.getRoot().getDiseases().size();i++)
	    	a = a + " " + tree.getRoot().getDiseases().get(i);
	    
	    Speak.speak("You have" + a);
	    p = new Prontuario(a, responder.getNome() ,name);
		IZumbiTwittero t = new ZumbiTwittero(p);
		t.twittar();
	}
	
    
	public void getAtestado() {
		IImprimeAtestado i = new ImprimeAtestado(p);
		i.imprime();
	}
}

