package curveLevels;
public class Main {

	public static void main(String[] args) {
		System.out.println("Iniciou");
		
		CreateFilesFactory filesFactory = new CreateFilesFactory();		
		DataSetFactory dataFactory = new DataSetFactory();
		WriterFactory writerFactory = new WriterFactory();
		
		IDataSetComponent data1 = dataFactory.getDataSet();
		data1.setDataSource("/Users/alvaromarques/csv322/zombie-health-new-cases20.csv");		
		
		ICreateFiles rCSV = filesFactory.getCreate(data1, "CSV");
		String r01 = rCSV.reader();		
		
		IWriter wCSV01 = writerFactory.write("Array1.csv");
		wCSV01.write(r01);
		
		IDataSetComponent data2 = dataFactory.getDataSet();
		data2.setDataSource("Array1.csv");	
		
		ICreateFiles cCSVtoRGB = filesFactory.getCreate(data2, "CSVtoRGB");
		cCSVtoRGB.foundMaxValue();
		String r02 = cCSVtoRGB.reader();
		
		IWriter wCSV02 = writerFactory.write("Array2.csv");
		wCSV02.write(r02);
		
		IDataSetComponent data3 = dataFactory.getDataSet();
		data3.setDataSource("Array2.csv");	
		
		ICreateFiles cRGBtoLC = filesFactory.getCreate(data3, "RGBtoLC");
		String r03 = cRGBtoLC.reader();		
		
		IWriter wCSV03 = writerFactory.write("Array3.csv");
		wCSV03.write(r03);
		
		System.out.println("Compilou");
	}

}
