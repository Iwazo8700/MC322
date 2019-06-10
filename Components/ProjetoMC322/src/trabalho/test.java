package trabalho;



import java.util.List;

import pt.clubedohardware.dataorganizer.DataOrganizer;
import pt.clubedohardware.node.Tree;
import pt.clubedohardware.fileusage.*;


public class test {

	public static void main(String[] args) {
		//Instanciacao do dataOrganizer
		DataOrganizer dataOr = new DataOrganizer();
		
		//Instanciacao do dataSet (componente feito pelo professor)
		DataSetComponent dataset = new DataSetComponent();
		String dir = "../teste.csv";//Local onde esta a matriz de instancias na sua maquina
	    dataset.setDataSource(dir);
	    String[][] instances = dataset.requestInstances();
	    
	    //Pega a lista de doencas, a matriz de frequencia e monta a arvore
	    List<String> diseases = dataOr.diseaseFilter(instances);
	    int[][] symptomFrequency = dataOr.symptomFilter(instances, diseases);
	    Tree tree = dataOr.treeMaker(diseases, symptomFrequency, instances);
	    
	    //instanciacao do fileUsage
	    IFileUsage fileUsage = new FileUsage();
	    //salva as doencas, matriz de frequencia e a arvore numa pasta chamada SerializedData na pasta do seu projeto
	    fileUsage.save(diseases, symptomFrequency, tree);
	    //salva so a arvore
	    fileUsage.save(tree);
	    //recupera a arvore
	    tree = fileUsage.getTree();
	    //recupera a lista de doencas
	    diseases = fileUsage.getDiseases();
	    //recupera a matriz de frequencia
	    symptomFrequency = fileUsage.getFrequency();
	    
	    //Metodo alternativo para visualizar os nos da arvore,
	    //onde o segundo parametro eh o nome da pasta que vc quer salvar a serializacao.
	    tree.DAO("tree", "../teste");
	}

}
