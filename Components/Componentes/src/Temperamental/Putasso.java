package Temperamental;

public class Putasso extends Estresse{
    public Putasso(){
        this.tempoInicial = System.currentTimeMillis();
        this.numPaciente = 0;
        cabeca = true;
        cansado = true;
    }


    public String update(){
    	String retorno;
        long agora = System.currentTimeMillis() - tempoInicial;
        //acoes de tempo total(mais extremas)
        long consulta = System.currentTimeMillis() - tempoPaciente;
        if(agora >= 30000)//um minuto de programa(EH O CALMO)
            retorno = acaoExtrema();
        else if(consulta >= 3000)
            retorno = acaoExtrema();
        else if(numPaciente/3 == 1)
            retorno = acaoNormal();
        else
            retorno = acaoNormal();
        return retorno;
    }



}
