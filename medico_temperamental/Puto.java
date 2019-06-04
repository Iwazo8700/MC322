package medico_temperamental;
import java.util.Random;

public class Puto implements IEstresse {
	private long tempoInicial;
    private long tempoPaciente;
    private int numPaciente;
    static boolean cabeca;
    static boolean cansado;
    public Puto(){
        this.tempoInicial = System.currentTimeMillis();
        this.numPaciente = 0;
        cansado = true;
        cabeca = true;
    }


	@Override
	public void acaoNormal() {
		// TODO Auto-generated method stub
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

	@Override
	public void acaoExtrema() {
		// TODO Auto-generated method stub
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
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
	
	@Override
	public void novoPaciente() {
		// TODO Auto-generated method stub
		this.tempoPaciente = System.currentTimeMillis();
        numPaciente++;
        update();
	}
	
}
