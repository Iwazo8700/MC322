package medico_temperamental;
import java.util.Random;


public class Calmo implements IEstresse {

	private long tempoInicial;
    private long tempoPaciente;
    private int numPaciente;
    static boolean extra;
    static boolean ultimo;
    
    //Saiu para beber agua, banheiro, cigarro, tomar um ar, pegar um cafezinho
    //acao extrema - fumou quase um maco de cigarro, ficou meia hora fora do escritorio 
    //dor de cabeca, comecou a ficar mto cansado, 
    public Calmo(){
        this.tempoInicial = System.currentTimeMillis();
        this.numPaciente = 0;
        extra = true;
        ultimo = false;
    }
    public void novoPaciente(){
        this.tempoPaciente = System.currentTimeMillis();
        numPaciente++;
        update();
    }
    public void acaoNormal(){
        Random aleatorio = new Random(); 
        int n = 5;
        int qlqr = aleatorio.nextInt(n);//aleatorio vai de 0 ate o numero-1
        switch(qlqr){
            
            case 1:
                if(extra){
                    System.out.println("Doutor esta tao feliz que quer fazer hora extra");
                    extra = false;
                    }
                break;
            case 2:
                if(ultimo){
                    System.out.println("Doutor gostou muito da ultima consuta");
                    }
                break;
            case 3:
                System.out.println("Doutor esta animado para o proimo atendimento");
                break;
            case 4:
                System.out.println("Doutor gostou muito do ultimo paciente");
                break;
        }
        ultimo = true;
    }
    
    public void acaoExtrema(){
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
        if(agora >= 5000)//um minuto de programa(EH O CALMO)
            acaoExtrema();
        else if(consulta >= 2000)
            acaoExtrema();
        else if(numPaciente/3 == 1)
            acaoNormal();
        else if(agora >= 1000)
            acaoNormal();
    }
    
}


