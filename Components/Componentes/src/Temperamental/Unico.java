package Temperamental;

import Temperamental.Estresse;

public class Unico extends Estresse{
    public Unico(){
        this.tempoInicial = System.currentTimeMillis();
        this.numPergunta = 0;
        cancelou = false;
    }

    public String update(){
    	String retorno = "";
        long agora = System.currentTimeMillis() - tempoInicial;
        if(numPergunta == 0){
            retorno = ("O medico ainda bem calmo\n");
        }
        else if(numPergunta < 8 || agora <= 8000){
        	if(numPergunta == 1);
        		retorno += ("O medico comecou a ficar estressado e cansado!!\n");
            retorno += acaoNormal();
        }
        else{
        	if(numPergunta == 9)
        		retorno += ("O medico esta MUITO cansado!!!\n");
            retorno += acaoExtrema();
        }

        return retorno;
    }
}
