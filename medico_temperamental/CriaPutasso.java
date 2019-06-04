package medico_temperamental;

public class CriaPutasso implements FabricaStress {

	@Override
	public IEstresse FabricaEstresse() {
		// TODO Auto-generated method stub
		return new Putasso();
	}

}
