
public class CreateFilesFactory {
	public ICreateFiles getCreate(IDataSetComponent data, String fileType){
	      if(fileType == null){
	         return null;
	      }		
	      if(fileType.equalsIgnoreCase("CSV")){
	         return new ReaderCSV(data);
	         
	      } else if(fileType.equalsIgnoreCase("CSVtoRGB")){
	         return new ConvertCSVtoRGB(data);
	         
	      } else if(fileType.equalsIgnoreCase("RGBtoLC")){
	         return new ConvertRGBtoLevelCurves(data);
	      }
	      
	      return null;
	   }
}
