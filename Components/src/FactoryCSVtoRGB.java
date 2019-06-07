
public class FactoryCSVtoRGB implements IConvertFactory{
	public class ConvertFactory(DataSetComponent data){
		return new ConvertCSVtoRGB(data);
	}
}
