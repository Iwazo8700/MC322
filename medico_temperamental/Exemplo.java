package medico_temperamental;

public class Exemplo {
	public static void main(String args[]) {
		FabricaStress calmo = TemperamentoGeral.CriaTemperamento("calmo");
		FabricaStress puto = TemperamentoGeral.CriaTemperamento("puto");
		FabricaStress putasso = TemperamentoGeral.CriaTemperamento("putasso");

		IEstresse medico_calmo = calmo.FabricaEstresse();
		IEstresse medico_puto = puto.FabricaEstresse();
		IEstresse medico_putasso = putasso.FabricaEstresse();


		System.out.println("calmo");
		medico_calmo.novoPaciente();
		medico_calmo.novoPaciente();
		medico_calmo.novoPaciente();
		medico_calmo.novoPaciente();
		medico_calmo.novoPaciente();
		System.out.println();

		System.out.println("puto");
		medico_puto.novoPaciente();
		medico_puto.novoPaciente();
		medico_puto.novoPaciente();
		medico_puto.novoPaciente();
		medico_puto.novoPaciente();
		System.out.println();

		System.out.println("putasso");
		medico_putasso.novoPaciente();
		medico_putasso.novoPaciente();
		medico_putasso.novoPaciente();
		medico_putasso.novoPaciente();
		medico_putasso.novoPaciente();
		System.out.println();

		IEstresse medico_calmo2 = calmo.FabricaEstresse();
		System.out.println("calmo");
		medico_calmo2.novoPaciente();
		medico_calmo2.novoPaciente();
		medico_calmo2.novoPaciente();
		medico_calmo2.novoPaciente();
		medico_calmo2.novoPaciente();
		System.out.println();

		System.out.println("fim");
	}
}
