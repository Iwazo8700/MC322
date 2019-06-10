package Temperamental;

import Temperamental.Estresse;

public class Unico extends Estresse{
    public Unico(){
        this.tempoInicial = System.currentTimeMillis();
        this.numPergunta = 0;
        cancelou = false;
    }

    public void update(){
        long agora = System.currentTimeMillis() - tempoInicial;
        if(numPergunta == 0){
            System.out.println("O medico ainda bem calmo");
        }
        else if(numPergunta < 8 || agora <= 8000){
            acaoNormal();
        }
        else{
            acaoExtrema();
        }


    }
}
