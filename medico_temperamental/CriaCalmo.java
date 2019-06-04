package medico_temperamental;

public class CriaCalmo implements FabricaStress {

	@Override
	public IEstresse FabricaEstresse() {
		// TODO Auto-generated method stub
		return new Calmo();
	}

}
