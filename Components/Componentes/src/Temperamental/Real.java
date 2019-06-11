package Temperamental;

public class Real extends Estresse{



    public Real(){
        this.tempoInicial = System.currentTimeMillis();
        this.numPaciente = 0;
        cabeca = true;
        cansado = true;
        cabeca = true;
    }


    public String update(){
    	String retorno = "";
        long agora = System.currentTimeMillis() - tempoInicial;
        //acoes de tempo total(mais extremas)
        long consulta = System.currentTimeMillis() - tempoPaciente;
        if(agora <= 4000 && numPaciente < 4){
            if(calmo){
                retorno+=("O medico esta calmo!\n");
                calmo = false;
                puto = true;
            }

            if(consulta >= 3000)
                retorno +=acaoNormal();
            else if(consulta <= 1000)
                retorno += acaoCalma();
        }else if(agora <= 7000 && numPaciente < 8){
            if(puto){
                retorno += ("O medico comecou a ficar estressado e cansado!!\n");
                retorno += acaoNormal();
                puto = false;
                putasso = true;
            }
            if(consulta >= 3000)
                retorno += acaoExtrema();
            else if(consulta <= 1000)
                retorno += acaoNormal();
        }else{
            if(putasso){
                retorno += ("O medico esta MUITO cansado!!!\n");
                retorno += acaoExtrema();
                putasso = false;
            }if(consulta >= 1000)
                retorno = acaoExtrema();
            else
                retorno = acaoNormal();

        }
        return retorno;
    }

}
