package speak;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;


public class TextToSpeechService implements ITextToSpeechService{

	    private final int BUFFER_SIZE = 128000;
	    private AudioInputStream audioStream;
	    private AudioFormat audioFormat;
	    private SourceDataLine sourceLine;

		/*
		 * Funcao que configura a conta para permitir acesso ao TextToSpeech da IBM
		 */
		
		private TextToSpeech setCredentials() {

			//Cria um novo objeto do tipo TextToSpeech

			TextToSpeech novo = new TextToSpeech();

			// Configura as credenciais necessarias (obtidas criando uma conta no cloud da ibm)

			IamOptions iamOptions = new IamOptions.Builder()
					  .apiKey("RM9mapRkhqaWSBs-idLDH5NVe8A1f0ecDY-i3Hiwr317")
					  .build();
			novo.setIamCredentials(iamOptions);

			return novo;
		}

		/*
		 * Funcao que cria o audio contendo a fala em fala.wav
		 */

		private void play(TextToSpeech service, String text) throws Exception {

			//Cria um objeto com as configuracoes de sintetizacao (o texto a ser falado e o formato do audio (.wav))
			SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
					  .text(text)
					  .accept(SynthesizeOptions.Accept.AUDIO_WAV)
					  .build();
			InputStream a = WaveUtils.reWriteWaveHeader(service.synthesize(synthesizeOptions).execute().getResult());
			//Enviara o texto atravez de byteArray para o WebSocket onde sera feita a conversao

			//Cria um inputStream com o audio do texto obtido pelo servico online da ibm
			//e conecta ele a um audioStream
			BufferedInputStream bis = new BufferedInputStream(a);
			audioStream = AudioSystem.getAudioInputStream(bis);
		    audioFormat = audioStream.getFormat();

		    //Cria uma conexao por onde o audio ira ser reproduzido
		    DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		    sourceLine = (SourceDataLine) AudioSystem.getLine(info);
		    sourceLine.open(audioFormat);

		    sourceLine.start();

		   //Reproduz o audio no SourceDataLine ate todos os bytes da stream serem reproduzidos
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

		@Override
		public void execute(String text) throws Exception{
			TextToSpeech service = setCredentials();

			play(service, text);
		}


	}
