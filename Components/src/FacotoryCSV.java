
public class FactoryCSV implements IConvertFactory{
	public class ConvertFactory(DataSetComponent data){
		return new ReaderCSV(data);
	}
}
