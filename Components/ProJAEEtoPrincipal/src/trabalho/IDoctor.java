package trabalho;



public interface IDoctor extends IEnquirer, IResponderReceptacle, ITableProducerReceptacle {
	public String getNome();
	public void andarNaArvore(boolean res);
	}

