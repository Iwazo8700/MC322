
public class WriterFactory {
	public IWriter write(String arquivo){
		return new Writer(arquivo);
	}
}
