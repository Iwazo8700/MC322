package medico_temperamental;

public class CriaPuto implements FabricaStress {

	@Override
	public IEstresse FabricaEstresse() {
		// TODO Auto-generated method stub
		return new Puto();
	}

}
