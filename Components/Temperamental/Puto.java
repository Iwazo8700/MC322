package Temperamental;

public class Puto extends Estresse{

    //Saiu para beber agua, banheiro, cigarro, tomar um ar, pegar um cafezinho
    //acao extrema - fumou quase um maco de cigarro, ficou meia hora fora do escritorio
    //dor de cabeca, comecou a ficar mto cansado,
    public Puto(){
        this.tempoInicial = System.currentTimeMillis();
        this.numPaciente = 0;
        cansado = true;
        cabeca = true;
    }
    public void update(){
        long agora = System.currentTimeMillis() - tempoInicial;
        //acoes de tempo total(mais extremas)
        long consulta = System.currentTimeMillis() - tempoPaciente;
        if(agora >= 60000)//um minuto de programa(EH O CALMO)
            acaoExtrema();
        else if(consulta >= 10000)
            acaoExtrema();
        else if(numPaciente/3 == 1)
            acaoNormal();
        else if(agora >= 7000)
            acaoNormal();
    }


}
