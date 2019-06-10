package trabalho;

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
    
	public boolean ask(String question) {
		return true;
	}

	public boolean finalAnswer(String answer) {
		boolean result = false;
		if (answer.equalsIgnoreCase(patientInstance[attributes.length - 1]))
			result = true;
		return result;
	}
}