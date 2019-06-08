package Temperamental;

public class TemperamentoGeral{
    public static IFabricaStress CriaTemperamento(String tipo){
        IFabricaStress retorno = null;
        if(tipo.equalsIgnoreCase("calmo"))
            retorno = new CriaCalmo();
        else if(tipo.equalsIgnoreCase("puto"))
            retorno = new CriaPuto();
        else if(tipo.equalsIgnoreCase("putasso"))
            retorno = new CriaPutasso();
        else if(tipo.equalsIgnoreCase("real"))
            retorno = new CriaReal();
        else if(tipo.equalsIgnoreCase("unico"))
            retorno = new CriaUnico();
        return retorno;
    }
}
