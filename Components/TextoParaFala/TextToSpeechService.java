import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.websocket.BaseSynthesizeCallback;
		
public class TextToSpeechService{

	    private final int BUFFER_SIZE = 128000;
	    private AudioInputStream audioStream;
	    private AudioFormat audioFormat;
	    private SourceDataLine sourceLine;

		public static void main(String args[]) {
			TextToSpeechService a = new TextToSpeechService();
			Scanner s = new Scanner(System.in);
			String p = s.nextLine();
			s.close();
			try {
				a.execute(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*
		 * Funcao que configura a conta para permitir acesso ao TextToSpeech da IBM
		 */
		
		public TextToSpeech setCredentials() {
			
			//Cria um novo objeto do tipo TextToSpeech
			
			TextToSpeech novo = new TextToSpeech();
			
			// Configura as credenciais necessarias (obtidas criando uma conta no cloud da ibm)
			
			IamOptions iamOptions = new IamOptions.Builder()
					  .apiKey("xFVh95prjjAl6ZgqVAjl6CcV0bINL_BrqHvhdgoaIuA3")
					  .build();	
			novo.setIamCredentials(iamOptions);
			
			return novo;
		}
		
		/*
		 * Funcao que cria o audio contendo a fala em fala.wav
		 */
		
		public void play(TextToSpeech service, String text) throws Exception {
			
			//Cria um objeto com as configuracoes de sintetizacao (o texto a ser falado e o formato do audio (.wav))
			SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
					  .text(text)
					  .accept(SynthesizeOptions.Accept.AUDIO_WAV)
					  .build();

			//Enviara o texto atravez de byteArray para o WebSocket onde sera feita a conversao
			
			BufferedInputStream bis = new BufferedInputStream(service.synthesize(synthesizeOptions).execute().getResult());
			
			audioStream = AudioSystem.getAudioInputStream(bis);
		    audioFormat = audioStream.getFormat();
		    DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		    sourceLine = (SourceDataLine) AudioSystem.getLine(info);
		    sourceLine.open(audioFormat);

		    sourceLine.start();	    
		    
		   
		    int nBytesRead = 0;
		    byte[] abData = new byte[BUFFER_SIZE];
		    while (nBytesRead != -1) {
		    	try {
		    		nBytesRead = audioStream.read(abData, 0, abData.length);
		    	}catch(IOException e) {
		    		
		    	}
		    		if (nBytesRead >= 0) {
		    			@SuppressWarnings("unused")
		    			int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
		    		}	    		
		    }
		    sourceLine.drain();
		    sourceLine.close();

		}
		
		
		public void execute(String text) throws Exception{
			TextToSpeech service = setCredentials();

			play(service, text);
		}
		
		
	}