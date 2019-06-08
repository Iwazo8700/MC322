package Temperamental;

public class Calmo extends Estresse{

    //Saiu para beber agua, banheiro, cigarro, tomar um ar, pegar um cafezinho
    //acao extrema - fumou quase um maco de cigarro, ficou meia hora fora do escritorio
    //dor de cabeca, comecou a ficar mto cansado,
    public Calmo(){
        this.tempoInicial = System.currentTimeMillis();
        this.numPaciente = 0;
        extra = true;
        ultimo = false;
    }

    public void update(){
        long agora = System.currentTimeMillis() - tempoInicial;
        //acoes de tempo total(mais extremas)
        long consulta = System.currentTimeMillis() - tempoPaciente;
        if(agora >= 5000)//um minuto de programa(EH O CALMO)
            acaoNormal();
        else if(consulta >= 2000)
            acaoNormal();
        else if(numPaciente/3 == 1)
            acaoCalma();
        else if(agora >= 1000)
            acaoCalma();
    }
}
