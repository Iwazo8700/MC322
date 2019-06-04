package medico_temperamental;

public class TemperamentoGeral {
	public static FabricaStress CriaTemperamento(String tipo){
        FabricaStress retorno = null;
        if(tipo.equalsIgnoreCase("calmo"))
            retorno = new CriaCalmo();
        else if(tipo.equalsIgnoreCase("puto"))
            retorno = new CriaPuto();
        else if(tipo.equalsIgnoreCase("putasso"))
            retorno = new CriaPutasso();
        return retorno;
    }
}
