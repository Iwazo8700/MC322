package Temperamental;

public class Exemplo{
    public static void main(String args[]){
      IFabricaStress calmo = TemperamentoGeral.CriaTemperamento("calmo");
      IFabricaStress puto = TemperamentoGeral.CriaTemperamento("puto");
      IFabricaStress putasso = TemperamentoGeral.CriaTemperamento("putasso");
      IFabricaStress real = TemperamentoGeral.CriaTemperamento("real");
      IFabricaStress unico = TemperamentoGeral.CriaTemperamento("unico");


      System.out.println("calmo");
      Estresse medico_calmo = calmo.FabricaEstresse();
      medico_calmo.novoPaciente();
      medico_calmo.novoPaciente();
      medico_calmo.novoPaciente();
      medico_calmo.novoPaciente();
      medico_calmo.novoPaciente();
      System.out.println();

      System.out.println("puto");
      Estresse medico_puto = puto.FabricaEstresse();
      medico_puto.novoPaciente();
      medico_puto.novoPaciente();
      medico_puto.novoPaciente();
      medico_puto.novoPaciente();
      medico_puto.novoPaciente();
      System.out.println();

      System.out.println("putasso");
      Estresse medico_putasso = putasso.FabricaEstresse();
      medico_putasso.novoPaciente();
      medico_putasso.novoPaciente();
      medico_putasso.novoPaciente();
      medico_putasso.novoPaciente();
      medico_putasso.novoPaciente();
      System.out.println();


      Estresse medico_real = real.FabricaEstresse();
      medico_real.novoPaciente();
      medico_real.novoPaciente();
      medico_real.novoPaciente();
      medico_real.novoPaciente();
      medico_real.novoPaciente();
      medico_real.novoPaciente();
      medico_real.novoPaciente();
      System.out.println();

      Estresse medico_unico = unico.FabricaEstresse();
      medico_unico.novaPergunta();
      medico_unico.novaPergunta();
      medico_unico.novaPergunta();
      medico_unico.novaPergunta();
      medico_unico.novaPergunta();
      medico_unico.novaPergunta();
      medico_unico.novaPergunta();
      medico_unico.novaPergunta();
      medico_unico.novaPergunta();
      medico_unico.novaPergunta();
      System.out.println("fim");
    }

}
