
public class FactoryRGBtoLevel implements IConvertFactory{
	public class ConvertFactory(DataSetComponent data){
		return new ConvertRGBtoLevelCurves(data);
	}
}
