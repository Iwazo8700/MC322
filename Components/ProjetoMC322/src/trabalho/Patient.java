package trabalho;


import java.util.Scanner;

public class Patient implements IPatient {
	private String attributes[];
	private String patientInstance[];
    private String name;
    
    public Patient(String name) {
    	this.name = name;
    }
    
    public String getNome() {
    	return name;
    }
    
	public String ask(String question) {
		Scanner scan = new Scanner(System.in);
		while(!scan.hasNextLine());
		String result = scan.nextLine();

		scan.close();
		
		return result;
	}

	public boolean finalAnswer(String answer) {
		boolean result = false;
		if (answer.equalsIgnoreCase(patientInstance[attributes.length - 1]))
			result = true;
		return result;
	}
}