package Temperamental;

public class Real extends Estresse{



    public Real(){
        this.tempoInicial = System.currentTimeMillis();
        this.numPaciente = 0;
        cabeca = true;
        cansado = true;
        cabeca = true;
    }


    public void update(){
        long agora = System.currentTimeMillis() - tempoInicial;
        //acoes de tempo total(mais extremas)
        long consulta = System.currentTimeMillis() - tempoPaciente;
        if(agora <= 4000 && numPaciente < 4){
            if(calmo){
                System.out.println("O medico esta calmo!");
                calmo = false;
                puto = true;
            }

            if(consulta >= 3000)
                acaoNormal();
            else if(consulta <= 1000)
                acaoCalma();
        }else if(agora <= 7000 && numPaciente < 8){
            if(puto){
                System.out.println("O medico comecou a ficar estressado e cansado!!");
                acaoNormal();
                puto = false;
                putasso = true;
            }
            if(consulta >= 3000)
                acaoExtrema();
            else if(consulta <= 1000)
                acaoNormal();
        }else{
            if(putasso){
                System.out.println("O medico esta MUITO cansado!!!");
                acaoExtrema();
                putasso = false;
            }if(consulta >= 1000)
                acaoExtrema();
            else
                acaoNormal();

        }
    }

}
