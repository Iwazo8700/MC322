package Temperamental;

import java.util.Random;

public abstract class Estresse{
    protected long tempoInicial;
    protected long tempoPaciente;
    protected int numPaciente;
    protected int numPergunta;
    protected boolean cabeca;
    protected boolean cansado;
    protected boolean extra;
    protected boolean ultimo;
    protected boolean calmo = true;
    protected boolean puto = false;
    protected boolean putasso = false;
    protected boolean cancelou = true;
    protected static int repeticao = 0;

    protected  String acaoExtrema(){
        Random aleatorio = new Random();
        String retorno = "";
        int n = 5;
        int qlqr = aleatorio.nextInt(n);//aleatorio vai de 0 ate o numero-1
        switch(qlqr){

            case 1:
                if(cabeca){
                		retorno = ("Doutor comecou a ficar com uma dor de cabeca muito forte");
                    cabeca = false;
                    }else{acaoExtrema();}
                break;
            case 2:
                if(cansado){
                    retorno = ("Doutor comecou a ficar muito cansado");
                    cansado = false;
                    }else{acaoExtrema();}
                break;
            case 3:
                if(cancelou && repeticao != 1){
                retorno = ("Doutor cancelou uma das consultas");
                repeticao = 1;}else{acaoExtrema();}
                break;
            case 4:
                if(repeticao != 2)
                    {retorno = ("Doutor pediu para saiu para fumar e quase acabou com um maco de cigarro");
                    repeticao = 2;
                    try { Thread.sleep (4000); } catch (InterruptedException ex) {}}
                else{acaoExtrema();}
                break;
        }
        return retorno;
    }

    protected String acaoNormal(){
        Random aleatorio = new Random();
        String retorno = "";
        int n = 6;
        int qlqr = aleatorio.nextInt(n);//aleatorio vai de 0 ate o numero-1
        switch(qlqr){
            case 1:
                if(repeticao != 3)
                {retorno = ("Doutor pediu para sair, ele foi ao banheiro dar uma estravazada");
                 repeticao = 3;
                try { Thread.sleep (2000); } catch (InterruptedException ex) {}}else{acaoNormal();}//2 sec}
                break;
            case 2:
                if(repeticao != 4)
                {retorno = ("Doutor pediu para sair, e acabou indo fumar um cigarro");
                repeticao = 4;
                try { Thread.sleep (2000); } catch (InterruptedException ex) {}}else{acaoNormal();}//2 sec
                break;
            case 3:
                if(repeticao != 5)
                {retorno = ("Doutor pediu para sair, na verdade ele so foi tomar um ar");
                repeticao = 5;
                try { Thread.sleep (1000); } catch (InterruptedException ex) {}}else{acaoNormal();}//1 sec
                break;
            case 4:
                if(repeticao != 6)
                {retorno = ("Doutor pediu para sair, ele resoulveu ir beber um cafezinho");
                 repeticao = 6;
                try { Thread.sleep (2000); } catch (InterruptedException ex) {}}else{acaoNormal();}//2 sec
                break;
            case 5:
                if(repeticao != 7)
                {retorno = ("Doutor pediu para sair, ele foi beber agua para dar uma estravazada");
                repeticao = 7;
                 try { Thread.sleep (1000); } catch (InterruptedException ex) {}}else{acaoNormal();}//1 sec
                break;
        }
        return retorno;
    }

    protected String acaoCalma(){
        Random aleatorio = new Random();
        String retorno = "";
        int n = 5;
        int qlqr = aleatorio.nextInt(n);//aleatorio vai de 0 ate o numero-1
        switch(qlqr){

            case 1:
                if(extra){
                    retorno = ("Doutor esta tao feliz que quer fazer hora extra");
                    extra = false;
                    }
                break;
            case 2:
                if(ultimo&&repeticao !=8){
                    retorno = ("Doutor gostou muito da ultima consuta");
                    repeticao = 8;
                    }else{acaoCalma();}
                break;
            case 3:
                retorno = ("Doutor esta animado para o proximo atendimento");
                repeticao = 10000;
                break;
            case 4:
                if(repeticao != 9)
                {retorno = ("Doutor gostou muito do ultimo paciente");
                repeticao = 9;}
                break;
        }
        ultimo = true;
        return retorno;
    }
    public String novoPaciente(){
        tempoPaciente = System.currentTimeMillis();
        numPaciente++;
        return update();
    }


    public String novaPergunta(){
    	String ret = update();
        numPergunta++;
        return ret;
    }
    protected abstract String update();
  }
