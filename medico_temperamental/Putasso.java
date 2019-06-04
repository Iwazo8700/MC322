package medico_temperamental;
import java.util.Random;

public class Putasso implements IEstresse {

	private long tempoInicial;
    private long tempoPaciente;
    private int numPaciente;
    static boolean cabeca;
    static boolean cansado;
    
    //Saiu para beber agua, banheiro, cigarro, tomar um ar, pegar um cafezinho
    //acao extrema - fumou quase um maco de cigarro, ficou meia hora fora do escritorio 
    //dor de cabeca, comecou a ficar mto cansado, 
    public Putasso(){
        this.tempoInicial = System.currentTimeMillis();
        this.numPaciente = 0;
        cabeca = true;
        cansado = true;
    }
    public void novoPaciente(){
        this.tempoPaciente = System.currentTimeMillis();
        numPaciente++;
        update();
    }
    public void acaoExtrema(){
        Random aleatorio = new Random(); 
        int n = 5;
        int qlqr = aleatorio.nextInt(n);//aleatorio vai de 0 ate o numero-1
        switch(qlqr){
            
            case 1:
                if(cabeca){
                    System.out.println("Doutor comecou a ficar com uma dor de cabeca muito forte");
                    cabeca = false;
                    }
                break;
            case 2:
                if(cansado){
                    System.out.println("Doutor comecou a ficar muito cansado");
                    cansado = false;
                    }
                break;
            case 3:
                System.out.println("Doutor cancelou uma das consultas");
                break;
            case 4:
                System.out.println("Doutor saiu para fumar e quase acabou com um maco de cigarro");
                try { Thread.sleep (4000); } catch (InterruptedException ex) {}//1 sec
                break;
        }
    }
    
    public void acaoNormal(){
        Random aleatorio = new Random(); 
        int n = 6;
        int qlqr = aleatorio.nextInt(n);//aleatorio vai de 0 ate o numero-1
        switch(qlqr){
            case 1:
                System.out.println("Doutor saiu para ir ao banheiro");
                try { Thread.sleep (2000); } catch (InterruptedException ex) {}//2 sec
                break;
            case 2:
                System.out.println("Doutor saiu para fumar um cigarro");
                try { Thread.sleep (2000); } catch (InterruptedException ex) {}//2 sec
                break;
            case 3:
                System.out.println("Doutor saiu para tomar um ar");
                try { Thread.sleep (1000); } catch (InterruptedException ex) {}//1 sec
                break;
            case 4:
                System.out.println("Doutor saiu para beber um cafezinho");
                try { Thread.sleep (2000); } catch (InterruptedException ex) {}//2 sec
                break;
            case 5:
                System.out.println("Doutor saiu para beber agua");
                try { Thread.sleep (1000); } catch (InterruptedException ex) {}//1 sec
                break;
        }
    }
    
    
    public void update(){
        long agora = System.currentTimeMillis() - tempoInicial;
        //acoes de tempo total(mais extremas)
        long consulta = System.currentTimeMillis() - tempoPaciente;
        if(agora >= 30000)//um minuto de programa(EH O CALMO)
            acaoExtrema();
        else if(consulta >= 3000)
            acaoExtrema();
        else if(numPaciente/3 == 1)
            acaoNormal();
        else
            acaoNormal();
    }

}
