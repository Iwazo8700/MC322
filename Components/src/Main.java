
public class Main {

	public static void main(String[] args) {
		DataSetComponent data = new DataSetComponent();
		data.setDataSource("src/csv/zombie-health-cases500.csv");
		
		ReaderCSV rCSV = new ReaderCSV(data);
		String Array = rCSV.reader();
		
		String arquivo01 = "src/csv/Array1.csv";
		WriterCSV wCSV01 = new WriterCSV(arquivo01);
		wCSV01.Writer(Array);
		
		DataSetComponent data1 = new DataSetComponent();
		data1.setDataSource("src/csv/Array1.csv");
		
		ConvertCSVtoRGB cCSVtoRGB = new ConvertCSVtoRGB(data1);
		cCSVtoRGB.foundMaxValue();
		String resultado = cCSVtoRGB.reader();
		
		String arquivo02 = "src/csv/Array2.csv";
		WriterCSV wCSV02 = new WriterCSV(arquivo02);
		wCSV02.Writer(resultado);
		
		DataSetComponent data2 = new DataSetComponent();
		data2.setDataSource("src/csv/Array2.csv");
		
		ConvertRGBtoLevelCurves cRGBtoLC = new ConvertRGBtoLevelCurves(data2);
		resultado = cRGBtoLC.reader();
		//System.out.println(resultado);
		
		String arquivo03 = "src/csv/Array3.csv";
		WriterCSV wCSV03 = new WriterCSV(arquivo03);
		wCSV03.Writer(resultado);
	}

}
