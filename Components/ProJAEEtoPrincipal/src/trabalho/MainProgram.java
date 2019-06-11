package trabalho;

import  componenteServidor.*;
import curveLevels.CreateFilesFactory;
import curveLevels.DataSetFactory;
import curveLevels.ICreateFiles;
import curveLevels.IDataSetComponent;
import curveLevels.IWriter;
import curveLevels.WriterFactory;
import speak.Speak;
import tradutor.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;


import com.sun.net.httpserver.*;

import Equipiada.Components.PCA_Analysis.IPCA_Analysis.IPCA_Analysis;
import Equipiada.Components.PCA_Analysis.PCA_Analysis.PCA_Analysis;
public class MainProgram {
	static String lingua;
	static boolean comecou;
	static boolean acabou;
	static Map<String,String> imgs_png;
	static Map<String,String> imgs_jpg;
	static String ask;
	static String r03 = "null";
	
	public static void main(String args[]) throws IOException {		
		final String csvUrl = "/Users/alvaromarques/csv322/zombie-health-new-cases20.csv";
		IServidor servidor = FabricaServidor.create();
		IDoctor doc = new Doctor("Asdrubal");
		IPatient pac = new Patient("Bastiao");
		DataSetComponent dt = new DataSetComponent();
		dt.setDataSource(csvUrl); 
		doc.connect(dt);
		comecou = false;
		acabou = false;
		
		
		Thread t1 = new Thread(new Runnable () {
			public void run() {	
				System.out.println("Começando processo csv");
				CreateFilesFactory filesFactory = new CreateFilesFactory();		
				DataSetFactory dataFactory = new DataSetFactory();
				WriterFactory writerFactory = new WriterFactory();
				
				IDataSetComponent data1 = dataFactory.getDataSet();
				data1.setDataSource(csvUrl);		
				
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
				r03 = cRGBtoLC.reader();		
		        System.out.println("tchau");
//				IWriter wCSV03 = writerFactory.write("Array3.csv");
//				wCSV03.write(r03);
			}
		});

		t1.start();
		
		servidor.addContext("/intro/", new HttpHandler() {
			public void handle(HttpExchange exchange) throws IOException{
				Servidor.addHeaders(exchange);
				Map<String, String> query = Servidor.splitQuery(Servidor.getQuery(exchange));
				lingua = query.get("lingua");
				Servidor.sendResponse(exchange, "");
			}
			
		}); 
		servidor.addContext("/sec/", new HttpHandler() {
			public void handle(HttpExchange exchange) throws IOException {
				Servidor.addHeaders(exchange);
				Map<String, String> query = Servidor.splitQuery(Servidor.getQuery(exchange));
				String q = query.get("q");
				String j = query.get("s");
				switch (q) {
					case "lingua":
						Servidor.sendResponse(exchange, getText("Olá, vamos te atender agora"));
						break;
					
					default:
						Servidor.sendResponse(exchange, "null");
						break;
				}
				if (j.equals("true")) {
					doc.connect(pac);	
				}
			}
			
		});
		servidor.addContext("/quest/", new HttpHandler() {
			public void handle(HttpExchange exchange) throws IOException {
				Servidor.addHeaders(exchange);
				Map<String, String> query = Servidor.splitQuery(Servidor.getQuery(exchange));
				String q = query.get("s");
				if (q.equals("sim")) {
					
					doc.andarNaArvore(true);
					Servidor.sendResponse(exchange, "");
					
				}else if(q.equals("nao")){	
					doc.andarNaArvore(false);
					Servidor.sendResponse(exchange, "");
						
				}else if (q.equals("start")) {
					if (!acabou)
						ask = doc.ask();		
					if (ask.startsWith("D")) {
						Speak.speak(ask.substring(2));
						acabou = true;
					}
					Servidor.sendResponse(exchange, getText(ask));
						
				}
			}
			
		});
		
		servidor.addContext("/plot/", new HttpHandler() {
			 @Override
		        public void handle(HttpExchange exchange) throws IOException {
				 	Servidor.addHeaders(exchange);
		            Headers headers = exchange.getResponseHeaders();
		            headers.add("Content-Type", "image/jpg");	            
		            IPCA_Analysis a = new PCA_Analysis("/Users/alvaromarques/miniconda3/bin/python3", "/Users/alvaromarques/marcos/pca_prototype_scatter.py",csvUrl);
		            a.pca();		            
		            File file = new File (csvUrl.substring(0, csvUrl.length()-3) + "jpg");
		            byte[] bytes  = new byte [(int)file.length()];
		            System.out.println(file.getAbsolutePath());
		            System.out.println("length:" + file.length());		             
		            FileInputStream fileInputStream = new FileInputStream(file);
		            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		            bufferedInputStream.read(bytes, 0, bytes.length);	 
		            Servidor.sendResponse(exchange, bytes);
			 }});
		servidor.addContext("/plotcsv/", new HttpHandler() {
			 @Override
		        public void handle(HttpExchange exchange) throws IOException {
				 	Servidor.addHeaders(exchange);
		            Headers headers = exchange.getResponseHeaders();
		            headers.add("Content-Type", "text/csv");	            
		            
		            
		            Servidor.sendResponse(exchange, r03);
			 }});
		servidor.initialize();		
		}
	
		
		
	
	public static String getText(String text) {
		System.out.println(Translate.translate(text, lingua));
		return Translate.translate(text, lingua);
		
	}
	
}
