package Speak;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

public class SpeakConfig {
    private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;

	public static void main(String args[]) {
		SpeakConfig a = new SpeakConfig();
		Scanner s = new Scanner(System.in);
		String p = s.nextLine();
		a.execute(p);
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
	
	public void createAudio(TextToSpeech service, String text) {
		
		//Cria um objeto com as configuracoes de sintetizacao (o texto a ser falado e o formato do audio (.wav))
		SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
				  .text(text)
				  .accept(SynthesizeOptions.Accept.AUDIO_WAV)
				  .build();

		//Enviara o texto atravez de byteArray para o WebSocket onde sera feita a conversao
		final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		service.synthesizeUsingWebSocket(synthesizeOptions, new BaseSynthesizeCallback() {
				  @Override
				  public void onAudioStream(byte[] bytes) {
				    // append to our byte array
					  try {
						  byteArrayOutputStream.write(bytes);
					  } catch (IOException e) {
						  e.printStackTrace();
					  }
				  }
				});
		
		// Espera que a sintese do audio se complete
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			System.err.println("Erro na espera");
		}

		// Recebe a stream com o audio e salva no arquivo "fala.wav"
		String filename = "fala.wav";
		OutputStream fileOutputStream = null;
		
		//Abre o output stream
		try {
			fileOutputStream = new FileOutputStream(filename);
		} catch (FileNotFoundException e2) {
			System.err.println("Erro no outputStream");
		}
		
		//Escreve os dados no outputStream
		try {
			byteArrayOutputStream.writeTo(fileOutputStream);
			byteArrayOutputStream.close();
			fileOutputStream.close();
		} catch (IOException e1) {
			System.err.println("Erro no audio");
			e1.printStackTrace();
		}
	}
	
	
	/*
	 * Funcao que executara o audio em fala.wav
	 */
	
	public void play() {
	    try {
	        soundFile = new File("fala.wav");
	        audioStream = AudioSystem.getAudioInputStream(soundFile);
	    } catch (Exception e){
	    	System.err.println("Erro em criar inputStream");
	    }

	    audioFormat = audioStream.getFormat();

	    DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
	    try {
	    	sourceLine = (SourceDataLine) AudioSystem.getLine(info);
	        sourceLine.open(audioFormat);
	    } catch (Exception e) {
	        System.out.println("Erro em abrir arquivo");
	    }

	    sourceLine.start();

	    int nBytesRead = 0;
	    byte[] abData = new byte[BUFFER_SIZE];
	    while (nBytesRead != -1) {
        try {
        	nBytesRead = audioStream.read(abData, 0, abData.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (nBytesRead >= 0) {
            @SuppressWarnings("unused")
            int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
	    }
	    }

	    sourceLine.drain();
	    sourceLine.close();
		
	}
	
	
	public void execute(String text){
		TextToSpeech service = setCredentials();

		createAudio(service, text);

		play();
	}
	
	
}
