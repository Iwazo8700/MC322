
public class Main {

	public static void main(String[] args) {
		System.out.println("Iniciou");
		
		CreateFilesFactory filesFactory = new CreateFilesFactory();		
		DataSetFactory dataFactory = new DataSetFactory();
		WriterFactory writerFactory = new WriterFactory();
		
		IDataSetComponent data1 = dataFactory.getDataSet();
		data1.setDataSource("src/csv/zombie-health-cases500.csv");		
		//data1.setDataSource("src/csv/zombie-health-new-cases20.csv");
		
		ICreateFiles rCSV = filesFactory.getCreate(data1, "CSV");
		String r01 = rCSV.reader();		
		
		IWriter wCSV01 = writerFactory.write("src/csv/Array1.csv");
		wCSV01.Writer(r01);
		
		IDataSetComponent data2 = dataFactory.getDataSet();
		data2.setDataSource("src/csv/Array1.csv");	
		
		ICreateFiles cCSVtoRGB = filesFactory.getCreate(data2, "CSVtoRGB");
		cCSVtoRGB.foundMaxValue();
		String r02 = cCSVtoRGB.reader();
		
		IWriter wCSV02 = writerFactory.write("src/csv/Array2.csv");
		wCSV02.Writer(r02);
		
		IDataSetComponent data3 = dataFactory.getDataSet();
		data3.setDataSource("src/csv/Array2.csv");	
		
		ICreateFiles cRGBtoLC = filesFactory.getCreate(data3, "RGBtoLC");
		String r03 = cRGBtoLC.reader();		
		
		IWriter wCSV03 = writerFactory.write("src/csv/Array3.csv");
		wCSV03.Writer(r03);
		
		System.out.println("Compilou");
	}

}
